package org.example.weiyuntong.billinvoice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 *  用于记录 每张发票分给每个订单的发票金额
 */
@Data
public class BillInvoiceAllotmentVO {

    @Schema(description = "账单ID", example = "")
    private Long billId;

    // 前端不用传 后端生成
    @Schema(description = "发票ID", example = "")
    private Long invoiceId;

    @Schema(description = "发票代码")
    private String invoiceSn;

    @Schema(description = "本次开票金额")
    private BigDecimal nowInvoiceAmount;


}
