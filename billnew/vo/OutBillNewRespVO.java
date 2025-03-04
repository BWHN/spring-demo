package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import com.weiyuntong.framework.common.enums.OutApplyInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Schema(description = "管理后台 - 新对账单 Response VO")
@Data
@ToString(callSuper = true)
public class OutBillNewRespVO {

    @Schema(description = "账单ID", required = true, example = "12073")
    private Long id;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "申请状态")
    private OutApplyInvoiceStatusEnum applyStatus;

    @Schema(description = "账单状态")
    private BillStatusEnum billStatus;

    @Schema(description = "承运商ID")
    private Long carrierId;
    @Schema(description = "承运商名称")
    private String carrier;

    @Schema(description = "账单名称")
    private String billName;

    @Schema(description = "运单数量")
    private int waybillCount;

    @Schema(description = "应付金额")
    private BigDecimal payableAmount = BigDecimal.ZERO;

    @Schema(description = "创建者姓名")
    private String creatorName;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;


}
