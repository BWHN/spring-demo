package org.example.weiyuntong.credit;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.credit.vo.CreditConfigCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.credit.vo.CreditConfigRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.credit.vo.CreditConfigUpdateReqVO;
import com.weiyuntong.module.bizcenter.convert.credit.CreditConfigConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.credit.CreditConfigDO;
import com.weiyuntong.module.bizcenter.service.credit.CreditConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.*;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "管理后台 - 赊销配置")
@RestController
@RequestMapping("/bizcneter/credit-config")
@Validated
public class CreditConfigController {

    @Resource
    private CreditConfigService creditConfigService;

    @PostMapping("/create")
    @Operation(summary = "创建赊销配置")
    @PreAuthorize("@ss.hasPermission('bizcneter:credit-config:create')")
    public CommonResult<Long> createCreditConfig(@Valid @RequestBody CreditConfigCreateReqVO createReqVO) {
        return success(creditConfigService.createCreditConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新赊销配置")
    @PreAuthorize("@ss.hasPermission('bizcneter:credit-config:update')")
    public CommonResult<Boolean> updateCreditConfig(@Valid @RequestBody CreditConfigUpdateReqVO updateReqVO) {
        creditConfigService.updateCreditConfig(updateReqVO);
        return success(true);
    }

//    @DeleteMapping("/delete")
//    @Operation(summary = "删除赊销配置")
//    @Parameter(name = "id", description = "编号", required = true)
//    @PreAuthorize("@ss.hasPermission('bizcneter:credit-config:delete')")
//    public CommonResult<Boolean> deleteCreditConfig(@RequestParam("id") Long id) {
//        creditConfigService.deleteCreditConfig(id);
//        return success(true);
//    }

    @GetMapping("/get")
    @Operation(summary = "获得赊销配置")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcneter:credit-config:query')")
    public CommonResult<CreditConfigRespVO> getCreditConfig(@RequestParam("id") Long id) {
        CreditConfigDO creditConfig = creditConfigService.getCreditConfig(id);
        return success(CreditConfigConvert.INSTANCE.convert(creditConfig));
    }

    @GetMapping("/getCustomerCreditConfig")
    @Operation(summary = "获得企业名下赊销配置信息")
    public CommonResult<CreditConfigRespVO> getCustomerCreditConfig() {
        CreditConfigDO creditConfig = creditConfigService.getCustomerCreditConfig(WebFrameworkUtils.getTenantId());
        return success(CreditConfigConvert.INSTANCE.convert(creditConfig));
    }

//    @GetMapping("/list")
//    @Operation(summary = "获得赊销配置列表")
//    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
//    @PreAuthorize("@ss.hasPermission('Picketer:credit-config:query')")
//    public CommonResult<List<CreditConfigRespVO>> getCreditConfigList(@RequestParam("ids") Collection<Long> ids) {
//        List<CreditConfigDO> list = creditConfigService.getCreditConfigList(ids);
//        return success(CreditConfigConvert.INSTANCE.convertList(list));
//    }
//
//    @GetMapping("/page")
//    @Operation(summary = "获得赊销配置分页")
//    @PreAuthorize("@ss.hasPermission('bizcneter:credit-config:query')")
//    public CommonResult<PageResult<CreditConfigRespVO>> getCreditConfigPage(@Valid CreditConfigPageReqVO pageVO) {
//        PageResult<CreditConfigDO> pageResult = creditConfigService.getCreditConfigPage(pageVO);
//        return success(CreditConfigConvert.INSTANCE.convertPage(pageResult));
//    }
//
//    @GetMapping("/export-excel")
//    @Operation(summary = "导出赊销配置 Excel")
//    @PreAuthorize("@ss.hasPermission('bizcneter:credit-config:export')")
//    @OperateLog(type = EXPORT)
//    public void exportCreditConfigExcel(@Valid CreditConfigExportReqVO exportReqVO,
//              HttpServletResponse response) throws IOException {
//        List<CreditConfigDO> list = creditConfigService.getCreditConfigList(exportReqVO);
//        // 导出 Excel
//        List<CreditConfigExcelVO> datas = CreditConfigConvert.INSTANCE.convertList02(list);
//        ExcelUtils.write(response, "赊销配置.xls", "数据", CreditConfigExcelVO.class, datas);
//    }

}
