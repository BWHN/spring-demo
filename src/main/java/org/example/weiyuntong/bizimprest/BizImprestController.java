package org.example.weiyuntong.bizimprest;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.bizimprest.vo.*;
import com.weiyuntong.module.bizcenter.convert.bizimprest.BizImprestConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.bizimprest.BizImprestDO;
import com.weiyuntong.module.bizcenter.service.bizimprest.BizImprestService;
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

@Tag(name = "备用金信息")
@RestController
@RequestMapping("/bizcenter/biz-imprest")
@Validated
public class BizImprestController {

    @Resource
    private BizImprestService bizImprestService;

    @PostMapping("/create")
    @Operation(summary = "创建备用金信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:create')")
    public CommonResult<Long> createBizImprest(@Valid @RequestBody BizImprestCreateReqVO createReqVO) {
        return success(bizImprestService.createBizImprest(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新备用金信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:update')")
    public CommonResult<Boolean> updateBizImprest(@Valid @RequestBody BizImprestUpdateReqVO updateReqVO) {
        bizImprestService.updateBizImprest(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除备用金信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:delete')")
    public CommonResult<Boolean> deleteBizImprest(@RequestParam("id") Long id) {
        bizImprestService.deleteBizImprest(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得备用金信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:query')")
    public CommonResult<BizImprestRespVO> getBizImprest(@RequestParam("id") Long id) {
        BizImprestDO bizImprest = bizImprestService.getBizImprest(id);
        return success(BizImprestConvert.INSTANCE.convert(bizImprest));
    }

    @GetMapping("/list")
    @Operation(summary = "获得备用金信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:query')")
    public CommonResult<List<BizImprestRespVO>> getBizImprestList(@RequestParam("ids") Collection<Long> ids) {
        List<BizImprestDO> list = bizImprestService.getBizImprestList(ids);
        return success(BizImprestConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得备用金信息分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:query')")
    public CommonResult<PageResult<BizImprestRespVO>> getBizImprestPage(@Valid BizImprestPageReqVO pageVO) {
        PageResult<BizImprestDO> pageResult = bizImprestService.getBizImprestPage(pageVO);
        return success(BizImprestConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出备用金信息 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest:export')")
    @OperateLog(type = EXPORT)
    public void exportBizImprestExcel(@Valid BizImprestExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BizImprestDO> list = bizImprestService.getBizImprestList(exportReqVO);
        // 导出 Excel
        List<BizImprestExcelVO> datas = BizImprestConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "备用金信息.xls", "数据", BizImprestExcelVO.class, datas);
    }
    @PostMapping("/setBizImprest")
    @Operation(summary = "设置备用金默认值")
    @PreAuthorize("@ss.hasPermission('bizcenter:expense-info:set')")
    public CommonResult<Boolean>  setExpenseInfo(@Valid @RequestBody BizImprestCreateReqVO createReqVO) {
        bizImprestService.setExpenseInfo(createReqVO);
        return success(true);
    }
}
