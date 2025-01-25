package org.example.weiyuntong.taskorderbiddingrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 任务单报价记录信息 Excel 导出 Request VO，参数和 TaskorderBiddingRecordPageReqVO 是一致的")
@Data
public class TaskorderBiddingRecordExportReqVO {

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
    private LocalDateTime[] grabTime;

    @Schema(description = "是否保温:1.保温")
    private Integer isWarm;

    @Schema(description = "是否加热:1.加热")
    private Integer isHeat;

    @Schema(description = "预计毛利润")
    private BigDecimal grossProfit;

    @Schema(description = "创建者", example = "李四")
    private String creatorName;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新者", example = "赵六")
    private String updaterName;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "报价状态（-1.报价失效0.待确认1.确认报价）", example = "1")
    private Byte status;

    @Schema(description = "关联的任务Id", example = "28523")
    private Long taskId;

    @Schema(description = "报价企业id", example = "17498")
    private Long entId;
    @Schema(description = "关联的任务委托单Id", example = "2032")
    private Long taskEntrustId;

}
