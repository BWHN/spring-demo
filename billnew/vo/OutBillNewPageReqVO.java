package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import com.weiyuntong.framework.common.enums.OutApplyInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillTypeEnum;
import com.weiyuntong.module.system.service.permission.dto.RoleDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.util.List;


@Schema(description = "管理后台 - 新对账单分页查询 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OutBillNewPageReqVO extends RoleDataDTO {

    @Schema(description = "企业id")
    private Long entId;

    @Schema(description = "账单维度开票申请状态")
    private OutApplyInvoiceStatusEnum applyStatus;

    @Schema(description = "外部货运平台账单")
    private Boolean outBill;

    @Schema(description = "账单类型", example = "应付对账单：PAYABLE，应收对账单：RECEIVABLES")
    private BillTypeEnum billType;

    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "账单名称")
    private String billName;
    @Schema(description = "账单状态")
    private BillStatusEnum billStatus;
    private List<BillStatusEnum> billStatusList;

    @Schema(description = "收付款状态")
    private List<BillStatusEnum> paidStatusList;
    @Schema(description = "开票状态")
    private List<BillInvoiceStatusEnum> invoiceStatusList;

    @Schema(description = "承运人ID")
    private Long carrierId;
    @Schema(description = "承运人")
    private String carrier;

    @Schema(description = "创建人")
    private String creatorName;

    @Schema(description = "创建时间开始")
    private String createTimeStart;
    @Schema(description = "创建时间结束")
    private String createTimeEnd;

    @Schema(description = "前端自定义排序规则")
    private String customOrder;

    public String getCustomOrder() {
        if (StringUtils.isNotBlank(customOrder)) {
            if ("createTime desc".contains(this.customOrder)) {
                return customOrder.replace("createTime", "create_time");
            } else {
                return null;
            }
        }
        return null;
    }
}
