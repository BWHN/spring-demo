package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Schema(description = "平台大厅统计")
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TradeHallSummaryVO {

    @Schema(description = "待成交")
    private BigDecimal toDealWeight;
    @Schema(description = "今日成交")
    private BigDecimal dealWeightToday;
    @Schema(description = "公开订单量")
    private long publicCount;
    @Schema(description = "内部订单量")
    private long ownCount;

}
