package org.example.weiyuntong.billinvoice.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class BillInvoiceShareVO extends BillInvoiceBaseVO {

    // 当前发票分配给这个订单的金额
    @Schema(description = "本次开票金额")
    private BigDecimal nowInvoiceAmount;

    @Schema(description = "共用发票账单")
    private String billNo;

    @Schema(description = "共用发票账单列表")
    private List<Map<Long , String>> billNoList;

    @Schema(description = "发票id")
    private Long invoiceId;

    @Schema(description = "结算金额")
    private BigDecimal settleAmount;

}
