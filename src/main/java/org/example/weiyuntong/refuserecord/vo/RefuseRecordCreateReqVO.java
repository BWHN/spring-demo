package org.example.weiyuntong.refuserecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 撤销信息记录创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RefuseRecordCreateReqVO extends RefuseRecordBaseVO {
    @Schema(description = "拒绝的id", required = true, example = "16414")
    private String ids;
    @Schema(description = "关联的任务Id", required = false, example = "10457")
    private Long taskId;
}
