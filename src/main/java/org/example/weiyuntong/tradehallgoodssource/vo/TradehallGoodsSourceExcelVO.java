package org.example.weiyuntong.tradehallgoodssource.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 交易大厅-货源管理 Excel VO
 *
 * @author 维运通
 */
@Data
public class TradehallGoodsSourceExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("租户名称")
    private String tenantName;

    @ExcelProperty("托运人id")
    private Long customerId;

    @ExcelProperty("托运人名称")
    private String customerName;

    @ExcelProperty("联系人姓名")
    private String contactName;

    @ExcelProperty("联系人电话")
    private String contactMobile;

    @ExcelProperty("货物名称")
    private String goodsName;

    @ExcelProperty("货物量：吨/KG/升")
    private BigDecimal goodsWeight;

    @ExcelProperty("是否可拼车")
    private Boolean isCarpoolAble;

    @ExcelProperty("装货日期")
    private LocalDate loadDate;

    @ExcelProperty("装货时间：上午、下午、00:00-24:00")
    private String loaddateTime;

    @ExcelProperty("收货日期")
    private LocalDate unloadDate;

    @ExcelProperty("卸货时间：上午、下午、00:00-24:00")
    private String unloaddateTime;

    @ExcelProperty("过期日期")
    private LocalDate expireDate;

    @ExcelProperty("过期时间：上午、下午、00:00-24:00")
    private String expireTime;

    @ExcelProperty("查看权限:DEFAULT_ALL默认全部可见,VISIBLE_TO_SPECIFIC_CARRIERS部分承运商可见，FOR_INTERNAL_ENTERPRISE公司内部可见")
    private String viewPermissions;

    @ExcelProperty("查看的权限的承运商id，逗号分隔")
    private String viewPermissionsCarrier;

    @ExcelProperty("装货地址id")
    private Long loadAddressId;

    @ExcelProperty("卸货地址id")
    private Long unloadAddressId;

    @ExcelProperty("是否开启电子围栏")
    private Boolean isFenceAble;

    @ExcelProperty("最后一次承运介质名称")
    private String lastMediumName;

    @ExcelProperty("车辆载重")
    private BigDecimal carWeight;

    @ExcelProperty("允许可装介质，类别之间用逗号分隔")
    private String allowMedium;

    @ExcelProperty("排放标准")
    private String emissionStandard;

    @ExcelProperty("所需的车辆类型")
    private String carType;

    @ExcelProperty("是否保温:1.保温")
    private Boolean isWarm;

    @ExcelProperty("是否加热:1.加热")
    private Boolean isHeat;

    @ExcelProperty("委托运价")
    private BigDecimal entrustPrice;

    @ExcelProperty("委托运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum entrustPriceUnit;

    @ExcelProperty("预计毛利润")
    private BigDecimal predictGrossProfit;

    @ExcelProperty("货物价格")
    private BigDecimal goodsPrice;

    @ExcelProperty("货物单位：元/吨、元/升、元/KG等")
    private String goodsPriceUnit;

    @ExcelProperty("合理损耗")
    private BigDecimal loss;

    @ExcelProperty("损耗单位(‰/kG)")
    private String lossUnit;

    @ExcelProperty("结算策略:见字典管理settle_strategy")
    private String settleStrategy;

    @ExcelProperty("货物运费结算方式（见字典管理:settl_type")
    private Integer settleType;

    @ExcelProperty("结算周期")
    private String billingCycle;

    @ExcelProperty("是否需要单据")
    private Boolean isDocument;

    @ExcelProperty("上游是否需要开票")
    private Boolean upperNeedInvoice;

    @ExcelProperty("下游是否需要开票")
    private Boolean lowerNeedInvoice;

    @ExcelProperty("货物运输方式（ship_type陆运/水陆联运/水运）")
    private Integer shipType;

    @ExcelProperty("结算信息备注")
    private String settleRemark;

    @ExcelProperty("货物安全")
    private String cargoSecurity;

    @ExcelProperty("罐体安全")
    private String tankSecurity;

    @ExcelProperty("进出厂安全")
    private String factorySecurity;

    @ExcelProperty("货源状态")
    private String goodsStatus;

    @ExcelProperty("业务来源:1:PC 2:APP_IOS 3.APP_ANDROID 4:WECHAT 5:MINI_APP")
    private String source;

    @ExcelProperty("状态:1启用 0停用")
    private int status;

    @ExcelProperty("排序")
    private Short rowSort;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("版本号")
    private Integer version;

    @ExcelProperty("合同上传后的路径")
    private String contractPath;

    @ExcelProperty("货物量：吨/KG/升")
    private BigDecimal remainingWeight;

    @ExcelProperty("包装规格")
    private String packingSpecs;

    @ExcelProperty("包装数量")
    private String packingAmount;


    @ExcelProperty("寻车运价")
    private BigDecimal searchCarPrice;

    @ExcelProperty("寻车运价单位：元/吨、元/升、元/KG等")
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
