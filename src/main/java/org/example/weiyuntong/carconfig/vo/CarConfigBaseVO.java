package org.example.weiyuntong.carconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
* 车辆费用配置 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CarConfigBaseVO {

    @Schema(description = "车型", example = "2")
    private String carType;

    @Schema(description = "油价", example = "32272")
    private BigDecimal oilPrice;

    @Schema(description = "固定成本均摊")
    private BigDecimal fixedCost;

    @Schema(description = "账期成本")
    private BigDecimal billCost;

    @Schema(description = "税点")
    private BigDecimal taxPoint;

    @Schema(description = "重车司机提成")
    private BigDecimal driverPercentage;

    @Schema(description = "空车司机提成")
    private BigDecimal emptyDriverPercentage;

    @Schema(description = "重车油耗")
    private BigDecimal oilConsumption;;

    @Schema(description = "空车油耗")
    private BigDecimal emptyOilConsumption;

    @Schema(description = "尿素价格")
    private BigDecimal ureaPrice;

    @Schema(description = "百升油尿素消耗")
    private BigDecimal ureaConsumption;

    @Schema(description = "单日人工成本")
    private BigDecimal personCost;

    @Schema(description = "单日资金成本")
    private BigDecimal fundCost;

    @Schema(description = "承兑成本比例")
    private BigDecimal settleRate;

}
