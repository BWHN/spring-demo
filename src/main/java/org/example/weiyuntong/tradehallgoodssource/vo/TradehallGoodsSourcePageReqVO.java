package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "货源交易大厅-货源管理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallGoodsSourcePageReqVO extends PageParam {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "企业名称", example = "赵六")
    private String tenantName;

    @Schema(description = "托运人id", example = "16778")
    private Long customerId;

    @Schema(description = "托运人名称", example = "李四")
    private String customerName;

    @Schema(description = "联系人姓名", example = "赵六")
    private String contactName;

    @Schema(description = "联系人电话")
    private String contactMobile;

    @Schema(description = "货源编号", example = "张三")
    private Long mediumId;

    @Schema(description = "货物名称", example = "张三")
    private String mediumName;

    @Schema(description = "货物量：吨/KG/升")
    private BigDecimal goodsWeight;

    @Schema(description = "是否可拼车")
    private Boolean isCarpoolAble;

    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] loadDate;

    @Schema(description = "装货时间：上午、下午、00:00-24:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] loaddateTime;

    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] unloadDate;

    @Schema(description = "卸货时间：上午、下午、00:00-24:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] unloaddateTime;

    @Schema(description = "过期日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] expireDate;

    @Schema(description = "过期时间：上午、下午、00:00-24:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private String[] expireTime;

    @Schema(description = "查看权限:DEFAULT_ALL默认全部可见,VISIBLE_TO_SPECIFIC_CARRIERS部分承运商可见，FOR_INTERNAL_ENTERPRISE公司内部可见")
    private String viewPermissions;

    @Schema(description = "查看的权限的承运商id，逗号分隔")
    private String viewPermissionsCarrier;

    @Schema(description = "装货地址id", example = "23471")
    private Long loadAddressId;

    @Schema(description = "卸货地址id", example = "6302")
    private Long unloadAddressId;

    @Schema(description = "是否开启电子围栏")
    private Boolean isFenceAble;

    @Schema(description = "最后一次承运介质名称", example = "小有可维")
    private String lastMediumName;

    @Schema(description = "车辆载重")
    private BigDecimal carWeight;

    @Schema(description = "允许可装介质，类别之间用逗号分隔")
    private String allowMedium;

    @Schema(description = "排放标准")
    private String emissionStandard;

    @Schema(description = "所需的车辆类型", example = "1")
    private String carType;

    @Schema(description = "是否保温:1.保温")
    private Boolean isWarm;

    @Schema(description = "是否加热:1.加热")
    private Boolean isHeat;

    @Schema(description = "委托运价", example = "10255")
    private BigDecimal entrustPrice;

    @Schema(description = "委托运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum entrustPriceUnit;

    @Schema(description = "预计毛利润")
    private BigDecimal predictGrossProfit;

    @Schema(description = "货物价格", example = "352")
    private BigDecimal goodsPrice;

    @Schema(description = "货物单位：元/吨、元/升、元/KG等")
    private String goodsPriceUnit;

    @Schema(description = "合理损耗")
    private BigDecimal loss;

    @Schema(description = "损耗单位(‰/kG)")
    private String lossUnit;

    @Schema(description = "结算策略:见字典管理settle_strategy")
    private String settleStrategy;

    @Schema(description = "货物运费结算方式（见字典管理:settl_type", example = "1")
    private Integer settleType;

    @Schema(description = "结算周期")
    private String billingCycle;

    @Schema(description = "是否需要单据")
    private Boolean isDocument;

    @Schema(description = "上游是否需要开票")
    private Boolean upperNeedInvoice;

    @Schema(description = "下游是否需要开票")
    private Boolean lowerNeedInvoice;

    @Schema(description = "货物运输方式（ship_type陆运/水陆联运/水运）", example = "1")
    private Integer shipType;

    @Schema(description = "结算信息备注", example = "你猜")
    private String settleRemark;

    @Schema(description = "货物安全")
    private String cargoSecurity;

    @Schema(description = "罐体安全")
    private String tankSecurity;

    @Schema(description = "进出厂安全")
    private String factorySecurity;

    @Schema(description = "货源状态", example = "1")
    private String goodsStatus;

    @Schema(description = "业务来源:1:PC 2:APP_IOS 3.APP_ANDROID 4:WECHAT 5:MINI_APP")
    private String source;

    @Schema(description = "状态:1启用 0停用", example = "2")
    private Byte status;

    @Schema(description = "排序")
    private Short rowSort;

    @Schema(description = "备注", example = "随便")
    private String remark;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "版本号")
    private Integer version;

    @Schema(description = "合同上传后的路径")
    private String contractPath;

    @Schema(description = "货物量：吨/KG/升")
    private BigDecimal remainingWeight;

    @Schema(description = "包装规格")
    private String packingSpecs;

    @Schema(description = "包装数量")
    private String packingAmount;

    @Schema(description = "寻车运价", example = "4969")
    private BigDecimal searchCarPrice;

    @Schema(description = "寻车运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum searchCarPriceUnit;

    @Schema(description = "装货地址名称", example = "圣泉化工")
    private String loadAddressName;

    @Schema(description = "卸货地址名称", example = "金华xx化工")
    private String unloadAddressName;

    @Schema(description = "装货地经度")
    private Long sendLng;

    @Schema(description = "装货地纬度")
    private Long sendLat;

    @Schema(description = "装货地省编号")
    private String sendProvinceCode;

    @Schema(description = "装货地省名称", example = "山东省")
    private String sendProvinceName;

    @Schema(description = "装货地城市编号")
    private String sendCityCode;

    @Schema(description = "装货地城市名称", example = "济南市")
    private String sendCityName;

    @Schema(description = "装货地区域编号")
    private String sendDistrictCode;

    @Schema(description = "装货地区域名称", example = "章丘区")
    private String sendDistrictName;

    @Schema(description = "卸货地经度")
    private Long receiveLng;

    @Schema(description = "卸货地纬度")
    private Long receiveLat;

    @Schema(description = "卸货地省编号")
    private String receiveProvinceCode;

    @Schema(description = "卸货地省名称", example = "浙江省")
    private String receiveProvinceName;

    @Schema(description = "卸货地城市编号")
    private String receiveCityCode;

    @Schema(description = "卸货地城市名称", example = "金华市")
    private String receiveCityName;

    @Schema(description = "卸货地区域编号")
    private String receiveDistrictCode;

    @Schema(description = "卸货地区域名称", example = "xx区")
    private String receiveDistrictName;
}
