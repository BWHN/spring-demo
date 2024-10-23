package org.example.weiyuntong.carbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FleetAndExpenseCostCountVO {

    @Schema(defaultValue = "总费用 = 车队费用 + 业务")
    private BigDecimal totalCost = BigDecimal.ZERO;



    /**
     * 业务费用
     */
    @Schema(defaultValue = "业务费用")
    private BigDecimal expenseCost = BigDecimal.ZERO;

    List<ExpenseCostCountVO> expenseCostList;


    /**
     * 车队费用
     */
    @Schema(defaultValue = "车队费用")
    private BigDecimal fleetCost = BigDecimal.ZERO;

    @Schema(defaultValue = "车队费用")
    private BigDecimal oilCost = BigDecimal.ZERO;

    @Schema(defaultValue = "车队费用")
    private BigDecimal maintenanceCost = BigDecimal.ZERO;

    @Schema(defaultValue = "车队费用")
    private BigDecimal ureaCost = BigDecimal.ZERO;

    @Schema(defaultValue = "车队费用")
    private BigDecimal roadbridgeCost = BigDecimal.ZERO;

    @Schema(defaultValue = "车队费用")
    private BigDecimal etcCost = BigDecimal.ZERO;



}
