package org.example.weiyuntong.tradehallgoodssource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;

@Schema(description = "管理后台 - 交易大厅-货源管理更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallGoodsSourceUpdateReqVO extends TradehallGoodsSourceBaseVO {

    @Schema(description = "主键id", required = true, example = "20485")
    @NotNull(message = "主键id不能为空")
    private Long id;

}
