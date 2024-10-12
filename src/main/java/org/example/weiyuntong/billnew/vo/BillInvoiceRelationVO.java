package org.example.weiyuntong.billnew.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  中间表 用于 关联 biz_bill_invoice biz_bill
 */
@Data
public class BillInvoiceRelationVO {

    @Schema(description = "主键id", example = "")
    private Long id;

    @Schema(description = "账单ID", example = "")
    private Long billId;

    @Schema(description = "发票ID", example = "")
    private Long invoiceId;

    @Schema(description = "本次开票金额")
    private BigDecimal allotmentMoney;


}
