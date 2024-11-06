package org.example.weiyuntong.etccost.vo;

import com.weiyuntong.module.fleetcenter.dal.dataobject.etc.EtcCostDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Schema(description = "管理后台 - 路桥费用详情 Request VO")
@Data
@ToString(callSuper = true)
public class EtcCostDetailVO extends EtcCostRespVO {

    private List<EtcCostDO> costList = Collections.emptyList();

}
