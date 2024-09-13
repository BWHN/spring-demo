package org.example.module.bizcenter.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.PayableStatusEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SourceEnums;
import com.weiyuntong.module.bizcenter.util.BigDecimalUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 运单货源信息 Response VO")
@Data
@ToString(callSuper = true)
public class WaybillSourcePageRespVO {

    //基础信息
    @Schema(description = "ID", required = true, example = "13608")
    private Long id;
    @Schema(description = "运单编号")
    private String waybillNo;
    @Schema(description = "运单状态", example = "2")
    private SourceEnums waybillStatus;
    @Schema(description = "上游名称", example = "张三")
    private String customerName;
    @Schema(description = "托运公司名称")
    private String consignor;
    @Schema(description = "货源名称", example = "李四")
    private String mediumName;
    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime createTime;

    //车辆信息
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "司机姓名", example = "张三")
    private String driverName;
    @Schema(description = "司机联系电话")
    private String driverMobile;
    @Schema(description = "押运员姓名", example = "李四")
    private String followName;
    @Schema(description = "押运员联系电话")
    private String followMobile;
    //时间
    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadDate;
    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadDate;
    @Schema(description = "装货地址")
    private String loadAddressDetail;
    @Schema(description = "卸货地址")
    private String unLoadAddressDetail;
    @Schema(description = "装货地省名称", example = "小有可维")
    private String sendProvinceName;
    @Schema(description = "装货地城市名称", example = "赵六")
    private String sendCityName;
    @Schema(description = "卸货地省名称", example = "李四")
    private String receiveProvinceName;
    @Schema(description = "卸货地城市名称", example = "李四")
    private String receiveCityName;
    //价格
    @Schema(description = "运价单位")
    private PriceUnitEnum dealPriceUnit;
    @Schema(description = "运价")
    private BigDecimal dealPrice;
    @Schema(description = "运费")
    private BigDecimal amount;
    @Schema(description = "支付运费")
    private BigDecimal payAmount;
    @Schema(description = "补款/扣款")
    private BigDecimal exceptionAmount;
    @Schema(description = "成本")
    private BigDecimal ownAmount;
    @Schema(description = "货物重量")
    private BigDecimal weight;
    @Schema(description = "上游支付费用（异常）")
    private BigDecimal topPayAmount;
    @Schema(description = "下游支付费用（异常）")
    private BigDecimal lowerPayAmount;

    //车次账单信息
    @Schema(description = "车次编号")
    private String waybillCarNo;
    @Schema(description = "账单编号")
    private String billNo;
    @Schema(description = "付款状态")
    private PayableStatusEnum payStatus;
    @Schema(description = "开票状态")
    private BillInvoiceStatusEnum invoiceStatus;

    //负责人
    @Schema(description = "负责人")
    private String userName;
    // 车辆所属
    private OwnTypeEnum ownType;

    public BigDecimal getExceptionAmount() {
        return BigDecimalUtil.subtract(topPayAmount, lowerPayAmount);
    }

    public String getCarType() {
        if (ownType != null) {
            if (OwnTypeEnum.OWN.equals(ownType) || OwnTypeEnum.LEASE.equals(ownType)) {
                return "自营";
            } else if (OwnTypeEnum.OTHER.equals(ownType)) {
                return "常规";
            } else if (OwnTypeEnum.SINGLE.equals(ownType)) {
                return "散车";
            }
        }
        return "常规";
    }
}
