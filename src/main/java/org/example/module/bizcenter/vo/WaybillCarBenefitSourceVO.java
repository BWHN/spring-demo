package org.example.module.bizcenter.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 车次效益
 *
 * @author 维运通
 */
@Data
public class WaybillCarBenefitSourceVO  {

    @Schema(description = "车次业务利润（元）")
    private BigDecimal waybillCarProfit;
    @Schema(description = "车次业务利润率")
    private BigDecimal waybillCarProfitRate;
    @Schema(description = "总成本（元）")
    private BigDecimal totalCost;
    @Schema(description = "应收金额")
    private BigDecimal receivableAmount;
    @Schema(description = "应付金额")
    private BigDecimal payableAmount;
    @Schema(description = "总里程")
    private BigDecimal totalMileage;
    @Schema(description = "空驶率")
    private BigDecimal emptyDriveRate;
    @Schema(description = "运行天数")
    private BigDecimal runDay;

    @Schema(description = "垫付成本（元）")
    private BigDecimal advanceCost;
    @Schema(description = "承兑成本（元）")
    private BigDecimal settleCost;
    @Schema(description = "业务费用（元）")
    private BigDecimal expenseCost;
    @Schema(description = "车队费用（元）")
    private BigDecimal carCost;
    @Schema(description = "司机提成（元）")
    private BigDecimal driverCost;
    @Schema(description = "固定成本（元）")
    private BigDecimal fixedAmount;
    @Schema(description = "营销费用（元）")
    private BigDecimal marketAmount;


}
