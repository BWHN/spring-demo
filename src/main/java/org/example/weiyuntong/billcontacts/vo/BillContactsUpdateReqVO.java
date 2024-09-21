package org.example.weiyuntong.billcontacts.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 账单联系人更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillContactsUpdateReqVO extends BillContactsBaseVO {

    @Schema(description = "id", required = true, example = "5530")
    @NotNull(message = "id不能为空")
    private Long id;

}
