package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 对账单 Excel 导出 Request VO，参数和 BillPageReqVO 是一致的")
@Data
public class BillExportReqVO {

    @Schema(description = "承运商ID", example = "17119")
    private Long enterpriseId;

    @Schema(description = "承运商名称", example = "王五")
    private String enterpriseName;

    @Schema(description = "账期开始日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] billStartDate;

    @Schema(description = "账期结束日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] billEndDate;

    @Schema(description = "装货量")
    private BigDecimal loadedWeight;

    @Schema(description = "卸载量")
    private BigDecimal unloadedWeight;

    @Schema(description = "超亏吨")
    private BigDecimal excessWeight;

    @Schema(description = "超货损")
    private BigDecimal lossWeight;

    @Schema(description = "开票需求")
    private Boolean applyInvoice;

    @Schema(description = "应付金额")
    private BigDecimal payableAmount;

    @Schema(description = "账单状态", example = "2")
    private String billStatus;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "账单类型", example = "1")
    private String billType;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "创建者姓名", example = "小有可维")
    private String creatorName;

    @Schema(description = "更新者姓名", example = "李四")
    private String updaterName;

}
