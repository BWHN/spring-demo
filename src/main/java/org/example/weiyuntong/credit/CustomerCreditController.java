package org.example.weiyuntong.credit;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.credit.vo.*;
import com.weiyuntong.module.bizcenter.convert.credit.CustomerCreditConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.credit.CustomerCreditDO;
import com.weiyuntong.module.bizcenter.service.credit.CustomerCreditService;
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
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "管理后台 - 客户赊销")
@RestController
@RequestMapping("/bizcenter/customer-credit")
@Validated
public class CustomerCreditController {

    @Resource
    private CustomerCreditService customerCreditService;

//    @PostMapping("/create")
//    @Operation(summary = "创建客户赊销")
//    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:create')")
//    public CommonResult<Long> createCustomerCredit(@Valid @RequestBody CustomerCreditCreateReqVO createReqVO) {
//        return success(customerCreditService.createCustomerCredit(createReqVO));
//    }

    @GetMapping("/count")
    @Operation(summary = "获得客户赊销")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
//    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:query')")
    public CommonResult<CustomerCreditCountVO> count() {
        CustomerCreditCountVO customerCreditCountVO = customerCreditService.getCount();
        return success(customerCreditCountVO);
    }


    @PutMapping("/update")
    @Operation(summary = "更新客户赊销")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:update')")
    public CommonResult<Boolean> updateCustomerCredit(@Valid @RequestBody CustomerCreditUpdateReqVO updateReqVO) {
        customerCreditService.updateCustomerCredit(updateReqVO);
        return success(true);
    }

//    @DeleteMapping("/delete")
//    @Operation(summary = "删除客户赊销")
//    @Parameter(name = "id", description = "编号", required = true)
//    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:delete')")
//    public CommonResult<Boolean> deleteCustomerCredit(@RequestParam("id") Long id) {
//        customerCreditService.deleteCustomerCredit(id);
//        return success(true);
//    }

    @GetMapping("/get")
    @Operation(summary = "获得客户赊销")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:query')")
    public CommonResult<CustomerCreditRespVO> getCustomerCredit(@RequestParam("id") Long id) {
        CustomerCreditDO customerCredit = customerCreditService.getCustomerCredit(id);
        return success(CustomerCreditConvert.INSTANCE.convert(customerCredit));
    }

//    @GetMapping("/list")
//    @Operation(summary = "获得客户赊销列表")
//    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
//    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:query')")
//    public CommonResult<List<CustomerCreditRespVO>> getCustomerCreditList(@RequestParam("ids") Collection<Long> ids) {
//        List<CustomerCreditDO> list = customerCreditService.getCustomerCreditList(ids);
//        return success(CustomerCreditConvert.INSTANCE.convertList(list));
//    }

    @GetMapping("/page")
    @Operation(summary = "获得客户赊销分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:query')")
    public CommonResult<PageResult<CustomerCreditRespVO>> getCustomerCreditPage(@Valid CustomerCreditPageReqVO pageVO) {
        PageResult<CustomerCreditDO> pageResult = customerCreditService.getCustomerCreditPage(pageVO);
        return success(CustomerCreditConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出客户赊销 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-credit:export')")
    @OperateLog(type = EXPORT)
    public void exportCustomerCreditExcel(@Valid CustomerCreditExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CustomerCreditDO> list = customerCreditService.getCustomerCreditList(exportReqVO);
        // 导出 Excel
        List<CustomerCreditExcelVO> datas = CustomerCreditConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "客户赊销.xls", "数据", CustomerCreditExcelVO.class, datas);
    }

}
