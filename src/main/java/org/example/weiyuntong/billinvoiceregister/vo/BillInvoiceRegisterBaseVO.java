package org.example.weiyuntong.billinvoiceregister.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billinvoiceregister.enums.BillInvoiceRegisterTypeEnum;
import com.weiyuntong.module.bizcenter.enums.BillRegisterStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillInvoiceRegisterBaseVO {

    /**
     * 开票申请id
     */
    private Long applyId;

    /**
     * 发票id
     */
    private Long invoiceId;

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
     * 申请类型 开票/收票
     */
    private BillInvoiceRegisterTypeEnum type;

    /**
     * 状态
     */
    private BillRegisterStatusEnum status;

    /**
     * 发票号
     */
    private String invoiceNo;

    /**
     * 税号
     */
    private String taxNumber;

    /**
     * 发票抬头
     */
    private String title;

    /**
     * 发票金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 发票图片
     */
    private String invoiceUrl;

    /**
     * 开票人
     */
    private String invoicer;

    /**
     * 开票时间
     */
    private LocalDateTime invoiceTime;

    /**
     * 核销金额
     */
    private BigDecimal checkedAmount;

}
