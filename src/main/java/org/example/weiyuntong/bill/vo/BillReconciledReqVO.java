package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillReconciledReqVO {

    /**
     * 账单ID
     */
    private Long id;

    /**
     * 地址ID
     */
    private Long addressId;

    /**
     * 发票ID
     */
    private Long invoiceId;
    /**
     * 发票吨数
     */
    private BigDecimal tonnes;

    @Schema(description = "单据")
    private Boolean isDocument;
    @Schema(description = "开票")
    private Boolean upperNeedInvoice;

}
