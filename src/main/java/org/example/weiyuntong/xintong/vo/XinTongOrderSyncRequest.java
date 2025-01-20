package org.example.weiyuntong.xintong.vo;

import lombok.Data;

import java.util.List;

@Data
public class XinTongOrderSyncRequest {

    // 商户编号
    private String merchantCode;
    // 商户ID
    private String merchantId;
    // 商户端订单号
    private String merchantOrder;
    // 装卸货地址列表
    private List<Address> addressList;
    // 货物信息
    private CargoInfo cargoInfo;
    // 运输单价单位
    private String transportUnitPriceUnit;
    // 运输单价（单位：元，保留两位小数）
    private String transportUnitPrice;
    // 货物总量（单位：吨，保留三位小数）
    private String totalCargoVolume;
    // 装车费（单位：元，保留两位小数）
    private String loadingFee;
    // 卸车费（单位：元，保留两位小数）
    private String unloadingFee;
    // 空驶费（单位：元，保留两位小数）
    private String emptyVehicleFee;
    // 扣款类别集合
    private List<Deduction> deductionTable;
    // 结算方式 1：到付；2：预付款-按比例；3：预付款-固定金额
    private String settlementMethod;
    // 结算方式对应的值
    // 结算周期(1：到付(单位：天，允许最大值：365)); 预付比例(2：预付款-按比例(单位：%，最大值：50.00));
    // 预付固定金额(3：预付款-固定金额(单位: 元，允许最大值：100000.00)
    private String settlementMethodValue;
    // 结算类型 1：按原发；2：按实收；3：按原发实收最小值；4：按原发实收最大值；默认1：按原发
    private String settlementType;
    // 抹零类型 1：不抹零；2：小数抹零；3：个位抹零；4：十位抹零；默认1：不抹零
    private String roundingType;
    // 亏吨扣款 1：不扣款；2：亏吨即扣款；3：超出指定重量扣款；4：超出原发比例扣款；默认1：不扣款
    private String weightDeduction;
    // 途耗标准 亏吨扣款若为“3：超出指定重量扣款”必填；单位：千克，最大值：100000.00；亏吨扣款若为“4：超出原发比例扣款”：必填;单位：% 允许最大值：50.00；
    private String routeConsumptionStandard;
    // 装货必传信息  1：装货磅单；2：车货合照；多选中间用逗号隔开
    private List<String> mandatoryInformationForLoading;
    // 卸货必传信息 （1：卸货磅单；2：车货合照；3： 卸货重量；多选中间用逗号隔开。
    // (若结算类型为按实收、按原发时候最小值、按原发实收最大值。亏吨扣款为：亏吨即扣款、超出指定重量扣款；3：卸货重量-必选['3'])
    private List<String> mandatoryInformationForUnloading;
    // 订单有效时间段
    private String orderTime;
    // 日均车数
    private String averageDailyVehicles;
    // 订单外抢单 0：是；1：否
    private String externalOrderGrab;
    // 自动签收 0：否；1：是
    private String automaticReceipt;
    // 货物图片
    private List<String> cargoImage;
    // 备注
    private String remark;

    @Data
    public static class Address {
        // 地址类型: 1-装货地，2-卸货地
        private String addressType;
        // 省-名称
        private String addressProvinceName;
        // 市-名称
        private String addressCityName;
        // 区-名称
        private String addressDistrictName;
        // 省-编码
        private String addressProvinceCode;
        // 区-编码
        private String addressCityCode;
        // 市-编码
        private String addressDistrictCode;
        // 详细地址
        private String detailedAddress;
        // 简称
        private String addressAbbreviation;
        // 经度
        private String lng;
        // 纬度
        private String lat;
        // 装/卸货时间段
        private List<String> timePeriod;
        //联系人姓名
        private String userName;
        //联系人手机号
        private String userPhone;
    }

    @Data
    public static class CargoInfo {
        // 货物名称
        private String cargoName;
        // 货物类型
        private String cargoType;
        // 计量单位
        private String cargoUnit;
        // 货物价值
        private String cargoValue;
        // 是否展示货物价值
        private String cargoValueConceal;
    }

    @Data
    public static class Deduction {
        // 扣款类别名称
        private String deductionName;
        // 扣款金额
        private String deductionMoney;
    }

}
