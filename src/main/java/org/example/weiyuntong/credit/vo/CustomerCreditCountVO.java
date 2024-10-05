package org.example.weiyuntong.credit.vo;

import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerCreditCountVO {

    @Schema(description = "授信总额")
    private BigDecimal totalCreditAmount;

    @Schema(description = "已使用总额")
    private BigDecimal totalUsedAmount;

    @Schema(description = "额度警示消息")
    private Long amountWarnNum;

    @Schema(description = "风险警示消息")
    private Long riskWarnNum;

    @Schema(description = "逾期警示消息")
    private Long overdueWarnNum;

    @Schema(description = "资金收益")
    private BigDecimal totalIncomeAmount;

    @Schema(description = "剩余总额")
    public BigDecimal getTotalAvailableAmount() {
        return BigDecimalUtil.subtract(totalCreditAmount, totalUsedAmount);
    }
}


