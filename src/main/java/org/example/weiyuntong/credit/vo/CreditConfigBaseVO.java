package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
* 赊销配置 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CreditConfigBaseVO {

    @Schema(description = "承运商ID", example = "6628")
    private Long carrierId;

    @Schema(description = "账期开始时间")
    private String billStart;

    @Schema(description = "账期结束时间")
    private String billEnd;

    @Schema(description = "额度预警提醒")
    private BigDecimal lowThreshold;

    @Schema(description = "逾期预警提醒")
    private BigDecimal overdueThreshold;

    @Schema(description = "资金收益比")
    private BigDecimal interestRate;

    @Schema(description = "s")
    private BigDecimal slevel;

    @Schema(description = "a")
    private BigDecimal alevel;

    @Schema(description = "b")
    private BigDecimal blevel;

    @Schema(description = "c")
    private BigDecimal clevel;

    @Schema(description = "d")
    private BigDecimal dlevel;
}
