package org.example.weiyuntong.efficiencydiff.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* 效率预警阈值 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class EfficiencyDiffBaseVO {

    private Long id;

    @Schema(description = "企业id", example = "26713")
    private Long entId;

    @Schema(description = "类型", example = "26713")
    private String type;

    @Schema(description = "总时长偏差最小值")
    private BigDecimal minTotalDiff;

    @Schema(description = "总时长偏差最大值")
    private BigDecimal maxTotalDiff;

    @Schema(description = "发车时长偏差")
    private BigDecimal minDepartedDiff;

    @Schema(description = "发车时长偏差")
    private BigDecimal maxDepartedDiff;

    @Schema(description = "到达装货地")
    private BigDecimal minGetLoadedDiff;

    @Schema(description = "到达装货地")
    private BigDecimal maxGetLoadedDiff;

    @Schema(description = "装货时长")
    private BigDecimal minLoadedDiff;

    @Schema(description = "装货时长")
    private BigDecimal maxLoadedDiff;

    @Schema(description = "到达卸货地")
    private BigDecimal minGetUnloadedDiff;

    @Schema(description = "到达卸货地")
    private BigDecimal maxGetUnloadedDiff;

    @Schema(description = "卸货时长")
    private BigDecimal minUnloadedDiff;

    @Schema(description = "卸货时长")
    private BigDecimal maxUnloadedDiff;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
