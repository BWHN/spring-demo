package org.example.weiyuntong.billnew;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.module.bizcenter.controller.admin.bill.vo.BillBackReviewReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.billnew.vo.*;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillIgnoreDO;
import com.weiyuntong.module.bizcenter.service.billnew.BillNewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;


@Tag(name = "业务中心 - 运单对账单")
@RestController
@RequestMapping("/bizcenter/bill-new")
@Validated
public class BillNewController {

    @Resource
    private BillNewService billNewService;


    @PostMapping("/create")
    @Operation(summary = "运单对账单-创建运单对账单")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:create')")
    @Idempotent
    public CommonResult<Long> createBill(@Valid @RequestBody BillSourceCreateVO createReqVO) {
        return success(billNewService.createBill(createReqVO));
    }


    @PostMapping("/update")
    @Operation(summary = "运单对账单-更新运单对账单")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:create')")
    @Idempotent
    public CommonResult<Long> updateBill(@Valid @RequestBody BillSourceUpdateVO createReqVO) {
        return success(billNewService.updateBill(createReqVO));
    }

    @PostMapping("/update-source")
    @Operation(summary = "运单对账单-更新运单对账单")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:update-source')")
    @Idempotent
    public CommonResult<Long> updateSource(@Valid @RequestBody WaybillSourceUpdateBillVO updateBillVO) {
        return success(billNewService.updateSource(updateBillVO));
    }

    @GetMapping("/delete-source")
    @Operation(summary = "运单对账单-删除对账单中的运单")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:delete-source')")
    @Idempotent
    public CommonResult<Long> deleteSource(Long sourceId,Long billId) {
        return success(billNewService.deleteSource(sourceId,billId));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除账单")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteBill(@RequestParam("id") Long id) {
        billNewService.deleteBill(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得对账单详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill:query')")
    public CommonResult<BillNewDetailVO> getBillNewDetailById(@RequestParam(value = "id", required = false) Long id,
                                                              @RequestParam(value = "billNo", required = false) String billNo) {
        return success(billNewService.getBillNewDetailById(id, billNo));
    }


    @GetMapping("/pageCount")
    @Operation(summary = "运单对账单- 分页Tab统计")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:query')")
    public CommonResult<BillNewRespCountVO> getBillNewPageCount(@Valid BillNewPageReqVO pageVO) {
        return success(billNewService.getBillNewPageTabCount(pageVO));
    }

    @GetMapping("/page")
    @Operation(summary = "运单对账单- 分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:query')")
    public CommonResult<PageResult<BillNewRespVO>> getBillNewPage(@Valid BillNewPageReqVO pageVO) {
        return success(billNewService.getBillNewPage(pageVO));
    }

    @PostMapping("/backReview")
    @Operation(summary = "账单-驳回")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:backReview')")
    public CommonResult<?> backReview(@RequestBody BillBackReviewReqVO billBackReviewReqVO) {
        return billNewService.backReview(billBackReviewReqVO);
    }

    @PostMapping("/invalidBill")
    @Operation(summary = "账单-作废")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:invalidBill')")
    public CommonResult<?> invalidBill(@RequestBody BillBackReviewReqVO billBackReviewReqVO) {
        return billNewService.invalidBill(billBackReviewReqVO);
    }

    @GetMapping("/reconciled")
    @Operation(summary = "账单-审核")
    @Idempotent
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:reconciled')")
    public CommonResult<Boolean> reconciled(Long id) {
        billNewService.reconciled(id);
        return success(true);
    }

    @GetMapping("/to-reconciled")
    @Operation(summary = "账单-提交审核")
    @Idempotent
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:toReconciled')")
    public CommonResult<Boolean> toReconciled(Long id) {
        billNewService.toReconciled(id);
        return success(true);
    }

    @PostMapping("/ignoreBill")
    @Operation(summary = "账单-忽略")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:ignoreBill')")
    public CommonResult<?> ignoreBill(@RequestBody BillIgnoreDO billIgnoreDO) {
        return billNewService.ignoreBill(billIgnoreDO);
    }

    @PostMapping("/ignoreBill-back")
    @Operation(summary = "账单-撤销忽略")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-new:ignoreBill')")
    public CommonResult<?> ignoreBillBack(@RequestBody BillIgnoreDO billIgnoreDO) {
        return billNewService.ignoreBillBack(billIgnoreDO);
    }

    @GetMapping("/getExcel")
    @Operation(summary = "应付应收对账单导出")
    @Parameter(name = "id", description = "账单id", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill:export')")
    public CommonResult<BillNewExcel> getBillExcel(Long id) {
        return success(billNewService.getBillExcel(id));
    }

    @GetMapping("/initCustomerBill")
    public CommonResult<Boolean> initCustomerBill() {
        billNewService.initCustomerBill();
        return success(true);
    }
}
