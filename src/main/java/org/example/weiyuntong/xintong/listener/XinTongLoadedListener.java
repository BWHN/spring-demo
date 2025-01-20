package org.example.weiyuntong.xintong.listener;

import com.alibaba.fastjson.JSONObject;
import com.weiyuntong.framework.tenant.core.aop.TenantIgnore;
import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongWaybillStatusChangeCallBackRequest;
import com.weiyuntong.module.bizcenter.controller.admin.waybill.vo.WaybillLoadedRepVO;
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
@Component("XinTongLoadedListener")
public class XinTongLoadedListener implements XinTongOperateListener {

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

        WaybillLoadedRepVO loadedRepVO = new WaybillLoadedRepVO();
        loadedRepVO.setId(waybillCarDO.getId());

        // 图片地址转换
        try {
            String url1 = fileService.downloadAndUploadImage(req.getLoadedImgUrl(), NJWL_FILE_WANGHUO.getName());
            loadedRepVO.setLoadedImgUrl(url1);
        } catch (IOException e) {
            loadedRepVO.setLoadedImgUrl(req.getLoadedImgUrl());
            log.error("星通北斗changeWaybillStatus文件上传失败：{}", JSONObject.toJSONString(req));
        }
        try {
            String url1 = fileService.downloadAndUploadImage(req.getMileageUrl(), NJWL_FILE_WANGHUO.getName());
            loadedRepVO.setMileageUrl(url1);
        } catch (IOException e) {
            loadedRepVO.setMileageUrl(req.getMileageUrl());
            log.error("星通北斗changeWaybillStatus文件上传失败：{}", JSONObject.toJSONString(req));
        }
        try {
            String url1 = fileService.downloadAndUploadImage(req.getReceiptUrl(), NJWL_FILE_WANGHUO.getName());
            loadedRepVO.setReceiptUrl(url1);
        } catch (IOException e) {
            loadedRepVO.setReceiptUrl(req.getReceiptUrl());
            log.error("星通北斗changeWaybillStatus文件上传失败：{}", JSONObject.toJSONString(req));
        }

        loadedRepVO.setLoadedMileage(req.getMileage());
        loadedRepVO.setLoadedTime(req.getLoadedTime());
        loadedRepVO.setLoadedWeight(req.getLoadedWeight());
        waybillSourceCarService.loaded(loadedRepVO, null , req.getEntId());

    }
    private void checkParams(XinTongWaybillStatusChangeCallBackRequest req){
        if (req.getLoadedWeight() == null
                || req.getLoadedTime() == null
                || req.getMileage() == null

        ){
            throw exception("缺少必要参数!");
        }
    }

//    || StringUtil.isEmpty(req.getMileageUrl())  || StringUtil.isEmpty(req.getLoadedImgUrl())
}
