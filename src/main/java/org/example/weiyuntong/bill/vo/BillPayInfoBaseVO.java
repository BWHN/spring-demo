package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillPayInfoBaseVO {

    private String billNo;

    private Long billId;

    @Schema(description = "承运商id")
    private Long carrierId;

    @Schema(description = "承运商")
    private String carrier;

    @Schema(description = "已收账单个数/已付账单个数")
    private Integer paid;

    @Schema(description = "车次个数")
    private Integer carCount;

    @Schema(description = "实付金额总和")
    private BigDecimal paidAmount;

    @Schema(description = "应付金额总和")
    private BigDecimal receivablesAmount;

    @Schema(description = "剩余应付金额总和")
    private BigDecimal receivabledAmount;

    @Schema(description = "实际收票金额总和")
    private BigDecimal invoiceAmount;

    @Schema(description = "实际收票金额")
    private BigDecimal realInvoiceAmount;

    @Schema(description = "剩余收票金额")
    private BigDecimal invoicedAmount;

    @Schema(description = "承运商联系人-姓名")
    private String carrierContacts;

    @Schema(description = "承运商联系人-联系方式")
    private String carrierContactsPhone;

    @Schema(description = "承运商负责人-姓名")
    private String carrierCharge;

    @Schema(description = "承运商负责人-联系方式")
    private String carrierChargePhone;

}
