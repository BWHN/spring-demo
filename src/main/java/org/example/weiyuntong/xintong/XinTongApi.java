package org.example.weiyuntong.xintong;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.api.xintong.util.AesUtil;
import com.weiyuntong.module.bizcenter.api.xintong.util.CommonUtil;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongOrderSyncRequest;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongOrderSyncResponse;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongWaybillCarSyncRequest;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.util.CoordinateTransformationUtil;
import com.weiyuntong.module.system.dal.dataobject.address.MyAddressDO;
import com.weiyuntong.module.system.dal.dataobject.user.AdminUserDO;
import com.weiyuntong.module.system.service.address.MyAddressService;
import com.weiyuntong.module.system.service.user.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.*;

@Component
@Slf4j
public class XinTongApi {

    private static final String DEFAULT_CAR_GO_IMAGE = "https://osslianfile.oss-cn-beijing.aliyuncs.com/NJWL_FLIE_PATH/652b8d86b11f4d6c89ecb4331b093209.jpg";

    @Value("${xinTong.merchantCode}")
    private String merchantCode;
    @Value("${xinTong.merchantId}")
    private String merchantId;
    @Value("${xinTong.merchantKey}")
    private String merchantKey;
    @Value("${xinTong.orderSyncUrl}")
    private String orderSyncUrl;

    @Resource
    private MyAddressService myAddressService;
    @Resource
    private AdminUserService adminUserService;

