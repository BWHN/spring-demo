package org.example.weiyuntong.billinvoice;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.billinvoice.vo.*;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillTypeEnum;
import com.weiyuntong.module.bizcenter.service.billinvoice.BillInvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;


@Tag(name = "管理后台 - 账单发票")
@RestController
@RequestMapping("/bizcenter/bill-invoice")
@Validated
public class BillInvoiceController {

    @Resource
    private BillInvoiceService billInvoiceService;

    @PostMapping("/create")
    @Idempotent(message = "正在处理，勿重复提交", timeout = 5)
    @Operation(summary = "登记开票")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:create')")
    public CommonResult<Long> createBillInvoice(@Valid @RequestBody BillInvoiceCreateReqVO createReqVO) {
        return success(billInvoiceService.createBillInvoice(createReqVO));
    }


    @PostMapping("/ocrInvoice")
    @Operation(summary = "发票自动识别")
    public CommonResult<Map<String, String>> ocrInvoice(@RequestParam("file") MultipartFile img) {
        return success(billInvoiceService.ocrInvoice(img));
    }

    @PutMapping("/update")
    @Operation(summary = "更新账单发票")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:update')")
    public CommonResult<Boolean> updateBillInvoice(@Valid @RequestBody BillInvoiceUpdateReqVO updateReqVO) {
        billInvoiceService.updateBillInvoice(updateReqVO);
        return success(true);
    }

    @PostMapping("/ocrInvoiceByFile")
    @Operation(summary = "发票自动识别")
    public CommonResult<Map<String, String>> ocrInvoiceByFile(@RequestParam("file") MultipartFile img) throws IOException {
        return success(billInvoiceService.ocrInvoiceByFile(img));
    }


    /**
     * 开票情况信息导出
     * @param billTypeEnum
     * @param response
     * @throws IOException
     */
   @GetMapping("/export-excel-R")
   @Operation(summary = "开票情况信息导出")
   @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:export')")
   @OperateLog(type = EXPORT)
   public void exportBillInvoiceExcelR(@Valid BillTypeEnum billTypeEnum,
             HttpServletResponse response) throws IOException {
       List<BillingInvoiceExcelVO> data = billInvoiceService.getBillInvoiceExcelVOList(billTypeEnum);
       ExcelUtils.write(response, "开票数据.xls", "开票数据", BillingInvoiceExcelVO.class, data);
   }

    /**
     * 收票情况信息导出
     * @param billTypeEnum
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel-P")
    @Operation(summary = "收票情况信息导出")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:export')")
    @OperateLog(type = EXPORT)
    public void exportBillInvoiceExcelP(@Valid BillTypeEnum billTypeEnum,
                                       HttpServletResponse response) throws IOException {
        List<BillReceiveInvoiceExcelVO> data = billInvoiceService.getBillReceiveInvoiceExcelVOList(billTypeEnum);
        ExcelUtils.write(response, "收票数据.xls", "收票数据", BillReceiveInvoiceExcelVO.class, data);
    }


//
//    @DeleteMapping("/delete")
//    @Operation(summary = "删除账单发票")
//    @Parameter(name = "id", description = "编号", required = true)
//    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:delete')")
//    public CommonResult<Boolean> deleteBillInvoice(@RequestParam("id") Long id) {
//        billInvoiceService.deleteBillInvoice(id);
//        return success(true);
//    }
//
//    @GetMapping("/get")
//    @Operation(summary = "获得账单发票")
//    @Parameter(name = "id", description = "编号", required = true, example = "1024")
//    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:query')")
//    public CommonResult<BillInvoiceRespVO> getBillInvoice(@RequestParam("id") Long id) {
//        BillInvoiceDO billInvoice = billInvoiceService.getBillInvoice(id);
//        return success(BillInvoiceConvert.INSTANCE.convert(billInvoice));
//    }
//
//    @GetMapping("/list")
//    @Operation(summary = "获得账单发票列表")
//    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
//    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:query')")
//    public CommonResult<List<BillInvoiceRespVO>> getBillInvoiceList(@RequestParam("ids") Collection<Long> ids) {
//        List<BillInvoiceDO> list = billInvoiceService.getBillInvoiceList(ids);
//        return success(BillInvoiceConvert.INSTANCE.convertList(list));
//    }
//
//    @GetMapping("/page")
//    @Operation(summary = "获得账单发票分页")
//    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:query')")
//    public CommonResult<PageResult<BillInvoiceRespVO>> getBillInvoicePage(@Valid BillInvoicePageReqVO pageVO) {
//        PageResult<BillInvoiceDO> pageResult = billInvoiceService.getBillInvoicePage(pageVO);
//        return success(BillInvoiceConvert.INSTANCE.convertPage(pageResult));
//    }
//
//    @GetMapping("/export-excel")
//    @Operation(summary = "导出账单发票 Excel")
//    @PreAuthorize("@ss.hasPermission('bizcenter:bill-invoice:export')")
//    @OperateLog(type = EXPORT)
//    public void exportBillInvoiceExcel(@Valid BillInvoiceExportReqVO exportReqVO,
//              HttpServletResponse response) throws IOException {
//        List<BillInvoiceDO> list = billInvoiceService.getBillInvoiceList(exportReqVO);
//        // 导出 Excel
//        List<BillInvoiceExcelVO> datas = BillInvoiceConvert.INSTANCE.convertList02(list);
//        ExcelUtils.write(response, "账单发票.xls", "数据", BillInvoiceExcelVO.class, datas);
//    }

}
