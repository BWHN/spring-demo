package org.example.weiyuntong.updatelog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 修改记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UpdateLogUpdateReqVO extends UpdateLogBaseVO {

    @Schema(description = "id", required = true, example = "16292")
    @NotNull(message = "id不能为空")
    private Long id;

}