    public XinTongOrderSyncResponse syncOrder(TransportTaskEntrustorderDO entrustOrderDO) {
        try {
            XinTongOrderSyncRequest xinTongOrderSyncRequest = new XinTongOrderSyncRequest();
            xinTongOrderSyncRequest.setMerchantCode(merchantCode);
            xinTongOrderSyncRequest.setMerchantId(merchantId);
            xinTongOrderSyncRequest.setMerchantOrder(entrustOrderDO.getCode());

            // 装卸货地
            List<XinTongOrderSyncRequest.Address> addressList = new ArrayList<>();
            XinTongOrderSyncRequest.Address sendAddress = new XinTongOrderSyncRequest.Address();
            sendAddress.setAddressType("1");
            MyAddressDO loaded = myAddressService.getMyAddress(entrustOrderDO.getLoadAddressId());
            sendAddress.setAddressProvinceName(entrustOrderDO.getSendProvinceName());
            sendAddress.setAddressCityName(entrustOrderDO.getSendCityName());
            sendAddress.setAddressDistrictName(entrustOrderDO.getSendDistrictName());
            sendAddress.setDetailedAddress(entrustOrderDO.getLoadAddressDetail());
            if (StrUtil.isEmpty(loaded.getContactName())){
                AdminUserDO user = adminUserService.getUser(WebFrameworkUtils.getLoginUserId());
                sendAddress.setUserName(user.getNickname());
                sendAddress.setUserPhone(user.getMobile());
            }else {
                sendAddress.setUserName(loaded.getContactName());
                sendAddress.setUserPhone(loaded.getContactPhone());
            }

            Map<String, Double> bdGPS = CoordinateTransformationUtil.gd2bd(entrustOrderDO.getSendLng() / 1000000f,
                    entrustOrderDO.getSendLat() / 1000000f);
            sendAddress.setLng(BigDecimal.valueOf(bdGPS.get("lon")).setScale(6, RoundingMode.DOWN).toString());
            sendAddress.setLat(BigDecimal.valueOf(bdGPS.get("lat")).setScale(6, RoundingMode.DOWN).toString());
            sendAddress.setTimePeriod(Collections.singletonList("00:00-23:59"));
            addressList.add(sendAddress);
            XinTongOrderSyncRequest.Address receiveAddress = new XinTongOrderSyncRequest.Address();
            MyAddressDO unload = myAddressService.getMyAddress(entrustOrderDO.getUnloadAddressId());
            receiveAddress.setAddressType("2");
            receiveAddress.setAddressProvinceName(entrustOrderDO.getReceiveProvinceName());
            receiveAddress.setAddressCityName(entrustOrderDO.getReceiveCityName());
            receiveAddress.setAddressDistrictName(entrustOrderDO.getReceiveDistrictName());
            receiveAddress.setDetailedAddress(entrustOrderDO.getUnLoadAddressDetail());
            if (StrUtil.isEmpty(unload.getContactName())){
                AdminUserDO user = adminUserService.getUser(WebFrameworkUtils.getLoginUserId());
                receiveAddress.setUserName(user.getNickname());
                receiveAddress.setUserPhone(user.getMobile());
            }else {
                receiveAddress.setUserName(unload.getContactName());
                receiveAddress.setUserPhone(unload.getContactPhone());
            }
            bdGPS = CoordinateTransformationUtil.gd2bd(entrustOrderDO.getReceiveLng() / 1000000f,
                    entrustOrderDO.getReceiveLat() / 1000000f);
            receiveAddress.setLng(BigDecimal.valueOf(bdGPS.get("lon")).setScale(6, RoundingMode.DOWN).toString());
            receiveAddress.setLat(BigDecimal.valueOf(bdGPS.get("lat")).setScale(6, RoundingMode.DOWN).toString());
            receiveAddress.setTimePeriod(Collections.singletonList("00:00-23:59"));
            addressList.add(receiveAddress);
            xinTongOrderSyncRequest.setAddressList(addressList);

            // 货物信息
            XinTongOrderSyncRequest.CargoInfo cargoInfo = new XinTongOrderSyncRequest.CargoInfo();
            cargoInfo.setCargoName(entrustOrderDO.getMediumName());
            cargoInfo.setCargoType("煤炭及制品");    // 暂时先写死，后面改配置
            PriceUnitEnum searchCarPriceUnit = entrustOrderDO.getSearchCarPriceUnit();
            if (searchCarPriceUnit == PriceUnitEnum.PRICE_UNIT_TON) {
                cargoInfo.setCargoUnit("吨");
            } else if (searchCarPriceUnit == PriceUnitEnum.PRICE_UNIT_CAR) {
                cargoInfo.setCargoUnit("车");
            }
            xinTongOrderSyncRequest.setCargoInfo(cargoInfo);

            xinTongOrderSyncRequest.setTransportUnitPriceUnit(PriceUnitEnum.getPriceXinTong(entrustOrderDO.getSearchCarPriceUnit()));
            xinTongOrderSyncRequest.setTransportUnitPrice(entrustOrderDO.getSearchCarPrice().setScale(2, RoundingMode.DOWN).toString());
            xinTongOrderSyncRequest.setTotalCargoVolume(entrustOrderDO.getWeight().setScale(3, RoundingMode.DOWN).toString());
            xinTongOrderSyncRequest.setSettlementMethod("1");
            xinTongOrderSyncRequest.setSettlementMethodValue(entrustOrderDO.getBillingCycle());
            switch (entrustOrderDO.getSettleStrategy()) {
                case "LOADED":
                    xinTongOrderSyncRequest.setSettlementType("1");
                    break;
                case "UNLOADED":
                    xinTongOrderSyncRequest.setSettlementType("2");
                    break;
                case "MIN_LOADED_UNLOADED":
                    xinTongOrderSyncRequest.setSettlementType("3");
                    break;
                case "MAX_LOADED_UNLOADED":
                    xinTongOrderSyncRequest.setSettlementType("4");
                    break;
            }
            xinTongOrderSyncRequest.setMandatoryInformationForLoading(Collections.singletonList("1"));
            xinTongOrderSyncRequest.setMandatoryInformationForUnloading(Arrays.asList("1", "3"));
            String startDate = DateUtil.formatDate(Timestamp.valueOf(entrustOrderDO.getLoadDate()));
            String endDate = DateUtil.formatDate(Timestamp.valueOf(entrustOrderDO.getUnloadDate()));
            xinTongOrderSyncRequest.setOrderTime(startDate + "至" + endDate);
            xinTongOrderSyncRequest.setAverageDailyVehicles("10");
            xinTongOrderSyncRequest.setExternalOrderGrab("0");
            xinTongOrderSyncRequest.setCargoImage(Collections.singletonList(DEFAULT_CAR_GO_IMAGE));

            // 构造请求
            log.info("星通北斗syncOrder请求参数：{}", JSONObject.toJSONString(xinTongOrderSyncRequest));
            String orderSyncUrl = this.orderSyncUrl + "/wlhy_interface_api/hyOrderRef/setHyOrderAdd";
            HttpRequest post = HttpUtil.createPost(orderSyncUrl);
            Map<String, String> headers = new HashMap<>();
            headers.put("content-type", "application/json");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3141.7 Safari/537.36");
            String key = CommonUtil.encryptMD5(merchantKey);
            headers.put("key", key);
            headers.put("merchantId", merchantId);
            post.addHeaders(headers);
            String encrypt = AesUtil.encrypt(JSONObject.toJSONString(xinTongOrderSyncRequest), merchantKey);
            post.body(encrypt);
            String response = post.execute().body();
            log.info("星通北斗syncOrder返回结果：{}", JSONObject.toJSONString(response));
            String decrypt = AesUtil.decrypt(response, merchantKey);
            log.info("星通北斗syncOrder解密后结果：{}", decrypt);
            return JSONObject.parseObject(decrypt).toJavaObject(XinTongOrderSyncResponse.class);
        } catch (Exception e) {
            log.error("星通北斗syncOrder请求异常：", e);
            return new XinTongOrderSyncResponse(-1, e.getMessage());
        }
    }

