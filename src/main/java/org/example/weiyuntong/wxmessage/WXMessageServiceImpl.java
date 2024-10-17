package org.example.weiyuntong.wxmessage;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.weiyuntong.framework.datapermission.core.annotation.DataPermission;
import com.weiyuntong.framework.tenant.core.aop.TenantIgnore;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.wxmessage.vo.WXMessage;
import com.weiyuntong.module.bizcenter.dal.dataobject.commondelayqueue.CommonDelayqueueDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.Waybill;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.wxmessage.WXMessageDO;
import com.weiyuntong.module.bizcenter.dal.mysql.commondelayqueue.CommonDelayqueueMapper;
import com.weiyuntong.module.bizcenter.dal.mysql.waybill.WaybillCarMapper;
import com.weiyuntong.module.bizcenter.dal.mysql.waybill.WaybillMapper;
import com.weiyuntong.module.bizcenter.dal.mysql.wxmessage.WXMessageMapper;
import com.weiyuntong.module.bizcenter.service.commondelayqueue.CommonDelayqueueService;
import com.weiyuntong.module.bizcenter.service.commondelayqueue.DelayQueueProcessor;
import com.weiyuntong.module.bizcenter.util.WXBizMsgCrypt;
import com.weiyuntong.module.system.dal.dataobject.address.MyAddressDO;
import com.weiyuntong.module.system.dal.dataobject.user.AdminUserDO;
import com.weiyuntong.module.system.dal.mysql.address.MyAddressMapper;
import com.weiyuntong.module.system.dal.mysql.user.AdminUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * 微信订阅相关接口的实现
 */

@Service
@Validated
@Slf4j
public class WXMessageServiceImpl implements WXMessageService , DelayQueueProcessor {

    // 发送订阅消息的请求地址
    private static final String API_URL = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send";

    // 获取accessToken的请求地址
    // 使用force_refresh = false 时为普通调用模式，access_token 有效期内重复调用该接口不会更新 access_token
    private final static String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/stable_token";


    // 订阅消息模板id
    private static final String TEMPLATE_Id_ISSUED = "gWZREeqjGWiNXY5lzET_e9jBylcsrdMgGYalDVPxQYk";
    private static final String TEMPLATE_Id_DEPARTED = "TKXn9f4mCyY-iKYdVnPawg13iY4WfE4Aubdkp481z0k";
    private static final String TEMPLATE_Id_LOAD = "Ry_PaV8Wh8Ene7rt8AsTi-WdWnAQh_2Y8_cSkJb5H58";
    private static final String TEMPLATE_Id_UNLOAD = "HlPELSvCF6TaxlbN3Bd_CoKebjuOPDfciTpRD3EunWU";

    @Value("${wx.miniapp.configs[0].appid}")
    private String WX_APPID;

    @Value("${wx.miniapp.configs[0].secret}")
    private String WX_SECRET;

    @Resource
    private WaybillCarMapper waybillCarMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private MyAddressMapper myAddressMapper;

    @Resource
    private WaybillMapper waybillMapper;

    @Resource
    private WXMessageMapper wxMessageMapper;

    @Resource
    private CommonDelayqueueMapper commonDelayqueueMapper;

    @Lazy
    @Resource
    private CommonDelayqueueService commonDelayqueueService;


