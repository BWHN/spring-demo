package org.example.weiyuntong.tradehallgoodssource.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;

@Schema(description = "管理后台 - 交易大厅-货源管理创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallGoodsSourceCreateReqVO extends TradehallGoodsSourceBaseVO {
    //关于满足挂靠车辆组建虚拟承运商需求
   private List<AssignTrainNumberVO> assignTrainNumberList;

    @Schema(description = "货物级别id", example = "1")
    private String goodsLevelId;

    @Schema(description = "货物级别名称", example = "张三")
    private String goodsLevel;
}
