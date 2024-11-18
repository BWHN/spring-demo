package org.example.weiyuntong.waybillcarcost.vo;

import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 车次成本 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WaybillCarCostRespVO extends WaybillCarCostBaseVO {


    @Schema(description = "ID")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "总成本")
    public BigDecimal getTotalCost() {
        return BigDecimalUtil.add(getFreewayCost(), getFreewayOilCost(), getRoadOilCost(), getEmptyFreewayCost(), getOperatingCost(), getEmptyFreewayOilCost(), getEmptyRoadOilCost());
    }

}
