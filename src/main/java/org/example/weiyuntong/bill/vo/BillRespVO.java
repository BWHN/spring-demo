package org.example.weiyuntong.bill.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billexpress.vo.BillExpressRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.billinvoice.vo.BillInvoiceShareVO;
import com.weiyuntong.module.bizcenter.controller.admin.billpay.vo.BillPayRespVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillAbortDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillIgnoreDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.billinvoice.BillInvoiceDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.customerbill.CustomerBillDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.ReconciledStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import com.weiyuntong.module.bpm.dal.dataobject.node.NodeDO;
import com.weiyuntong.module.opecenter.controller.admin.express.vo.ExpressBaseVO;
import com.weiyuntong.module.system.dal.dataobject.address.MyAddressDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.weiyuntong.framework.common.util.date.DateUtils.*;

@Schema(description = "管理后台 - 对账单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillRespVO extends BillBaseVO {

    @Schema(description = "ID", required = true, example = "12073")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "车次信息")
    private List<WaybillCarDO> waybillCarList;

    @Schema(description = "发票信息")
    private CustomerBillDO customerBill;

    @Schema(description = "邮寄信息")
    private ExpressBaseVO express;

    @Schema(description = "收件")
    private MyAddressDO address;

    @Schema(description = "发票邮寄信息")
    private BillExpressRespVO billExpress;

    @Schema(description = "单据邮寄信息")
    private BillExpressRespVO billDocumentExpress;

    @Schema(description = "剩余应收")
    public BigDecimal remainAmount;

    @Schema(description = "企业联络人", example = "李四")
    private String entProName;

    @Schema(description = "客户负责人", example = "李四")
    private String contactsPhone;

    @Schema(description = "客户编号")
    private String code;

    @Schema(description = "账单审核财务编码")
    private String moneyCode;

    @Schema(description = "客户名称")
    private String customerName;

    @Schema(description = "应付运费")
    private BigDecimal receivablesAmount;

    @Schema(description = "收付款明细")
    private List<BillPayRespVO> payList;

    @Schema(description = "发票信息")
    private BillInvoiceDO billInvoice;

    @Schema(description = "客户联系人电话")
    private String customerContactMobile;

    @Schema(description = "用户银行账户id", example = "1")
    private Long userBankAccountId;

    private List<NodeDO> nodeDOList;

    @Schema(description = "单据数量")
    private Integer documentCount;

    @Schema(description = "逾期金额")
    private BigDecimal expiredAmount = BigDecimalUtil.ZERO;

    @Schema(description = "业务联系人")
    private String serviceManagerName;

    @Schema(description = "对账状态")
    public ReconciledStatusEnum getReconciledStatus() {
        if (getBillStatus() == BillStatusEnum.TO_RECONCILED) {
            return ReconciledStatusEnum.TO_RECONCILED;
        }

        return ReconciledStatusEnum.RECONCILED;
    }

    @Schema(description = "对账状态描述")
    public String getReconciledStatusDesc() {
        return getReconciledStatus().getDesc();
    }

    /*public BigDecimal getExpiredAmount() {
        if (StringUtil.isNotEmpty(getPeriod())) {
            Integer period = Integer.valueOf(getPeriod());
            if (getCheckBillDate() == null) {
                return null;
            }
            Date endDate = DateUtil.offsetDay(getCheckBillDate(), period);
            if (DateUtil.betweenDay(new Date(), endDate, true) > 0) {
                return getRemainAmount();
            }
        }

        return null;
    }*/

    public Boolean getLower() {
        if (waybillCarList != null && waybillCarList.size() > 0) {
            return waybillCarList.get(0).getLower();
        }
        return false;
    }

    @Schema(description = "付款人支付费用")
    private BigDecimal payerPaidAmount;

    @Schema(description = "收款人支付费用")
    private BigDecimal payeePaidAmount;

    @Schema(description = "货主端支付下游费用")
    private BigDecimal payerPaidLowerMoney;

    @Schema(description = "承运端支付下游费用")
    private BigDecimal payeePaidLowerMoney;

    private List<String> checkMoney;

    @Schema(description = "发票数据统计")
    private List<BillInvoiceShareVO> billInvoiceList;

    @Schema(description = "开票吨数")
    private BigDecimal invoiceTonnes;

    @Schema(description = "上次付款时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDateTime lastPayTime;

    @Schema(description = "上次收款时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDateTime lastReceivableTime;

    @Schema(description = "收款人开户行")
    private String payeeOpeningBankName;

    @Schema(description = "付款人开户行")
    private String payerOpeningBankName;

    @Schema(description = "驳回信息")
    private BillAbortDO abortInfo;

    @Schema(description = "最近一次付款时间")
    private LocalDateTime latestPayTime;

    @Schema(description = "剩余开票金额")
    private BigDecimal surplusInvoiceAmount;

    private List<BillIgnoreDO> ignoreDOList;

}
