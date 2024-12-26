package org.example.weiyuntong.refuserecord.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallcarsource.TradehallCarSourceDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallprocess.TradehallProcessDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 撤销信息记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RefuseRecordRespVO extends RefuseRecordBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "撤销方名称")
    private String enterpriseName;

    @Schema(description = "关联单号")
    private String associatedCode;

    @Schema(description = "报价拒绝信息")
    TradehallProcessDO reportPriceInfo;

    @Schema(description = "委托单拒绝信息")
    TransportTaskEntrustorderDO entrustOrderDO;

    @Schema(description = "车源拒绝信息")
    TradehallCarSourceDO tradehallCarSourceDO;

    @Schema(description = "用车拒绝信息")
    TradehallProcessDO vehicleUsage;
}
