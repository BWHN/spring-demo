package org.example.weiyuntong.bill.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.weiyuntong.framework.common.enums.ApprovalEnums;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoicePostStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

/**
* 对账单 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class BillBaseVO {
    @Schema(description = "上游付款凭证", example = "143")
    private String upReconciliationImg;
    /**
     * 承运商ID
     */
    @Schema(description = "承运商ID", example = "17119")
    private Long carrierId;

    @Schema(description = "承运商名称(托运人)", example = "王五")
    private String carrier;

    @Schema(description = "账期开始日期")
    private LocalDate billStartDate;

    @Schema(description = "账期结束日期")
    private LocalDate billEndDate;

    @Schema(description = "装货量")
    private BigDecimal loadedWeight = BigDecimal.ZERO;

    @Schema(description = "卸载量")
    private BigDecimal unloadedWeight = BigDecimal.ZERO;

    @Schema(description = "垫付金额")
    private BigDecimal advanceMoney;

    @Schema(description = "超亏吨")
    private BigDecimal excessWeight = BigDecimal.ZERO;

    @Schema(description = "超货损")
    private BigDecimal lossWeight = BigDecimal.ZERO;

    @Schema(description = "开票需求")
    private Boolean applyInvoice;

    @Schema(description = "开票金额")
    private BigDecimal invoiceAmount;

    @Schema(description = "登记开票金额")
    private BigDecimal registerInvoiceAmount;

    @Schema(description = "应收运费(应付运费)")
    private BigDecimal receivablesAmount = BigDecimal.ZERO;

    @Schema(description = "应付金额")
    private BigDecimal payableAmount = BigDecimal.ZERO;

    @Schema(description = "账单状态", example = "2")
    private BillStatusEnum billStatus;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "账单类型", example = "应付对账单：PAYABLE，应收对账单：RECEIVABLES")
    private BillTypeEnum billType;

    @Schema(description = "创建者姓名", example = "小有可维")
    private String creatorName;

    @Schema(description = "更新者姓名", example = "李四")
    private String updaterName;

    @Schema(description = "发票ID")
    private Long invoiceId;

    @Schema(description = "发票抬头")
    @TableField(exist = false)
    private String invoiceTitle;

    @Schema(description = "发票备注")
    private String invoiceRemark;

    @Schema(description = "发票备注文件")
    private String invoiceRemarkImg;

    @Schema(description = "车辆数")
    private Integer carCount;

    @Schema(description = "邮寄地址")
    private Long addressId;

    @Schema(description = "上游对账凭证", example = "['http://www.jpg']")
    private String attachment;

    @Schema(description = "业务联系人")
    private String customerContact;

    @Schema(description = "开票状态")
    private BillInvoiceStatusEnum invoiceStatus;

    @Schema(description = "发票邮件状态")
    private BillInvoicePostStatusEnum invoicePostStatus;

    @Schema(description = "单据状态")
    private BillInvoicePostStatusEnum docketStatus;

    @Schema(description = "托运人ID")
    private Long consignorId;

    @Schema(description = "托运人")
    private String consignor;

    @Schema(description = "付款账期")
    private String period;

    @Schema(description = "审核状态")
    private ApprovalEnums approveStatus;

    @Schema(description = "是否垫付")
    private Boolean advancePayment=false;

    @Schema(description = "申请金额")
    private BigDecimal applyAmount = BigDecimal.ZERO;

    @Schema(description = "实收金额")
    private BigDecimal paidAmount = BigDecimal.ZERO;

    @Schema(description = "申请时间")
    private LocalDateTime applyTime;

    @Schema(description = "付款时间", example = "2023-8-22 11:31:20")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDateTime dingdingApplyTime;

    @Schema(description = "货主端支付费用")
    private BigDecimal payerPaidAmount = BigDecimal.ZERO;

    @Schema(description = "承运端支付费用")
    private BigDecimal payeePaidAmount = BigDecimal.ZERO;

    @Schema(description = "预计毛利润")
    private BigDecimal grossProfit = BigDecimal.ZERO;

    @Schema(description = "货物损耗")
    public BigDecimal getLossAmount() {
        return lossWeight;
    }

    public BigDecimal getPaidAmount() {
        if (paidAmount == null) {
            return BigDecimal.ZERO;
        }
        return paidAmount;
    }

    @Schema(description = "是否需要单据")
    private Boolean isDocument;

    @Schema(description = "创建者电话")
    private String creatorPhone;

    @Schema(description = "对账日期")
    private Date checkBillDate;

    @Schema(description = "负责人")
    private String corporateName;

    @Schema(description = "开票吨数")
    private BigDecimal invoiceTonnes;

    @Schema(description = "是否忽略")
    private Boolean isIgnore;

    @Schema(description = "预测账单利润")
    private BigDecimal billProfit;

    @Schema(description = "预测账单利润率")
    private BigDecimal billProfitRate;

    @Schema(description = "实际账单利润")
    private BigDecimal realBillProfit;

    @Schema(description = "实际账单利润率")
    private BigDecimal realBillProfitRate;



}
