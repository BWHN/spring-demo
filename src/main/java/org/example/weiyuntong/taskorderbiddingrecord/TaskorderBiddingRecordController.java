package org.example.weiyuntong.taskorderbiddingrecord;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.taskorderbiddingrecord.vo.*;
import com.weiyuntong.module.bizcenter.convert.taskorderbiddingrecord.TaskorderBiddingRecordConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.taskorderbiddingrecord.TaskorderBiddingRecordDO;
import com.weiyuntong.module.bizcenter.service.taskorderbiddingrecord.TaskorderBiddingRecordService;
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

@Tag(name = "业务中心-任务管理-任务需求单报价")
@RestController
@RequestMapping("/bizcenter/taskorder-bidding-record")
@Validated
public class TaskorderBiddingRecordController {

    @Resource
    private TaskorderBiddingRecordService taskorderBiddingRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建任务单报价记录信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:create')")
    public CommonResult<Long> createTaskorderBiddingRecord(@Valid @RequestBody TaskorderBiddingRecordCreateReqVO createReqVO) {
        return success(taskorderBiddingRecordService.createTaskorderBiddingRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新任务单报价记录信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:update')")
    public CommonResult<Boolean> updateTaskorderBiddingRecord(@Valid @RequestBody TaskorderBiddingRecordUpdateReqVO updateReqVO) {
        taskorderBiddingRecordService.updateTaskorderBiddingRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除任务单报价记录信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:delete')")
    public CommonResult<Boolean> deleteTaskorderBiddingRecord(@RequestParam("id") Long id) {
        taskorderBiddingRecordService.deleteTaskorderBiddingRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得任务单报价记录信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:query')")
    public CommonResult<TaskorderBiddingRecordRespVO> getTaskorderBiddingRecord(@RequestParam("id") Long id) {
        TaskorderBiddingRecordDO taskorderBiddingRecord = taskorderBiddingRecordService.getTaskorderBiddingRecord(id);
        return success(TaskorderBiddingRecordConvert.INSTANCE.convert(taskorderBiddingRecord));
    }

    @GetMapping("/list")
    @Operation(summary = "获得任务单报价记录信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:query')")
    public CommonResult<List<TaskorderBiddingRecordRespVO>> getTaskorderBiddingRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<TaskorderBiddingRecordDO> list = taskorderBiddingRecordService.getTaskorderBiddingRecordList(ids);
        return success(TaskorderBiddingRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得任务单报价记录信息分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:query')")
    public CommonResult<PageResult<TaskorderBiddingRecordRespVO>> getTaskorderBiddingRecordPage(@Valid TaskorderBiddingRecordPageReqVO pageVO) {
        PageResult<TaskorderBiddingRecordDO> pageResult = taskorderBiddingRecordService.getTaskorderBiddingRecordPage(pageVO);
        return success(TaskorderBiddingRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出任务单报价记录信息 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-bidding-record:export')")
    @OperateLog(type = EXPORT)
    public void exportTaskorderBiddingRecordExcel(@Valid TaskorderBiddingRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TaskorderBiddingRecordDO> list = taskorderBiddingRecordService.getTaskorderBiddingRecordList(exportReqVO);
        // 导出 Excel
        List<TaskorderBiddingRecordExcelVO> datas = TaskorderBiddingRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "任务单报价记录信息.xls", "数据", TaskorderBiddingRecordExcelVO.class, datas);
    }

}
