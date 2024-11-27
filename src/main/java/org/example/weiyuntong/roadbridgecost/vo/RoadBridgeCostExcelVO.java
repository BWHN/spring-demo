package org.example.weiyuntong.roadbridgecost.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.weiyuntong.module.bizcenter.enums.ExpenseStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 路桥费用 Excel VO
 *
 * @author 维运通
 */
@Data
public class RoadBridgeCostExcelVO {

    @ExcelProperty("车次编码")
    private String waybillCarNo;
    @ExcelProperty("车牌号")
    private String carNumber;
    @ExcelProperty("装货地")
    private String loadAddress;
    @ExcelProperty("卸货地")
    private String unloadAddress;
    @ExcelProperty("装货时间")
    private String loadedTime;
    @ExcelProperty("卸货时间")
    private String unloadedTime;
    @ExcelProperty("总费用")
    private BigDecimal totalMoney = BigDecimal.ZERO;
    @ExcelProperty("待审核金额")
    private BigDecimal pendingMoney = BigDecimal.ZERO;
    @ExcelProperty("已审核金额")
    private BigDecimal approveMoney = BigDecimal.ZERO;
    @ExcelProperty("已驳回金额")
    private BigDecimal rejectMoney = BigDecimal.ZERO;
    @ExcelIgnore
    private BigDecimal money;
    @ExcelIgnore
    private ExpenseStatusEnum expenseStatusRe;
    @ExcelProperty("审核状态")
    private String expenseStatus;

    public String getExpenseStatus() {
        return expenseStatusRe.getDesc();
    }

}
