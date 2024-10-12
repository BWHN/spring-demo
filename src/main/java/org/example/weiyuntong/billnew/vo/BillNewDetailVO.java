package org.example.weiyuntong.billnew.vo;

import com.weiyuntong.module.bizcenter.controller.admin.waybillsource.vo.WaybillSourceBillVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillAbortDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Schema(description = "管理后台 - 新对账单详情 VO")
@Data
@ToString(callSuper = true)
public class BillNewDetailVO extends BillSourceCreateVO {

    @Schema(description = "账单ID", required = true, example = "12073")
    private Long id;
    /**
     * 头部信息
     */
    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "账单金额")
    private BigDecimal amount;
    @Schema(description = "实际支付金额")
    private BigDecimal paidAmount;
    @Schema(description = "收付款状态", example = "9000.00")
    private BillStatusEnum paidStatus;
    @Schema(description = "忽略金额")
    private BigDecimal ignoreAmount;

    @Schema(description = "开票金额")
    private BigDecimal invoiceAmount;
    @Schema(description = "实际开票金额")
    private BigDecimal registerInvoiceAmount;
    @Schema(description = "忽略开票金额")
    private BigDecimal ignoreInvoiceAmount;
    @Schema(description = "开票状态", example = "参见：BillInvoiceStatusEnum")
    private BillInvoiceStatusEnum invoiceStatus;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "创建人")
    private String createName;
    @Schema(description = "审核时间")
    private LocalDateTime reviewerTime;
    @Schema(description = "审核人")
    private String reviewerName;
    @Schema(description = "账单状态desc")
    private String billStatusDesc;

    @Schema(description = "开票信息")
    private List<BillInvoiceLogVO> invoiceLogVOS;
    /**
     * 收款信息
     */
    private List<BillPayLogVO> billPayLogList;
    /**
     * 审核记录
     */
    private List<BillAbortDO> billAbortDOList;

    /**
     * 账单关联的运单列表
     */

    @Schema(description = "总运量")
    private BigDecimal totalWeight;
    @Schema(description = "总的钱")
    private BigDecimal totalAmount;

    List<WaybillSourceBillVO> waybillSourceList;

}
