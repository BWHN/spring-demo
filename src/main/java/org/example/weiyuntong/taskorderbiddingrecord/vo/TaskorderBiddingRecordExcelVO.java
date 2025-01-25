package org.example.weiyuntong.taskorderbiddingrecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 任务单报价记录信息 Excel VO
 *
 * @author 维运通
 */
@Data
public class TaskorderBiddingRecordExcelVO {

    @ExcelProperty("抢单运量")
    private BigDecimal grabWeight;

    @ExcelProperty("剩余运量")
    private BigDecimal surplusWeight;

    @ExcelProperty("寻车运价")
    private BigDecimal price;

    @ExcelProperty("上报运价")
    private BigDecimal reportPrice;

    @ExcelProperty("上报车辆id，多个车辆逗号分隔")
    private String reportCarId;

    @ExcelProperty("上报车辆车牌，多个车辆逗号分隔")
    private String reportCarNum;

    @ExcelProperty("车辆类型")
    private Integer carType;

    @ExcelProperty("抢单截止时间")
    private LocalDateTime grabTime;

    @ExcelProperty("是否保温:1.保温")
    private Integer isWarm;

    @ExcelProperty("是否加热:1.加热")
    private Integer isHeat;

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("预计毛利润")
    private BigDecimal grossProfit;

    @ExcelProperty("创建者")
    private String creatorName;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新者")
    private String updaterName;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("报价状态（-1.报价失效0.待确认1.确认报价）")
    private int status;

    @ExcelProperty("关联的任务Id")
    private Long taskId;

    @ExcelProperty("关联的任务委托单Id")
    private Long taskEntrustId;

    @ExcelProperty("报价企业id")
    private Long entId;

}
