package org.example.weiyuntong.billInvoiceaply.vo;

import com.weiyuntong.module.bizcenter.enums.BillApplyStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillInvoiceApplyPageResVO {

    // id
    private Long id;
    // 申请编号
    private String code;
    // 开票申请状态
    private BillApplyStatusEnum status;
    // 发票抬头
    private String title;
    // 税号
    private String taxNumber;
    // 申请金额
    private String invoiceAmount;
    // 已开金额
    private BigDecimal paidAmount;
    // 账单呢编号
    private String billNo;
    // 开票单编号
    private String registerCode;
    // 申请人
    private String creatorName;
    // 申请时间
    private LocalDateTime createTime;

}
