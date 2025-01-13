package org.example.weiyuntong.tradehallcarsource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
@Schema(description = "车源交易大厅-用车接单信息 Request VO")
@Data
@ToString(callSuper = true)
public class ReceiveOrderVo {

    @Schema(description = "委托单/任务的id")
    private Long id;

    @Schema(description = "期望运价")
    private BigDecimal expectedPrice;

    @Schema(description = "关联车次")
    private String relateTrainNumber;
}
