package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "订单更新的vo")
@Data
@ToString(callSuper = true)
public class TransportOrderUpdateReqVO {

    @Schema(description = "子任务id")
    private Long id;

    @Schema(description = "计划id", example = "5787")
    private Long planId;

    @Schema(description = "计划code")
    private String planCode;

    @Schema(description = "企业id", example = "13373")
    private Long entId;

    @Schema(description = "托运公司ID", example = "19780")
    private Long consignorId;

    @Schema(description = "托运公司名称")
    private String consignor;

    @Schema(description = "托运客户id", example = "17863")
    private Long customerId;

    @Schema(description = "托运客户名称", example = "张三")
    private String customerName;

    @Schema(description = "合同id", example = "26821")
    private Long contractId;

    @Schema(description = "合同编码")
    private String contractCode;

    @Schema(description = "货源编号", example = "9735")
    private Long mediumId;

    @Schema(description = "货源名称", example = "赵六")
    private String mediumName;

    @Schema(description = "货物级别id（逗号隔开）", example = "22816")
    private String goodsLevelId;

    @Schema(description = "货物级别名称")
    private String goodsLevel;

    @Schema(description = "货物重量")
    private BigDecimal weight;

    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginDate;

    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endDate;

    @Schema(description = "装货地址id", example = "62")
    private Long loadAddressId;

    @Schema(description = "卸货地址id", example = "1131")
    private Long unloadAddressId;

    @Schema(description = "装货地址详情")
    private String loadAddressDetail;

    @Schema(description = "卸货地址详情")
    private String unLoadAddressDetail;

    @Schema(description = "装货地址名称", example = "王五")
    private String loadAddressName;

    @Schema(description = "装货地经度")
    private String sendLng;

    @Schema(description = "装货地纬度")
    private String sendLat;

    @Schema(description = "装货地省编号")
    private String sendProvinceCode;

    @Schema(description = "装货地省名称", example = "李四")
    private String sendProvinceName;

    @Schema(description = "装货地城市编号")
    private String sendCityCode;

    @Schema(description = "装货地城市名称", example = "李四")
    private String sendCityName;

    @Schema(description = "装货地区域编号")
    private String sendDistrictCode;

    @Schema(description = "装货地区域名称", example = "张三")
    private String sendDistrictName;

    @Schema(description = "卸货地址名称", example = "赵六")
    private String unloadAddressName;

    @Schema(description = "卸货地经度")
    private String receiveLng;

    @Schema(description = "卸货地纬度")
    private String receiveLat;

    @Schema(description = "卸货地省编号")
    private String receiveProvinceCode;

    @Schema(description = "卸货地省名称", example = "赵六")
    private String receiveProvinceName;

    @Schema(description = "卸货地城市编号")
    private String receiveCityCode;

    @Schema(description = "卸货地城市名称", example = "小有可维")
    private String receiveCityName;

    @Schema(description = "卸货地区域编号")
    private String receiveDistrictCode;

    @Schema(description = "卸货地区域名称", example = "王五")
    private String receiveDistrictName;

    @Schema(description = "货物运费结算方式（settl_type运输单价*卸货量/运输单价*装货量/总报价）", example = "2")
    private Integer settleType;

    @Schema(description = "是否允许报不同价格1.是，0不是", example = "17627")
    private Boolean isQuotePrice;

    @Schema(description = "下游结算周期")
    private String billingCycle;

    @Schema(description = "车辆类型")
    private String mergedField;

    @Schema(description = "查看权限:DEFAULT_ALL默认全部可见,VISIBLE_TO_SPECIFIC_CARRIERS部分承运商可见，FOR_INTERNAL_ENTERPRISE公司内部可见")
    private String viewPermissions;

    @Schema(description = "查看的权限的承运商id，逗号分隔")
    private String viewPermissionsCarrier;

    @Schema(description = "可见范围名称")
    private String viewPermissionsName;

    /**
     * 车辆类型id
     */
    private String mergedId;

    @Schema(description = "货源类别名称")
    private String goodsTypeName;

    @Schema(description = "货物类别")
    private String goodsType;

    @Schema(description = "结算策略")
    private String settleStrategy;

    @Schema(description = "是否开票（2024/8/7 修改为发布订单时填写的是否开票）")
    private Boolean lowerNeedInvoice;

    @Schema(description = "是否需要单据")
    private Boolean isDocument;

    @Schema(description = "结算信息备注", example = "你说的对")
    private String settleRemark;

    @Schema(description = "预计毛利润")
    private BigDecimal grossProfit;

    @Schema(description = "运价", example = "12163")
    private BigDecimal price;

    @Schema(description = "委托运价", example = "6576")
    private BigDecimal entrustPrice;

    private PriceUnitEnum entrustPriceUnit;

    @Schema(description = "运价单位：元/吨、元/升、元/KG等")
    private String priceUnit;

    @Schema(description = "损耗")
    private BigDecimal loss;

    @Schema(description = "损耗单位(‰/kG)")
    private String lossUnit;

    @Schema(description = "货物货值单价（元/吨）", example = "5099")
    private BigDecimal goodUnitPrice;

    @Schema(description = "是否保温:1.保温")
    private Boolean isWarm;

    @Schema(description = "是否加热:1.加热")
    private Boolean isHeat;

    @Schema(description = "最后一次承运介质名称", example = "李四")
    private String lastMediumName;

    @Schema(description = "货物安全")
    private String cargoSecurity;

    @Schema(description = "罐体安全")
    private String tankSecurity;

    @Schema(description = "进出厂安全")
    private String factorySecurity;

    @Schema(description = "车辆载重")
    private BigDecimal carWeight;

    @Schema(description = "允许可装介质，类别之间用逗号分隔")
    private String allowMedium;

    @Schema(description = "允许可装介质名称，类别之间用逗号分隔")
    private String allowMediumName;

    @Schema(description = "排放标准")
    private String emissionStandard;

    @Schema(description = "排放标准code")
    private String carEmissionCode;

    @Schema(description = "所需的车辆类型", example = "1")
    private String taskCarType;

    @Schema(description = "路书线路名称", example = "王五")
    private String planningLineName;

    @Schema(description = "路书线路Id", example = "17763")
    private Long planningLineId;

    @Schema(description = "货源联系人选择  0自己 1客户 3其他")
    private Integer contactChoice;

    @Schema(description = "货源联系人")
    private String supplyContacts;

    @Schema(description = "货源联系人电话")
    private String supplyContactsPhone;

    @Schema(description = "是否忽略:0.是 1.否")
    private Boolean isIgnore;

    @Schema(description = "预计收款日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime receivableTime;

    @Schema(description = "企业信息指派",example = "1")
    private List<TaskOrderCapacityVO> taskEntrustOrderDOList;

    @Schema(description = "是否保存客户信息")
    private Boolean isSaveCustomer;

    public String getSettleStrategyName(){
        return SettleStrategyEnum.instanceOf(this.settleStrategy).getDesc();
    }

}
