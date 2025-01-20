package org.example.weiyuntong.xintong.listener;

import com.alibaba.fastjson.JSONObject;
import com.weiyuntong.framework.common.util.gps.GpsUtils;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongWaybillStatusChangeCallBackRequest;
import com.weiyuntong.module.bizcenter.controller.admin.waybillcarevent.vo.WaybillCarEventCreateReqVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import com.weiyuntong.module.bizcenter.service.waybill.WaybillCarService;
import com.weiyuntong.module.bizcenter.service.waybillcarevent.WaybillCarEventService;
import com.weiyuntong.module.infra.service.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

import static com.weiyuntong.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.weiyuntong.module.system.enums.FilePathEnum.NJWL_FILE_WANGHUO;


@Slf4j
@Component("XinTongGetUnLoadedListener")
public class XinTongGetUnLoadedListener implements XinTongOperateListener {

    @Resource
    private WaybillCarEventService waybillCarEventService;
    @Resource
    private WaybillCarService waybillCarService;
    @Resource
    private FileService fileService;


    @Override
    public void operate(XinTongWaybillStatusChangeCallBackRequest req) {
        // https://tms-v21-driver-gzh-api.w-lian.com/vip3/api/busi/TmsYsdBusiness/arriveUnloadAddress
        checkParams(req);

        WaybillCarDO waybillCarDO = waybillCarService.selectWaybillCarDOByWaybillSourceNo(req.getWaybillSourceNo());
        if (waybillCarDO == null){
            throw exception("参数异常【"+ req.getWaybillSourceNo() +"】不存在");
        }

        WaybillCarEventCreateReqVO waybillCarEventCreateReqVO = new WaybillCarEventCreateReqVO();
        waybillCarEventCreateReqVO.setWaybillCarId(waybillCarDO.getId());
        waybillCarEventCreateReqVO.setEventName("到达卸货地");
        waybillCarEventCreateReqVO.setEventCode("UNLOADED");

        // 图片地址转换
        try {
            String url1 = fileService.downloadAndUploadImage(req.getEventImages(), NJWL_FILE_WANGHUO.getName());
            waybillCarEventCreateReqVO.setEventImages(url1);
        } catch (IOException e) {
            waybillCarEventCreateReqVO.setEventImages(req.getEventImages());
            log.error("星通北斗changeWaybillStatus文件上传失败：{}", JSONObject.toJSONString(req));
        }

        waybillCarEventCreateReqVO.setLng(String.valueOf(GpsUtils.geoToLong(req.getLng())));
        waybillCarEventCreateReqVO.setLat(String.valueOf(GpsUtils.geoToLong(req.getLat())));


        waybillCarEventService.getUnLoadWaybillCarEvent(waybillCarEventCreateReqVO, true, null);

    }
    private void checkParams(XinTongWaybillStatusChangeCallBackRequest req){
        if (req.getEventTime() == null){
            throw exception("缺少必要参数!");
        }
    }
}
