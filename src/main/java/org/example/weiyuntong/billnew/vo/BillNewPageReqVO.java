package org.example.weiyuntong.billnew.vo;

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
public class BillNewPageReqVO extends RoleDataDTO {

    @Schema(description = "企业id")
    private Long entId;
    private Long userId;
    private List<Long> roleIds;
    private Long ownRoleLabelId;

    @Schema(description = "账单类型", example = "应付对账单：PAYABLE，应收对账单：RECEIVABLES")
    private BillTypeEnum billType;

    @Schema(description = "承运人")
    private String carrier;
    @Schema(description = "托运人")
    private String consignor;
    @Schema(description = "创建人")
    private String creatorName;
    @Schema(description = "审核人姓名")
    private String reviewerName;
    @Schema(description = "账单名称")
    private String billName;

    @Schema(description = "账单状态")
    private BillStatusEnum billStatus;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "账单收付款状态")
    private BillStatusEnum paidStatus;
    @Schema(description = "账单收付款状态")
    private List<BillStatusEnum> paidStatusList;
    @Schema(description = "账单开票状态")
    private BillInvoiceStatusEnum invoiceStatus;
    @Schema(description = "账单开票状态")
    private List<BillInvoiceStatusEnum> invoiceStatusList;

    @Schema(description = "创建时间开始")
    private String createTimeStart;
    @Schema(description = "创建时间结束")
    private String createTimeEnd;

    @Schema(description = "审核时间开始")
    private String reviewerTimeStart;
    @Schema(description = "审核时间结束")
    private String reviewerTimeEnd;

    @Schema(description = "前端自定义排序规则")
    private String customOrder;

    public String getCustomOrder(){
        if (StringUtils.isNotBlank(customOrder)){
            if ("billStatus desc".contains(this.customOrder)){
                return customOrder.replace("billStatus", "bill_status");
            }else if ("waybillCount desc".contains(this.customOrder)){
                return customOrder;
            }else if ("payableAmount desc".contains(this.customOrder)){
                return customOrder.replace("payableAmount", "payable_amount");
            }else if ("receivablesAmount desc".contains(this.customOrder)){
                return customOrder.replace("receivablesAmount", "receivables_amount");
            }else if ("invoiceStatus desc".contains(this.customOrder)){
                return customOrder.replace("invoiceStatus", "invoice_status");
            }else if ("registerInvoiceAmount desc".contains(this.customOrder)) {
                return customOrder;
            }else if ("toInvoiceAmount desc".contains(this.customOrder)) {
                return customOrder;
            }else if ("paidStatus desc".contains(this.customOrder)) {
                return customOrder;
            }else if ("paidAmount desc".contains(this.customOrder)) {
                return customOrder;
            }else if ("toPaidAmount desc".contains(this.customOrder)) {
                return customOrder;
            }else if ("ignorePaidAmount desc".contains(this.customOrder)) {
                return customOrder;
            }else if ("createTime desc".contains(this.customOrder)){
                return customOrder.replace("createTime", "create_time");
            }else {
                return null;
            }
        }
        return null;
    }
}
