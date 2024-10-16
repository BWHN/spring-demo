package org.example.weiyuntong.billpayapply.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 付款申请创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPayApplyCreateReqVO extends BillPayApplyBaseVO {

    // 是否需要提交
    private boolean needSubmit;

    private List<BillPayApplyRelationCreateVO> billPayApplyRelationList;

}
