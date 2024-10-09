package org.example.weiyuntong.billinvoiceregister.vo;

import com.weiyuntong.module.bizcenter.enums.BillRegisterStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillInvoiceRegisterPageResVO {

    // id
    private Long id;
    // 开票编号
    private String code;
    // 开票申请状态
    private BillRegisterStatusEnum status;
    // 发票抬头
    private String title;
    // 税号
    private String taxNumber;
    // 发票金额
    private BigDecimal invoiceAmount;
    // 待核销金额
    private BigDecimal toInvoiceAmount;
    // 开票人
    private String invoicer;
    // 开票时间
    private LocalDateTime invoiceTime;
    // 发票号码
    private String invoiceNo;
    // 账单呢编号
    private String billNo;
    // 申请人
    private String creatorName;
    // 申请时间
    private LocalDateTime createTime;
    // 发票图片
    private String invoiceUrl;

}
