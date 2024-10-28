package org.example.weiyuntong.bizimpresteditrecord;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.bizimpresteditrecord.vo.*;
import com.weiyuntong.module.bizcenter.convert.bizimpresteditrecord.BizImprestEditRecordConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.bizimpresteditrecord.BizImprestEditRecordDO;
import com.weiyuntong.module.bizcenter.service.bizimpresteditrecord.BizImprestEditRecordService;
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

@Tag(name = "备用金修改记录")
@RestController
@RequestMapping("/bizcenter/biz-imprest-edit-record")
@Validated
public class BizImprestEditRecordController {

    @Resource
    private BizImprestEditRecordService bizImprestEditRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建备用金修改记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:create')")
    public CommonResult<Long> createBizImprestEditRecord(@Valid @RequestBody BizImprestEditRecordCreateReqVO createReqVO) {
        return success(bizImprestEditRecordService.createBizImprestEditRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新备用金修改记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:update')")
    public CommonResult<Boolean> updateBizImprestEditRecord(@Valid @RequestBody BizImprestEditRecordUpdateReqVO updateReqVO) {
        bizImprestEditRecordService.updateBizImprestEditRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除备用金修改记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:delete')")
    public CommonResult<Boolean> deleteBizImprestEditRecord(@RequestParam("id") Long id) {
        bizImprestEditRecordService.deleteBizImprestEditRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得备用金修改记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:query')")
    public CommonResult<BizImprestEditRecordRespVO> getBizImprestEditRecord(@RequestParam("id") Long id) {
        BizImprestEditRecordDO bizImprestEditRecord = bizImprestEditRecordService.getBizImprestEditRecord(id);
        return success(BizImprestEditRecordConvert.INSTANCE.convert(bizImprestEditRecord));
    }

    @GetMapping("/list")
    @Operation(summary = "获得备用金修改记录列表按照ID获取")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:query')")
    public CommonResult<List<BizImprestEditRecordRespVO>> getBizImprestEditRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<BizImprestEditRecordDO> list = bizImprestEditRecordService.getBizImprestEditRecordList(ids);
        return success(BizImprestEditRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得备用金修改记录分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:query')")
    public CommonResult<PageResult<BizImprestEditRecordRespVO>> getBizImprestEditRecordPage(@Valid BizImprestEditRecordPageReqVO pageVO) {
        PageResult<BizImprestEditRecordDO> pageResult = bizImprestEditRecordService.getBizImprestEditRecordPage(pageVO);
        return success(BizImprestEditRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出备用金修改记录 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:export')")
    @OperateLog(type = EXPORT)
    public void exportBizImprestEditRecordExcel(@Valid BizImprestEditRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BizImprestEditRecordDO> list = bizImprestEditRecordService.getBizImprestEditRecordList(exportReqVO);
        // 导出 Excel
        List<BizImprestEditRecordExcelVO> datas = BizImprestEditRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "备用金修改记录.xls", "数据", BizImprestEditRecordExcelVO.class, datas);
    }
    @PostMapping("/editList")
    @Operation(summary = "获得当前企业备用金修改记录列表")
    //@PreAuthorize("@ss.hasPermission('bizcenter:biz-imprest-edit-record:query')")
    public CommonResult<List<BizImprestEditRecordRespVO>> getBizImprestEditRecordInfoList() {
        List<BizImprestEditRecordDO> list = bizImprestEditRecordService.getBizImprestEditRecordInfoList(WebFrameworkUtils.getTenantId());
        return success(BizImprestEditRecordConvert.INSTANCE.convertList(list));
    }
}
