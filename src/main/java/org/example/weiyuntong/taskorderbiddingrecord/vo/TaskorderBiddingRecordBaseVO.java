package org.example.weiyuntong.taskorderbiddingrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 任务单报价记录信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TaskorderBiddingRecordBaseVO {

    @Schema(description = "抢单运量")
    private BigDecimal grabWeight;

    @Schema(description = "剩余运量")
    private BigDecimal surplusWeight;

    @Schema(description = "寻车运价", example = "24695")
    private BigDecimal price;

    @Schema(description = "上报运价", example = "23347")
    private BigDecimal reportPrice;

    @Schema(description = "上报车辆id，多个车辆逗号分隔", example = "619")
    private String reportCarId;

    @Schema(description = "上报车辆车牌，多个车辆逗号分隔")
    private String reportCarNum;

    @Schema(description = "车辆类型", example = "1")
    private Integer carType;

    @Schema(description = "抢单截止时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime grabTime;

    @Schema(description = "是否保温:1.保温")
    private Integer isWarm;

    @Schema(description = "是否加热:1.加热")
    private Integer isHeat;

    @Schema(description = "预计毛利润")
    private BigDecimal grossProfit;

    @Schema(description = "创建者", example = "李四")
    private String creatorName;

    @Schema(description = "更新者", example = "赵六")
    private String updaterName;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "报价状态（-1.报价失效0.待确认1.确认报价）", required = true, example = "1")
    @NotNull(message = "报价状态（-1.报价失效0.待确认1.确认报价）不能为空")
    private int status;

    @Schema(description = "关联的任务Id", required = true, example = "28523")
    @NotNull(message = "关联的任务Id不能为空")
    private Long taskId;

    @Schema(description = "关联的任务委托单Id", required = true, example = "2032")
    @NotNull(message = "关联的任务委托单Id不能为空")
    private Long taskEntrustId;

    @Schema(description = "报价企业id", required = true, example = "17498")
    @NotNull(message = "报价企业id不能为空")
    private Long entId;

}
