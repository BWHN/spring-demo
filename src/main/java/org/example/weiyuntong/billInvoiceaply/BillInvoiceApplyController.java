package org.example.weiyuntong.billInvoiceaply;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.*;
import com.weiyuntong.module.bizcenter.service.billinvoiceapply.BillInvoiceApplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "开票申请")
@RestController
@RequestMapping("/bizcenter/bill-invoice-apply")
@Validated
public class BillInvoiceApplyController {

    @Resource
    private BillInvoiceApplyService billInvoiceApplyService;

    @PostMapping("/create")
    @Operation(summary = "创建开票申请")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice-apply:create')")
    @Idempotent
    public CommonResult<?> create(@RequestBody BillInvoiceApplyCreateVO createReqVO) {
        return billInvoiceApplyService.create(createReqVO);
    }

    @GetMapping("/page")
    @Operation(summary = "开票申请分页")
    public CommonResult<PageResult<BillInvoiceApplyPageResVO>> page(BillInvoiceApplyPageReqVO pageVO) {
        return success(billInvoiceApplyService.page(pageVO));
    }

    @GetMapping("/summary")
    @Operation(summary = "开票申请统计")
    public CommonResult<BillInvoiceApplyPageSummaryVO> summary(BillInvoiceApplyPageReqVO pageVO) {
        return success(billInvoiceApplyService.summary(pageVO));
    }

    @GetMapping("/detail")
    @Operation(summary = "开票申请详情")
    public CommonResult<BillInvoiceApplyDetailVO> detail(Long id) {
        return success(billInvoiceApplyService.detail(id));
    }

    @PostMapping("/update")
    @Operation(summary = "更新开票申请")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice-apply:update')")
    @Idempotent
    public CommonResult<?> update(@RequestBody BillInvoiceApplyUpdateVO updateReqVO) {
        return billInvoiceApplyService.update(updateReqVO);
    }

    @GetMapping("/submit")
    @Operation(summary = "开票申请提交")
    public CommonResult<?> submit(Long id) {
        return billInvoiceApplyService.submit(id);
    }

    @PostMapping("/reject")
    @Operation(summary = "退回开票申请")
    public CommonResult<?> reject(@RequestBody BillInvoiceApplyAbortReqVO abortReqVO) {
        return billInvoiceApplyService.reject(abortReqVO);
    }

    @GetMapping("/invoke")
    @Operation(summary = "撤销开票申请")
    public CommonResult<?> invoke(Long id) {
        return billInvoiceApplyService.invoke(id);
    }

    @GetMapping("/review")
    @Operation(summary = "开票申请审核")
    public CommonResult<?> review(Long id) {
        return billInvoiceApplyService.review(id);
    }

    @PostMapping("/register-invoice")
    @Operation(summary = "开票申请登记开票")
    public CommonResult<?> registerInvoice(@RequestBody BillInvoiceApplyRegisterReqVO reqVO) {
        return billInvoiceApplyService.registerInvoice(reqVO);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除开票申请")
    public CommonResult<?> delete(Long id) {
        return billInvoiceApplyService.delete(id);
    }

    @GetMapping("/bill-waybill-source-page")
    @Operation(summary = "账单的运单分页")
    public CommonResult<PageResult<BillWaybillSourcePageResVO>> billWaybillSourcePage(BillWaybillSourcePageReqVO pageVO) {
        return success(billInvoiceApplyService.billWaybillSourcePage(pageVO));
    }

}