    public XinTongOrderSyncResponse informXinTongCheckWaybill(String xinTongWaybillId) {
        XinTongWaybillCarSyncRequest xinTongWaybillCarSyncRequest = new XinTongWaybillCarSyncRequest();
        xinTongWaybillCarSyncRequest.setMerchantCode(merchantCode);
        xinTongWaybillCarSyncRequest.setMerchantId(merchantId);
        xinTongWaybillCarSyncRequest.setWaybillIdsArr(Collections.singletonList(xinTongWaybillId));
        try {
            // 构造请求
            log.info("星通北斗syncOrder请求参数：{}", JSONObject.toJSONString(xinTongWaybillCarSyncRequest));
            String url = orderSyncUrl + "/wlhy_interface_api/hyOrderRef/setHyOrderAdd";
            String response = HttpUtil.post(url, JSONObject.toJSONString(xinTongWaybillCarSyncRequest));
            log.info("星通北斗syncOrder返回结果：{}", JSONObject.toJSONString(response));
            return JSONObject.parseObject(response).toJavaObject(XinTongOrderSyncResponse.class);
        } catch (Exception e) {
            log.error("星通北斗syncOrder请求异常：", e);
            return new XinTongOrderSyncResponse(-1, e.getMessage());
        }
    }

    public XinTongOrderSyncResponse informXinTongCheckWaybillCar(String xinTongWaybillId) {
        XinTongWaybillCarSyncRequest xinTongWaybillCarSyncRequest = new XinTongWaybillCarSyncRequest();
        xinTongWaybillCarSyncRequest.setMerchantCode(merchantCode);
        xinTongWaybillCarSyncRequest.setMerchantId(merchantId);
        xinTongWaybillCarSyncRequest.setWaybillIdsArr(Collections.singletonList(xinTongWaybillId));
        try {
            // 构造请求
            log.info("星通北斗syncOrder请求参数：{}", JSONObject.toJSONString(xinTongWaybillCarSyncRequest));
            String url = orderSyncUrl + "/wlhy_interface_api/hyOrderRef/setHyOrderAdd";
            String response = HttpUtil.post(url, JSONObject.toJSONString(xinTongWaybillCarSyncRequest));
            log.info("星通北斗syncOrder返回结果：{}", JSONObject.toJSONString(response));
            return JSONObject.parseObject(response).toJavaObject(XinTongOrderSyncResponse.class);
        } catch (Exception e) {
            log.error("星通北斗syncOrder请求异常：", e);
            return new XinTongOrderSyncResponse(-1, e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(CommonUtil.encryptMD5("kF4z2Tv6rZ8IVniBYnfXew=="));
    }

}
