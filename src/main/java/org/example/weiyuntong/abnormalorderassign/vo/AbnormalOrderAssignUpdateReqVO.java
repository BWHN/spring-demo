package org.example.weiyuntong.abnormalorderassign.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "运营中心-异常管理 - 委托失效分配记录更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AbnormalOrderAssignUpdateReqVO extends AbnormalOrderAssignBaseVO {

    @Schema(description = "id", required = true, example = "4902")
    @NotNull(message = "id不能为空")
    private Long id;

}
