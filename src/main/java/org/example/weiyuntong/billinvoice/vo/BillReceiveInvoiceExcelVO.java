package org.example.weiyuntong.billinvoice.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 收票情况信息导出 vo
 */

@Data
public class BillReceiveInvoiceExcelVO {

    @ExcelProperty("账单编号")
    private String billNo;

    @ExcelProperty("账单创建人")
    private String creatorName;

    @ExcelProperty("车辆归属")
    private String carSource;

    @ExcelProperty("承运人")
    private String carrier;

    @ExcelProperty("车次编号")
    private String waybillCarNo;

    @ExcelProperty("车牌号")
    private String carNumber;

    @ExcelProperty("会计周期")
    private LocalDate accountingCycle;

    @ExcelProperty("卸货时间")
    private LocalDateTime unloadedTime;

    @ExcelProperty("发票抬头")
    private String name;

    @ExcelProperty("托运人")
    private String consignor;

    @ExcelProperty("货源业务员")
    private String serviceManagerName;

    @ExcelProperty("货物名称")
    private String mediumName;

    @ExcelProperty("装货城市")
    private String installCityName;

    @ExcelProperty("卸货城市")
    private String unloadCityName;

    @ExcelProperty("应付金额(元)")
    private BigDecimal payableAmount;

    @ExcelProperty("开票金额")
    private BigDecimal invoiceAmount;

    @ExcelProperty("发票号")
    private String invoiceSn;

    @ExcelProperty("开票日期")
    private LocalDate invoiceDate;

    @ExcelProperty("实际收票日期")
    private LocalDateTime createTime;

}
