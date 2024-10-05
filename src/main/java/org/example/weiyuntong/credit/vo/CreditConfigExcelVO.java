package org.example.weiyuntong.credit.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 赊销配置 Excel VO
 *
 * @author 维运通
 */
@Data
public class CreditConfigExcelVO {

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("承运商ID")
    private Long carrierId;

    @ExcelProperty("账期开始时间")
    private String billStart;

    @ExcelProperty("账期结束时间")
    private String billEnd;

    @ExcelProperty("额度预警提醒")
    private BigDecimal lowThreshold;

    @ExcelProperty("逾期预警提醒")
    private BigDecimal overdueThreshold;

    @ExcelProperty("利率")
    private BigDecimal interestRate;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
