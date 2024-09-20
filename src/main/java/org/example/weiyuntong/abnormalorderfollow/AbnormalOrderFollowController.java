package org.example.weiyuntong.abnormalorderfollow;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.abnormalorderfollow.vo.*;
import com.weiyuntong.module.bizcenter.convert.abnormalorderfollow.AbnormalOrderFollowConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.abnormalorderfollow.AbnormalOrderFollowDO;
import com.weiyuntong.module.bizcenter.service.abnormalorderfollow.AbnormalOrderFollowService;
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

@Tag(name = "运营中心-异常管理-委托失效记录跟进记录")
@RestController
@RequestMapping("/bizcenter/abnormal-order-follow")
@Validated
public class AbnormalOrderFollowController {

    @Resource
    private AbnormalOrderFollowService abnormalOrderFollowService;

    @PostMapping("/create")
    @Operation(summary = "创建委托失效记录跟进记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:create')")
    public CommonResult<Long> createAbnormalOrderFollow(@Valid @RequestBody AbnormalOrderFollowCreateReqVO createReqVO) {
        return success(abnormalOrderFollowService.createAbnormalOrderFollow(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新委托失效记录跟进记录")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:update')")
    public CommonResult<Boolean> updateAbnormalOrderFollow(@Valid @RequestBody AbnormalOrderFollowUpdateReqVO updateReqVO) {
        abnormalOrderFollowService.updateAbnormalOrderFollow(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除委托失效记录跟进记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:delete')")
    public CommonResult<Boolean> deleteAbnormalOrderFollow(@RequestParam("id") Long id) {
        abnormalOrderFollowService.deleteAbnormalOrderFollow(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得委托失效记录跟进记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:query')")
    public CommonResult<AbnormalOrderFollowRespVO> getAbnormalOrderFollow(@RequestParam("id") Long id) {
        AbnormalOrderFollowDO abnormalOrderFollow = abnormalOrderFollowService.getAbnormalOrderFollow(id);
        return success(AbnormalOrderFollowConvert.INSTANCE.convert(abnormalOrderFollow));
    }

    @GetMapping("/list")
    @Operation(summary = "获得委托失效记录跟进记录列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:query')")
    public CommonResult<List<AbnormalOrderFollowRespVO>> getAbnormalOrderFollowList(@RequestParam("ids") Collection<Long> ids) {
        List<AbnormalOrderFollowDO> list = abnormalOrderFollowService.getAbnormalOrderFollowList(ids);
        return success(AbnormalOrderFollowConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得委托失效记录跟进记录分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:query')")
    public CommonResult<PageResult<AbnormalOrderFollowRespVO>> getAbnormalOrderFollowPage(@Valid AbnormalOrderFollowPageReqVO pageVO) {
        PageResult<AbnormalOrderFollowDO> pageResult = abnormalOrderFollowService.getAbnormalOrderFollowPage(pageVO);
        return success(AbnormalOrderFollowConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出委托失效记录跟进记录 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:export')")
    @OperateLog(type = EXPORT)
    public void exportAbnormalOrderFollowExcel(@Valid AbnormalOrderFollowExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AbnormalOrderFollowDO> list = abnormalOrderFollowService.getAbnormalOrderFollowList(exportReqVO);
        // 导出 Excel
        List<AbnormalOrderFollowExcelVO> datas = AbnormalOrderFollowConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "委托失效记录跟进记录.xls", "数据", AbnormalOrderFollowExcelVO.class, datas);
    }
    @GetMapping("/followList")
    @Operation(summary = "获得委托失效记录跟进记录列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:abnormal-order-follow:query')")
    public CommonResult<List<AbnormalOrderFollowRespVO>> getAbnormalOrderFollowListByEntrustId(@RequestParam("id") Long entrustId) {
        List<AbnormalOrderFollowDO> list = abnormalOrderFollowService.getAbnormalOrderFollowListByEntrustId(entrustId);
        return success(AbnormalOrderFollowConvert.INSTANCE.convertList(list));
    }
}
