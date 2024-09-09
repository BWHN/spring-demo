package org.example.weiyuntong.bill.vo;

import com.weiyuntong.framework.desensitize.core.slider.annotation.FixedPhoneDesensitize;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CustomerBillVO {
    @Schema(description = "id")
    private Long id;

    @Schema(description = "租户ID")
    private Long tenantId;

    @Schema(description = "货主id")
    private Long consignorId;

    @Schema(description = "承运商id")
    private Long carrierId;

    @Schema(description = "客户编码")
    private String code;

    @Schema(description = "客户名称")
    private String name;

    @Schema(description = "货主客户名称")
    private String consignor;

    @Schema(description = "账单数量")
    private Integer billNum;

    @Schema(description = "已收账单")
    private int paidBillNum;

    @Schema(description = "账单状态")
    private BillStatusEnum billStatus;

    @Schema(description = "车次数量")
    private Integer carNum;

    @Schema(description = "应收金额")
    private BigDecimal receivablesAmount = BigDecimalUtil.ZERO;

    @Schema(description = "剩余应收金额")
    private BigDecimal remainAmount = BigDecimalUtil.ZERO;

    @Schema(description = "实收金额")
    private BigDecimal paidAmount = BigDecimalUtil.ZERO;

    @Schema(description = "逾期金额")
    private BigDecimal expiredAmount = BigDecimalUtil.ZERO;

    @Schema(description = "应开发票金额")
    private BigDecimal totalInvoiceAmount = BigDecimalUtil.ZERO;

    @Schema(description = "发票金额")
    private BigDecimal invoicedAmount = BigDecimalUtil.ZERO;

    @Schema(description = "剩余应开发票金额")
    private BigDecimal remainInvoicedAmount = BigDecimalUtil.ZERO;

    @Schema(description = "企业联络人", example = "李四")
    @FixedPhoneDesensitize(prefixKeep = 1, suffixKeep = 0, replacer = "*")
    private String entProName;

    @Schema(description = "企业联络人电话")
    @FixedPhoneDesensitize(prefixKeep = 3, suffixKeep = 4, replacer = "*")
    private String entPeoPhone;

    @Schema(description = "业务经理")
    private String serviceManagerName;

    @Schema(description = "客户经理id")
    private Long serviceManagerId;

    @Schema(description = "负责人联系电话")
    private String serviceManagerMobile;

    @Schema(description = "客户联系人")
    @FixedPhoneDesensitize(prefixKeep = 1, suffixKeep = 0, replacer = "*")
    private String customerContact;

    @Schema(description = "客户联系人电话")
    @FixedPhoneDesensitize(prefixKeep = 3, suffixKeep = 4, replacer = "*")
    private String customerContactMobile;

    @Schema(description = "客户负责人")
    private String corporateName;

    @Schema(description = "客户负责人电话")
    private String corporateMobile;

    @Schema(description = "车辆数")
    private Long carCount;

    @Schema(description = "实际发票金额")
    private BigDecimal realInvoiceAmount = BigDecimalUtil.ZERO;

    @Schema(description = "已收账单个数/已付账单个数")
    private Integer paid;

    private List<BillRespVO> billRespVOS;

    @Schema(description = "剩余开票金额")
    public BigDecimal getRemainderAmount() {
        return BigDecimalUtil.subtract(receivablesAmount, paidAmount);
    }

    public BigDecimal getRemainInvoicedAmount() {
        //剩余应开发票金额：统计出来的账单信息中的invoice_amount总和-实际开票金额
        return BigDecimalUtil.subtract(invoicedAmount, realInvoiceAmount);
    }

}
