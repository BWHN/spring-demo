package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
* 指派生成车次的vo
*/
@Data
public class AssignTrainNumberReportPriceVO {

        @Schema(description = "车辆id", example = "25658")
        private Long carId;

        @Schema(description = "重量")
        private BigDecimal weight;

        @Schema(description = "价格", example = "17369")
        private BigDecimal price;

        @Schema(description = "价格单位", example = "17369")
        private PriceUnitEnum priceUnit;
}
