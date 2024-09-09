package org.example.weiyuntong.bill.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 对账单 Excel VO
 *
 * @author 维运通
 */
@Data
public class BillExcelVO {

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("承运商ID")
    private Long enterpriseId;

    @ExcelProperty("承运商名称")
    private String enterpriseName;

    @ExcelProperty("账期开始日期")
    private LocalDate billStartDate;

    @ExcelProperty("账期结束日期")
    private LocalDate billEndDate;

    @ExcelProperty("装货量")
    private BigDecimal loadedWeight;

    @ExcelProperty("卸载量")
    private BigDecimal unloadedWeight;

    @ExcelProperty("超亏吨")
    private BigDecimal excessWeight;

    @ExcelProperty("超货损")
    private BigDecimal lossWeight;

    @ExcelProperty("开票需求")
    private Boolean applyInvoice;

    @ExcelProperty("应付金额")
    private BigDecimal payableAmount;

    @ExcelProperty("账单状态")
    private String billStatus;

    @ExcelProperty("账单编号")
    private String billNo;

    @ExcelProperty("账单类型")
    private String billType;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("创建者姓名")
    private String creatorName;

    @ExcelProperty("更新者姓名")
    private String updaterName;

}
