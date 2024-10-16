package org.example.weiyuntong.billpayapply;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.BillInvoiceApplyAbortReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.BillWaybillSourcePageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.BillWaybillSourcePageResVO;
import com.weiyuntong.module.bizcenter.controller.admin.billpayapply.vo.*;
import com.weiyuntong.module.bizcenter.service.billpayapply.BillPayApplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;


@Tag(name = "管理后台 - 付款申请")
@RestController
@RequestMapping("/bizcenter/bill-pay-apply")
@Validated
public class BillPayApplyController {

    @Resource
    private BillPayApplyService billPayApplyService;

    @PostMapping("/create")
    @Operation(summary = "创建付款申请")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay-apply:create')")
    @Idempotent
    public CommonResult<?> create(@Valid @RequestBody BillPayApplyCreateReqVO createReqVO) {
        return billPayApplyService.create(createReqVO);
    }

    @GetMapping("/detail")
    @Operation(summary = "付款申请")
    public CommonResult<BillPayApplyDetailVO> detail(@RequestParam("id") Long id) {
        return success(billPayApplyService.detail(id));
    }

    @PostMapping("/update")
    @Operation(summary = "更新付款申请")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay-apply:update')")
    @Idempotent
    public CommonResult<?> update(@RequestBody BillPayApplyUpdateVO updateReqVO) {
        return billPayApplyService.update(updateReqVO);
    }

    @GetMapping("/page")
    @Operation(summary = "付款申请分页")
    public CommonResult<PageResult<BillPayPageResVO>> page(@Valid BillPayApplyPageReqVO pageVO) {
        return success(billPayApplyService.page(pageVO));
    }

    @GetMapping("/summary")
    @Operation(summary = "付款申请统计")
    public CommonResult<BillPayPageSummaryVO> summary(@Valid BillPayApplyPageReqVO pageVO) {
        return success(billPayApplyService.summary(pageVO));
    }

    @GetMapping("/submit")
    @Operation(summary = "付款申请提交")
    public CommonResult<?> submit(@RequestParam("id")Long id) {
        return billPayApplyService.submit(id);
    }

    @DeleteMapping("/delete")
    @Idempotent
    @Operation(summary = "删除付款申请")
    public CommonResult<?> delete(@RequestParam("id") Long id) {
        return billPayApplyService.delete(id);
    }

    @PostMapping("/reject")
    @Idempotent
    @Operation(summary = "退回付款申请")
    public CommonResult<?> reject(@RequestBody BillInvoiceApplyAbortReqVO abortReqVO) {
        return billPayApplyService.reject(abortReqVO);
    }

    @GetMapping("/invoke")
    @Idempotent
    @Operation(summary = "撤销付款申请")
    public CommonResult<?> invoke(@RequestParam("id") Long id) {
        return billPayApplyService.invoke(id);
    }

    @GetMapping("/review")
    @Operation(summary = "开票申请审核")
    public CommonResult<?> review(@RequestParam("id") Long id) {
        return billPayApplyService.review(id);
    }

    @GetMapping("/bill-waybill-source-page")
    @Operation(summary = "账单的运单分页")
    public CommonResult<PageResult<BillWaybillSourcePageResVO>> billWaybillSourcePage(BillWaybillSourcePageReqVO pageVO) {
        return success(billPayApplyService.billWaybillSourcePage(pageVO));
    }

    @GetMapping("/remove")
    @Operation(summary = "付款申请详情内移除付款单")
    @Idempotent
    public CommonResult<?> remove(@RequestParam("id") Long id) {
        return billPayApplyService.remove(id);
    }

    @PostMapping("/register-pay")
    @Idempotent
    @Operation(summary = "付款申请-付款登记")
    public CommonResult<?> registerPay(@RequestBody BillPayApplyRegisterReqVO reqVO) {
        return billPayApplyService.registerPay(reqVO);
    }


}
