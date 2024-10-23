package org.example.weiyuntong.carbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


/**
 * 自营车辆效益 图表展示
 */

@Data
public class CarBenefitDataVO {

    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "实际业务利润率")
    private BigDecimal realWaybillCarProfitRate;

    @Schema(description = "实际业务利润（元）")
    private BigDecimal realWaybillCarProfit;

    // 该车牌号在本月的全部车次应收金额的总和
    @Schema(description = "应收金额（元）")
    private BigDecimal receivablesAmount;

    @Schema(description = "总成本（元）")
    private BigDecimal totalCost;

    @Schema(description = "变动成本（元）")
    private BigDecimal operateCost;

    @Schema(description = "固定成本（元）")
    private BigDecimal fixedCost;

    @Schema(description = "司机提成（元）")
    private BigDecimal driverCost;

    @Schema(description = "业务费用（元）")
    private BigDecimal operatingCost;

    @Schema(description = "自身成本（元）")
    private BigDecimal ownCost;

    @Schema(description = "账期成本（元）")
    private BigDecimal carryingCost;

    @Schema(description = "承兑成本（元）")
    private BigDecimal ownSettleAmount;

    @Schema(description = "车队费用（元）")
    private BigDecimal fleetCost;

    @Schema(description = "加油费")
    private BigDecimal oilCost;
    @Schema(description = "尿素费")
    private BigDecimal ureaCost;
    @Schema(description = "维修费")
    private BigDecimal maintenanceCost;
    @Schema(description = "etc费")
    private BigDecimal etcCost;
    @Schema(description = "路桥费")
    private BigDecimal roadbridgeCost;


}
