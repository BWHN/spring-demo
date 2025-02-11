package org.example.weiyuntong.tradehallgoodssource.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Optional;

/**
 * 我的委托 / 我的报价 Tab统计 vo
 */

@Data
public class EntrustOrderCountVO {

    // @Schema(description = "全部数量")
    // private Long allNum;

    @Schema(description = "待报价数量")
    private Long toQuotedNum;

    @Schema(description = "待接单数量")
    private Long pendingOrderNum;

    @Schema(description = "待确认数量")
    private Long toConfirmedNum;

    @Schema(description = "待下发数量")
    private Long distributeNum;

    @Schema(description = "已撤销数量")
    private Long revokedNum;

    @Schema(description = "被拒绝数量")
    private Long beRejectedNum;

    @Schema(description = "已完成数量")
    private Long completedNum;


    /**
     * 计算所有数量字段的总和
     * @return 所有数量字段的总和
     */
    public Long getAllNum() {
        long total = 0L;
        total += Optional.ofNullable(toQuotedNum).orElse(0L);
        total += Optional.ofNullable(pendingOrderNum).orElse(0L);
        total += Optional.ofNullable(toConfirmedNum).orElse(0L);
        total += Optional.ofNullable(distributeNum).orElse(0L);
        total += Optional.ofNullable(revokedNum).orElse(0L);
        total += Optional.ofNullable(beRejectedNum).orElse(0L);
        total += Optional.ofNullable(completedNum).orElse(0L);
        return total;
    }

}
