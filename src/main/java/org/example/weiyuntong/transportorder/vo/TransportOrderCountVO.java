package org.example.weiyuntong.transportorder.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "管理后台 - 订单 Response VO")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class TransportOrderCountVO {

    @Schema(description = "待接单")
    private long toReceive;
    @Schema(description = "待确认")
    private long toSure;
    @Schema(description = "已结束")
    private long over;
    @Schema(description = "异常")
    private long exception;
    @Schema(description = "被拒绝")
    private long refused;
    @Schema(description = "已放弃")
    private long receiverRefused;
    @Schema(description = "被撤销")
    private long revoked;
    @Schema(description = "全部")
    private long allCount;

    public TransportOrderCountVO(long toReceive, long toSure, long over, long exception) {
        this.toReceive = toReceive;
        this.toSure = toSure;
        this.over = over;
        this.exception = exception;
    }
}
