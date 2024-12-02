package org.example.weiyuntong.transporttaskmatch.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
* 运输任务匹配信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TransportTaskMatchBaseVO {
    /**
     * 发起方预计毛利润
     */
    private BigDecimal startGrossProfit;

    @Schema(description = "关联的任务id", example = "20122")
    private Long id;

    @Schema(description = "关联的任务id", example = "20122")
    private Long taskId;

    @Schema(description = "关联子任务ID", example = "20122")
    private Long entrustOrderId;

    @Schema(description = "分配运量")
    private BigDecimal assignWeight;

    @Schema(description = "分配运价", example = "23494")
    private BigDecimal assignPrice;

    @Schema(description = "委托运价", example = "27061")
    private BigDecimal entrustPrice;

    @Schema(description = "寻车运价", example = "14076")
    private BigDecimal searchCarPrice;

    @Schema(description = "寻车运价元/吨、元/升、元/KG等", example = "14076")
    private PriceUnitEnum searchCarPriceUnit;

    @Schema(description = "运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum assignPriceUnit;

    @Schema(description = "期望运价", example = "3772")
    private BigDecimal expectedPrice;

    @Schema(description = "车源联系人")
    private String vehicleContacts;

    @Schema(description = "车源联系人")
    private String vehicleContactsPhone;

    @Schema(description = "司机", example = "张三")
    private String driverName;

    @Schema(description = "司机联系电话")
    private String driverContactsPhone;

    @Schema(description = "车牌号")
    private String carNumber;

    @Schema(description = "关联车次信息")
    private String relateTrainNumber;

    @Schema(description = "预计毛利润")
    private BigDecimal grossProfit;

    @Schema(description = "预计空车位置")
    private String expectedEmptyCarLocation;

    @Schema(description = "当前状态", example = "1")
    private String carCurrentStatus;

    @Schema(description = "是否下游开票")
    private Boolean isDownstreamInvoice;

    @Schema(description = "车辆押运员")
    private String carEscort;

    @Schema(description = "车辆归属")
    private String carBelong;

    @Schema(description = "状态:0.有效，1锁定", example = "1")
    private Integer status;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "版本号")
    private Integer version;

    @Schema(description = "匹配信息类型：1.群组、2.公司、3.车辆", required = true, example = "2")
    @NotNull(message = "匹配信息类型：1.群组、2.公司、3.车辆不能为空")
    private Integer matchType;

    @Schema(description = "车辆匹配信息(多选以逗号分隔)")
    private String vehicleMatch;

    @Schema(description = "企业匹配信息(多选以逗号分隔)")
    private String entMatch;

    @Schema(description = "群组匹配信息(多选以逗号分隔)")
    private String teamMatch;

    @Schema(description = "承运商名称")
    private String carrierName;
    /**
     * 运价单位：元/吨、元/升、元/KG等
     */
    @TableField(exist = false)
    private PriceUnitEnum priceUnit;
}
