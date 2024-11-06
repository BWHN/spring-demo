package org.example.weiyuntong.etccost.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.weiyuntong.module.bizcenter.enums.ExpenseStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ETC费用 Excel VO
 *
 * @author 维运通
 */
@Data
public class EtcCostExcelVO {

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
    @ExcelProperty("无需审核金额")
    private BigDecimal defaultMoney = BigDecimal.ZERO;

    @ExcelIgnore
    private BigDecimal money;
    @ExcelIgnore
    private ExpenseStatusEnum expenseStatusRe;

    @ExcelProperty("审核状态")
    private String expenseStatusName;

    public String getExpenseStatusName() {
        return expenseStatusRe.getDesc();
    }

}
