package org.example.weiyuntong.billinvoice.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 账单发票 Excel VO
 *
 * @author 维运通
 */
@Data
public class BillInvoiceExcelVO {

    @ExcelProperty("账单ID")
    private Long billId;

    @ExcelProperty("发票代码")
    private String invoiceSn;

    @ExcelProperty("发票金额")
    private BigDecimal invoiceAmount;

    @ExcelProperty("开票日期")
    private LocalDateTime invoiceDate;

    @ExcelProperty("发票凭证")
    private String invoiceUrl;


    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
