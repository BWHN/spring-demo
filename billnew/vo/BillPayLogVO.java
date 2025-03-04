package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillPayLogVO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "编号")
    private String code;
    @Schema(description = "金额")
    private BigDecimal amount;
    @Schema(description = "付款方式")
    private Integer payWay;
    @Schema(description = "收款日期")
    private LocalDateTime payTime;
    @Schema(description = "付款人")
    private String payer;
    @Schema(description = "登记人")
    private String creatorName;
    @Schema(description = "登记时间")
    private String createTime;
    @Schema(description = "路径")
    private String payUrl;
    @Schema(description = "申请人")
    private String applyName;
    @Schema(description = "申请时间")
    private String applyTime;

}
