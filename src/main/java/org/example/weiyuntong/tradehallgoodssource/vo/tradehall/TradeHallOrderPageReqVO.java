package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.enums.GoodsReportPriceStatusEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "接单管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradeHallOrderPageReqVO extends PageParam {

    @Schema(description = "托运人")
    private String consignor;
    @Schema(description = "货物名称")
    private String mediumName;
    @Schema(description = "开始日期-开始")
    private String beginTimeStart;
    @Schema(description = "开始日期-结束")
    private String beginTimeEnd;
    @Schema(description = "结束日期-开始")
    private String endTimeStart;
    @Schema(description = "结束日期-结束")
    private String endTimeEnd;
    // 待接单：TO_TRADING
    @Schema(description = "货源状态")
    private GoodsStatusEnum goodsStatus;
    // 待确认：TO_CONFIRMED
    // 已结束：TO_DEAL_COMPLETED
    // 被拒绝：TO_SEND_REFUSED
    // 被撤销：TO_SEND_REVOKED
    @Schema(description = "订单状态")
    private List<GoodsReportPriceStatusEnum> status;
    // 已放弃
    @Schema(description = "已放弃 1 是")
    private Integer giveUp;

    private Long tenantId;
    private Long userId;
    private List<Long> roleIds;
    private Long ownRoleLabelId;

    @Schema(description = "前端自定义排序规则")
    private String customOrder;

    @Schema(description = "编码")
    private String code;
    @Schema(description = "关键字")
    private String keyword;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unLoadAddress;

}
