package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillInvoiceLogVO {

    @Schema(description = "开票单id")
    private Long id;
    @Schema(description = "编号")
    private String code;
    @Schema(description = "金额")
    private BigDecimal amount;
    @Schema(description = "开票日期")
    private LocalDateTime invoiceTime;
    @Schema(description = "发票编号")
    private String invoiceNo;
    @Schema(description = "开票人")
    private String invoicer;
    @Schema(description = "照片")
    private String invoiceUrl;
    @Schema(description = "登记人")
    private String creatorName;
    @Schema(description = "登记时间")
    private String createTime;
    @Schema(description = "申请人")
    private String applyName;
    @Schema(description = "申请时间")
    private String applyTime;
}