    /**
     * 批量下发通知接口
     * @return
     */
    @Override
    @TenantIgnore
    @DataPermission(enable = false)
    public void sendSubscribeMessageByWaybillCarList(List<WaybillCarDO> waybillCarList) {

        // 发车提醒
        commonDelayqueueService.submitByWaybillCarDOS(waybillCarList , "WXMessageServiceImpl");

        // 下发通知
        String page = "pages/home/index";  // 跳转路径
        if (CollectionUtil.isNotEmpty(waybillCarList)){
            List<WXMessageDO> wxMessageDOS = new ArrayList<>();
            try {
                for (WaybillCarDO waybillCarDO : waybillCarList) {
                    AdminUserDO adminUserDO = adminUserMapper.selectByNameAndPhone(waybillCarDO.getDriver(), waybillCarDO.getDriverPhone(), WebFrameworkUtils.getTenantId());
                    Boolean b = false;
                    WXMessageDO wxMessageDO = new WXMessageDO();
                    if (adminUserDO != null  && adminUserDO.getOpenId() != null){
                        String messageData = createSendMsgDataIssued(waybillCarDO);
                        b = sendSubscribeMessage(getAccessToken(), adminUserDO.getOpenId(), TEMPLATE_Id_ISSUED,
                                page, messageData  , wxMessageDO);
                    }
                    wxMessageDO.setSuccessful(b);
                    wxMessageDO.setWaybillCarId(waybillCarDO.getId());
                    wxMessageDO.setWaybillCarNo(waybillCarDO.getWaybillCarNo());
                    wxMessageDO.setTemplateId(TEMPLATE_Id_ISSUED);
                    wxMessageDO.setEntId(WebFrameworkUtils.getTenantId());
                    wxMessageDO.setSentType(0);
                    wxMessageDO.setWaybillStatus(WaybillStatusEnum.TO_ISSUED);
                    wxMessageDOS.add(wxMessageDO);
                }
            }catch (Exception e){
                log.error("下发发送微信订阅信息出错");
            }
            if (CollectionUtil.isNotEmpty(wxMessageDOS)){
                wxMessageMapper.insertBatch(wxMessageDOS);
            }
        }
    }


    /**
     * 发车提醒通知
     * @param waybillCarIds
     * TO_DEPARTED("待发车")
     */
    @Override
    @TenantIgnore
    public void sendSubscribeMessageByWaybillCarNoDeparted(List<Long> waybillCarIds) {
        String page = "pages/home/index";  // 跳转路径
        List<WaybillCarDO> waybillCarDOS = waybillCarMapper.selectWaybillCarDOByIds(waybillCarIds);
        if (CollectionUtil.isNotEmpty(waybillCarDOS)){
            // 只给待发车的车次发送信息
            waybillCarDOS = waybillCarDOS.stream().filter(x -> WaybillStatusEnum.TO_DEPARTED.equals(x.getWaybillStatus())).collect(Collectors.toList());
            List<WXMessageDO> wxMessageDOS = new ArrayList<>();
            for (WaybillCarDO waybillCarDO : waybillCarDOS) {
                AdminUserDO adminUserDO = adminUserMapper.selectByNameAndPhone(waybillCarDO.getDriver(), waybillCarDO.getDriverPhone(), waybillCarDO.getTenantId());
                WXMessageDO wxMessageDO = new WXMessageDO();
                Boolean b = false;
                if (adminUserDO != null  && adminUserDO.getOpenId() != null){
                    String messageData = createSendMsgDataDeparted(waybillCarDO);
                    b = sendSubscribeMessage(getAccessToken(), adminUserDO.getOpenId(), TEMPLATE_Id_DEPARTED, page, messageData ,wxMessageDO);
                }
                wxMessageDO.setSuccessful(b);
                wxMessageDO.setWaybillCarId(waybillCarDO.getId());
                wxMessageDO.setWaybillCarNo(waybillCarDO.getWaybillCarNo());
                wxMessageDO.setTemplateId(TEMPLATE_Id_DEPARTED);
                wxMessageDO.setEntId(waybillCarDO.getTenantId());
                wxMessageDO.setSentType(1);
                wxMessageDO.setWaybillStatus(WaybillStatusEnum.TO_DEPARTED);
                wxMessageDOS.add(wxMessageDO);
            }
            if (CollectionUtil.isNotEmpty(wxMessageDOS)){
                wxMessageMapper.insertBatch(wxMessageDOS);
            }
        }
    }


