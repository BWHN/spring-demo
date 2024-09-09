package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillMonthVO {

    @Schema(description = "装货物重量")
    private BigDecimal loadWeight;

    @Schema(description = "卸货物重量")
    private BigDecimal unloadWeight;

    @Schema(description = "损耗")
    private BigDecimal loss;

    @Schema(description = "运费金额")
    private BigDecimal money;

    @Schema(description = "月份")
    private String month;

    @Schema(description = "年份")
    private String year;
}
