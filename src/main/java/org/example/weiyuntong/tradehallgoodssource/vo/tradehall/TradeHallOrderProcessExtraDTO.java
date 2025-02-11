package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import com.weiyuntong.module.bizcenter.enums.SettleTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TradeHallOrderProcessExtraDTO {

    @Schema(description = "id")
    private Long id;
    @Schema(description = "报价ID")
    private Long processId;
    @Schema(description = "价格-用车时填写的价格")
    private BigDecimal expectedPrice;
    @Schema(description = "价格单位", example = "17369")
    private PriceUnitEnum expectedPriceUnit ;
    @Schema(description = "损耗")
    private BigDecimal loss;
    @Schema(description = "损耗单位")
    private PriceUnitEnum lossUnit;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
    @Schema(description = "结算方式")
    private Integer settleType;
    @Schema(description = "结算方式枚举")
    private SettleTypeEnum settleTypeEnum;
    @Schema(description = "预计付款日期")
    private LocalDateTime payTime;
    @Schema(description = "是否需要开票")
    private Boolean lowerNeedInvoice;

}
