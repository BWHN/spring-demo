package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weiyuntong.module.system.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BillSourceExcelVO {

    private Long id;

    @Schema(description = "运单编号")
    private String waybillCarNo;
    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "货物名称")
    private String mediumName;

    @Schema(description = "日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime settleTime;

    @Schema(description = "装货量")
    private BigDecimal loadedWeight;

    @Schema(description = "卸货量")
    private BigDecimal unloadedWeight;

    @Schema(description = "结算运量")
    private BigDecimal settleWeight;

    @Schema(description = "补偿（货主端支付费用）")
    private BigDecimal payerPaidAmount;

    @Schema(description = "扣款（承运商端支付费用）")
    private BigDecimal payeePaidAmount;

    @Schema(description = "单价 （适配老代码的字段）")
    private BigDecimal entrustPrice;
    @Schema(description = "单价 单位")
    private PriceUnitEnum entrustPriceUnit;
    @Schema(description = "运费（适配老代码的字段）")
    private BigDecimal dealPrice;
    @Schema(description = "货物损耗")
    private BigDecimal lossAmount = BigDecimalUtil.ZERO;
    @Schema(description = "装货地址名称")
    private String loadAddressName;
    @Schema(description = "卸货地址名称")
    private String unloadAddressName;


    public BigDecimal getExcessWeight() {
        return BigDecimalUtil.subtract(loadedWeight, unloadedWeight);
    }
}
