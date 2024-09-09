package org.example.weiyuntong.bill.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class BillApplyPayReq {
    @Schema(description = " 账单ID列表",example = "100")
    private Collection<Long> idList;

    @Schema(description = "申请金额",example = "300.00")
    private BigDecimal applyAmont;

    @Schema(description = "用户账户id",example = "1314")
    private Long useBankAccountId;
}
