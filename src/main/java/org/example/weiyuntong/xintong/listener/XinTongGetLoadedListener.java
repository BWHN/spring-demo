package org.example.weiyuntong.xintong.listener;

import com.alibaba.fastjson.JSONObject;
import com.weiyuntong.framework.common.util.date.DateUtils;
import com.weiyuntong.framework.common.util.gps.GpsUtils;
import com.weiyuntong.framework.tenant.core.aop.TenantIgnore;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongWaybillStatusChangeCallBackRequest;
import com.weiyuntong.module.bizcenter.controller.admin.waybillcarevent.vo.WaybillCarEventCreateReqVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import com.weiyuntong.module.bizcenter.service.waybill.WaybillCarService;
import com.weiyuntong.module.bizcenter.service.waybillcarevent.WaybillCarEventService;
import com.weiyuntong.module.infra.service.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

import static com.weiyuntong.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.weiyuntong.module.system.enums.FilePathEnum.NJWL_FILE_WANGHUO;


@Slf4j
@Component("XinTongGetLoadedListener")
public class XinTongGetLoadedListener implements XinTongOperateListener {

    @Resource
    private WaybillCarEventService waybillCarEventService;
    @Resource
    private WaybillCarService waybillCarService;
    @Resource
    private FileService fileService;



    @Override
    @TenantIgnore
    @Transactional(rollbackFor = Exception.class)
    public void operate(XinTongWaybillStatusChangeCallBackRequest req){
        checkParams(req);
        //https://tms-v21-driver-gzh-api.w-lian.com/vip3/api/busi/TmsYsdBusiness/arriveLoadAddress

        WaybillCarDO waybillCarDO = waybillCarService.selectWaybillCarDOByWaybillSourceNo(req.getWaybillSourceNo());
        if (waybillCarDO == null){
            throw exception("参数异常【"+ req.getWaybillSourceNo() +"】不存在");
        }

        WaybillCarEventCreateReqVO waybillCarEventCreateReqVO = new WaybillCarEventCreateReqVO();
        waybillCarEventCreateReqVO.setWaybillCarId(waybillCarDO.getId());
        waybillCarEventCreateReqVO.setEventName("到达装货地");
        waybillCarEventCreateReqVO.setEventCode("LOADED");
        waybillCarEventCreateReqVO.setEventTime(DateUtils.of(req.getEventTime()));

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

        waybillCarEventService.getLoadWaybillCarEvent(waybillCarEventCreateReqVO, true, null , req.getEntId());

    }


    private void checkParams(XinTongWaybillStatusChangeCallBackRequest req){
        if (req.getEventTime() == null){
            throw exception("缺少必要参数!");
        }
    }
}

