package org.example.weiyuntong.customer.vo;

import com.weiyuntong.framework.common.enums.ApprovalEnums;
import com.weiyuntong.module.bizcenter.dal.dataobject.customercontacts.CustomerContactsDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.customerline.CustomerLineDO;
import com.weiyuntong.module.bizcenter.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 客户 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class CustomerBaseVO {

    @Schema(description = "是否启用", example = "0启用 1不启用")
    private Integer enable;

    private String unloadAddressName;

    private String loadAddressName;

    @Schema(description = "ID", example = "26848")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

    @Schema(description = "创建人", required = true)
    private String creatorName;

    @Schema(description = "客户编号")
    private String code;

    @Schema(description = "客户所属行业")
    private String customerIndustry;

    @Schema(description = "客户最小体量")
    private Integer customerMinwgt;

    @Schema(description = "客户最大体量")
    private Integer customerMaxwgt;

    @Schema(description = "钱包份额")
    private Long customerMoney;

    @Schema(description = "客户贡献")
    private Long customerPay;

    @Schema(description = "出发地")
    private String beginArea;

    @Schema(description = "目的地")
    private String endArea;

    @Schema(description = "主要产品")
    private String goods;

    @Schema(description = "产品种类（普货，二类，三类等）", example = "2")
    private String goodsType;

    @Schema(description = "客户浏览次数")
    private String customerPeoNum;

    @Schema(description = "客户风险信息id", example = "29772")
    private String riskId;

    @Schema(description = "客户风险信息数量")
    private Integer riskNum;

    @Schema(description = "价格敏感度")
    private CustomerPercentEnums moneyPercent;

    @Schema(description = "安全敏感度")
    private CustomerPercentEnums securityPercent;

    @Schema(description = "品质敏感度")
    private CustomerPercentEnums qualityPercent;

    @Schema(description = "转交状态（1.正常 2.转交中 3.待审批 4.已审批）", example = "2")
    private String forwardStatus;

    @Schema(description = "更新者姓名", example = "小有可维")
    private String updaterName;

    @Schema(description = "客户名称", example = "李四")
    @NotNull(message = "客户名称不能为空")
    private String name;

    @Schema(description = "客户评级")
    private String level;

    @Schema(description = "客户类型（1.生产商，2.贸易商，3.物流商，4.中介商等）", example = "1")
    private CustomerTypeEnums type;

    @Schema(description = "客户背书（上市公司，500强等）")
    private CustomerBackEnums back;

    @Schema(description = "客户地址")
    private String address;

    @Schema(description = "客户来源（第三方网站，老客户介绍等）")
    private String customerFrom;

    @Schema(description = "客户状态（1.潜在客户，2.机会客户，3.成单客户，4.优质客户）", example = "2")
    private CustomerStatusEnums status;

    @Schema(description = "客户审核状态（1.待审批 2.已审批 3.转交中 4.正常状态）", example = "1")
    private ApprovalEnums checkStatus;

    @Schema(description = "企业类型（国企，民企）", example = "2")
    private String entType;

    @Schema(description = "企业市场地位（市场领导者，跟随者，挑战者）")
    private CustomerPowerEnums entPower;

    @Schema(description = "企业联络人", example = "李四")
    private String entProName;

    @Schema(description = "企业联络人电话")
    private String entPeoPhone;

    @Schema(description = "企业联络人职务")
    private String entPeoLevel;

    @Schema(description = "客户最大贷款额度")
    private BigDecimal maxLoans;

    @Schema(description = "客户剩余贷款额度")
    private BigDecimal residueLoans;

    @Schema(description = "客户已使用的贷款额度")
    private BigDecimal useLoans;

    @Schema(description = "客户贷款开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loansBegtime;

    @Schema(description = "客户贷款结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loansEndtime;

    @Schema(description = "逾期款项")
    private BigDecimal loansMoney;

    @Schema(description = "资金收益比")
    private BigDecimal loansCost;

    @Schema(description = "资金收益")
    private BigDecimal loansIncome;

    @Schema(description = "账期")
    private Integer billScope;

    @Schema(description = "企业id", example = "12760")
    private Long entId;

    @Schema(description = "转交id", example = "1699")
    private Long forwardId;

    @Schema(description = "业务经理ID", example = "32330")
    private Long serviceManagerId;

    @Schema(description = "业务经理名称", example = "赵六")
    private String serviceManagerName;

    @Schema(description = "运维经理ID", example = "25867")
    private Long omManagerId;

    @Schema(description = "运维经理名称", example = "李四")
    private String omManagerName;

    @Schema(description = "群组id", example = "济南群组")
    private Long teamId;

    @Schema(description = "客户联系人列表")
    private List<CustomerContactsDO> customerContactsList;

    @Schema(description = "客户路线列表")
    private List<CustomerLineDO> customerLineList;

    @Schema(description = "客户产品ID列表")
    private List<Long> customerProductIdList;
}
