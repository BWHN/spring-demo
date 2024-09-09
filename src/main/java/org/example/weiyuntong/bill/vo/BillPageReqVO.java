package org.example.weiyuntong.bill.vo;

import com.weiyuntong.framework.common.util.StringUtil;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.system.service.permission.dto.RoleDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;


@Schema(description = "管理后台 - 对账单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPageReqVO extends RoleDataDTO {

    @Schema(description = "承运商名称", example = "王五")
    private String carrier;

    @Schema(description = "托运人名称", example = "王五")
    private String consignor;

    @Schema(description = "账单审核财务编码")
    private String moneyCode;

    @Schema(description = "搜索条件name", example = "王五")
    private String name;

    @Schema(description = "账单类型", example = "PAYABLE:应付账款, RECEIVABLES:应收账款")
    private String billType;

    @Schema(description = "账单状态", example = "TO_RECONCILED:待对账, TO_INVOICED:待开票")
    private BillStatusEnum billStatus;

    @Schema(description = "是否付款")
    private String isPay;

    @Schema(description = "账单状态列表", example = "TO_RECONCILED:待对账, TO_INVOICED:待开票")
    private List<String> billStatusList;

    @Schema(description = "账单状态列表不含列表", example = "TO_RECONCILED:待对账, TO_INVOICED:待开票")
    private List<String> noBillStatusList;

    @Schema(description = "搜索账单开始创建日期 yyyy-MM-dd")
    private String createTimeStart;

    @Schema(description = "搜索账单结束创建日期 yyyy-MM-dd")
    private String createTimeEnd;

    @Schema(description = "上次付款时间")
    private String lastPayTimeStart;
    @Schema(description = "上次付款时间")
    private String lastPayTimeEnd;

    @Schema(description = "上次收款时间")
    private String lastReceivableTimeStart;
    @Schema(description = "上次收款时间")
    private String lastReceivableTimeEnd;

    @Schema(description = "租户ID")
    private Long tenantId;

    @Schema(description = "开票需求")
    private Boolean applyInvoice;

    @Schema(description = "发票邮寄状态 TO_POSTED: 待邮寄  POSTED: 已邮寄")
    private String invoicePostStatus;

    @Schema(description = "单据邮寄状态 TO_POSTED: 待邮寄  POSTED: 已邮寄")
    private String docketStatus;

    @Schema(description = "创建人")
    private String creatorName;

    @Schema(description = "是否需要单据")
    private Boolean isDocument;

    @Schema(description = "付款审核状态")
    private List<String> approveStatusList;

    @Schema(description = "账期审核状态")
    private String periodApproveStatus;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "登录人id")
    private Long userId;

    @Schema(description = "车次编号")
    private String waybillCarNo;

    @Schema(description = "车牌号")
    private String carNumber;

    public String getCreateTimeStart() {
        if (StringUtil.isEmpty(createTimeStart)) {
            return null;
        }
        return createTimeStart + " 00:00:00";
    }

    public String getCreateTimeEnd() {
        if (StringUtil.isEmpty(createTimeEnd)) {
            return null;
        }
        return createTimeEnd + " 23:59:59";
    }

    @Schema(description = "搜索关键字")
    private String keyword;

    @Schema(description = "收款人开户行")
    private List<String> payeeOpeningBankName;

    @Schema(description = "付款人开户行")
    private List<String> payerOpeningBankName;
}
