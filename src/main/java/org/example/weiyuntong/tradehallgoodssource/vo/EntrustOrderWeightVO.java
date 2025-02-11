package org.example.weiyuntong.tradehallgoodssource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author FanluNiu
 * @version 1.0
 * @date 2024-05-11 9:29
 */
@Data
public class EntrustOrderWeightVO {

    @Schema(description = "总重量")
    private BigDecimal weight;

    @Schema(description = "剩余重量")
    private BigDecimal remainingWeight;

    @Schema(description = "撤销重量")
    private BigDecimal revokeWeight;

    @Schema(description = "忽略重量")
    private BigDecimal ignoreWeight;

    @Schema(description = "总数")
    private Long total;

    private List<EntrustOrderWeightCarrierVO> entrustOrderWeightCarrierVOList;
}
