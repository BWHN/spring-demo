package org.example.weiyuntong.violations;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.MyPageResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.fleetcenter.controller.admin.violations.vo.*;
import com.weiyuntong.module.fleetcenter.convert.violations.ViolationsConvert;
import com.weiyuntong.module.fleetcenter.dal.dataobject.violations.ViolationsDO;
import com.weiyuntong.module.fleetcenter.service.violations.ViolationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "车队中心 - 违规管理")
@RestController
@RequestMapping("/fleetcenter/violations")
@Validated
public class ViolationsController {

    @Resource
    private ViolationsService violationsService;

    @PostMapping("/create")
    @Operation(summary = "创建违规记录")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:create')")
    public CommonResult<Long> createViolations(@Valid @RequestBody ViolationsCreateReqVO createReqVO) {
        return success(violationsService.createViolations(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新违规记录")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:update')")
    public CommonResult<Boolean> updateViolations(@Valid @RequestBody ViolationsUpdateReqVO updateReqVO) {
        violationsService.updateViolations(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除违规记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:delete')")
    public CommonResult<Boolean> deleteViolations(@RequestParam("id") Long id) {
        violationsService.deleteViolations(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得违规记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:query')")
    public CommonResult<ViolationsRespVO> getViolations(@RequestParam("id") Long id) {
        ViolationsDO violations = violationsService.getViolations(id);
        return success(ViolationsConvert.INSTANCE.convert(violations));
    }

    @GetMapping("/list")
    @Operation(summary = "获得违规记录列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:query')")
    public CommonResult<List<ViolationsRespVO>> getViolationsList(@RequestParam("ids") Collection<Long> ids) {
        List<ViolationsDO> list = violationsService.getViolationsList(ids);
        return success(ViolationsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得违规记录分页")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:query')")
    public CommonResult<PageResult<ViolationsRespVO>> getViolationsPage(@Valid ViolationsPageReqVO pageVO) {
        PageResult<ViolationsDO> pageResult = violationsService.getViolationsPage(pageVO);
        return success(ViolationsConvert.INSTANCE.convertPage(pageResult));
    }

    @PostMapping("/pages")
    @Operation(summary = "获得违规记录分页")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:query')")
    public CommonResult<MyPageResult<ViolationsRespVO>> getViolationsPages(@RequestBody @Valid ViolationsPageReqVO pageVO) {
        return success(violationsService.getViolationsPages(pageVO));
    }

    @RequestMapping(value = "/creatFile", method = {RequestMethod.POST, RequestMethod.PUT})
    @Operation(summary = "上传违规截图")
    public CommonResult<String> creatFile(@Parameter(description = "违规截图")
                                          @RequestParam("file") MultipartFile file,
                                          @Parameter(description = "车牌号")
                                          @RequestParam("license") String license
    ) throws Exception {
        return success(violationsService.creatFile(file, license));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出违规记录 Excel")
    @PreAuthorize("@ss.hasPermission('fleetcenter:violations:export')")
    @OperateLog(type = EXPORT)
    public void exportViolationsExcel(@Valid ViolationsExportReqVO exportReqVO,
                                      HttpServletResponse response) throws IOException {
        List<ViolationsDO> list = violationsService.getViolationsList(exportReqVO);
        // 导出 Excel
        List<ViolationsExcelVO> datas = ViolationsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "违规记录.xls", "违规记录", ViolationsExcelVO.class, datas);
    }

}
