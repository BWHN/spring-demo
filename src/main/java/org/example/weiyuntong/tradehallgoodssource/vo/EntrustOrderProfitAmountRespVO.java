package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.controller.admin.carconfig.vo.CarConfigProfitVO;
import com.weiyuntong.module.fleetcenter.dal.dataobject.carconfig.CarConfigDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EntrustOrderProfitAmountRespVO {

    @Schema(description = "车辆信息")
    private CarConfigProfitVO carConfigProfit ;

    @Schema(description = "配置信息")
    private CarConfigDO settingInfo ;

    @Schema(description = "接单方/报价方预测毛利润")
    private BigDecimal grossProfit;

    @Schema(description = "发起方预计毛利润")
    private BigDecimal startGrossProfit;
}
