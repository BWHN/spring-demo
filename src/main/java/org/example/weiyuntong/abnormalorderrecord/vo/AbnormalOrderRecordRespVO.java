package org.example.weiyuntong.abnormalorderrecord.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "运营中心-异常管理-委托失效记录 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AbnormalOrderRecordRespVO extends AbnormalOrderRecordBaseVO {

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "货源委托信息")
    private TransportTaskEntrustorderDO transportTaskEntrustOrderDO;

    @Schema(description = "跟进次数")
    private Long followCount;
}
