package org.example.weiyuntong.carconfig.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskassign.TransportTaskAssignDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskmatch.TransportTaskMatchDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProfitAmountReqVO {

    @Schema(description = "发货地经纬度", example = "183.128734,32.08723")
    private String startGps;

    @Schema(description = "收货地经纬度", example = "183.128734,32.08723")
    private String endGps;

    @Schema(description = "委托运价", example = "10255")
    private BigDecimal entrustPrice;

    @Schema(description = "匹配信息", example = "10255")
    private List<TransportTaskMatchDO> taskMatchList;

    @Schema(description = "车辆匹配信息", example = "10255")
    private List<TransportTaskAssignDO> taskAssignList;

    @Schema(description = "上游结算周期")
    private Integer upBillingCycle;

    @Schema(description = "结算周期(下游)")
    private String billingCycle;

    @Schema(description = "运单类型")
    private WaybillTypeEnum waybillType;

    @Schema(description = "货物重量")
    private BigDecimal carWeight;

    @Schema(description = "客户ID")
    private Long customerId;

    @Schema(description = "车辆配置信息")
    private CarConfigProfitVO carConfigProfit;

    @Schema(description = "委托运价单位")
    private String priceUnit;

    @Schema(description = "上游是否开票")
    private Boolean upperNeedInvoice ;

    @Schema(description = "下游是否开票")
    private Boolean lowerNeedInvoice ;

    @Schema(description = "结算方式")
    private String settleType ;
}
