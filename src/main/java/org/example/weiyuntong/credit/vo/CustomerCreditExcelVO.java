package org.example.weiyuntong.credit.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 客户赊销 Excel VO
 *
 * @author 维运通
 */
@Data
public class CustomerCreditExcelVO {

    @ExcelProperty("客户编号")
    private Long customerId;

    @ExcelProperty("客户名称")
    private String name;

    @ExcelProperty("客户类型")
    private String type;

    @ExcelProperty("客户评级")
    private String level;

    @ExcelProperty("风险信息")
    private String warnNum;

    @ExcelProperty("客户状态")
    private String status;

    @ExcelProperty("客户赊销额度")
    private String totalAmount;

    @ExcelProperty("剩余额度")
    private BigDecimal availableAmount;

    @ExcelProperty("逾期款项")
    private BigDecimal expiredAmount;

    @ExcelProperty("资金占用成本")
    private String interestRateDesc;

    @ExcelProperty("资金收益")
    private BigDecimal incomeAmount;



}
