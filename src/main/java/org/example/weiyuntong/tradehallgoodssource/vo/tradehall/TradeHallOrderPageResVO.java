package org.example.weiyuntong.tradehallgoodssource.vo.tradehall;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.GoodsViewPermissionsEnums;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "接单管理分页 Response VO")
@Data
@ToString(callSuper = true)
public class TradeHallOrderPageResVO {

    @Schema(description = "订单类型")
    private WaybillTypeEnum type;
    @Schema(description = "展示Code")
    private String code;
    @Schema(description = "ID")
    private Long id;
    @Schema(description = "子单编号")
    private String entrustCode;
    @Schema(description = "订单")
    private Long orderId;
    @Schema(description = "订单编号")
    private String orderCode;
    @Schema(description = "托运人")
    private String consignor;
    @Schema(description = "开始日期")
    private LocalDate beginTime;
    @Schema(description = "结束日期")
    private LocalDate endTime;
    @Schema(description = "装货地")
    private String loadAddress;
    @Schema(description = "卸货地")
    private String unLoadAddress;
    @Schema(description = "装货地详情")
    private String loadAddressDetail;
    @Schema(description = "卸货地详情")
    private String unLoadAddressDetail;
    @Schema(description = "货物名称")
    private String mediumName;
    @Schema(description = "运价")
    private BigDecimal entrustPrice;
    @Schema(description = "运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum entrustPriceUnit;

    @Schema(description = "总运量")
    private BigDecimal totalWeight;
    @Schema(description = "剩余运量")
    private BigDecimal remainingWeight;
    @Schema(description = "成交运量")
    private BigDecimal dealWeight = BigDecimal.ZERO;
    @Schema(description = "拒绝运量")
    private BigDecimal senderRefusedWeight = BigDecimal.ZERO;
    @Schema(description = "放弃运量")
    private BigDecimal refusedWeight;
    @Schema(description = "撤销运量")
    private BigDecimal revokeWeight;
    @Schema(description = "忽略运量")
    private BigDecimal ignoreWeight;

    @Schema(description = "待确认条数")
    private int toSureCount;
    @Schema(description = "已确认条数")
    private int sureCount;
    @Schema(description = "被拒绝条数")
    private int refusedCount;
    @Schema(description = "被撤销条数")
    private int revokedCount;

    @Schema(description = "寻车范围")
    private GoodsViewPermissionsEnums viewPermissions;
    @Schema(description = "权限标签名称（寻车范围是ROLE_LABEL时使用）")
    private String roleLabelName;
    @Schema(description = "接单人")
    private String carrierName;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 是否发单人
    @JsonIgnore
    private Integer senderFlag;

    @Schema(description = "寻车运价")
    private BigDecimal searchCarPrice;
    @Schema(description = "寻车运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum searchCarPriceUnit;


}
