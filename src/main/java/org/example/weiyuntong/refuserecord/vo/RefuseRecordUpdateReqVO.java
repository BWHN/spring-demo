package org.example.weiyuntong.refuserecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 撤销信息记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RefuseRecordUpdateReqVO extends RefuseRecordBaseVO {

    @Schema(description = "id", required = true, example = "1759")
    @NotNull(message = "id不能为空")
    private Long id;

}
