package org.example.weiyuntong.roadbridgecost;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.fleetcenter.controller.admin.roadbridgecost.vo.*;
import com.weiyuntong.module.fleetcenter.enums.FleetCostEnums;
import com.weiyuntong.module.fleetcenter.service.roadbridgecost.RoadBridgeCostService;
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

@Tag(name = "管理后台 - 路桥费用")
@RestController
@RequestMapping("/fleetcenter/roadbridge-cost")
@Validated
public class RoadBridgeCostController {

    @Resource
    private RoadBridgeCostService roadBridgeCostService;

    @PostMapping("/create")
    @Operation(summary = "创建路桥费用")
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:create')")
    public CommonResult<Long> createRoadBridgeCost(@Valid @RequestBody RoadBridgeCostCreateReqVO createReqVO) {
        createReqVO.setCostType(FleetCostEnums.ROAD_BRIDGE_COST);
        createReqVO.setIsPay(true);
        return success(roadBridgeCostService.createRoadBridgeCost(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新路桥费用")
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:update')")
    public CommonResult<Boolean> updateRoadBridgeCost(@Valid @RequestBody RoadBridgeCostUpdateReqVO updateReqVO) {
        updateReqVO.setIsPay(true);
        roadBridgeCostService.updateRoadBridgeCost(updateReqVO);
        return success(true);
    }

    @PutMapping("/app-update")
    @Operation(summary = "更新尿素费用")
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:update')")
    public CommonResult<Boolean> updateAppRoadBridgeCost(@Valid @RequestBody RoadBridgeCostUpdateReqVO updateReqVO) {
        updateReqVO.setIsPay(true);
        roadBridgeCostService.updateAppRoadBridgeCost(updateReqVO);
        return success(true);
    }

    @GetMapping("/app-get")
    @Operation(summary = "获得加油费用")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('fleetcenter:oil-cost:query')")
    public CommonResult<RoadBridgeCostBaseVO> getAppRoadBridgeCost(@RequestParam("id") Long id) {
        return success(roadBridgeCostService.getAppRoadBridgeCostByCostId(id));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除路桥费用")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:delete')")
    public CommonResult<Boolean> deleteRoadBridgeCost(@RequestParam("id") Long id) {
        roadBridgeCostService.deleteRoadBridgeCost(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获得路桥费用分页")
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:page')")
    public CommonResult<PageResult<RoadBridgeCostRespVO>> getRoadBridgeCostPage(@Valid RoadBridgeCostPageReqVO pageVO) {
        return success(roadBridgeCostService.getRoadBridgeCostPage(pageVO));
    }

    @GetMapping("/detail")
    @Operation(summary = "获得路桥费用详情")
    public CommonResult<RoadBridgeCostDetailVO> getRoadBridgeCostDetail(Long costId) {
        return success(roadBridgeCostService.getRoadBridgeCostDetail(costId));
    }

    @GetMapping("/summary")
    @Operation(summary = "获得路桥费用统计")
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:summary')")
    public CommonResult<Map<String, Long>> getRoadBridgeCostSummary() {
        return success(roadBridgeCostService.getRoadBridgeCostSummary());
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出路桥费用 Excel")
    @PreAuthorize("@ss.hasPermission('fleetcenter:roadbridge-cost:export')")
    @OperateLog(type = EXPORT)
    public void exportRoadBridgeCostExcel(@Valid RoadBridgeCostPageReqVO exportReqVO, HttpServletResponse response) throws IOException {

        List<RoadBridgeCostExcelVO> datas = roadBridgeCostService.getRoadBridgeCostList(exportReqVO);
        ExcelUtils.write(response, "路桥费用.xls", "数据", RoadBridgeCostExcelVO.class, datas);
    }

}
