package org.example.weiyuntong.credit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 赊销评级 Excel 导出 Request VO，参数和 CreditConfigLevelPageReqVO 是一致的")
@Data
public class CreditConfigLevelExportReqVO {

    @Schema(description = "客户评价")
    private String customerLevel;

    @Schema(description = "承运商", example = "14633")
    private Long carrierId;

    @Schema(description = "授信额度")
    private BigDecimal creditAmount;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
