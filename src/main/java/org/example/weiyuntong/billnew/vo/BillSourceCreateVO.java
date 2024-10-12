package org.example.weiyuntong.billnew.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillTypeEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.billexpress.BillExpressDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.customerbill.BillCustomerBillDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillSourceCreateVO {

    @Schema(description = "支付人")
    private String customerName;
    @Schema(description = "支付人id")
    private Long customerId;

    @Schema(description = "名称")
    private String name;
    @Schema(description = "备注")
    private String remark;
    @Schema(description = "运单ID", example = "[15123445666782413]")
    private List<Long> waybillSourceIdList;

    @Schema(description = "上游付款凭证", example = "143")
    private String upReconciliationImg;
    @Schema(description = "账单类型")
    private BillTypeEnum type;
    @Schema(description = "账单状态", example = "")
    private String billStatus;

    @Schema(description = "客户开票信息")
    private BillCustomerBillDO customerBillDO;
    @Schema(description = "客户邮寄信息")
    private BillExpressDO billExpressDO;

    @Schema(description = "是否开票")
    private Boolean needInvoiced;
    @Schema(description = "是否需要单据", example = "true")
    private Boolean needDocument;
    @Schema(description = "发票备注")
    private String invoiceRemark;
    @Schema(description = "发票备注文件")
    private String invoiceRemarkImg;
    @Schema(description = "开票吨数")
    private BigDecimal invoiceTonnes;
    @Schema(description = "自动申请开票")
    private Boolean autoInvoice;

    @Schema(description = "预测账单利润")
    private BigDecimal billProfit;
    @Schema(description = "预测账单利润率")
    private BigDecimal billProfitRate;
    @Schema(description = "实际账单利润")
    private BigDecimal realBillProfit;
    @Schema(description = "实际账单利润率")
    private BigDecimal realBillProfitRate;


    @Schema(description = "收件地址ID", example = "199")
    private Long addressId;

}
