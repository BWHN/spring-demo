package org.example.weiyuntong.etccost;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.fleetcenter.controller.admin.etccost.vo.*;
import com.weiyuntong.module.fleetcenter.enums.FleetCostEnums;
import com.weiyuntong.module.fleetcenter.service.etccost.EtcCostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - ETC费用")
@RestController
@RequestMapping("/fleetcenter/cost-etc")
@Validated
public class EtcCostController {

    @Resource
    private EtcCostService etcCostService;

    @PostMapping("/create")
    @Operation(summary = "创建ETC费用")
    @PreAuthorize("@ss.hasPermission('fleetcenter:etc-cost:create')")
    public CommonResult<Long> createEtcCost(@Valid @RequestBody EtcCostCreateReqVO createReqVO) {
        createReqVO.setCostType(FleetCostEnums.ETC_COST);
        return success(etcCostService.createEtcCost(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ETC费用")
    @PreAuthorize("@ss.hasPermission('fleetcenter:etc-cost:update')")
    public CommonResult<Boolean> updateEtcCost(@Valid @RequestBody EtcCostUpdateReqVO updateReqVO) {
        etcCostService.updateEtcCost(updateReqVO);
        return success(true);
    }

    @PutMapping("/app-update")
    @Operation(summary = "更新etc费用")
    @PreAuthorize("@ss.hasPermission('fleetcenter:cost-etc:update')")
    public CommonResult<Boolean> updateAppCostEtc(@Valid @RequestBody EtcCostUpdateReqVO updateReqVO) {
        etcCostService.updateAppCostEtc(updateReqVO);
        return success(true);
    }
    @GetMapping("/app-get")
    @Operation(summary = "获得etc费用")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('fleetcenter:cost-etc:query')")
    public CommonResult<EtcCostRespVO> getCostEtcByCostId(@RequestParam("id") Long id) {
        return success(etcCostService.getCostEtcRespByCostIdVO(id));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ETC费用")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('fleetcenter:etc-cost:delete')")
    public CommonResult<Boolean> deleteEtcCost(@RequestParam("id") Long id) {
        etcCostService.deleteEtcCost(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获得ETC费用分页")
    @PreAuthorize("@ss.hasPermission('fleetcenter:etc-cost:page')")
    public CommonResult<PageResult<EtcCostRespVO>> getEtcCostPage(@Valid EtcCostPageReqVO pageVO) {
        return success(etcCostService.getEtcCostPage(pageVO));
    }

    @GetMapping("/detail")
    @Operation(summary = "获得ETC费用详情")
    public CommonResult<EtcCostDetailVO> getEtcCostDetail(Long costId) {
        return success(etcCostService.getEtcCostDetail(costId));
    }


    @GetMapping("/summary")
    @Operation(summary = "获得ETC费用统计")
    @PreAuthorize("@ss.hasPermission('fleetcenter:etc-cost:summary')")
    public CommonResult<Map<String, Long>> getEtcCostSummary() {
        return success(etcCostService.getEtcCostSummary());
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出ETC费用 Excel")
    @PreAuthorize("@ss.hasPermission('fleetcenter:etc-cost:export')")
    @OperateLog(type = EXPORT)
    public void exportEtcCostExcel(@Valid EtcCostPageReqVO exportReqVO, HttpServletResponse response) throws IOException {
        List<EtcCostExcelVO> datas = etcCostService.getEtcExportCostList(exportReqVO);
        ExcelUtils.write(response, "ETC费用.xls", "数据", EtcCostExcelVO.class, datas);
    }

    @PostMapping("/upload-excel")
    @Operation(summary = "上传ETC文件")
    public CommonResult<Boolean> uploadExcel(@RequestBody EtcCostExcelUploadVO uploadVO) {
        return success(etcCostService.uploadExcel(uploadVO));
    }

}
