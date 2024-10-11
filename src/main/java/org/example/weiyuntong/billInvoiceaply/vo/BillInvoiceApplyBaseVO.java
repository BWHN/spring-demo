package org.example.weiyuntong.billInvoiceaply.vo;

import com.weiyuntong.module.bizcenter.enums.BillApplyStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillInvoiceApplyBaseVO {

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 客户名称
     */
    private String customer;

    /**
     * 申请编号
     */
    private String code;

    /**
     * 状态
     */
    private BillApplyStatusEnum status;

    /**
     * 税号
     */
    private String taxNumber;

    /**
     * 发票抬头
     */
    private String title;

    /**
     * 银行账户
     */
    private String account;

    /**
     * 开户行
     */
    private String openBank;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 发票备注
     */
    private String invoiceRemark;

    /**
     * 发票金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 发票吨数
     */
    private BigDecimal invoiceTonnes;

    /**
     * 附件
     */
    private String imgUrl;

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 收件人电话
     */
    private String receiverPhone;

    /**
     * 收件人地址
     */
    private String receiverAddress;

}
