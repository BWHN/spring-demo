package org.example.weiyuntong.tradehallcarsource.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallvehicleusage.TradehallVehicleUsageDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 交易大厅-车源管理 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallCarSourceRespVO extends TradehallCarSourceBaseVO {
    @Schema(description = "主键id", example = "20485")
    private Long id;

    @Schema(description = "本人发布是否用车控制", example = "true/false")
    private Boolean isControl=false;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "资质完善度", example = "实体资质对象，包含企业、司机、车辆资质")
    private QualificationCompletenessRespVO qualificationCompletenessRespVO;

    @Schema(description = "综合评价", example = "两颗🌟")
    private String evaluation;

    @Schema(description = "用车记录", example = "暂无记录")
    private List<TradehallVehicleUsageDO> vehicleUsageList;

    @Schema(description = "车辆信息", example = "")
    private CarInfoVO carInfo;

    @Schema(description = "车牌号", example = "京A88888")
    private String carNumber;

}
