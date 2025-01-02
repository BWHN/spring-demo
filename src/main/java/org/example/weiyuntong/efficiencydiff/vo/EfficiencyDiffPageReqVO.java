package org.example.weiyuntong.efficiencydiff.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 效率预警阈值分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EfficiencyDiffPageReqVO extends PageParam {

    @Schema(description = "企业id", example = "26713")
    private Long entId;

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
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
