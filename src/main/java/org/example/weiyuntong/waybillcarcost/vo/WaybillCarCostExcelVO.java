package org.example.weiyuntong.waybillcarcost.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 车次成本 Excel VO
 *
 * @author 维运通
 */
@Data
public class WaybillCarCostExcelVO {

    @ExcelProperty("车次ID")
    private Long waybillCarId;

    @ExcelProperty("重车高速里程")
    private BigDecimal freewayMileage;

    @ExcelProperty("重车底道里程")
    private BigDecimal roadMileage;

    @ExcelProperty("高速费用")
    private BigDecimal freewayCost;

    @ExcelProperty("运营天数")
    private BigDecimal runDay;

    @ExcelProperty("高速油费")
    private BigDecimal freewayOilCost;

    @ExcelProperty("底道油费")
    private BigDecimal roadOilCost;

    @ExcelProperty("空车高速里程")
    private BigDecimal emptyFreewayMileage;

    @ExcelProperty("空车底道里程")
    private BigDecimal emptyRoadMileage;

    @ExcelProperty("空车高速费用")
    private BigDecimal emptyFreewayCost;

    @ExcelProperty("业务费用")
    private BigDecimal operatingCost;

    @ExcelProperty("空车高速油费")
    private BigDecimal emptyFreewayOilCost;

    @ExcelProperty("空车底道油费")
    private BigDecimal emptyRoadOilCost;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
