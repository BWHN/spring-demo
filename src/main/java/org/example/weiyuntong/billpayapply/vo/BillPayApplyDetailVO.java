package org.example.weiyuntong.billpayapply.vo;

import com.weiyuntong.module.bizcenter.controller.admin.billInvoiceaply.vo.BillInvoiceApplyAbortVO;
import com.weiyuntong.module.bizcenter.controller.admin.billpayregister.vo.BillPayRegisterPageRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.billpayregister.vo.BillVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.billpay.PayWayEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillPayApplyDetailVO extends BillPayApplyBaseVO {

    // id
    private Long id;
    // 申请人
    private String creatorName;
    // 申请时间
    private LocalDateTime createTime;
    // 登记人 ??
    private String registerName;
    // 登记时间 ??
    private LocalDateTime registerTime;
    // 账单列表
    private List<BillVO> billList;
    // 退回记录 临时使用
    private List<BillInvoiceApplyAbortVO> abortList;
    // 付款信息
    private List<BillPayRegisterPageRespVO> billPayRegisterList;
    // 已经付款核销的金额
    private BigDecimal payedAmount;


    public String getPayWayDesc(){
        return PayWayEnum.instanceOf(this.getPayWay().toString()).getDesc();
    }


}
