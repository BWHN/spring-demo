package org.example.weiyuntong.waybillCarbenefitreport;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.module.bizcenter.task.WaybillCarBenefitHandler;
import com.weiyuntong.module.datacenter.controller.admin.waybillCarbenefitreport.vo.*;
import com.weiyuntong.module.datacenter.service.waybillcarbenefit.WaybillCarBenefitReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "报表管理-自营车次效益表")
@RestController
@RequestMapping("/datacenter/waybillCarBenefit")
@Validated
public class WaybillCarBenefitReportController {

    @Resource
    private WaybillCarBenefitReportService waybillCarBenefitReportService;
    @Resource
    private WaybillCarBenefitHandler waybillCarBenefitHandler;

    @PostMapping("/getOwnWaybillCarBenefitPage")
    @Operation(summary = "自营车次效益分页")
    public CommonResult<PageResult<WaybillOwnCarBenefitPageVO>> getOwnWaybillCarBenefitPage(@RequestBody WaybillOwnCarBenefitPageReqVO pageParam) {
        return success(waybillCarBenefitReportService.getOwnWaybillCarBenefitPage(pageParam));
    }

    @PostMapping("/getOwnWaybillCarBenefitCount")
    @Operation(summary = "自营车次效益看板数据")
    public CommonResult<WaybillOwnCarBenefitCount> getOwnWaybillCarBenefitCount(@RequestBody WaybillOwnCarBenefitPageReqVO pageParam) {
        return success(waybillCarBenefitReportService.getOwnWaybillCarBenefitCount(pageParam));
    }

    @PostMapping("/exportOwnWaybillCarBenefit")
    @Operation(summary = "导出自营车次效益")
    public void exportOwnWaybillCarBenefit(@RequestBody WaybillOwnCarBenefitPageReqVO pageParam, HttpServletResponse response) throws IOException {
        waybillCarBenefitReportService.exportOwnWaybillCarBenefit(pageParam, response);
    }

    @PostMapping("/getOtherWaybillCarBenefitPage")
    @Operation(summary = "外协车次效益分页")
    public CommonResult<PageResult<WaybillOtherCarBenefitPageVO>> getOtherWaybillCarBenefitPage(@RequestBody WaybillOtherCarBenefitPageReqVO pageParam) {
        return success(waybillCarBenefitReportService.getOtherWaybillCarBenefitPage(pageParam));
    }

    @PostMapping("/getOtherWaybillCarBenefitCount")
    @Operation(summary = "外协车次效益看板数据")
    public CommonResult<WaybillOtherCarBenefitCount> getOtherWaybillCarBenefitCount(@RequestBody WaybillOtherCarBenefitPageReqVO pageParam) {
        return success(waybillCarBenefitReportService.getOtherWaybillCarBenefitCount(pageParam));
    }

    @PostMapping("/exportOtherWaybillCarBenefit")
    @Operation(summary = "导出外协车次效益")
    public void exportOtherWaybillCarBenefit(@RequestBody WaybillOtherCarBenefitPageReqVO pageParam, HttpServletResponse response) throws IOException {
        waybillCarBenefitReportService.exportOtherWaybillCarBenefit(pageParam, response);
    }

    @GetMapping("/waybillCarBenefitScript")
    @Operation(summary = "车次效益脚本")
    public CommonResult<?> waybillCarBenefitScript(@RequestParam(required = false) Long tenantId,
                                                   @RequestParam(required = false) String waybillCarNo,
                                                   @RequestParam(required = false, defaultValue = "false") Boolean onlyPredict,
                                                   @RequestParam(required = false, defaultValue = "false") Boolean needArchive) {
        return waybillCarBenefitHandler.refreshBenefit(tenantId, waybillCarNo, onlyPredict, needArchive);
    }

}
