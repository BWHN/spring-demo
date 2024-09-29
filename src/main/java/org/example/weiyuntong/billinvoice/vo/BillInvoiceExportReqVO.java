package org.example.weiyuntong.billinvoice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 账单发票 Excel 导出 Request VO，参数和 BillInvoicePageReqVO 是一致的")
@Data
public class BillInvoiceExportReqVO {

    @Schema(description = "账单ID", example = "27357")
    private Long billId;

    @Schema(description = "发票代码")
    private String invoiceSn;

    @Schema(description = "发票金额")
    private BigDecimal invoiceAmount;

    @Schema(description = "开票日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] invoiceDate;

    @Schema(description = "发票凭证", example = "https://www.w-lian.cn")
    private String invoiceUrl;

    @Schema(description = "是否邮寄")
    private Boolean hasMailed;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