    /**
     * 装货、卸货
     * @param waybillCarNo
     * @return
     */
    @Override
    @TenantIgnore
    public void sendSubscribeMessageByWaybillCarNo(String waybillCarNo) {
        String page = "pages/home/index";  // 跳转路径
        WaybillCarDO waybillCarDO = waybillCarMapper.selectWaybillCarDOByWaybillCarNo(waybillCarNo);

        if (waybillCarDO != null){
            AdminUserDO adminUserDO = adminUserMapper.selectByNameAndPhone(waybillCarDO.getDriver(), waybillCarDO.getDriverPhone(), waybillCarDO.getTenantId());
            // 根据车次的状态 调用不同的模板 发送不同的信息
            WaybillStatusEnum waybillStatus = waybillCarDO.getWaybillStatus();
            WXMessageDO wxMessageDO = new WXMessageDO();
            Boolean b = false;
            if (adminUserDO != null  && adminUserDO.getOpenId() != null){
                if (waybillStatus.equals(WaybillStatusEnum.TO_LOADED)){
                    String messageData = createSendMsgDataLoad(waybillCarDO);
                    b = sendSubscribeMessage(getAccessToken(), adminUserDO.getOpenId(), TEMPLATE_Id_LOAD, page, messageData ,wxMessageDO);
                    wxMessageDO.setTemplateId(TEMPLATE_Id_LOAD);
                } else if (waybillStatus.equals(WaybillStatusEnum.TO_UNLOADED)) {
                    String messageData = createSendMsgDataUnLoad(waybillCarDO);
                    b = sendSubscribeMessage(getAccessToken() , adminUserDO.getOpenId() , TEMPLATE_Id_UNLOAD , page , messageData ,wxMessageDO);
                    wxMessageDO.setTemplateId(TEMPLATE_Id_UNLOAD);
                }
            }
            wxMessageDO.setSuccessful(b);
            wxMessageDO.setWaybillCarId(waybillCarDO.getId());
            wxMessageDO.setWaybillCarNo(waybillCarDO.getWaybillCarNo());
            wxMessageDO.setEntId(waybillCarDO.getTenantId());
            wxMessageDO.setSentType(2);
            wxMessageDO.setWaybillStatus(waybillStatus);
            wxMessageMapper.insert(wxMessageDO);
        }
    }






    /**
     * 保存微信回调的数据
     * @param aesKey
     * @param encrypt
     */
    @Override
    public void saveWXCallbackMessage(byte[] aesKey, String encrypt) {
        String decrypt = WXBizMsgCrypt.decrypt(encrypt, aesKey, WX_APPID);
        if (StringUtils.isNotEmpty(decrypt)){
            try {
                JSONObject jsonObject = JSONUtil.parseObj(decrypt);
                String toUserName = (String) jsonObject.get("ToUserName");
                String fromUserName = (String) jsonObject.get("FromUserName");
                String createTime = (String) jsonObject.get("CreateTime");
                String msgType = (String) jsonObject.get("MsgType");
                String listString = jsonObject.get("List").toString();
                if (StringUtils.isNotEmpty(listString) && listString.startsWith("[")) {
                    List<WXMessage> wxMessages = com.alibaba.fastjson.JSONObject.parseArray(listString, WXMessage.class);
                } else if(StringUtils.isNotEmpty(listString) && listString.startsWith("{")) {
                    WXMessage wxMessage = com.alibaba.fastjson.JSONObject.parseObject(listString, WXMessage.class);
                }
                // 后期考虑 将相关数据存储
            }catch (Exception e){
                log.error("解密微信回调数据出现异常");
            }
        }

    }


    /**
     * 从redis里获取 accessToken
     * 获取不到就刷新
     * @return accessToken
     */
    public String getAccessToken() {
        String key = "wx:accessToken";
        String accessToken = "";
        if (Boolean.FALSE.equals(stringRedisTemplate.hasKey(key))){
            // 刷新 accessToken
            accessToken = this.refreshAccessToken();
            if (!accessToken.isEmpty()){
                stringRedisTemplate.opsForValue().set(key, accessToken , 50  , TimeUnit.MINUTES);
            }
        }else {
            accessToken = stringRedisTemplate.opsForValue().get(key);
        }
        return accessToken;
    }


