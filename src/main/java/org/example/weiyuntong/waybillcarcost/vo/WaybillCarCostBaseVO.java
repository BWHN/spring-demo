package org.example.weiyuntong.waybillcarcost.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import javax.validation.constraints.*;

/**
* 车次成本 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WaybillCarCostBaseVO {

    @Schema(description = "车次ID", example = "28590")
    private Long waybillCarId;

    @Schema(description = "重车高速里程 - 废弃")
    private BigDecimal freewayMileage;

    @Schema(description = "重车底道里程 - 废弃")
    private BigDecimal roadMileage;

    @Schema(description = "高速费用")
    private BigDecimal freewayCost;

    @Schema(description = "运营天数")
    private BigDecimal runDay;

    @Schema(description = "高速油费 - 废弃")
    private BigDecimal freewayOilCost;

    @Schema(description = "底道油费 - 废弃")
    private BigDecimal roadOilCost;

    @Schema(description = "空车高速里程 - 废弃")
    private BigDecimal emptyFreewayMileage;

    @Schema(description = "空车底道里程 - 废弃")
    private BigDecimal emptyRoadMileage;

    @Schema(description = "空车高速费用")
    private BigDecimal emptyFreewayCost;

    @Schema(description = "业务费用")
    private BigDecimal operatingCost;

    @Schema(description = "空车高速油费 - 废弃")
    private BigDecimal emptyFreewayOilCost;

    @Schema(description = "空车底道油费 - 废弃")
    private BigDecimal emptyRoadOilCost;

    /**
     * 固定成本
     */
    private BigDecimal fixedCost;

    /**
     * 重车里程
     */
    private BigDecimal loadedMileage;

    /**
     * 空车里程
     */
    private BigDecimal emptyMileage;

    /**
     * 系统重车里程
     */
    private BigDecimal systemLoadedMileage;

    /**
     * 系统空车里程
     */
    private BigDecimal systemEmptyMileage;

    /**
     * 重车油耗
     */
    private BigDecimal loadedOilCost;

    /**
     * 空车油耗
     */
    private BigDecimal emptyOilCost;

    /**
     * 重车尿素
     */
    private BigDecimal loadedUreaCost;

    /**
     * 空车尿素
     */
    private BigDecimal emptyUreaCost;


}
