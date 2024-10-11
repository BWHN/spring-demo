package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillWaybillSourceAllotmentMoneyVO {

    /**
     * 运单id
     */
    private Long waybillSourceId;
    /**
     * 此申请中账单的分配金额
     */
    private BigDecimal allotmentMoney;

}
