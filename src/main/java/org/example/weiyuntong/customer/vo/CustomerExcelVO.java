package org.example.weiyuntong.customer.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.weiyuntong.framework.common.enums.ApprovalEnums;
import com.weiyuntong.module.bizcenter.enums.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 客户 Excel VO
 *
 * @author 维运通
 */
@Data
public class CustomerExcelVO {

    @ExcelProperty("客户编号")
    private String code;

    @ExcelProperty("客户所属行业")
    private String customerIndustry;

    @ExcelProperty("客户最小体量")
    private Integer customerMinwgt;

    @ExcelProperty("客户最大体量")
    private Integer customerMaxwgt;

    @ExcelProperty("钱包份额")
    private Long customerMoney;

    @ExcelProperty("客户贡献")
    private Long customerPay;

    @ExcelProperty("出发地")
    private String beginArea;

    @ExcelProperty("目的地")
    private String endArea;

    @ExcelProperty("主要产品")
    private String goods;

    @ExcelProperty("产品种类（普货，二类，三类等）")
    private String goodsType;

    @ExcelProperty("客户浏览次数")
    private String customerPeoNum;

    @ExcelProperty("客户风险信息id")
    private String riskId;

    @ExcelProperty("客户风险信息数量")
    private Integer riskNum;

    @ExcelProperty("价格敏感度")
    private String moneyPercent;

    @ExcelProperty("安全敏感度")
    private String securityPercent;

    @ExcelProperty("品质敏感度")
    private String qualityPercent;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("转交状态（1.正常 2.转交中 3.待审批 4.已审批）")
    private String forwardStatus;

    @ExcelProperty("创建者姓名")
    private String creatorName;

    @ExcelProperty("更新者姓名")
    private String updaterName;

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("客户名称")
    private String name;

    @ExcelProperty("客户评级")
    private String level;

    @ExcelProperty("客户类型（1.生产商，2.贸易商，3.物流商，4.中介商等）")
    private String type;

    @ExcelProperty("客户背书（上市公司，500强等）")
    private CustomerBackEnums back;

    @ExcelProperty("客户地址")
    private String address;

    @ExcelProperty("客户来源（第三方网站，老客户介绍等）")
    private String customerFrom;

    @ExcelProperty("客户状态（1.潜在客户，2.机会客户，3.成单客户，4.优质客户）")
    private CustomerStatusEnums status;

    @ExcelProperty("客户审核状态（1.待审批 2.已审批 3.转交中 4.正常状态）")
    private ApprovalEnums checkStatus;

    @ExcelProperty("企业类型（国企，民企）")
    private CustomerTypeEnums entType;

    @ExcelProperty("企业市场地位（市场领导者，跟随者，挑战者）")
    private CustomerPowerEnums entPower;

    @ExcelProperty("企业联络人")
    private String entProName;

    @ExcelProperty("企业联络人电话")
    private String entPeoPhone;

    @ExcelProperty("企业联络人职务")
    private String entPeoLevel;

    @ExcelProperty("客户最大贷款额度")
    private BigDecimal maxLoans;

    @ExcelProperty("客户已使用的贷款额度")
    private BigDecimal useLoans;

    @ExcelProperty("客户贷款开始时间")
    private LocalDateTime loansBegtime;

    @ExcelProperty("客户贷款结束时间")
    private LocalDateTime loansEndtime;

    @ExcelProperty("逾期款项")
    private BigDecimal loansMoney;

    @ExcelProperty("资金占用成本")
    private BigDecimal loansCost;

    @ExcelProperty("资金收益")
    private BigDecimal loansIncome;

    @ExcelProperty("账期")
    private Integer billScope;

    @ExcelProperty("企业id")
    private Long entId;

    @ExcelProperty("转交id")
    private Long forwardId;

    @ExcelProperty("业务经理ID")
    private Long serviceMangerId;

    @ExcelProperty("业务经理名称")
    private String serviceMangerName;

    @ExcelProperty("运维经理ID")
    private Long omMangerId;

    @ExcelProperty("运维经理名称")
    private String omMangerName;

    @ExcelProperty("群组id")
    private Long teamId;


}
