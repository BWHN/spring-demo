package org.example.weiyuntong.bill.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WaitInvoicePO {

    private Long consignorId;
    private Boolean lowerNeedInvoice;
    private Boolean upperNeedInvoice;
    private Long customerId;
    private Long carrierId;
    private BigDecimal receivablesAmount;
    private BigDecimal payableAmount;
    private Boolean ownership;

}
