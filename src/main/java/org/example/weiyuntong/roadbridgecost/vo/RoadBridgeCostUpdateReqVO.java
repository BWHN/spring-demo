package org.example.weiyuntong.roadbridgecost.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 路桥费用更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoadBridgeCostUpdateReqVO extends RoadBridgeCostBaseVO {

    @Schema(description = "id", required = true, example = "29531")
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 是否记录修改
     */
    private Integer needRecord;

}
