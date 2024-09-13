package org.example.module.bizcenter.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.PayableStatusEnum;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Data
public class BillSourceVO extends SourceSettlementBaseDO {
    //价格
    @Schema(description = "时长")
    private String time;
    @Schema(description = "补款/扣款")
    private BigDecimal exceptionAmount;
    @Schema(description = "成本")
    private BigDecimal ownAmount;

    @Schema(description = "账单id")
    private Long billId;
    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "账单状态")
    private BillStatusEnum billStatus;
    @Schema(description = "对账日期", example = "2020")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime checkBillDate;
    @Schema(description = "开票状态")
    private BillInvoiceStatusEnum invoiceStatus;
    @Schema(description = "登记开票金额", example = "0.00")
    private BigDecimal registerInvoiceAmount;
    @Schema(description = "开票完成时间", example = "2020")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime invoiceDate;
    @Schema(description = "付款状态")
    private PayableStatusEnum payStatus;
    @Schema(description = "实际支付金额")
    private BigDecimal paidAmount;
    @Schema(description = "付款完成时间", example = "2020")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime paidDate;
    @Schema(description = "营销费用")
    private BigDecimal marketAmount;

    @Schema(description = "上游支付费用（异常）")
    private BigDecimal topPayAmount;
    @Schema(description = "下游支付费用（异常）")
    private BigDecimal lowerPayAmount;

    public BigDecimal getExceptionAmount() {
        return BigDecimalUtil.subtract(topPayAmount, lowerPayAmount);
    }

}
