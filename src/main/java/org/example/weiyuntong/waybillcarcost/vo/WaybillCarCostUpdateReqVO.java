package org.example.weiyuntong.waybillcarcost.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 车次成本更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WaybillCarCostUpdateReqVO extends WaybillCarCostBaseVO {

    @Schema(description = "ID", required = true, example = "4867")
    @NotNull(message = "ID不能为空")
    private Long id;

}
