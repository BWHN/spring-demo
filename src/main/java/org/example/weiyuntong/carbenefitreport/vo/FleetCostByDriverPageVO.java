package org.example.weiyuntong.carbenefitreport.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 车队成本报表 司机维度 分页查询条件
 */
@Data
public class FleetCostByDriverPageVO {

    @Schema(description = "统计周期 年/月")
    @ExcelProperty("月份")
    private String cycle;

    @Schema(description = "驾驶员")
    @ExcelProperty("驾驶员")
    private String driver;

    // 此处车牌 可多个 ‘/’ 分割
    @Schema(description = "车牌号")
    @ExcelProperty("车牌号")
    private String carNumber;

    @Schema(description = "总费用（元）")
    @ExcelProperty("总费用（元）")
    private BigDecimal totalCost;

    @Schema(description = "车队费用（元）")
    @ExcelProperty("车队费用（元）")
    private BigDecimal fleetCost;

    @Schema(description = "加油费用（元）")
    @ExcelProperty("加油费用（元）")
    private BigDecimal oilCost;

    @Schema(description = "ETC费用（元）")
    @ExcelProperty("ETC费用（元）")
    private BigDecimal etcCost;

    @Schema(description = "路桥费用（元）")
    @ExcelProperty("路桥费用（元）")
    private BigDecimal roadBridgeCost;

    @Schema(description = "尿素费用（元）")
    @ExcelProperty("尿素费用（元）")
    private BigDecimal ureaCost;

    @Schema(description = "维修费用（元）")
    @ExcelProperty("维修费用（元）")
    private BigDecimal maintenanceCost;

    @Schema(description = "业务费用（元）")
    @ExcelProperty("业务费用（元）")
    private BigDecimal businessCost;



}
