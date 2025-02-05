package org.example.weiyuntong.updatelog;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.bizcenter.controller.admin.updatelog.vo.*;
import com.weiyuntong.module.bizcenter.convert.updatelog.UpdateLogConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.updatelog.UpdateLogDO;
import com.weiyuntong.module.bizcenter.service.updatelog.UpdateLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.*;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 修改记录")
@RestController
@RequestMapping("/bizcenter/update-log")
@Validated
public class UpdateLogController {

    @Resource
    private UpdateLogService updateLogService;

    @PostMapping("/create")
    @Operation(summary = "创建修改记录")
    public CommonResult<Long> createUpdateLog(@Valid @RequestBody UpdateLogCreateReqVO createReqVO) {
        return success(updateLogService.createUpdateLog(createReqVO));
    }

    @GetMapping("/get")
    @Operation(summary = "获得修改记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<UpdateLogRespVO> getUpdateLog(@RequestParam("id") Long id) {
        UpdateLogDO updateLog = updateLogService.getUpdateLog(id);
        return success(UpdateLogConvert.INSTANCE.convert(updateLog));
    }

    @GetMapping("/list")
    @Operation(summary = "获得修改记录列表")
    public CommonResult<List<UpdateLogRespVO>> getUpdateLogList(GetUpdateLogRespVO reqVO)  {
        List<UpdateLogDO> list = updateLogService.getUpdateLogList(reqVO);
        return success(UpdateLogConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/list1")
    @Operation(summary = "获得修改记录列表")
    public CommonResult<List<UpdateLogRespVO>> getUpdateLogList1(GetUpdateLogRespVO reqVO)  {
        List<UpdateLogDO> list = updateLogService.getUpdateLogList1(reqVO);
        return success(UpdateLogConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/customerList")
    @Operation(summary = "获得修改记录列表")
    public CommonResult<List<UpdateLogRespVO>> getUpdateLogCustomerList(@RequestParam("ids") List<Long> linkId) {
        List<UpdateLogDO> list = updateLogService.getUpdateLogCustomerList(linkId);
        return success(UpdateLogConvert.INSTANCE.convertList(list));
    }


}
