package org.example.weiyuntong.billinvoiceregister;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.module.bizcenter.controller.admin.billinvoiceregister.vo.*;
import com.weiyuntong.module.bizcenter.service.billinvoiceregister.BillInvoiceRegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "开票记录")
@RestController
@RequestMapping("/bizcenter/bill-invoice-register")
@Validated
public class BillInvoiceRegisterController {

    @Resource
    private BillInvoiceRegisterService billInvoiceRegisterService;

    @PostMapping("/create")
    @Operation(summary = "创建开票登记")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice-register:create')")
    @Idempotent
    public CommonResult<?> create(@RequestBody BillInvoiceRegisterCreateVO createReqVO) {
        return success(billInvoiceRegisterService.create(createReqVO));
    }

    @GetMapping("/page")
    @Operation(summary = "开票记录分页")
    public CommonResult<PageResult<BillInvoiceRegisterPageResVO>> page(BillInvoiceRegisterPageReqVO pageVO) {
        return success(billInvoiceRegisterService.page(pageVO));
    }

    @GetMapping("/summary")
    @Operation(summary = "开票记录统计")
    public CommonResult<BillInvoiceRegisterPageSummaryVO> summary(BillInvoiceRegisterPageReqVO pageVO) {
        return success(billInvoiceRegisterService.summary(pageVO));
    }

    @GetMapping("/detail")
    @Operation(summary = "开票记录详情")
    public CommonResult<BillInvoiceRegisterDetailVO> detail(@RequestParam(required = false) Long id,
                                                            @RequestParam(required = false) String code) {
        return success(billInvoiceRegisterService.detail(id, code));
    }

    @GetMapping("/check")
    @Operation(summary = "开票记录核销")
    public CommonResult<?> check(Long id) {
        return billInvoiceRegisterService.check(id);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除开票记录")
    public CommonResult<?> delete(Long id) {
        return billInvoiceRegisterService.delete(id);
    }

}
