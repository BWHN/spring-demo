package org.example.weiyuntong.identitycard;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.identitycard.vo.*;
import com.weiyuntong.module.bizcenter.convert.identitycard.IdentityCardConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.identitycard.IdentityCardDO;
import com.weiyuntong.module.bizcenter.service.identitycard.IdentityCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;


@Tag(name = "管理后台 - 用户身份信息")
@RestController
@RequestMapping("/biz/identity-card")
@Validated
public class IdentityCardController {

    @Resource
    private IdentityCardService identityCardService;

    @PostMapping("/create")
    @Operation(summary = "创建用户身份信息")
    @PreAuthorize("@ss.hasPermission('biz:identity-card:create')")
    public CommonResult<Long> createIdentityCard(@Valid @RequestBody IdentityCardCreateReqVO createReqVO) {
        return success(identityCardService.createIdentityCard(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户身份信息")
    @PreAuthorize("@ss.hasPermission('biz:identity-card:update')")
    public CommonResult<Boolean> updateIdentityCard(@Valid @RequestBody IdentityCardUpdateReqVO updateReqVO) {
        identityCardService.updateIdentityCard(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除用户身份信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('biz:identity-card:delete')")
    public CommonResult<Boolean> deleteIdentityCard(@RequestParam("id") Long id) {
        identityCardService.deleteIdentityCard(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得用户身份信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('biz:identity-card:query')")
    public CommonResult<IdentityCardRespVO> getIdentityCard(@RequestParam("id") Long id) {
        IdentityCardDO identityCard = identityCardService.getIdentityCard(id);
        return success(IdentityCardConvert.INSTANCE.convert(identityCard));
    }

    @GetMapping("/list")
    @Operation(summary = "获得用户身份信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('biz:identity-card:query')")
    public CommonResult<List<IdentityCardRespVO>> getIdentityCardList(@RequestParam("ids") Collection<Long> ids) {
        List<IdentityCardDO> list = identityCardService.getIdentityCardList(ids);
        return success(IdentityCardConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得用户身份信息分页")
    @PreAuthorize("@ss.hasPermission('biz:identity-card:query')")
    public CommonResult<PageResult<IdentityCardRespVO>> getIdentityCardPage(@Valid IdentityCardPageReqVO pageVO) {
        PageResult<IdentityCardDO> pageResult = identityCardService.getIdentityCardPage(pageVO);
        return success(IdentityCardConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出用户身份信息 Excel")
    @PreAuthorize("@ss.hasPermission('biz:identity-card:export')")
    @OperateLog(type = EXPORT)
    public void exportIdentityCardExcel(@Valid IdentityCardExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<IdentityCardDO> list = identityCardService.getIdentityCardList(exportReqVO);
        // 导出 Excel
        List<IdentityCardExcelVO> datas = IdentityCardConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "用户身份信息.xls", "数据", IdentityCardExcelVO.class, datas);
    }

}
