package org.example.weiyuntong.transporttaskmatch.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.weiyuntong.module.bizcenter.enums.PriceUnitEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 运输任务匹配信息 Excel VO
 *
 * @author 维运通
 */
@Data
public class TransportTaskMatchExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("关联的任务id")
    private Long taskId;

    @ExcelProperty("分配运量")
    private BigDecimal assignWeight;

    @ExcelProperty("分配运价")
    private BigDecimal assignPrice;

    @ExcelProperty("委托运价")
    private BigDecimal entrustPrice;

    @ExcelProperty("寻车运价")
    private BigDecimal searchCarPrice;

    @ExcelProperty("运价单位：元/吨、元/升、元/KG等")
    private PriceUnitEnum assignPriceUnit;

    @ExcelProperty("期望运价")
    private BigDecimal expectedPrice;

    @ExcelProperty("车源联系人")
    private String vehicleContacts;

    @ExcelProperty("车源联系人")
    private String vehicleContactsPhone;

    @ExcelProperty("司机")
    private String driverName;

    @ExcelProperty("司机联系电话")
    private String driverContactsPhone;

    @ExcelProperty("车牌号")
    private String carNumber;

    @ExcelProperty("关联车次信息")
    private String relateTrainNumber;

    @ExcelProperty("预计毛利润")
    private BigDecimal grossProfit;

    @ExcelProperty("预计空车位置")
    private String expectedEmptyCarLocation;

    @ExcelProperty("当前状态")
    private String carCurrentStatus;

    @ExcelProperty("是否下游开票")
    private Boolean isDownstreamInvoice;

    @ExcelProperty("车辆押运员")
    private String carEscort;

    @ExcelProperty("车辆归属")
    private String carBelong;

    @ExcelProperty("状态:0.有效，1锁定")
    private Integer status;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("版本号")
    private Integer version;

    @ExcelProperty("匹配信息类型：1.群组、2.公司、3.车辆")
    private Integer matchType;

    @ExcelProperty("车辆匹配信息(多选以逗号分隔)")
    private String vehicleMatch;

    @ExcelProperty("企业匹配信息(多选以逗号分隔)")
    private String entMatch;

    @ExcelProperty("群组匹配信息(多选以逗号分隔)")
    private String teamMatch;

}
