package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 赊销配置 Excel 导出 Request VO，参数和 CreditConfigPageReqVO 是一致的")
@Data
public class CreditConfigExportReqVO {

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

    @Schema(description = "利率")
    private BigDecimal interestRate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
