package org.example.weiyuntong.waybillcarcost.vo;

import lombok.*;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 车次成本 Excel 导出 Request VO，参数和 WaybillCarCostPageReqVO 是一致的")
@Data
public class WaybillCarCostExportReqVO {

    @Schema(description = "车次ID", example = "28590")
    private Long waybillCarId;

    @Schema(description = "重车高速里程")
    private BigDecimal freewayMileage;

    @Schema(description = "重车底道里程")
    private BigDecimal roadMileage;

    @Schema(description = "高速费用")
    private BigDecimal freewayCost;

    @Schema(description = "运营天数")
    private BigDecimal runDay;

    @Schema(description = "高速油费")
    private BigDecimal freewayOilCost;

    @Schema(description = "底道油费")
    private BigDecimal roadOilCost;

    @Schema(description = "空车高速里程")
    private BigDecimal emptyFreewayMileage;

    @Schema(description = "空车底道里程")
    private BigDecimal emptyRoadMileage;

    @Schema(description = "空车高速费用")
    private BigDecimal emptyFreewayCost;

    @Schema(description = "业务费用")
    private BigDecimal operatingCost;

    @Schema(description = "空车高速油费")
    private BigDecimal emptyFreewayOilCost;

    @Schema(description = "空车底道油费")
    private BigDecimal emptyRoadOilCost;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
