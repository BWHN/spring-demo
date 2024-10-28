package org.example.weiyuntong.bizimpresteditrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 备用金修改记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BizImprestEditRecordUpdateReqVO extends BizImprestEditRecordBaseVO {

    @Schema(description = "id", required = true, example = "23051")
    @NotNull(message = "id不能为空")
    private Long id;

}
