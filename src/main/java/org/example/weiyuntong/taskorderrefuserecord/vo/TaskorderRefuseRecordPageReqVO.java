package org.example.weiyuntong.taskorderrefuserecord.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 任务单拒绝记录信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TaskorderRefuseRecordPageReqVO extends PageParam {

    @Schema(description = "关联的任务Id", example = "10457")
    private Long taskId;

    @Schema(description = "关联的任务委托单Id", example = "13038")
    private Long taskEntrustId;

    @Schema(description = "企业id", example = "3978")
    private Long entId;

    @Schema(description = "拒绝其他备注信息", example = "随便")
    private String remark;

    @Schema(description = "拒绝原因，支持多选，以逗号分隔", example = "不好")
    private String refuseReason;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
