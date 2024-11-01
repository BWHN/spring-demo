package org.example.weiyuntong.carconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 车辆费用配置更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CarConfigUpdateReqVO extends CarConfigBaseVO {

    @Schema(description = "ID", required = true, example = "29187")
    private Long id;

}
