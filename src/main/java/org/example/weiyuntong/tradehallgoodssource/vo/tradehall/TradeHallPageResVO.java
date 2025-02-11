package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.module.bizcenter.enums.GoodsViewPermissionsEnums;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "平台大厅分页 Response VO")
@Data
@ToString(callSuper = true)
public class TradeHallPageResVO {

    @Schema(description = "ID")
    private Long id;
    @Schema(description = "订单ID")
    private Long orderId;
    @Schema(description = "订单编号")
    private String orderCode;
    @Schema(description = "委托单编号")
    private String entrustCode;
    @Schema(description = "开始日期")
    private LocalDate beginTime;
    @Schema(description = "结束日期")
    private LocalDate endTime;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unLoadAddress;
    @Schema(description = "装货地详情")
    private String loadAddressDetail;
    @Schema(description = "卸货地详情")
    private String unLoadAddressDetail;
    @Schema(description = "装卸距离")
    private BigDecimal transportDistance;
    @Schema(description = "货物名称")
    private String mediumName;
    @Schema(description = "货物类别")
    private String goodsTypeName;
    @Schema(description = "货物级别")
    private String goodsLevel;
    @Schema(description = "总重量")
    private BigDecimal weight;
    @Schema(description = "剩余运量")
    private BigDecimal remainingWeight;
    @Schema(description = "寻车运价")
    private BigDecimal searchCarPrice;
    @Schema(description = "寻车运价单位")
    private PriceUnitEnum searchCarPriceUnit;
    @Schema(description = "结算周期")
    private String billingCycle;
    @Schema(description = "是否开票")
    private Integer lowerNeedInvoice;
    @Schema(description = "剩余有效期")
    private Integer expireTime;
    @Schema(description = "剩余有效期单位")
    private String expireTimeUnit = "分钟";
    @Schema(description = "发单人")
    private String creatorName;
    @Schema(description = "发布日期")
    private LocalDateTime createTime;
    @Schema(description = "是否发单人 0：否 1：是")
    private Integer senderFlag;
    @Schema(description = "是否收藏")
    private Boolean collected;

    // 可见权限
    private GoodsViewPermissionsEnums viewPermissions;

    public void handleTime() {
        int day = expireTime / (60 * 24);
        if (day > 0) {
            expireTime = day;
            expireTimeUnit = "天";
        } else {
            int hour = expireTime / 60;
            if (hour > 0) {
                expireTime = hour;
                expireTimeUnit = "小时";
            }
        }
    }

}
