package org.example.weiyuntong.xintong.listener;

import com.alibaba.fastjson.JSONObject;
import com.weiyuntong.framework.common.util.gps.GpsUtils;
import com.weiyuntong.framework.tenant.core.aop.TenantIgnore;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongWaybillStatusChangeCallBackRequest;
import com.weiyuntong.module.bizcenter.controller.admin.waybill.vo.WaybillUnloadedRepVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import com.weiyuntong.module.bizcenter.service.waybill.WaybillCarService;
import com.weiyuntong.module.bizcenter.service.waybillsource.WaybillSourceCarService;
import com.weiyuntong.module.infra.service.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

import static com.weiyuntong.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.weiyuntong.module.system.enums.FilePathEnum.NJWL_FILE_WANGHUO;


@Slf4j
@Component("XinTongUnLoadedListener")
public class XinTongUnLoadedListener implements XinTongOperateListener {

    @Resource
    private WaybillSourceCarService waybillSourceCarService;
    @Resource
    private WaybillCarService waybillCarService;
    @Resource
    private FileService fileService;



    @Override
    @TenantIgnore
    @Transactional(rollbackFor = Exception.class)
    public void operate(XinTongWaybillStatusChangeCallBackRequest req) {
        checkParams(req);

        WaybillCarDO waybillCarDO = waybillCarService.selectWaybillCarDOByWaybillSourceNo(req.getWaybillSourceNo());
        if (waybillCarDO == null){
            throw exception("参数异常【"+ req.getWaybillSourceNo() +"】不存在");
        }

        WaybillUnloadedRepVO loadedRepVO = new WaybillUnloadedRepVO();
        loadedRepVO.setId(waybillCarDO.getId());

        // 图片地址转换
        try {
            String url1 = fileService.downloadAndUploadImage(req.getUnloadedImgUrl(), NJWL_FILE_WANGHUO.getName());
            loadedRepVO.setUnloadedImgUrl(url1);
        } catch (IOException e) {
            loadedRepVO.setUnloadedImgUrl(req.getUnloadedImgUrl());
            log.error("星通北斗changeWaybillStatus文件上传失败：{}", JSONObject.toJSONString(req));
        }
        try {
            String url1 = fileService.downloadAndUploadImage(req.getReceiptUrl(), NJWL_FILE_WANGHUO.getName());
            loadedRepVO.setUnloadedReceiptUrl(url1);
        } catch (IOException e) {
            loadedRepVO.setUnloadedReceiptUrl(req.getReceiptUrl());
            log.error("星通北斗changeWaybillStatus文件上传失败：{}", JSONObject.toJSONString(req));
        }

        loadedRepVO.setUnloadedMileage(req.getMileage());
        loadedRepVO.setUnloadedTime(req.getUnloadedTime());
        loadedRepVO.setUnloadedWeight(req.getUnloadedWeight());

        loadedRepVO.setLng(String.valueOf(GpsUtils.geoToLong(req.getLng())));
        loadedRepVO.setLat(String.valueOf(GpsUtils.geoToLong(req.getLat())));

        waybillSourceCarService.unloaded(loadedRepVO, null , req.getEntId());

    }
    private void checkParams(XinTongWaybillStatusChangeCallBackRequest req){
        if (req.getUnloadedWeight() == null
                || req.getUnloadedTime() == null
                || req.getMileage() == null
        ){
            throw exception("缺少必要参数!");
        }
    }
//    || StringUtil.isEmpty(req.getMileageUrl())   || StringUtil.isEmpty(req.getUnloadedImgUrl())
}
