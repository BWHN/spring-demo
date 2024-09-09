package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 对账单更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillUpdateReqVO extends BillBaseVO {

    @Schema(description = "ID", required = true, example = "12073")
    @NotNull(message = "ID不能为空")
    private Long id;

}
