package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 账单车次更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillCarUpdateReqVO extends BillCarBaseVO {

    @Schema(description = "ID", required = true, example = "27207")
    @NotNull(message = "ID不能为空")
    private Long id;

}
