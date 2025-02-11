package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AppTradeHallOrderProcessSubmitDTO {

    @Schema(description = "订单ID")
    private Long id;
    @Schema(description = "提交重量")
    private BigDecimal weight;
    @Schema(description = "司机id")
    private Long driverId;
    @Schema(description = "车辆id")
    private Long carId;
    @Schema(description = "用户车辆最大载重")
    private BigDecimal carMaxwgt;
    @Schema(description = "车牌号")
    private String carNumber;

}
