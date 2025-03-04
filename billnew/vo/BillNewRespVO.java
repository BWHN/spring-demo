package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.*;
import com.weiyuntong.module.bizcenter.enums.SourceTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Schema(description = "管理后台 - 新对账单 Response VO")
@Data
@ToString(callSuper = true)
public class BillNewRespVO {

    @Schema(description = "账单ID", required = true, example = "12073")
    private Long id;

    @Schema(description = "账单类型", example = "应付对账单：PAYABLE，应收对账单：RECEIVABLES")
    private BillTypeEnum billType;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "账单状态", example = "2")
    private BillStatusEnum billStatus;
    @Schema(description = "业务类型")
    private SourceTypeEnum billServiceType;
    @Schema(description = "承运商ID")
    private Long carrierId;
    @Schema(description = "承运商名称")
    private String carrier;
    private String carrierEnterpriseType;

    @Schema(description = "托运人ID")
    private Long consignorId;
    @Schema(description = "托运人")
    private String consignor;

    @Schema(description = "账单名称")
    private String billName;

    @Schema(description = "运单数量")
    private int waybillCount;

    @Schema(description = "应付金额")
    private BigDecimal payableAmount = BigDecimal.ZERO;

    @Schema(description = "应收运费")
    private BigDecimal receivablesAmount = BigDecimal.ZERO;

    @Schema(description = "账单开票状态" , example = "BillInvoiceStatusEnum")
    private String invoiceStatus;

    @Schema(description = "开票吨数")
    private BigDecimal invoiceTonnes;

    @Schema(description = "应开票金额")
    private BigDecimal invoicedAmount = BigDecimal.ZERO;

    @Schema(description = "已开票金额")
    private BigDecimal registerInvoiceAmount = BigDecimal.ZERO;

    @Schema(description = "待开票金额")
    private BigDecimal toInvoiceAmount = BigDecimal.ZERO;

    public BigDecimal getToInvoiceAmount(){
        return this.toInvoiceAmount.compareTo(BigDecimal.ZERO) <0 ? BigDecimal.ZERO : this.toInvoiceAmount;
    }

    @Schema(description = "忽略开票金额")
    private BigDecimal ignoreInvoiceAmount = BigDecimal.ZERO;

    public BigDecimal getIgnoreInvoiceAmount(){
        return this.ignoreInvoiceAmount.compareTo(BigDecimal.ZERO) <0 ? BigDecimal.ZERO : this.ignoreInvoiceAmount;
    }

    @Schema(description = "账单收付款状态" , example = "BillStatusEnum")
    private String paidStatus;

    @Schema(description = "已收、付金额")
    private BigDecimal paidAmount = BigDecimal.ZERO;

    @Schema(description = "待收、付金额")
    private BigDecimal toPaidAmount = BigDecimal.ZERO;

    public BigDecimal getToPaidAmount(){
        return this.toPaidAmount.compareTo(BigDecimal.ZERO) <0 ? BigDecimal.ZERO : this.toPaidAmount;
    }

    @Schema(description = "忽略收、付款金额")
    private BigDecimal ignorePaidAmount = BigDecimal.ZERO;

    public BigDecimal getIgnorePaidAmount(){
        return this.ignorePaidAmount.compareTo(BigDecimal.ZERO) <0 ? BigDecimal.ZERO : this.ignorePaidAmount;
    }

    @Schema(description = "创建者id")
    private String creatorId;

    @Schema(description = "创建者姓名", example = "小有可维")
    private String creatorName;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "审核人姓名")
    private String reviewerName;

    @Schema(description = "审核时间")
    private LocalDateTime reviewerTime;

    @Schema(description = "单据需求 0:否  1:是")
    private Boolean isDocument;

    @Schema(description = "是否当前企业创建的账单")
    private Boolean createEnt;

    @Schema(description = "是否为货运")
    private Boolean outBill;

    public String getPaidStatusDesc() {
        String desc = BillStatusEnum.valueOf(paidStatus).getDesc();
        if (billType.equals(BillTypeEnum.RECEIVABLES)){
            return desc.replace("付", "收");
        }
        return desc;
    }

    public String getInvoiceStatusDesc() {
        String desc = BillInvoiceStatusEnum.valueOf(invoiceStatus).getDesc();
        if (billType.equals(BillTypeEnum.PAYABLE)){
            return desc.replace("开", "收");
        }
        return desc;
    }

}
