package org.example.weiyuntong.tradehallgoodssource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author FanluNiu
 * @version 1.0
 * @date 2024-05-11 9:29
 */
@Data
public class EntrustOrderWeightCarrierVO {

    @Schema(description = "承运商名称")
    private String carrierName;

    @Schema(description = "承运商id")
    private Long carrierId;

    private String userName;

    private String userPhone;

    private String userId;

    @Schema(description = "成交重量")
    private BigDecimal dealWeight;

    @Schema(description = "待下发重量")
    private BigDecimal toMoveWeight;

    @Schema(description = "毛利润")
    private BigDecimal startGrossProfit;

    @Schema(description = "承运商车辆数量")
    private int carCount;

    @Schema(description = "总重量")
    private BigDecimal weight;
}
