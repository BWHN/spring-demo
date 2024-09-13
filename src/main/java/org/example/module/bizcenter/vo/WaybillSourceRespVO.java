package org.example.module.bizcenter.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.OwnTypeEnum;
import com.weiyuntong.module.bizcenter.enums.SourceEnums;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 运单货源信息 Response VO")
@Data
@ToString(callSuper = true)
public class WaybillSourceRespVO extends SourceSettlementBaseDO{
    //人员信息
    @Schema(description = "ID", required = true, example = "13608")
    private Long id;
    @Schema(description = "运单编号")
    private String waybillNo;
    @Schema(description = "运单状态", example = "2")
    private SourceEnums waybillStatus;
    @Schema(description = "发单人", example = "李四")
    private String createOrderName;
    @Schema(description = "接单人")
    private String receiveOrderName;
    @Schema(description = "负责人")
    private String userName;
    //货源信息
    @Schema(description = "上游名称", example = "张三")
    private String customerName;
    @Schema(description = "货源联系人")
    private String supplyContacts;
    @Schema(description = "货源联系人电话")
    private String supplyContactsPhone;
    @Schema(description = "订单编号")
    private String orderCode;
    @Schema(description = "合同编码")
    private String contractCode;
    @Schema(description = "货源名称", example = "李四")
    private String mediumName;
    @Schema(description = "货物重量")
    private BigDecimal weight;
    @Schema(description = "货物级别名称")
    private String goodsLevel;
    @Schema(description = "货物安全")
    private String cargoSecurity;
    @Schema(description = "罐体安全")
    private String tankSecurity;
    @Schema(description = "进出厂安全")
    private String factorySecurity;
    //运力信息
    @Schema(description = "运力id")
    private Long otherId;
    @Schema(description = "其他运力编号")
    private String otherWaybillNo;
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
    @Schema(description = "承运商名称")
    private String carrierName;
    @Schema(description = "车源联系人")
    private String inviteUserName;
    @Schema(description = "车源联系人电话")
    private String inviteUserPhone;
    //时间
    @Schema(description = "要求装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime loadDate;
    @Schema(description = "要求收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime unloadDate;
    @Schema(description = "装货地址")
    private String loadAddressDetail;
    @Schema(description = "装货名称")
    private String loadAddressName;
    @Schema(description = "装货联系人")
    private String loadUserName;
    @Schema(description = "装货联系人电话")
    private String loadUserPhone;
    @Schema(description = "卸货地址")
    private String unLoadAddressDetail;
    @Schema(description = "卸货名称")
    private String unloadAddressName;
    @Schema(description = "卸货联系人")
    private String unLoadUserName;
    @Schema(description = "卸货联系人电话")
    private String unLoadUserPhone;
    //运输信息
    @Schema(description = "车次id")
    private Long waybillCarId;
    @Schema(description = "车次编号")
    private String waybillCarNo;
    @Schema(description = "运输距离")
    private BigDecimal transportDistance;
    @Schema(description = "车次信息")
    private WaybillCarSourceVO waybillCarDO;
    //运单事件信息
    @Schema(description = "运单事件信息")
    private List<WaybillSourceEventRespVO> sourceEventDOList;
    //效益测算
    @Schema(description = "效益测算")
    private WaybillCarBenefitSourceVO waybillCarBenefitSourceVO;
    @Schema(description = "应收账单")
    private BillSourceVO receivableBillSourceDO;
    @Schema(description = "应付账单")
    private BillSourceVO payableBillSourceDO;

    // 车辆所属
    private OwnTypeEnum ownType;

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
