package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsStatusEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* 交易大厅-货源管理 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TradehallGoodsSourceBaseVO {
        @Schema(description = "企业租户id")
        private Long tenantId;

        @Schema(description = "编码",example = "HY2023052600001")
        private String code;

        @Schema(description = "委托单类型")
        private WaybillTypeEnum type;

        @Schema(description = "客户id", required = true, example = "1636289613490417665")
        @NotNull(message = "托运人id不能为空")
        private Long customerId;

        @Schema(description = "客户名称", example = "山东化链云科技有限公司")
        private String customerName;

        @Schema(description = "货主ID")
        private Long consignorId;

        @Schema(description = "托运人/货主")
        private String consignor;

        @Schema(description = "联系人姓名", example = "张先生")
        private String contactName;

        @Schema(description = "联系人电话",example = "18654607777")
        private String contactMobile;

        @Schema(description = "货源编号", example = "17552")
        private Long mediumId;

        @Schema(description = "货源名称", example = "92车用汽油")
        private String mediumName;

        @Schema(description = "货源类别名称", example = "一类")
        private String goodsTypeName;

        @Schema(description = "货物量：吨/KG/升", example = "229.00")
        private BigDecimal goodsWeight;

        @Schema(description = "是否可拼车", example = "true")
        private Boolean isCarpoolAble=false;

        @Schema(description = "是否包车:1.包车0，不包车")
        private Boolean isCharter=false;

        @Schema(description = "装货日期", example = "2023-05-26")
        private LocalDate loadDate;

        @Schema(description = "装货时间：上午、下午、00:00-24:00", example = "09:00")
        private String loaddateTime;

        @Schema(description = "收货日期", example = "2023-05-29")
        private LocalDate unloadDate;

        @Schema(description = "卸货时间：上午、下午、00:00-24:00", example = "17:00")
        private String unloaddateTime;

        @Schema(description = "过期日期", example = "2023-05-30")
        private LocalDate expireDate;

        @Schema(description = "过期时间：上午、下午、00:00-24:00", example = "00:00")
        private String expireTime;

        @Schema(description = "查看权限:DEFAULT_ALL默认全部可见,VISIBLE_TO_SPECIFIC_CARRIERS部分承运商可见，FOR_INTERNAL_ENTERPRISE公司内部可见",example = "DEFAULT_ALL")
        private String viewPermissions;

        @Schema(description = "查看的权限的承运商id，逗号分隔")
        private String viewPermissionsCarrier;

        @Schema(description = "装货地址id", example = "1")
        private Long loadAddressId;

        @Schema(description = "卸货地址id", example = "2")
        private Long unloadAddressId;

        @Schema(description = "是否开启电子围栏",example = "false")
        private Boolean isFenceAble=false;

        @Schema(description = "最后一次承运介质名称", example = "甲醇")
        private String lastMediumName;

        @Schema(description = "车辆载重",example = "31.50")
        private BigDecimal carWeight;

        @Schema(description = "允许可装介质，类别之间用逗号分隔",example = "一类,三类")
        private String allowMedium;

        @Schema(description = "允许可装介质名称，类别之间用逗号分隔")
        private String allowMediumName;

        @Schema(description = "排放标准",example = "国五")
        private String emissionStandard;

        @Schema(description = "所需的车辆类型", example = "1")
        private String carType;

        @Schema(description = "所需的车辆类型", example = "1")
        private String carTypeName;

        @Schema(description = "是否保温:1.保温",example = "true")
        private Boolean isWarm;

        @Schema(description = "是否加热:1.加热",example = "true")
        private Boolean isHeat;

        @Schema(description = "委托运价", example = "299.00")
        private BigDecimal entrustPrice;

        @Schema(description = "委托运价单位：元/吨、元/升、元/KG等",example = "元/吨")
        private PriceUnitEnum entrustPriceUnit;

        @Schema(description = "寻车运价", example = "230.00")
        private BigDecimal searchCarPrice;

        @Schema(description = "寻车运价单位：元/吨、元/升、元/KG等",example = "元/吨")
        private PriceUnitEnum searchCarPriceUnit;

        @Schema(description = "预计毛利润",example = "12302.00")
        private BigDecimal predictGrossProfit;

        @Schema(description = "预计毛利润")
        private BigDecimal grossProfit;

        @Schema(description = "发起方预计毛利润")
        private BigDecimal startGrossProfit;

        @Schema(description = "货物价格", example = "3520.00")
        private BigDecimal goodsPrice;

        @Schema(description = "货物单位：元/吨、元/升、元/KG等",example = "元/吨")
        private String goodsPriceUnit;

        @Schema(description = "合理损耗",example = "1")
        private BigDecimal loss;

        @Schema(description = "损耗单位(‰/kG)",example = "1")
        private PriceUnitEnum lossUnit;

        @Schema(description = "结算策略:见字典管理settle_strategy")
        private SettleStrategyEnum settleStrategy;

        @Schema(description = "货物运费结算方式（见字典管理:settl_type", example = "1")
        private Integer settleType;

        @Schema(description = "结算周期",example = "10")
        private String billingCycle;

        @Schema(description = "上游结算周期")
        private String upBillingCycle;

        @Schema(description = "是否需要单据",example = "false")
        private Boolean isDocument;

        @Schema(description = "上游是否需要开票",example = "false")
        private Boolean upperNeedInvoice;

        @Schema(description = "下游是否需要开票",example = "false")
        private Boolean lowerNeedInvoice;

        @Schema(description = "货物运输方式（ship_type陆运/水陆联运/水运）", example = "1")
        private Integer shipType;

        @Schema(description = "结算信息备注",  example = "票据齐全")
        private String settleRemark;

        @Schema(description = "货物安全",example = "安全")
        private String cargoSecurity;

        @Schema(description = "罐体安全",example = "安全")
        private String tankSecurity;

        @Schema(description = "进出厂安全",example = "安全")
        private String factorySecurity;

        @Schema(description = "货源状态", example = "TO_TRADING")
        private GoodsStatusEnum goodsStatus;

        @Schema(description = "业务来源:1:PC 2:APP_IOS 3.APP_ANDROID 4:WECHAT 5:MINI_APP",example = "PC")
        private String source;

        @Schema(description = "备注",example = "货源优质，欢迎报价")
        private String remarks;

        @Schema(description = "状态:1启用 0停用", example = "1")
        private Integer status;

        @Schema(description = "排序")
        private int rowSort;

        @Schema(description = "备注",example ="货源优质，欢迎报价")
        private String remark;

        @Schema(description = "版本号")
        private Integer version;

        @Schema(description = "合同上传后的路径")
        private String contractPath;

        @Schema(description = "货物量：吨/KG/升",example = "120")
        private BigDecimal remainingWeight;

        @Schema(description = "包装规格")
        private String packingSpecs;

        @Schema(description = "包装数量")
        private String packingAmount;

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

        @Schema(description = "创建者")
        private String creator;

        @Schema(description = "创建者姓名")
        private String creatorName;

        @Schema(description = "更新者")
        private String updater;

        @Schema(description = "更新者姓名")
        private String updaterName;

        @Schema(description = "状态更新时间")
        private LocalDateTime trackTime=LocalDateTime.now();

        @Schema(description = "客服联系人")
        private String customerServiceName="维运通";

        @Schema(description = "客服联系电话")
        private String customerServicePhone="18654607777";

        @Schema(description = "本人发布是否用车控制", example = "true/false")
        private Boolean isControl=false;
        @Schema(description = "过期日期")
        private String expireDateTips;

        @Schema(description = "装货地址详情")
        private String loadAddressDetail;

        @Schema(description = "卸货地址详情")
        private String unLoadAddressDetail;

        @Schema(description = "货物级别id", example = "1")
        private String goodsLevelId;

        @Schema(description = "货物级别名称", example = "张三")
        private String goodsLevel;

        @Schema(description = "浏览次数")
        private Integer viewNum = 0;

        @Schema(description = "收藏次数")
        private Integer favoritesNum = 0;
}
