package org.example.weiyuntong.carbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExpenseCostCountVO {

    @Schema(description = "业务费用名称")
    private String expenseName;

    @Schema(description = "费用金额")
    private BigDecimal amount;

}
