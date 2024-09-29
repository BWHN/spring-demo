package org.example.weiyuntong.billinvoice.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoicePostStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_HOUR_MINUTE_SECOND;

/**
* 账单发票 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillInvoiceBaseVO {

    @Schema(description = "账单ID", example = "27357")
    private Long billId;

    @Schema(description = "发票代码")
    private String invoiceSn;

    @Schema(description = "发票金额")
    private BigDecimal invoiceAmount;

    @Schema(description = "开票日期")
    @DateTimeFormat(pattern = FORMAT_HOUR_MINUTE_SECOND)
    private LocalDate invoiceDate;

    @Schema(description = "发票凭证", example = "https://www.w-lian.cn")
    private String invoiceUrl;

    @Schema(description = "发票日志")
    private String invoiceRemark;

    @Schema(description = "邮寄状态")
    private BillInvoicePostStatusEnum invoicePostStatus;

}
