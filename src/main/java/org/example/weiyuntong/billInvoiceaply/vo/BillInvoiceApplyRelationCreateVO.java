package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillInvoiceApplyRelationCreateVO {

    /**
     * 账单id
     */
    private Long billId;

    /**
     * 此申请中账单的分配金额
     */
    private BigDecimal allotmentMoney;

    /**
     * 忽略剩余
     */
    private Integer ignored;

    /**
     * 运单信息
     */
    private List<BillWaybillSourceAllotmentMoneyVO> waybillSourceInfoList;

}
