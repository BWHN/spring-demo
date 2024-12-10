package org.example.weiyuntong.waybillCarbenefitreport.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillStatusEnum;
import com.weiyuntong.module.system.service.permission.dto.RoleDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
public class WaybillOtherCarBenefitPageReqVO extends RoleDataDTO {

    @Schema(description = "运单编码")
    private String waybillSourceNo;
    @Schema(description = "车辆编码")
    private String waybillCarNo;
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "车次状态")
    private List<WaybillStatusEnum> waybillCarStatus;
    @Schema(description = "卸货时间开始")
    private String unloadedTimeStart;
    @Schema(description = "卸货时间结束")
    private String unloadedTimeEnd;
    @Schema(description = "账单编码")
    private String billNo;
    @Schema(description = "应收账单创建时间开始")
    private String receiveBillCreateTimeStart;
    @Schema(description = "应收账单创建时间结束")
    private String receiveBillCreateTimeEnd;
    @Schema(description = "应收账单状态")
    private List<BillStatusEnum> receiveBillStatus;
    @Schema(description = "应付账单创建时间开始")
    private String payBillCreateTimeStart;
    @Schema(description = "应付账单创建时间结束")
    private String payBillCreateTimeEnd;
    @Schema(description = "应付账单状态")
    private List<BillStatusEnum> payBillStatus;
    @Schema(description = "业务利润率开始")
    private BigDecimal profitRateStart;
    @Schema(description = "业务利润率结束")
    private BigDecimal profitRateEnd;
    @Schema(description = "托运人")
    private String consignor;
    @Schema(description = "货源业务员")
    private String goodsServiceName;
    @Schema(description = "发单人")
    private String waybillSender;
    @Schema(description = "承运人")
    private String carrier;
    @Schema(description = "车源业务员")
    private String carServiceName;
    @Schema(description = "报价人/接单人")
    private String waybillReceiver;
    @Schema(description = "导出表头")
    private List<String> header;

    private Long tenantId;
    private int notPage;

    public BigDecimal getProfitRateStart() {
        if (profitRateStart != null) {
            return profitRateStart.divide(new BigDecimal(100), 4, RoundingMode.HALF_UP);
        }
        return null;
    }

    public BigDecimal getProfitRateEnd() {
        if (profitRateEnd != null) {
            return profitRateEnd.divide(new BigDecimal(100), 4, RoundingMode.HALF_UP);
        }
        return null;
    }

}
