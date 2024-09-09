package org.example.weiyuntong.bill.vo;

import lombok.Data;

@Data
public class BillBackReviewReqVO {

    /**
     * 账单ID
     */
    private Long id;

    /**
     * 驳回原因
     */
    private String reason;

    /**
     * 驳回节点
     */
    private String node;

}
