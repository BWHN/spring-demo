package org.example.weiyuntong.carbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CapacityExpenditureCount {

    /**
     * 运力分类统计
     */
    @Schema(description = "运力数量")
    private Long allCapacityCount;
    
    @Schema(description = "运力数量")
    private Long otherCount;

    @Schema(description = "运力数量")
    private Long singleCount;

    /**
     * 重车单价
     */
    @Schema(description = "重车单价（元/吨/公里）")
    private BigDecimal loadedMileagePrice;

    /**
     * 成本利润对比  and 运量对比
     */
    List<CapacityComparison> costProfitComparison;

}
