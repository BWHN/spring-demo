package org.example.weiyuntong.monitor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "车辆监控 - 查询请求参数")
@Data
public class MonitorRqeVo {
    @Schema(description = "企业id", example = "鲁E66B53")
    Long entId;

    @Schema(description = "地址类型编码", example = "GPS")
    String typeCode;

    @Schema(description = "客户类型", example = "承运商")
    String custName;

    @Schema(description = "客户类型", example = "承运商")
    String custType;

    @Schema(description = "客户类型", example = "承运商")
    String type;

    @Schema(description = "是否是自有", example = "1")
    String isSelf;

    @Schema(description = "车牌号", example = "1")
    String carNo;

}
