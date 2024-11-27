package org.example.weiyuntong.roadbridgecost.vo;

import com.weiyuntong.module.fleetcenter.controller.admin.cost.vo.CostBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 路桥费用 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class RoadBridgeCostBaseVO extends CostBaseVO {

    @Schema(description = "是否有路书 0 否 1 是")
    private Integer hasTravelGuide;

    @Schema(description = "预估费用")
    private BigDecimal predictMoney;

    @Schema(description = "费用id", example = "27820")
    private Long costId;

}
