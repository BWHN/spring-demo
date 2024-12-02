package org.example.weiyuntong.transporttaskmatch;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.transporttaskmatch.vo.*;
import com.weiyuntong.module.bizcenter.convert.transporttaskmatch.TransportTaskMatchConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskmatch.TransportTaskMatchDO;
import com.weiyuntong.module.bizcenter.service.transporttaskmatch.TransportTaskMatchService;
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

@Tag(name = "业务中心 - 运输任务匹配信息")
@RestController
@RequestMapping("/bizcenter/transport-task-match")
@Validated
public class TransportTaskMatchController {

    @Resource
    private TransportTaskMatchService transportTaskMatchService;

    @PostMapping("/create")
    @Operation(summary = "创建运输任务匹配信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:create')")
    public CommonResult<Long> createTransportTaskMatch(@Valid @RequestBody TransportTaskMatchCreateReqVO createReqVO) {
        return success(transportTaskMatchService.createTransportTaskMatch(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新运输任务匹配信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:update')")
    public CommonResult<Boolean> updateTransportTaskMatch(@Valid @RequestBody TransportTaskMatchUpdateReqVO updateReqVO) {
        transportTaskMatchService.updateTransportTaskMatch(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除运输任务匹配信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:delete')")
    public CommonResult<Boolean> deleteTransportTaskMatch(@RequestParam("id") Long id) {
        transportTaskMatchService.deleteTransportTaskMatch(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得运输任务匹配信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:query')")
    public CommonResult<TransportTaskMatchRespVO> getTransportTaskMatch(@RequestParam("id") Long id) {
        TransportTaskMatchDO transportTaskMatch = transportTaskMatchService.getTransportTaskMatch(id);
        return success(TransportTaskMatchConvert.INSTANCE.convert(transportTaskMatch));
    }

    @GetMapping("/list")
    @Operation(summary = "获得运输任务匹配信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:query')")
    public CommonResult<List<TransportTaskMatchRespVO>> getTransportTaskMatchList(@RequestParam("ids") Collection<Long> ids) {
        List<TransportTaskMatchDO> list = transportTaskMatchService.getTransportTaskMatchList(ids);
        return success(TransportTaskMatchConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得运输任务匹配信息分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:query')")
    public CommonResult<PageResult<TransportTaskMatchRespVO>> getTransportTaskMatchPage(@Valid TransportTaskMatchPageReqVO pageVO) {
        PageResult<TransportTaskMatchDO> pageResult = transportTaskMatchService.getTransportTaskMatchPage(pageVO);
        return success(TransportTaskMatchConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出运输任务匹配信息 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:transport-task-match:export')")
    @OperateLog(type = EXPORT)
    public void exportTransportTaskMatchExcel(@Valid TransportTaskMatchExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TransportTaskMatchDO> list = transportTaskMatchService.getTransportTaskMatchList(exportReqVO);
        // 导出 Excel
        List<TransportTaskMatchExcelVO> datas = TransportTaskMatchConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "运输任务匹配信息.xls", "数据", TransportTaskMatchExcelVO.class, datas);
    }

}
