package org.example.weiyuntong.taskorderrefuserecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 任务单拒绝记录信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TaskorderRefuseRecordUpdateReqVO extends TaskorderRefuseRecordBaseVO {

    @Schema(description = "id", required = true, example = "24678")
    @NotNull(message = "id不能为空")
    private Long id;

}
