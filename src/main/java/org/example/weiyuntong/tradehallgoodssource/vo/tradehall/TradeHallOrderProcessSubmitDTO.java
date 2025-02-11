package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class TradeHallOrderProcessSubmitDTO {

    @Schema(description = "订单ID")
    private Long id;
    @Schema(description = "报价信息")
    private List<TradeHallOrderProcessVO> processList;

}
