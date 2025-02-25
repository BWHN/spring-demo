package org.example.weiyuntong.abnormalorderassign;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.abnormalorderassign.vo.*;
import com.weiyuntong.module.bizcenter.convert.abnormalorderassign.AbnormalOrderAssignConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.abnormalorderassign.AbnormalOrderAssignDO;
import com.weiyuntong.module.bizcenter.service.abnormalorderassign.AbnormalOrderAssignService;
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

@Tag(name = "运营中心-异常管理-委托失效分配记录")
@RestController
@RequestMapping("/bizcenter/abnormal-order-assign")
@Validated
public class AbnormalOrderAssignController {

    @Resource
    private AbnormalOrderAssignService abnormalOrderAssignService;

    @PostMapping("/create")
    @Operation(summary = "创建委托失效分配记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:create')")
    public CommonResult<Long> createAbnormalOrderAssign(@Valid @RequestBody AbnormalOrderAssignCreateReqVO createReqVO) {
        return success(abnormalOrderAssignService.createAbnormalOrderAssign(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新委托失效分配记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:update')")
    public CommonResult<Boolean> updateAbnormalOrderAssign(@Valid @RequestBody AbnormalOrderAssignUpdateReqVO updateReqVO) {
        abnormalOrderAssignService.updateAbnormalOrderAssign(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除委托失效分配记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:delete')")
    public CommonResult<Boolean> deleteAbnormalOrderAssign(@RequestParam("id") Long id) {
        abnormalOrderAssignService.deleteAbnormalOrderAssign(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得委托失效分配记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:query')")
    public CommonResult<AbnormalOrderAssignRespVO> getAbnormalOrderAssign(@RequestParam("id") Long id) {
        AbnormalOrderAssignDO abnormalOrderAssign = abnormalOrderAssignService.getAbnormalOrderAssign(id);
        return success(AbnormalOrderAssignConvert.INSTANCE.convert(abnormalOrderAssign));
    }

    @GetMapping("/list")
    @Operation(summary = "获得委托失效分配记录列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:query')")
    public CommonResult<List<AbnormalOrderAssignRespVO>> getAbnormalOrderAssignList(@RequestParam("ids") Collection<Long> ids) {
        List<AbnormalOrderAssignDO> list = abnormalOrderAssignService.getAbnormalOrderAssignList(ids);
        return success(AbnormalOrderAssignConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得委托失效分配记录分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:query')")
    public CommonResult<PageResult<AbnormalOrderAssignRespVO>> getAbnormalOrderAssignPage(@Valid AbnormalOrderAssignPageReqVO pageVO) {
        PageResult<AbnormalOrderAssignDO> pageResult = abnormalOrderAssignService.getAbnormalOrderAssignPage(pageVO);
        return success(AbnormalOrderAssignConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出委托失效分配记录 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-assign:export')")
    @OperateLog(type = EXPORT)
    public void exportAbnormalOrderAssignExcel(@Valid AbnormalOrderAssignExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AbnormalOrderAssignDO> list = abnormalOrderAssignService.getAbnormalOrderAssignList(exportReqVO);
        // 导出 Excel
        List<AbnormalOrderAssignExcelVO> datas = AbnormalOrderAssignConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "委托失效分配记录.xls", "数据", AbnormalOrderAssignExcelVO.class, datas);
    }

}
