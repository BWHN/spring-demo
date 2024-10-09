package org.example.weiyuntong.billinvoiceregister.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.BillWaybillSourceAllotmentMoneyVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillInvoiceRegisterRelationCreateVO {

    /**
     * 账单id
     */
    private Long billId;
    /**
     * 此申请中账单的核销金额
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
