package org.example.module.bizcenter.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class WaybillSourceCount {

    @Schema(description = "全部")
    private long allCount;
    @Schema(description = "待下发")
    private long toIssued;
    @Schema(description = "待发车")
    private long toDeparted;
    @Schema(description = "待装货")
    private long toLoaded;
    @Schema(description = "待卸货")
    private long toUnLoaded;
    @Schema(description = "待送达")
    private long toSendCount;
    @Schema(description = "待核对")
    private long toChecked;
    @Schema(description = "待发起对账")
    private long toCreateBill;
    @Schema(description = "待提交")
    private long toSubmit;
    @Schema(description = "待审核")
    private long toCheckedBill;
    @Schema(description = "待对账")
    private long toBillCount;
    @Schema(description = "待支付")
    private long toPay;
    @Schema(description = "待开票")
    private long toInvoiced;
    @Schema(description = "待结算")
    private long toPayCount;
    @Schema(description = "完结")
    private long finished;
    @Schema(description = "异常运单")
    private long errorCount;
    @Schema(description = "作废")
    private long invalid;
    @Schema(description = "取消")
    private long cancel;
}
