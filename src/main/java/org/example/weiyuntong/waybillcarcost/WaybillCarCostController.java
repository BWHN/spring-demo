package org.example.weiyuntong.waybillcarcost;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.convert.waybillcarcost.WaybillCarCostConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybillcarcost.WaybillCarCostDO;
import com.weiyuntong.module.bizcenter.controller.admin.waybillcarcost.vo.*;
import com.weiyuntong.module.bizcenter.service.waybillcarcost.WaybillCarCostService;
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
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - 车次成本")
@RestController
@RequestMapping("/biz/waybill-car-cost")
@Validated
public class WaybillCarCostController {

    @Resource
    private WaybillCarCostService waybillCarCostService;

    @PostMapping("/create")
    @Operation(summary = "创建车次成本")
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:create')")
    public CommonResult<Long> createWaybillCarCost(@Valid @RequestBody WaybillCarCostCreateReqVO createReqVO) {
        return success(waybillCarCostService.createWaybillCarCost(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新车次成本")
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:update')")
    public CommonResult<Boolean> updateWaybillCarCost(@Valid @RequestBody WaybillCarCostUpdateReqVO updateReqVO) {
        waybillCarCostService.updateWaybillCarCost(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除车次成本")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:delete')")
    public CommonResult<Boolean> deleteWaybillCarCost(@RequestParam("id") Long id) {
        waybillCarCostService.deleteWaybillCarCost(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得车次成本")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:query')")
    public CommonResult<WaybillCarCostRespVO> getWaybillCarCost(@RequestParam("id") Long id) {
        WaybillCarCostDO waybillCarCost = waybillCarCostService.getWaybillCarCost(id);
        return success(WaybillCarCostConvert.INSTANCE.convert(waybillCarCost));
    }

    @GetMapping("/list")
    @Operation(summary = "获得车次成本列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:query')")
    public CommonResult<List<WaybillCarCostRespVO>> getWaybillCarCostList(@RequestParam("ids") Collection<Long> ids) {
        List<WaybillCarCostDO> list = waybillCarCostService.getWaybillCarCostList(ids);
        return success(WaybillCarCostConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得车次成本分页")
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:query')")
    public CommonResult<PageResult<WaybillCarCostRespVO>> getWaybillCarCostPage(@Valid WaybillCarCostPageReqVO pageVO) {
        PageResult<WaybillCarCostDO> pageResult = waybillCarCostService.getWaybillCarCostPage(pageVO);
        return success(WaybillCarCostConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出车次成本 Excel")
    @PreAuthorize("@ss.hasPermission('biz:waybill-car-cost:export')")
    @OperateLog(type = EXPORT)
    public void exportWaybillCarCostExcel(@Valid WaybillCarCostExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<WaybillCarCostDO> list = waybillCarCostService.getWaybillCarCostList(exportReqVO);
        // 导出 Excel
        List<WaybillCarCostExcelVO> datas = WaybillCarCostConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "车次成本.xls", "数据", WaybillCarCostExcelVO.class, datas);
    }

}
