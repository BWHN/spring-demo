package org.example.weiyuntong.tradehallgoodssource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
* 指派生成车次的vo
*/
@Data
public class AssignTrainNumberVO {

        @Schema(description = "承运商ID", example = "509")
        private Long carrierId;
        @Schema(description = "承运商", example = "509")
        private String carrierName;
        @Schema(description = "车次报价的信息对象")
        List<AssignTrainNumberReportPriceVO> reportPriceList;
}
