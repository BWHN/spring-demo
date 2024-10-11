package org.example.weiyuntong.billInvoiceaply.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillInvoiceApplyRegisterReqVO extends BillInvoiceApplyBaseVO {

    // 申请ID
    private Long id;
    // 发票号
    private String invoiceNo;
    // 发票抬头
    private String invoiceTitle;
    // 税号
    private String invoiceTaxNumber;
    // 发票金额
    private BigDecimal invoiceMoney;
    // 开票人
    private String invoicer;
    // 发票图片
    private String invoiceUrl;
    // 开票时间
    private String invoiceTime;
    // 账单信息
    private List<BillInfo> billInfoList;

    @Data
    public static class BillInfo {
        // 账单id
        private Long id;
        // 是否忽略
        private Integer ignored;
    }

}
