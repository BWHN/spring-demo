package org.example.weiyuntong.carbenefitreport.vo;

import com.weiyuntong.module.datacenter.controller.admin.export.annotations.ExportParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 自营车辆效益
 */

@Data
public class CarBenefitCount {

    @Schema(description = "预测业务利润（元）")
    @ExportParam(parent = "利润", value = "预测业务利润（元）")
    private BigDecimal waybillCarProfit=BigDecimal.ZERO;

    // 实际业务利润/不含税应收金额*100%
    @ExportParam(parent = "利润", value = "实际业务利润率")
    @Schema(description = "实际业务利润率")
    private BigDecimal realWaybillCarProfitRate=BigDecimal.ZERO;
    // 实际业务利润=不含税应收金额-总成本
    @Schema(description = "实际业务利润（元）")
    @ExportParam(parent = "利润", value = "实际业务利润（元）")
    private BigDecimal realWaybillCarProfit=BigDecimal.ZERO;

    // 该车牌号在本月的全部车次应收金额的总和
    @Schema(description = "应收金额（元）")
    @ExportParam(parent = "收入", value = "应收金额（元）")
    private BigDecimal receivablesAmount=BigDecimal.ZERO;

    @Schema(description = "实际收款金额（元）")
    @ExportParam(parent = "收入", value = "实际收款金额（元）")
    private BigDecimal realReceivablesAmount=BigDecimal.ZERO;

    @Schema(description = "总成本（元）")
    @ExportParam(parent = "成本", value = "总成本（元）")
    private BigDecimal totalCost=BigDecimal.ZERO;

    // 车辆空闲率=(总天数-运行天数)/总天数*100%
    @Schema(description = "空闲率")
    @ExportParam(parent = "效率", value = "空闲率")
    private BigDecimal vehicleFreeRate=BigDecimal.ZERO;

    // 自然月天数
    @Schema(description = "总天数（天）")
    @ExportParam(parent = "效率", value = "总天数（天）")
    private BigDecimal totalDays=BigDecimal.ZERO;

    @Schema(description = "运行天数（天）")
    @ExportParam(parent = "效率", value = "运行天数（天）")
    private BigDecimal runningDays=BigDecimal.ZERO;

    @Schema(description = "空驶率")
    @ExportParam(parent = "效率", value = "空驶率")
    private BigDecimal emptyMileageRate=BigDecimal.ZERO;

    @Schema(description = "运量（吨）")
    @ExportParam(parent = "效率", value = "运量（吨）")
    private BigDecimal shippingWeight=BigDecimal.ZERO;

    @Schema(description = "空车里程（公里）")
    @ExportParam(parent = "效率", value = "空车里程（公里）")
    private BigDecimal noLoadMileage=BigDecimal.ZERO;

    @Schema(description = "总里程（公里）")
    @ExportParam(parent = "效率", value = "总里程（公里）")
    private BigDecimal totalMileage=BigDecimal.ZERO;

}
