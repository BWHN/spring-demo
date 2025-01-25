package org.example.weiyuntong.taskorderbiddingrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 任务单报价记录信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TaskorderBiddingRecordRespVO extends TaskorderBiddingRecordBaseVO {

    @Schema(description = "id", required = true, example = "9819")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
