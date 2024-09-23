package org.example.weiyuntong.billpay.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.billpay.PayWayEnum;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_HOUR_MINUTE_SECOND;

/**
* 登记付款 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillPayBaseVO {

    @Schema(description = "付款方式")
    private String payWay;

    @Schema(description = "凭证", example = "https://www.w-lian.cn")
    private String payUrl;

    @Schema(description = "发票代码")
    private String invoiceSn;

    @Schema(description = "付款时间")
    @DateTimeFormat(pattern = FORMAT_HOUR_MINUTE_SECOND)
    private LocalDateTime payTime;

    @Schema(description = "付款金额")
    private BigDecimal payMoney;

    @Schema(description = "付款账户", example = "28201")
    private String payAccount;

    @Schema(description = "账单id", example = "26769")
    private Long billId;

    @Schema(description = "发票账户id", example = "17866")
    private Long customerBillId;

    @Schema(description = "收款金额", example = "17866")
    private BigDecimal putMoney;

    @Schema(description = "收款时间")
    @DateTimeFormat(pattern = FORMAT_HOUR_MINUTE_SECOND)
    private LocalDateTime putTime;

    @Schema(description = "收款账户", example = "17866")
    private String putAccount;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "实收金额")
    private BigDecimal paidAmount;

    @Schema(description = "应付金额含税")
    private BigDecimal payableAmount;

    @Schema(description = "应收金额")
    private BigDecimal receivablesAmount;

    @Schema(description = "剩余金额")
    private BigDecimal remainAmount;

    @Schema(description = "收款人账户名")
    private String payeeAccountName;

    @Schema(description = "收款人账号")
    private String payeeAccountNumber;

    @Schema(description = "收款人开户行")
    private String payeeOpeningBankName;

    @Schema(description = "收款账户联行号")
    private String payeeBkNo;

    @Schema(description = "付款人账户名")
    private String payerAccountName;

    @Schema(description = "付款人账号")
    private String payerAccountNumber;

    @Schema(description = "付款人开户行")
    private String payerOpeningBankName;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "用户银行账户id", example = "1")
    private Long userBankAccountId;
    public String getPayWayDesc() {
        return PayWayEnum.instanceOf(payWay).getDesc();
    }

    @Schema(description = "剩余应收")
    public BigDecimal getRemainAmount() {
        return BigDecimalUtil.subtract(receivablesAmount, paidAmount);
    }
}
