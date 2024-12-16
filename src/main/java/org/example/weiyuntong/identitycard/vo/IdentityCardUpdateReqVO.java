package org.example.weiyuntong.identitycard.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 用户身份信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IdentityCardUpdateReqVO extends IdentityCardBaseVO {

    @Schema(description = "ID", required = true, example = "31306")
    @NotNull(message = "ID不能为空")
    private Long id;

}
