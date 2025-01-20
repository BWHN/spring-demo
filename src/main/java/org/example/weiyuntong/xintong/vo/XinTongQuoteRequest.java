package org.example.weiyuntong.xintong.vo;

import com.weiyuntong.framework.common.enums.DriverOwnTypeEnums;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.fleetcenter.enums.DriverTypeEnum;
import com.weiyuntong.module.system.enums.CarCategoryEnum;
import com.weiyuntong.module.system.enums.CarColorEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class XinTongQuoteRequest {

    //子任务单编号
    @NotNull(message = "订单编号不能为空")
    @Schema(description = "订单编号", example = "WTD1234")
    private String orderCode;
    @NotNull(message = "客户订单编号不能为空")
    @Schema(description = "客户订单编号")
    private String merchantOrder;
    @NotNull(message = "运量不能为空")
    @Schema(description = "运量")
    private BigDecimal weight;
    @NotNull(message = "期望运价单位不能为空")
    @Schema(description = "期望运价")
    private BigDecimal expectedPrice;
    @NotNull(message = "期望运价单位不能为空")
    @Schema(description = "期望运价单位")
    private PriceUnitEnum expectedPriceUnit;
//    @NotNull(message = "装货时间不能为空")
//    @Schema(description = "装货时间")
//    private String loadDate;
//    @NotNull(message = "卸货时间不能为空")
//    @Schema(description = "卸货时间")
//    private String unloadDate;
    @NotNull(message = "车辆信息不能为空")
    @Schema(description = "车辆信息")
    private List<CarInfo> carInfoList;
    @NotNull(message = "运司机信息不能为空")
    @Schema(description = "司机信息")
    private DriverInfo driverInfo;

    @Data
    public static class DriverInfo {
        @NotNull(message = "运力类型不能为空")
        @Schema(description = "运力类型")
        private DriverOwnTypeEnums ownType;
        @NotNull(message = "姓名不能为空")
        @Schema(description = "姓名")
        private String name;
        @NotNull(message = "电话不能为空")
        @Schema(description = "电话")
        private String phone;
        @Schema(description = "性别", example = "1（男），2（女）")
        private String sex;
        @NotNull(message = "身份类型不能为空")
        @Schema(description = "身份类型")
        private DriverTypeEnum type;
        @Schema(description = "启用状态", example = "0（不启用），1（默认启用）")
        private Integer status;
        @NotNull(message = "身份证号不能为空")
        @Schema(description = "身份证号")
        private String card;
        @Schema(description = "身份证照片正面")
        private String cardMain;
        @Schema(description = "身份证照片背面")
        private String cardRevolt;
        @Schema(description = "身份证开始时间", example = "yyyy-MM-dd")
        private String cardBeginTime;
        @Schema(description = "身份证到期时间", example = "yyyy-MM-dd")
        private String cardExpirationTime;
        @Schema(description = "驾驶证正面")
        private String licensePhoto;
        @Schema(description = "驾驶证副面")
        private String licensePhotofy;
        @Schema(description = "驾照类型", example = "C1、A1等（例如A1A2D）")
        private String cardType;
        @Schema(description = "初次领证时间", example = "yyyy-MM-dd")
        private String licenseBeginTime;
        @Schema(description = "驾照到期时间", example = "yyyy-MM-dd")
        private String licenseExpirationTime;
        @Schema(description = "驾驶员从业资格证")
        private String proImgPath;
        @Schema(description = "驾驶员从业资格证开始时间", example = "yyyy-MM-dd")
        private String proBeginTime;
        @Schema(description = "驾驶员从业资格证到期时间", example = "yyyy-MM-dd")
        private String proExpirationTime;
//        @Schema(description = "押运员从业资格证")
//        private String followProImgPath;
//        @Schema(description = "押运员从业资格证开始时间")
//        private String followProBeginTime;
//        @Schema(description = "押运员从业资格证到期时间")
//        private String followProExpirationTime;
        @NotNull(message = "司机账户信息不能为空")
        @Schema(description = "司机账户信息")
        private List<BankAccountInfo> bankAccountInfo;
    }

    @Data
    public static class BankAccountInfo {
        @NotNull(message = "司机账户信息-收款人姓名不能为空")
        @Schema(description = "收款人姓名")
        private String payeeName;
        @NotNull(message = "司机账户信息-卡号不能为空")
        @Schema(description = "卡号")
        private String accountNumber;
        @NotNull(message = "司机账户信息-预留电话不能为空")
        @Schema(description = "预留电话")
        private String reserveMobile;
        @Schema(description = "开户行")
        private String openingBank;
    }

    @Data
    public static class CarInfo {
        @NotNull(message = "车辆种类不能为空")
        @Schema(description = "车辆种类")
        private CarCategoryEnum carCategory;
        @NotNull(message = "运力类型不能为空")
        @Schema(description = "运力类型")
        private OwnTypeEnum capacityType;
        @NotNull(message = "车牌号不能为空")
        @Schema(description = "车牌号")
        private String carNumber;
        @Schema(description = "车牌颜色")
        private CarColorEnum carNumberColor;
        @Schema(description = "使用性质")
        private String natureUse;
        @Schema(description = "所有人")
        private String ownName;
        @NotNull(message = "核定载质量不能为空")
        @Schema(description = "核定载质量")
        private BigDecimal carMaxwgt;
        @Schema(description = "车头行驶证")
        private String carHeadDriveSrc;
        @Schema(description = "车头行驶证副页")
        private String carHeadfyDriveSrc;
        @Schema(description = "车头行驶证编号")
        private String carHeadDriveCode;
        @Schema(description = "车头行驶证结束时间")
        private String carHeadDriveEndtime;
        @Schema(description = "车头运输证")
        private String carHeadMoveSrc;
        @Schema(description = "车头运输证副页")
        private String carHeadMovefySrc;
        @Schema(description = "车头运输证编号")
        private String carHeadMoveCode;
        @Schema(description = "车头运输证结束时间")
        private String carHeadMoveEndtime;
        @Schema(description = "车辆识别代号")
        private String carBodyNumber;
        @Schema(description = "行驶证发证日期")
        private String carMoveRegisterTime;
    }

}
