package org.example.weiyuntong.carconfig.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 车辆费用配置 Excel VO
 *
 * @author 维运通
 */
@Data
public class CarConfigExcelVO {

    @ExcelProperty("车型")
    private String carType;

    @ExcelProperty("油价")
    private BigDecimal oilPrice;

    @ExcelProperty("高速司机提成")
    private BigDecimal freewayPercentage;

    @ExcelProperty("底道司机提成")
    private BigDecimal roadPercentage;

    @ExcelProperty("高速油耗")
    private BigDecimal freewayOilConsumption;

    @ExcelProperty("底道油耗")
    private String roadOilConsumption;

    @ExcelProperty("空车高速司机提成")
    private BigDecimal emptyFreewayPercentage;

    @ExcelProperty("空车底道司机提成")
    private BigDecimal emptyRoadPercentage;

    @ExcelProperty("空车高速油耗")
    private BigDecimal emptyFreewayOilConsumption;

    @ExcelProperty("空车底道油耗")
    private BigDecimal emptyRoadOilConsumption;

    @ExcelProperty("固定成本均摊")
    private BigDecimal fixedCost;

    @ExcelProperty("账期成本")
    private BigDecimal billCost;

    @ExcelProperty("税点")
    private BigDecimal taxPoint;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
