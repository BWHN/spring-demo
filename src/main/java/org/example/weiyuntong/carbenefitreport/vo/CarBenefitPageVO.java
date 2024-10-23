package org.example.weiyuntong.carbenefitreport.vo;

import com.weiyuntong.module.datacenter.controller.admin.export.annotations.ExportParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 自营车辆效益
 */

@Data
public class CarBenefitPageVO {

    @ExportParam(parent = "月份", value = "月份")
    @Schema(description = "月份")
    private String cycle;

    @ExportParam(parent = "车牌号", value = "车牌号")
    @Schema(description = "车牌号")
    private String carNumber;

    @ExportParam(parent = "车辆归属", value = "车辆归属")
    @Schema(description = "车辆归属 1自有/2租赁")
    private String carBelong;


    // 在发布单子的时候进行的预测业务利润的全部总和
    @Schema(description = "预测业务利润（元）")
    @ExportParam(parent = "利润", value = "预测业务利润（元）")
    private BigDecimal waybillCarProfit;

    // 实际业务利润/不含税应收金额*100%
    @ExportParam(parent = "利润", value = "实际业务利润率")
    @Schema(description = "实际业务利润率")
    private BigDecimal realWaybillCarProfitRate;
    // 实际业务利润=不含税应收金额-总成本
    @Schema(description = "实际业务利润（元）")
    @ExportParam(parent = "利润", value = "实际业务利润（元）")
    private BigDecimal realWaybillCarProfit;


    // 该车牌号在本月的全部车次应收金额的总和
    @Schema(description = "应收金额（元）")
    @ExportParam(parent = "收入", value = "应收金额（元）")
    private BigDecimal receivablesAmount;

    @Schema(description = "实际收款金额（元）")
    @ExportParam(parent = "收入", value = "实际收款金额（元）")
    private BigDecimal realReceivablesAmount;

    @Schema(description = "未收款金额（元）")
    @ExportParam(parent = "收入", value = "未收款金额（元）")
    private BigDecimal noReceivablesAmount;

    @Schema(description = "忽略金额(元)")
    @ExportParam(parent = "收入", value = "忽略金额(元)")
    private BigDecimal ignoreAmount;


    @Schema(description = "总成本（元）")
    @ExportParam(parent = "成本", value = "总成本（元）")
    private BigDecimal totalCost;

    @Schema(description = "变动成本（元）")
    @ExportParam(parent = "成本", value = "变动成本（元）")
    private BigDecimal operateCost;

    @Schema(description = "变动成本占比")
    @ExportParam(parent = "成本", value = "变动成本占比")
    private BigDecimal operateCostRate;

    @Schema(description = "车队费用（元）")
    @ExportParam(parent = "成本", value = "车队费用（元）")
    private BigDecimal fleetCost;

    @Schema(description = "司机提成（元）")
    @ExportParam(parent = "成本", value = "司机提成（元）")
    private BigDecimal driverCost;

    @Schema(description = "业务费用（元）")
    @ExportParam(parent = "成本", value = "业务费用（元）")
    private BigDecimal operatingCost;

    @Schema(description = "自身成本（元）")
    @ExportParam(parent = "成本", value = "自身成本（元）")
    private BigDecimal ownCost;

    @Schema(description = "账期成本（元）")
    @ExportParam(parent = "成本", value = "账期成本（元）")
    private BigDecimal carryingCost;

    @Schema(description = "承兑成本（元）")
    @ExportParam(parent = "成本", value = "承兑成本（元）")
    private BigDecimal ownSettleAmount;

    @Schema(description = "固定成本（元）")
    @ExportParam(parent = "成本", value = "固定成本（元）")
    private BigDecimal fixedCost;


    // 车辆空闲率=(总天数-运行天数)/总天数*100%
    @Schema(description = "空闲率")
    @ExportParam(parent = "效率", value = "空闲率")
    private BigDecimal vehicleFreeRate;

    // 自然月天数
    @Schema(description = "总天数（天）")
    @ExportParam(parent = "效率", value = "总天数（天）")
    private BigDecimal totalDays;

    @Schema(description = "运行天数（天）")
    @ExportParam(parent = "效率", value = "运行天数（天）")
    private BigDecimal runningDays;

    @Schema(description = "有计划等待（天）")
    @ExportParam(parent = "效率", value = "有计划等待（天）")
    private BigDecimal planWaitDays;

    @Schema(description = "无计划等待（天）")
    @ExportParam(parent = "效率", value = "无计划等待（天）")
    private BigDecimal noPlanWaitDays;

    @Schema(description = "停车天数（天）")
    @ExportParam(parent = "效率", value = "停车天数（天）")
    private BigDecimal parkDays;

    @Schema(description = "空驶率")
    @ExportParam(parent = "效率", value = "空驶率")
    private BigDecimal emptyMileageRate;

    @Schema(description = "总里程（公里）")
    @ExportParam(parent = "效率", value = "总里程（公里）")
    private BigDecimal totalMileage;

    @Schema(description = "重车里程（公里）")
    @ExportParam(parent = "效率", value = "重车里程（公里）")
    private BigDecimal loadedMileage;

    @Schema(description = "空车里程（公里）")
    @ExportParam(parent = "效率", value = "空车里程（公里）")
    private BigDecimal noLoadMileage;

    @Schema(description = "车次数")
    @ExportParam(parent = "效率", value = "车次数")
    private Integer waybillCarNum;

    @Schema(description = "运量（吨）")
    @ExportParam(parent = "效率", value = "运量（吨）")
    private BigDecimal shippingWeight;

    @Schema(description = "应收不含税（元）")
    private BigDecimal realReceivablesAmountWithoutTax;

}
