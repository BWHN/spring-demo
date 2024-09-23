package org.example.weiyuntong.billpay.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 登记付款 Excel VO
 *
 * @author 维运通
 */
@Data
public class BillPayExcelVO {

    @ExcelProperty("付款方式")
    private String payWay;

    @ExcelProperty("付款凭证")
    private String payUrl;

    @ExcelProperty("发票代码")
    private String invoiceSn;

    @ExcelProperty("付款时间")
    private LocalDateTime payTime;

    @ExcelProperty("付款金额")
    private BigDecimal payMoney;

    @ExcelProperty("付款账户")
    private String payAccount;

    @ExcelProperty("账单id")
    private Long billId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("发票账户id")
    private Long customerBillId;

}
