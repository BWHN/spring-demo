package org.example.weiyuntong.credit.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 赊销评级 Excel VO
 *
 * @author 维运通
 */
@Data
public class CreditConfigLevelExcelVO {

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("客户评价")
    private String customerLevel;

    @ExcelProperty("承运商")
    private Long carrierId;

    @ExcelProperty("授信额度")
    private BigDecimal creditAmount;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
