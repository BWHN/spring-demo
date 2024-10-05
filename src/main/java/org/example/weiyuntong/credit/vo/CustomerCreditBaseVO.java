package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
* 客户赊销 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CustomerCreditBaseVO {

    @Schema(description = "客户ID", example = "10695")
    private Long customerId;

    @Schema(description = "承运商", example = "22795")
    private Long carrierId;

    @Schema(description = "授信额度")
    private BigDecimal totalAmount;

    @Schema(description = "已使用额度")
    private BigDecimal usedAmount;

    @Schema(description = "逾期额度")
    private BigDecimal expiredAmount;

    @Schema(description = "资金收益")
    private BigDecimal incomeAmount;

    @Schema(description = "资金暂用成本")
    private BigDecimal interestRate;
}
