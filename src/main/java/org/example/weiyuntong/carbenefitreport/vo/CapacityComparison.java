package org.example.weiyuntong.carbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class CapacityComparison {

    @Schema(description = "外协运力类型类型")
    private String type;

    @Schema(description = "利润")
    private BigDecimal profit;

    @Schema(description = "利润率")
    private BigDecimal profitRate;

    @Schema(description = "运量")
    private BigDecimal weight;

}
