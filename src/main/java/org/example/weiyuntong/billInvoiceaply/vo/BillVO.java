package org.example.weiyuntong.billInvoiceaply.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BillVO {
    //账单id
    private Long id;
    //账单编号
    private String billNo;
    //账单名称
    private String billName;
    //账单金额
    private BigDecimal receivablesAmount;
    //待开票金额
    private BigDecimal toInvoiceAmount;
    //本次开票金额
    private BigDecimal allotmentMoney;
    //已收金额
    private BigDecimal paidAmount;
    //收款状态
    private BillStatusEnum paidStatus;
    // 是否忽略
    private Integer ignored;
    //创建人
    private String creatorName;
    //创建时间
    private LocalDateTime createTime;
    // 运单信息
    private List<BillWaybillSourceAllotmentMoneyVO> waybillSourceInfoList;

}
