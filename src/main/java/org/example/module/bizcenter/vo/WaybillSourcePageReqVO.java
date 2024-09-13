package org.example.module.bizcenter.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 运单货源信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WaybillSourcePageReqVO extends PageParam {

    @Schema(description = "预计装货时间", example = "1")
    private String loadBeginDate;
    private String loadEndDate;

    @Schema(description = "预计卸货时间", example = "1")
    private String unloadBeginDate;
    private String unloadEndDate;

    @Schema(description = "托运人名称")
    private String customerName;
    @Schema(description = "车牌号")
    private String carNumber;

    private Long entId;

    @Schema(description = "运单状态")
    private List<String> waybillStatus;

    @Schema(description = "来自 up 上游 down 下游")
    private String from;
}
