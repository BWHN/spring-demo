package org.example.module.bizcenter.vo;

import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import com.weiyuntong.module.bizcenter.enums.SettleStrategyEnum;
import com.weiyuntong.module.bizcenter.enums.SourceEnums;
import com.weiyuntong.module.system.enums.EnterpriseTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 运单货源信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class WaybillSourceBaseVO {

    @Schema(description = "ID", required = true, example = "13608")
    private Long id;

    @Schema(description = "子任务单id", example = "21781")
    private Long entrustId;

    @Schema(description = "指派信息id", example = "32084")
    private Long processId;

    @Schema(description = "运单编号")
    private String waybillNo;

    @Schema(description = "运单状态", example = "2")
    private SourceEnums waybillStatus;

    @Schema(description = "上游ID", example = "20301")
    private Long customerId;

    @Schema(description = "上游名称", example = "张三")
    private String customerName;

    @Schema(description = "上游客户类型", example = "2")
    private EnterpriseTypeEnum customerType;

    @Schema(description = "托运公司ID", example = "29957")
    private Long consignorId;

    @Schema(description = "托运公司名称")
    private String consignor;

    @Schema(description = "托运公司类型", example = "1")
    private EnterpriseTypeEnum consignorType;

    @Schema(description = "货物重量")
    private BigDecimal weight;

    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "车辆id", example = "15924")
    private Long carId;

    @Schema(description = "司机id", example = "7498")
    private Long driverId;

    @Schema(description = "司机姓名", example = "张三")
    private String driverName;

    @Schema(description = "司机联系电话")
    private String driverMobile;

    @Schema(description = "押运员姓名", example = "李四")
    private String followName;

    @Schema(description = "押运员联系电话")
    private String followMobile;

    @Schema(description = "押运员id", example = "25667")
    private Long followId;

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

    @Schema(description = "装货地址id", example = "23388")
    private Long loadAddressId;

    @Schema(description = "装货地址名称", example = "李四")
    private String loadAddressName;

    @Schema(description = "装货地经度")
    private String sendLng;

    @Schema(description = "装货地纬度")
    private String sendLat;

    @Schema(description = "装货地省编号")
    private String sendProvinceCode;

    @Schema(description = "装货地省名称", example = "小有可维")
    private String sendProvinceName;

    @Schema(description = "装货地城市编号")
    private String sendCityCode;

    @Schema(description = "装货地城市名称", example = "赵六")
    private String sendCityName;

    @Schema(description = "装货地区域编号")
    private String sendDistrictCode;

    @Schema(description = "装货地区域名称", example = "小有可维")
    private String sendDistrictName;

    @Schema(description = "卸货地址id", example = "18743")
    private Long unloadAddressId;

    @Schema(description = "卸货地址名称", example = "张三")
    private String unloadAddressName;

    @Schema(description = "卸货地经度")
    private String receiveLng;

    @Schema(description = "卸货地纬度")
    private String receiveLat;

    @Schema(description = "卸货地省编号")
    private String receiveProvinceCode;

    @Schema(description = "卸货地省名称", example = "李四")
    private String receiveProvinceName;

    @Schema(description = "卸货地城市编号")
    private String receiveCityCode;

    @Schema(description = "卸货地城市名称", example = "李四")
    private String receiveCityName;

    @Schema(description = "卸货地区域编号")
    private String receiveDistrictCode;

    @Schema(description = "卸货地区域名称", example = "张三")
    private String receiveDistrictName;

    @Schema(description = "是否需要开票")
    private Boolean needInvoice;

    @Schema(description = "是否需要单据")
    private Boolean needDocument;

    @Schema(description = "实际成交价格", example = "20085")
    private BigDecimal dealPrice;

    @Schema(description = "运价单位")
    private PriceUnitEnum dealPriceUnit;

    @Schema(description = "运费")
    private BigDecimal amount;

    @Schema(description = "支付运费")
    private BigDecimal payAmount;

    @Schema(description = "货源编号", example = "7272")
    private Long mediumId;

    @Schema(description = "货源名称", example = "李四")
    private String mediumName;

    @Schema(description = "预计结算日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime processPayTime;

    @Schema(description = "结算策略")
    private SettleStrategyEnum settleStrategy;

    @Schema(description = "损耗")
    private BigDecimal loss;

    @Schema(description = "损耗单位(‰/kG)")
    private PriceUnitEnum lossUnit;

    @Schema(description = "付款日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime payTime;

    @Schema(description = "货物运费结算方式（settl_type运输单价*卸货量/运输单价*装货量/总报价）", example = "2")
    private Integer settleType;

    @Schema(description = "下游结算周期")
    private String billingCycle;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime createTime;

}