    /**
     * 刷新  accessToken 设置两小时过期
     * @return
     */
    public String refreshAccessToken(){
        String accessToken = "";
        try {
            String body = String.format(
                    "{\"grant_type\":\"client_credential\",\"appid\":\"%s\",\"secret\":\"%s\",\"force_refresh\":%s}",
                    WX_APPID, WX_SECRET, false);
            String result = HttpUtil.post(GET_ACCESS_TOKEN , body);
            if (result.contains("access_token")){
                JSONObject entries = JSONUtil.parseObj(result);
                accessToken = entries.get("access_token").toString();
            }
        }catch (Exception e){
            log.error("获取accessToken失败");
        }
        return accessToken;
    }



    /**
     * 向微信服务器 发送消息
     * @param accessToken
     * @param openid 小程序用户
     * @param templateId 消息模板ID
     * @param page 点击跳转的路径
     * @param data
     */

    public static Boolean sendSubscribeMessage(String accessToken, String openid,
                                               String templateId, String page, String data , WXMessageDO wxMessageDO) {
        Boolean b = false;
        try {
            String url = API_URL + "?access_token=" + accessToken;

            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setDoOutput(true);

            // 构建请求体
            String body = buildRequestBody(openid, templateId, page, data);
            byte[] requestBodyBytes = body.getBytes(StandardCharsets.UTF_8);

            // 发送请求
            connection.getOutputStream().write(requestBodyBytes);

            // 读取响应
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject entries = JSONUtil.parseObj(response);
            String errcode = entries.get("errcode").toString();
            wxMessageDO.setResponse(response.toString());
            if (responseCode == HttpURLConnection.HTTP_OK && "0".equals(errcode)) {
                // 请求成功处理逻辑
                log.info("发送订阅消息成功" + response);
                b = true;
            } else {
                // 请求失败处理逻辑
                log.error("发送订阅消息失败" + responseCode + response);
            }
            connection.disconnect();
        } catch (Exception e) {
            // 异常处理逻辑
            e.printStackTrace();
        }
        return b;
    }

    private static String buildRequestBody(String openid, String templateId, String page, String data) {
        // 构建请求体的JSON字符串
        return String.format(
                "{\"touser\":\"%s\",\"template_id\":\"%s\",\"page\":\"%s\",\"data\":%s}",
                openid, templateId, page, data);
    }





   // 根据不同的模板id组装不同的数据  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /**
     * 下发成功提醒
     *  gWZREeqjGWiNXY5lzET_e9jBylcsrdMgGYalDVPxQYk
     * @param waybillCarDO
     * @return
     */

    public String createSendMsgDataIssued(WaybillCarDO waybillCarDO){
        // 构建订阅消息内容的JSON对象
        JSONObject messageData = new JSONObject();
        messageData.put("car_number3", createDataItem("车牌号",
                waybillCarDO.getCarNumber()));
        MyAddressDO loadAddr = myAddressMapper.selectById(waybillCarDO.getLoadAddressId());
        MyAddressDO unLoadAddr = myAddressMapper.selectById(waybillCarDO.getUnloadAddressId());
        String addr = truncateIfExceedsTwenty(loadAddr.getCityName() + "->" + unLoadAddr.getCityName());
        messageData.put("thing8", createDataItem("运输线路",
                addr ));
        Waybill waybill = waybillMapper.selectById(waybillCarDO.getWaybillId());
        messageData.put("time6", createDataItem("要求装货时间",
                String.valueOf(waybill.getLoadingDate()).replace("T" , " ").substring(0,16) ));
        String mediumName = truncateIfExceedsTwenty(waybillCarDO.getMediumName());
        messageData.put("thing14", createDataItem("货物",
                mediumName ));
        messageData.put("thing1", createDataItem("温馨提示",
                "车次号:" + waybillCarDO.getWaybillCarNo()));
        return messageData.toString();
    }



