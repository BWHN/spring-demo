package org.example.weiyuntong.bizexpensetype;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.bizexpensetype.vo.*;
import com.weiyuntong.module.bizcenter.convert.bizexpensetype.BizExpenseTypeConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.bizexpenseimageconfig.BizExpenseImageConfigDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bizexpensetype.BizExpenseTypeDO;
import com.weiyuntong.module.bizcenter.service.bizexpenseimageconfig.BizExpenseImageConfigService;
import com.weiyuntong.module.bizcenter.service.bizexpensetype.BizExpenseTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "费用类型")
@RestController
@RequestMapping("/bizcenter/biz-expense-type")
@Validated
public class BizExpenseTypeController {

    @Resource
    private BizExpenseTypeService bizExpenseTypeService;
    @Resource
    private BizExpenseImageConfigService bizExpenseImageConfigService;


    @PostMapping("/create")
    @Operation(summary = "创建费用类型")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:create')")
    public CommonResult<Long> createBizExpenseType(@Valid @RequestBody BizExpenseTypeCreateReqVO createReqVO) {
        return bizExpenseTypeService.createBizExpenseType(createReqVO);
    }

    @PutMapping("/update")
    @Operation(summary = "更新费用类型")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:update')")
    public CommonResult<Boolean> updateBizExpenseType(@Valid @RequestBody BizExpenseTypeUpdateReqVO updateReqVO) {
        return bizExpenseTypeService.updateBizExpenseType(updateReqVO);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除费用类型")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:delete')")
    public CommonResult<Boolean> deleteBizExpenseType(@RequestParam("ids") List<Long> ids) {
        bizExpenseTypeService.deleteBizExpenseType(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得费用类型")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:query')")
    public CommonResult<BizExpenseTypeRespVO> getBizExpenseType(@RequestParam("id") Long id) {
        BizExpenseTypeDO bizExpenseType = bizExpenseTypeService.getBizExpenseType(id);
        BizExpenseTypeRespVO convert = BizExpenseTypeConvert.INSTANCE.convert(bizExpenseType);
        convert.setImageConfigDOS(bizExpenseImageConfigService.getBizExpenseImageConfigList(id));
        return success(convert);
    }

    @GetMapping("/list")
    @Operation(summary = "获得费用类型列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:query')")
    public CommonResult<List<BizExpenseTypeRespVO>> getBizExpenseTypeList(@RequestParam("ids") Collection<Long> ids) {
        List<BizExpenseTypeDO> list = bizExpenseTypeService.getBizExpenseTypeList(ids);
        return success(BizExpenseTypeConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/dictList")
    @Operation(summary = "获得费用类型列表-字典")
    public CommonResult<List<BizExpenseTypeDictRespVO>> getBizExpenseTypeDictList() {
        List<BizExpenseTypeDO> list = bizExpenseTypeService.getBizExpenseTypeList();
        List<BizExpenseTypeDictRespVO> expenseTypeDictRespVOS = BizExpenseTypeConvert.INSTANCE.convertDictList(list);
        return success(expenseTypeDictRespVOS);
    }

    @GetMapping("/history-dictList")
    @Operation(summary = "获得费用类型列表-字典")
    public CommonResult<List<BizExpenseTypeDictRespVO>> getHistoryBizExpenseTypeDictList() {
        List<BizExpenseTypeDictRespVO> list = bizExpenseTypeService.getBizExpenseTypeDictList();
        return success(list);
    }

    @GetMapping("/page")
    @Operation(summary = "获得费用类型分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:query')")
    public CommonResult<PageResult<BizExpenseTypeRespVO>> getBizExpenseTypePage(@Valid BizExpenseTypePageReqVO pageVO) {
        PageResult<BizExpenseTypeDO> pageResult = bizExpenseTypeService.getBizExpenseTypePage(pageVO);
        PageResult<BizExpenseTypeRespVO> pageResultAll = BizExpenseTypeConvert.INSTANCE.convertPage(pageResult);
        for (BizExpenseTypeRespVO item : pageResultAll.getList()) {
            List<BizExpenseImageConfigDO> bizExpenseImageConfigDOS = bizExpenseImageConfigService.getBizExpenseImageConfigList(item.getId());
            if (null != bizExpenseImageConfigDOS && bizExpenseImageConfigDOS.size() > 0) {
                item.setImageConfigDOS(bizExpenseImageConfigDOS);
            }
        }
        return success(pageResultAll);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出费用类型 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:export')")
    @OperateLog(type = EXPORT)
    public void exportBizExpenseTypeExcel(@Valid BizExpenseTypeExportReqVO exportReqVO,
                                          HttpServletResponse response) throws IOException {
        List<BizExpenseTypeDO> list = bizExpenseTypeService.getBizExpenseTypeList(exportReqVO);
        // 导出 Excel
        List<BizExpenseTypeExcelVO> datas = BizExpenseTypeConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "费用类型.xls", "数据", BizExpenseTypeExcelVO.class, datas);
    }

    @PostMapping("/updateStatus")
    @Operation(summary = "更新费用类型状态")
    //@PreAuthorize("@ss.hasPermission('bizcenter:biz-expense-type:query')")
    public CommonResult<Boolean> updateBizExpenseStatus(@Valid @RequestBody BizExpenseTypeUpdateReqVO updateReqVO) {
        bizExpenseTypeService.updateBizExpenseStatus(updateReqVO.getId(), updateReqVO.getStatus());
        return success(true);
    }
    @PostMapping("/imprestControl")
    @Operation(summary = "设置费用类型是否启用备用金")
    public CommonResult<Boolean> imprestControl(@Valid @RequestBody BizExpenseTypeUpdateReqVO updateReqVO) {
        bizExpenseTypeService.imprestControl(updateReqVO.getId(), updateReqVO.getImprestStatus());
        return success(true);
    }
}
