package org.example.weiyuntong.bizexpensetype.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 费用类型 Excel VO
 *
 * @author 维运通
 */
@Data
public class BizExpenseTypeExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("费用类型名称")
    private String name;

    @ExcelProperty("费用上限:0.无上限1.有上限")
    private Boolean isExpenseLimit;

    @ExcelProperty("费用上线金额")
    private BigDecimal expenseLimitAmount;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("版本号")
    private Integer version;

}
