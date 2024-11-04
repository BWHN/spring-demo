package org.example.weiyuntong.bizexpensetype.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 费用类型 Excel 导出 Request VO，参数和 BizExpenseTypePageReqVO 是一致的")
@Data
public class BizExpenseTypeExportReqVO {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "费用类型名称", example = "李四")
    private String name;

    @Schema(description = "费用上限:0.无上限1.有上限")
    private Byte isExpenseLimit;

    @Schema(description = "费用上线金额")
    private BigDecimal expenseLimitAmount;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "版本号")
    private Integer version;

}
