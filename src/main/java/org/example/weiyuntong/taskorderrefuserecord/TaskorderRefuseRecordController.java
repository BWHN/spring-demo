package org.example.weiyuntong.taskorderrefuserecord;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.taskorderrefuserecord.vo.*;
import com.weiyuntong.module.bizcenter.convert.taskorderrefuserecord.TaskorderRefuseRecordConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.taskorderrefuserecord.TaskorderRefuseRecordDO;
import com.weiyuntong.module.bizcenter.service.taskorderrefuserecord.TaskorderRefuseRecordService;
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

@Tag(name = "业务中心-任务管理-拒绝任务信息")
@RestController
@RequestMapping("/bizcenter/taskorder-refuse-record")
@Validated
public class TaskorderRefuseRecordController {

    @Resource
    private TaskorderRefuseRecordService taskorderRefuseRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建任务单拒绝记录信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:create')")
    public CommonResult<Long> createTaskorderRefuseRecord(@Valid @RequestBody TaskorderRefuseRecordCreateReqVO createReqVO) {
        return success(taskorderRefuseRecordService.createTaskorderRefuseRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新任务单拒绝记录信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:update')")
    public CommonResult<Boolean> updateTaskorderRefuseRecord(@Valid @RequestBody TaskorderRefuseRecordUpdateReqVO updateReqVO) {
        taskorderRefuseRecordService.updateTaskorderRefuseRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除任务单拒绝记录信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:delete')")
    public CommonResult<Boolean> deleteTaskorderRefuseRecord(@RequestParam("id") Long id) {
        taskorderRefuseRecordService.deleteTaskorderRefuseRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得任务单拒绝记录信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:query')")
    public CommonResult<TaskorderRefuseRecordRespVO> getTaskorderRefuseRecord(@RequestParam("id") Long id) {
        TaskorderRefuseRecordDO taskorderRefuseRecord = taskorderRefuseRecordService.getTaskorderRefuseRecord(id);
        return success(TaskorderRefuseRecordConvert.INSTANCE.convert(taskorderRefuseRecord));
    }

    @GetMapping("/getByEntOrderId")
    @Operation(summary = "获得任务单id查找拒绝信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
//    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:query')")
    public CommonResult<TaskorderRefuseRecordRespVO> getByEntOrderId(@RequestParam("id") Long orderId) {
        return success(taskorderRefuseRecordService.getByEntOrderId(orderId));
    }

    @GetMapping("/list")
    @Operation(summary = "获得任务单拒绝记录信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:query')")
    public CommonResult<List<TaskorderRefuseRecordRespVO>> getTaskorderRefuseRecordList(@RequestParam("ids") Collection<Long> ids) {
        List<TaskorderRefuseRecordDO> list = taskorderRefuseRecordService.getTaskorderRefuseRecordList(ids);
        return success(TaskorderRefuseRecordConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得任务单拒绝记录信息分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:query')")
    public CommonResult<PageResult<TaskorderRefuseRecordRespVO>> getTaskorderRefuseRecordPage(@Valid TaskorderRefuseRecordPageReqVO pageVO) {
        PageResult<TaskorderRefuseRecordDO> pageResult = taskorderRefuseRecordService.getTaskorderRefuseRecordPage(pageVO);
        return success(TaskorderRefuseRecordConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出任务单拒绝记录信息 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:taskorder-refuse-record:export')")
    @OperateLog(type = EXPORT)
    public void exportTaskorderRefuseRecordExcel(@Valid TaskorderRefuseRecordExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TaskorderRefuseRecordDO> list = taskorderRefuseRecordService.getTaskorderRefuseRecordList(exportReqVO);
        // 导出 Excel
        List<TaskorderRefuseRecordExcelVO> datas = TaskorderRefuseRecordConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "任务单拒绝记录信息.xls", "数据", TaskorderRefuseRecordExcelVO.class, datas);
    }

}
