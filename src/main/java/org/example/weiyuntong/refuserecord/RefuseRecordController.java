package org.example.weiyuntong.refuserecord;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.refuserecord.vo.*;
import com.weiyuntong.module.bizcenter.convert.refuserecord.RefuseRecordConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.refuserecord.RefuseRecordDO;
import com.weiyuntong.module.bizcenter.service.refuserecord.RefuseRecordService;
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

@Tag(name = "管理后台 - 撤销信息记录")
@RestController
@RequestMapping("/bizcenter/refuse-record")
@Validated
public class RefuseRecordController {

    @Resource
    private RefuseRecordService refuseRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建撤销信息记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:create')")
    public CommonResult<Long> createRefuseRecord(@Valid @RequestBody RefuseRecordCreateReqVO createReqVO) {
        return success(refuseRecordService.createRefuseRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新撤销信息记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:update')")
    public CommonResult<Boolean> updateRefuseRecord(@Valid @RequestBody RefuseRecordUpdateReqVO updateReqVO) {
        refuseRecordService.updateRefuseRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除撤销信息记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:delete')")
    public CommonResult<Boolean> deleteRefuseRecord(@RequestParam("id") Long id) {
        refuseRecordService.deleteRefuseRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得撤销信息记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:query')")
    public CommonResult<RefuseRecordRespVO> getRefuseRecord(@RequestParam("id") Long id) {
        RefuseRecordDO refuseRecord = refuseRecordService.getRefuseRecord(id);
        return success(RefuseRecordConvert.INSTANCE.convert(refuseRecord));
    }

    @GetMapping("/list")
    @Operation(summary = "获得撤销信息记录列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:query')")
    public CommonResult<List<RefuseRecordRespVO>> getRefuseRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<RefuseRecordDO> list = refuseRecordService.getRefuseRecordList(ids);
        return success(RefuseRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得撤销信息记录分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:query')")
    public CommonResult<PageResult<RefuseRecordRespVO>> getRefuseRecordPage(@Valid RefuseRecordPageReqVO pageVO) {
        PageResult<RefuseRecordDO> pageResult = refuseRecordService.getRefuseRecordPage(pageVO);
        return success(RefuseRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出撤销信息记录 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:refuse-record:export')")
    @OperateLog(type = EXPORT)
    public void exportRefuseRecordExcel(@Valid RefuseRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RefuseRecordDO> list = refuseRecordService.getRefuseRecordList(exportReqVO);
        // 导出 Excel
        List<RefuseRecordExcelVO> datas = RefuseRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "撤销信息记录.xls", "数据", RefuseRecordExcelVO.class, datas);
    }

}
