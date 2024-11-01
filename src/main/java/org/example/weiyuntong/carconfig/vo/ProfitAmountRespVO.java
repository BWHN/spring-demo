package org.example.weiyuntong.carconfig.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskmatch.TransportTaskMatchDO;
import com.weiyuntong.module.fleetcenter.dal.dataobject.carconfig.CarConfigDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ProfitAmountRespVO {

    @Schema(description = "匹配信息")
    private List<TransportTaskMatchDO> transportTaskMatchList;

    @Schema(description = "车辆信息")
    private CarConfigProfitVO carConfigProfit ;

    @Schema(description = "配置信息")
    private CarConfigDO settingInfo ;
}
