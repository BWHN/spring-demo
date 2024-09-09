package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author FanluNiu
 * @version 1.0
 * @date 2024-03-19 9:48
 */
@Data
public class BillPayDetailVO {

    @Schema(description = "账单ID")
    private Long id;

    @Schema(description = "公司名称", example = "143")
    private String enterpriseName;

    @Schema(description = "车牌号", example = "143")
    private String carNumber;

    @Schema(description = "账单号", example = "143")
    private String billNo;

    @Schema(description = "车次号", example = "143")
    private String waybillCarNo;

    @Schema(description = "应收运费(应付运费)")
    private BigDecimal receivablesAmount = BigDecimal.ZERO;

    @Schema(description = "应付金额")
    private BigDecimal payableAmount = BigDecimal.ZERO;

    @Schema(description = "已支付金额")
    private BigDecimal paidAmount;

    @Schema(description = "剩余应收")
    public BigDecimal remainAmount;

    @Schema(description = "本次付款金额")
    private BigDecimal nowPaidAmount;

    @Schema(description = "历史付款金额")
    private BigDecimal historyAmount;

    @Schema(description = "付款时间")
    private LocalDateTime paidTime;

    @Schema(description = "第？次付款")
    private Integer payCount;

    @Schema(description = "客户负责人")
    private String customer;
    @Schema(description = "客户负责人电话")
    private String customerPhone;

    @Schema(description = "车源联系人")
    private String inviteUserName;
    @Schema(description = "车源联系人电话")
    private String inviteUserPhone;

    @Schema(description = "接单人")
    private String receiveOrderName;

    @Schema(description = "卸车时间")
    private LocalDateTime unloadedTime;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "账单类型")
    private String billType;
}
