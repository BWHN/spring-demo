package org.example.weiyuntong.billpay.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 登记付款 Excel 导出 Request VO，参数和 BillPayPageReqVO 是一致的")
@Data
public class BillPayExportReqVO {

    @Schema(description = "付款方式")
    private String payWay;

    @Schema(description = "付款凭证", example = "https://www.w-lian.cn")
    private String payUrl;

    @Schema(description = "发票代码")
    private String invoiceSn;

    @Schema(description = "付款时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] payTime;

    @Schema(description = "付款金额")
    private BigDecimal payMoney;

    @Schema(description = "付款账户", example = "28201")
    private String payAccount;

    @Schema(description = "账单id", example = "26769")
    private Long billId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "发票账户id", example = "17866")
    private Long customerBillId;

}
