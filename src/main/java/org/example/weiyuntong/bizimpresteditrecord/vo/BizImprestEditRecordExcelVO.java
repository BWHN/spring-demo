package org.example.weiyuntong.bizimpresteditrecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 备用金修改记录 Excel VO
 *
 * @author 维运通
 */
@Data
public class BizImprestEditRecordExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("备用金ID")
    private Long imprestId;

    @ExcelProperty("备用金修改前金额")
    private BigDecimal editBeforeAmount;

    @ExcelProperty("备用金修改后金额")
    private BigDecimal editAfterAmount;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("版本号")
    private Integer version;

}
