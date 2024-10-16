package org.example.weiyuntong.billpayapply.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.billpay.PayWayEnum;
import com.weiyuntong.module.bizcenter.enums.BillApplyStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class BillPayPageResVO {

    // id
    private Long id;
    // 申请编号
    private String code;
    // 开票申请状态
    private BillApplyStatusEnum status;
    // 收款方名称
    private String customer;
    private String customerId;
    // 收款方账户编号
    private String payeeAccountNumber;
    // 收款方账户名称
    private String payeeAccountName;
    // 期望付款时间
    private String expectPayTime;
    // 付款金额（元）
    private BigDecimal payAmount;
    // 付款方式
    private Byte payWay;
    // 付款账户编号
    private String payerAccountNumber;
    // 付款账户名称
    private String payerAccountName;
    // 账单编号 逗号拼接
    private String billNo;
    // 付款单编号 逗号拼接
    private String registerCode;
    // 申请人
    private String creatorName;
    // 申请时间
    private LocalDateTime createTime;

    public String getPayWayDesc(){
        return PayWayEnum.instanceOf(String.valueOf(payWay)).getDesc();
    }

}
