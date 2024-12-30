package org.example.weiyuntong.waybillcarbenefitpredict;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.bizcenter.controller.admin.waybillcarbenefitpredict.vo.WaybillCarBenefitPredictDetailVO;
import com.weiyuntong.module.bizcenter.controller.admin.waybillcarbenefitpredict.vo.WaybillCarBenefitPredictUpdateVO;
import com.weiyuntong.module.bizcenter.service.waybillcarbenefitpredict.WaybillCarBenefitPredictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Tag(name = "车次预测效益")
@RestController
@RequestMapping("/biz/waybill-car-benefit-predict")
@Validated
public class WaybillCarBenefitPredictController {

    @Resource
    private WaybillCarBenefitPredictService waybillCarBenefitPredictService;

    @GetMapping("/get")
    @Operation(summary = "获得车次预测效益")
    @PreAuthorize("@ss.hasPermission('biz:waybill-benefit-predict:get')")
    public CommonResult<WaybillCarBenefitPredictDetailVO> get(String waybillCarNo, Long predictId) {
        return CommonResult.success(waybillCarBenefitPredictService.get(waybillCarNo, predictId));
    }

    @PutMapping("/update")
    @Operation(summary = "更新车次预测效益")
    @PreAuthorize("@ss.hasPermission('biz:waybill-benefit-predict:update')")
    public CommonResult<Boolean> update(@RequestBody WaybillCarBenefitPredictUpdateVO updateVO) {
        return CommonResult.success(waybillCarBenefitPredictService.update(updateVO));
    }

}
