package org.example.weiyuntong.monitor.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.fleetcenter.enums.CarGpsStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MonitorCarVO {
    //---------------监控表头信息------------------
    @Schema(description = "运力类型")
    private OwnTypeEnum capacityType;
    @Schema(description = "车牌号")
    private String carNumber;
    @Schema(description = "位置来源")
    private String gpsSource;
    @Schema(description = "位置时间")
    private String gpsDate;
    @Schema(description = "速度")
    private String speed;
    @Schema(description = "方位")
    private String direct;
    @Schema(description = "车辆状态")
    private CarGpsStatusEnum carStatus;
    @Schema(description = "停车状态")
    private String stopTime;
    @Schema(description = "车队名称")
    private String fleetName;
    @Schema(description = "所属公司")
    private String enterpriseName;
    @Schema(description = "车辆位置")
    private String locName;
    @Schema(description = "精度")
    private String lng;
    @Schema(description = "维度")
    private String lat;

    //----------------------车辆基础信息----------------------
    @Schema(description = "车辆类型名称")
    private String carTypeName;
    @Schema(description = "品牌型号")
    private String brandName;
    @Schema(description = "使用性质")
    private String natureUse;
    @Schema(description = "燃料类型名称")
    private String fuelTypeName;
    @Schema(description = "最大承重 —— 【保留】")
    private BigDecimal goodsMaxWight;
    @Schema(description = "核定载质量")
    private String carMaxwgt;
    @Schema(description = "排放标准（国三，国四，国五等）")
    private String carEmission;
    @Schema(description = "轴数")
    private Integer axlesNumber;
    @Schema(description = "车型")
    private String carModel;
    @Schema(description = "车辆长度")
    private BigDecimal carLength;
    @Schema(description = "可装介质（普货，二类，三类等）")
    private String carMedium;
    @Schema(description = "挂车牌号")
    private String carGcNo;

    //--------------司机信息---------------
    @Schema(description = "司机姓名")
    private String driverName;
    @Schema(description = "司机电话")
    private String driverPhone;
    @Schema(description = "司机性别")
    private String driverSex;
    @Schema(description = "准驾车型")
    private String cardType;
    @Schema(description = "押运员姓名")
    private String followName;
    @Schema(description = "押运员电话")
    private String followPhone;
    @Schema(description = "押运员性别")
    private String followSex;

    //-------------------货物信息------------------
    @Schema(description = "车次号")
    private String waybillCarNo;
    @Schema(description = "托运人")
    private String customerName;
    @Schema(description = "货物名称", example = "张三")
    private String mediumName;
    @Schema(description = "吨位", example = "33")
    private BigDecimal weight;
    @Schema(description = "装货地址", example = "南京")
    private String loadAddressDetail;
    @Schema(description = "卸货地址", example = "南京")
    private String unLoadAddressDetail;
    @Schema(description = "要求装货日期", example = "2222-1")
    private LocalDateTime loadDate;
    @Schema(description = "要求卸货日期", example = "2222-1")
    private LocalDateTime unloadDate;

    //-------------------设备信息(预留字段)-----------------
    @Schema(description = "终端设备号")
    private String terminal;
    @Schema(description = "终端类型")
    private String dataSource;
    @Schema(description = "终端厂家")
    private String terminalEnterprise;
    @Schema(description = "产品型号")
    private String terminalType;
    @Schema(description = "sim卡号")
    private String simCode;
    @Schema(description = "协议")
    private String protocol;
}
