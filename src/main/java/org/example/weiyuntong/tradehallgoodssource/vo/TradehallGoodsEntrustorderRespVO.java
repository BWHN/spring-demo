package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.controller.admin.transporttaskentrustorder.vo.TransportTaskEntrustorderBaseVO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallgoodsreportprice.TradehallGoodsReportPriceDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 运输任务委托单(子任务单) Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallGoodsEntrustorderRespVO extends TransportTaskEntrustorderBaseVO {

    @Schema(description = "id", example = "14969")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "货源类别名称")
    private String goodsTypeName;

    @Schema(description = "已确认报价列表")
    List<TradehallGoodsReportPriceDO> dealReportPriceList;

    @Schema(description = "待确认信息列表")
    List<TradehallGoodsReportPriceDO> waitReportPriceList;

}
