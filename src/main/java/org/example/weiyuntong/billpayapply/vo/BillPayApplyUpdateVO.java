package org.example.weiyuntong.billpayapply.vo;

import lombok.Data;

import java.util.List;

@Data
public class BillPayApplyUpdateVO extends BillPayApplyBaseVO {

    private Long id;

    private List<BillPayApplyRelationCreateVO> billPayApplyRelationList;

    // 是否需要提交
    private boolean needSubmit;
}
