package org.example.weiyuntong.billpayapply.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillPayApplyRelationCreateVO {

    /**
     * 账单id
     */
    private Long billId;

    /**
     * 此申请中账单的分配金额
     */
    private BigDecimal allotmentMoney;

    /**
     * 忽略剩余
     */
    private boolean ignored;

    /**
     * 运单信息
     */
    private List<WaybillSourceInfo> waybillSourceInfoList;

    @Data
    public static class WaybillSourceInfo {
        /**
         * 运单id
         */
        private Long waybillSourceId;
        /**
         * 此申请中账单的分配金额
         */
        private BigDecimal allotmentMoney;
    }

}