    /**
     * TKXn9f4mCyY-iKYdVnPawg13iY4WfE4Aubdkp481z0k
     * 发车通知
     * @return
     */
    public String createSendMsgDataDeparted(WaybillCarDO waybillCarDO){
        // 构建订阅消息内容的JSON对象
        JSONObject messageData = new JSONObject();
        messageData.put("car_number5", createDataItem("车牌号", waybillCarDO.getCarNumber()));
        messageData.put("thing3", createDataItem("装货点",
                truncateIfExceedsTwenty(waybillCarDO.getLoadAddressName())));
        Waybill waybill = waybillMapper.selectById(waybillCarDO.getWaybillId());
        messageData.put("time9", createDataItem("装货时间",
                String.valueOf(waybill.getLoadingDate()).replace("T" , " ").substring(0,16)));
        messageData.put("thing8", createDataItem("货物",
                truncateIfExceedsTwenty(waybillCarDO.getMediumName())));
        messageData.put("thing2", createDataItem("温馨提示",
                "车次号:" + waybillCarDO.getWaybillCarNo()));
        return messageData.toString();
    }


    /**
     * 装货提醒
     * Ry_PaV8Wh8Ene7rt8AsTi-WdWnAQh_2Y8_cSkJb5H58
     * @return
     */
    public String createSendMsgDataLoad(WaybillCarDO waybillCarDO){
        // 构建订阅消息内容的JSON对象
        JSONObject messageData = new JSONObject();
        messageData.put("thing5", createDataItem("司机车辆",
                waybillCarDO.getDriver() + " " + waybillCarDO.getCarNumber()));
        messageData.put("thing2", createDataItem("运单行程",
                truncateIfExceedsTwenty(
                        "前往" + waybillCarDO.getLoadAddressName()) ));
        messageData.put("thing6", createDataItem("货物",
                truncateIfExceedsTwenty(
                        waybillCarDO.getWeight() + "吨" + waybillCarDO.getMediumName())));
        messageData.put("thing1", createDataItem("温馨提示",
                "车次号:" + waybillCarDO.getWaybillCarNo() ));
        return messageData.toString();
    }


    /**
     * 卸货提醒
     * HlPELSvCF6TaxlbN3Bd_CoKebjuOPDfciTpRD3EunWU
     * @param waybillCarDO
     * @return
     */
    public String createSendMsgDataUnLoad(WaybillCarDO waybillCarDO){
        // 构建订阅消息内容的JSON对象
        JSONObject messageData = new JSONObject();
        messageData.put("thing5", createDataItem("司机车辆",
                waybillCarDO.getDriver() + " " + waybillCarDO.getCarNumber()));
        messageData.put("thing2", createDataItem("运单行程",
                truncateIfExceedsTwenty(
                        "前往" + waybillCarDO.getUnloadAddressName())));
        messageData.put("thing6", createDataItem("货物",
                waybillCarDO.getWeight() + "吨" + waybillCarDO.getMediumName()));
        messageData.put("thing1", createDataItem("温馨提示",
                "车次号:" + waybillCarDO.getWaybillCarNo() ));
        return messageData.toString();
    }




    private static Map<String, Object> createDataItem(String name, String value) {
        Map<String, Object> item = new HashMap<>();
        item.put("value", value);
        return item;
    }

    private static String truncateIfExceedsTwenty(String input) {
        if (StringUtils.isBlank(input)) {
            return "";
        }
        if (input.length() <= 20) {
            return input;
        } else {
            return input.substring(0, 20);
        }
    }


    @Override
    public void execute(CommonDelayqueueDO commonDelayqueueDO) {
        sendSubscribeMessageByWaybillCarNoDeparted(com.alibaba.fastjson.JSONObject.parseArray(commonDelayqueueDO.getJson(), Long.class));
        commonDelayqueueDO.setStatus(true);
        commonDelayqueueMapper.updateById(commonDelayqueueDO);
    }
}
