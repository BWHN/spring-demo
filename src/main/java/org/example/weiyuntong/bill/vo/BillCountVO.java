package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BillCountVO {

    @Schema(description = "全部")
    private Long allNum;

    @Schema(description = "待对账数量")
    private Long toReconciledNum;

    @Schema(description = "待开票数量")
    private Long toInvoicedNum;

    @Schema(description = "待对账数量")
    private Long receivableInvoiceNum;

    @Schema(description = "待收款数量")
    private Long toCollectedNum;

    @Schema(description = "待付款数量")
    private Long toPaidNum;

    @Schema(description = "已完结数量")
    private Long paidNum;

    @Schema(description = "驳回数量")
    private Long backReviewedNum;

}
