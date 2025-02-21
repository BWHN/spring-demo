package org.example.weiyuntong.waybillshare;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.bizcenter.controller.admin.waybillshare.vo.*;
import com.weiyuntong.module.bizcenter.service.waybillshare.WaybillShareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.*;
import java.util.List;
import java.util.Map;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 运单分享记录")
@RestController
@RequestMapping("/bizcenter/waybill-share")
@Validated
public class WaybillShareController {

    @Resource
    private WaybillShareService waybillShareService;

    @PostMapping("/create")
    @Operation(summary = "创建运单分享记录")
    public CommonResult<String> createWaybillShare(@Valid @RequestBody WaybillShareResVO createReqVO) {
        return success(waybillShareService.createWaybillShare(createReqVO));
    }

    @PostMapping("/getCode")
    public CommonResult<?> waybillShareGetCode(@RequestBody ShareVO shareVO) {
        return waybillShareService.waybillShareGetCode(shareVO);
    }

    @PostMapping("/login")
    public CommonResult<Boolean> waybillShareLogin(@RequestBody ShareVO shareVO) {
        return waybillShareService.waybillShareLogin(shareVO);
    }

    @PostMapping("/info")
    public CommonResult<WaybillShareVO> waybillShareInfo(@RequestBody ShareVO shareVO) {
        return success(waybillShareService.waybillShareInfo(shareVO));
    }

    @PostMapping("/listGpsHisByCarNo")
    @Operation(summary = "查询车辆历史轨迹记录信息")
    public CommonResult<List<Map<String, Object>>> getCarGpsHisData(@RequestBody Map<String, Object> paramMap) {
        return waybillShareService.getCarGpsHisData(paramMap);
    }

}
