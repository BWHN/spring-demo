package org.example.weiyuntong.customerbill;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.customerbill.vo.*;
import com.weiyuntong.module.bizcenter.convert.customerbill.CustomerBillConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.customerbill.CustomerBillDO;
import com.weiyuntong.module.bizcenter.service.customerbill.CustomerBillService;
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

@Tag(name = "业务中心 - 客户开票信息")
@RestController
@RequestMapping("/bizcenter/customer-bill")
@Validated
public class CustomerBillController {

    @Resource
    private CustomerBillService customerBillService;

    @PostMapping("/create")
    @Operation(summary = "创建客户开票信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:create')")
    public CommonResult<Long> createCustomerBill(@Valid @RequestBody CustomerBillCreateReqVO createReqVO) {
        return success(customerBillService.createCustomerBill(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新客户开票信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:update')")
    public CommonResult<Boolean> updateCustomerBill(@Valid @RequestBody CustomerBillUpdateReqVO updateReqVO) {
        customerBillService.updateCustomerBill(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除客户开票信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:delete')")
    public CommonResult<Boolean> deleteCustomerBill(@RequestParam("id") Long id) {
        customerBillService.deleteCustomerBill(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得客户开票信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:query')")
    public CommonResult<CustomerBillRespVO> getCustomerBill(@RequestParam("id") Long id) {
        CustomerBillDO customerBill = customerBillService.getCustomerBill(id);
        return success(CustomerBillConvert.INSTANCE.convert(customerBill));
    }

    @GetMapping("/list")
    @Operation(summary = "获得客户开票信息列表")
    @Parameter(name = "customerId", description = "编号列表", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:query')")
    public CommonResult<List<CustomerBillRespVO>> getCustomerBillList(@RequestParam("customerId") Long customerId) {
        List<CustomerBillDO> list = customerBillService.getCustomerBillList(customerId);
        return success(CustomerBillConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得客户开票信息分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:query')")
    public CommonResult<PageResult<CustomerBillRespVO>> getCustomerBillPage(@Valid CustomerBillPageReqVO pageVO) {
        PageResult<CustomerBillDO> pageResult = customerBillService.getCustomerBillPage(pageVO);
        return success(CustomerBillConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出客户开票信息 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer-bill:export')")
    @OperateLog(type = EXPORT)
    public void exportCustomerBillExcel(@Valid CustomerBillExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CustomerBillDO> list = customerBillService.getCustomerBillList(exportReqVO);
        // 导出 Excel
        List<CustomerBillExcelVO> datas = CustomerBillConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "客户开票信息.xls", "数据", CustomerBillExcelVO.class, datas);
    }

}
