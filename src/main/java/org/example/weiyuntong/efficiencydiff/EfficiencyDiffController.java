package org.example.weiyuntong.efficiencydiff;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.module.opecenter.controller.admin.efficiencydiff.vo.*;
import com.weiyuntong.module.opecenter.convert.efficiencydiff.EfficiencyDiffConvert;
import com.weiyuntong.module.opecenter.dal.dataobject.efficiencydiff.EfficiencyDiffDO;
import com.weiyuntong.module.opecenter.enums.CapacityType;
import com.weiyuntong.module.opecenter.service.efficiencydiff.EfficiencyDiffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.*;
import javax.validation.constraints.*;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "管理后台 - 效率预警阈值")
@RestController
@RequestMapping("/opecenter/efficiency-diff")
@Validated
public class EfficiencyDiffController {

    @Resource
    private EfficiencyDiffService efficiencyDiffService;

    @PostMapping("/create")
    @Operation(summary = "创建效率预警阈值")
    @PreAuthorize("@ss.hasPermission('opecenter:efficiency-diff:create')")
    public CommonResult<Long> createEfficiencyDiff(@RequestBody EfficiencyDiffDO createReqVO) {
        createReqVO.setType(CapacityType.CAR);
        return success(efficiencyDiffService.createEfficiencyDiff(createReqVO));
    }

    @PostMapping("/driver-create")
    @Operation(summary = "创建效率预警阈值")
    @PreAuthorize("@ss.hasPermission('opecenter:efficiency-diff:create')")
    public CommonResult<Long> createDriverEfficiencyDiff(@RequestBody EfficiencyDiffDO createReqVO) {
        createReqVO.setType(CapacityType.DRIVER);
        return success(efficiencyDiffService.createDriverEfficiencyDiff(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新效率预警阈值")
    @PreAuthorize("@ss.hasPermission('opecenter:efficiency-diff:update')")
    public CommonResult<Boolean> updateEfficiencyDiff(@Valid @RequestBody EfficiencyDiffUpdateReqVO updateReqVO) {
        efficiencyDiffService.updateEfficiencyDiff(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除效率预警阈值")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('opecenter:efficiency-diff:delete')")
    public CommonResult<Boolean> deleteEfficiencyDiff(@RequestParam("id") Long id) {
        efficiencyDiffService.deleteEfficiencyDiff(id);
        return success(true);
    }

    @GetMapping("/getByEntId")
    @Operation(summary = "获得效率预警阈值")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('opecenter:efficiency-diff:query')")
    public CommonResult<EfficiencyDiffRespVO> getEfficiencyDiff(@RequestParam("id") Long entId,String type) {
        EfficiencyDiffDO efficiencyDiff = efficiencyDiffService.getEfficiencyDiffByEntId(entId,type);
        return success(EfficiencyDiffConvert.INSTANCE.convert(efficiencyDiff));
    }


}
