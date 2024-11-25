package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallprocess.TradehallProcessDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Schema(description = "管理后台 - 订单 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportOrderWeightVO extends TransportOrderBaseVO {

    @Schema(description = "成交重量")
    private BigDecimal dealWeight = BigDecimal.ZERO;

    @Schema(description = "总重量")
    private BigDecimal totalWeight = BigDecimal.ZERO;

    @Schema(description = "放弃量")
    private BigDecimal giveUpWeight = BigDecimal.ZERO;

    @Schema(description = "撤销重量")
    private BigDecimal revokeWeight = BigDecimal.ZERO;

    @Schema(description = "委托单类型")
    private WaybillTypeEnum type;

    @Schema(description = "报价信息合计")
    private  Map<String, List<TradehallProcessDO>> processList;
}
