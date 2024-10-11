package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillInvoiceRegisterVO {

    // id
    private Long id;
    // 开票单编号
    private String code;
    // 开票金额
    private BigDecimal invoiceAmount;
    // 开票时间
    private LocalDateTime invoiceTime;
    // 发票图片
    private String invoiceUrl;
    // 发票号码
    private String invoiceNo;
    // 登记人
    private String creatorName;
    // 登记时间
    private LocalDateTime createTime;

}
