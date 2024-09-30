package org.example.weiyuntong.bizimprest.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 备用金信息 Excel VO
 *
 * @author 维运通
 */
@Data
public class BizImprestExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("备用金金额")
    private BigDecimal imprestAmount;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("版本号")
    private Integer version;

}
