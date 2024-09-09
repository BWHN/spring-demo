package org.example.weiyuntong.bill.vo;

import lombok.Data;

@Data
public class BillAbortUpdateReqVO extends BillCarUpdateVO {

    /**
     * 类型：1 业务 2 财务
     */
    private Integer type;

}
