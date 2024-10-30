package org.example.weiyuntong.customerbill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 客户开票信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CustomerBillUpdateReqVO extends CustomerBillBaseVO {

    @Schema(description = "ID", required = true, example = "24067")
    @NotNull(message = "ID不能为空")
    private Long id;

}
