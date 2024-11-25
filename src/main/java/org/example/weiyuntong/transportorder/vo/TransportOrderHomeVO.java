package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsStatusEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsViewPermissionsEnums;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 订单 Response VO")
@Data
public class TransportOrderHomeVO {

    private Long id;

    @Schema(description = "货源名称", example = "赵六")
    private String mediumName;

    @Schema(description = "委托运价")
    private BigDecimal entrustPrice;

    @Schema(description = "委托运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum entrustPriceUnit;

    @Schema(description = "货物重量")
    private BigDecimal weight;

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

    @Schema(description = "装货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginDate;

    @Schema(description = "收货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endDate;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "创建人")
    private String creatorName;

    @Schema(description = "托运公司名称")
    private String consignor;

    @Schema(description = "订单编号", example = "123")
    private String code;

    @Schema(description = "托运客户名称", example = "张三")
    private String customerName;

    @Schema(description = "待确认")
    private Long toSure;

    @Schema(description = "已确认")
    private Long sure;

    @Schema(description = "被拒绝")
    private Long refused;

    @Schema(description = "已撤销")
    private Long revoked;

    @Schema(description = "成交重量")
    private BigDecimal dealWeight=BigDecimal.ZERO;

    @Schema(description = "总重量")
    private BigDecimal totalWeight=BigDecimal.ZERO;

    @Schema(description = "撤销重量")
    private BigDecimal revokeWeight=BigDecimal.ZERO;

    @Schema(description = "忽略量")
    private BigDecimal ignoreAmount=BigDecimal.ZERO;

    @Schema(description = "放弃量")
    private BigDecimal receiverRefusedWeight=BigDecimal.ZERO;

    @Schema(description = "指派信息id")
    private Long taskId;

    @Schema(description = "委托单类型")
    private WaybillTypeEnum type;

    @Schema(description = "承运商ID")
    private String carrierId;
    @Schema(description = "承运商名称")
    private String carrierName;

    @Schema(description = "查看权限:DEFAULT_ALL默认全部可见,VISIBLE_TO_SPECIFIC_CARRIERS部分承运商可见，FOR_INTERNAL_ENTERPRISE公司内部可见")
    private GoodsViewPermissionsEnums viewPermissions;

    @Schema(description = "查看的权限的承运商id，逗号分隔")
    private String viewPermissionsCarrier;

    private String viewPermissionsName;

    @Schema(description = "权限标签名称（寻车范围是ROLE_LABEL时使用）")
    private String roleLabelName;

    @Schema(description = "货源状态")
    private GoodsStatusEnum goodsStatus;

    @Schema(description = "待接单/已结束")
    private String isOver;

}
