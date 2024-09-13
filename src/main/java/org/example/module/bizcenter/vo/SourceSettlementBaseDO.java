package org.example.module.bizcenter.vo;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Data
public class SourceSettlementBaseDO {
    //当前运单的结算
    @Schema(description = "是否需要开票")
    private Boolean needInvoice;
    @Schema(description = "实际成交价格", example = "20085")
    private BigDecimal dealPrice;
    @Schema(description = "运价单位")
    private PriceUnitEnum dealPriceUnit;
    @Schema(description = "运费")
    private BigDecimal amount;
    @Schema(description = "支付运费")
    private BigDecimal payAmount;
    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;
    @Schema(description = "损耗")
    private BigDecimal loss;
    @Schema(description = "损耗单位(‰/kG)")
    private PriceUnitEnum lossUnit;
    @Schema(description = "预计结算日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime processPayTime;
    @Schema(description = "货物运费结算方式（settl_type运输单价*卸货量/运输单价*装货量/总报价）", example = "2")
    private Integer settleType;
}
