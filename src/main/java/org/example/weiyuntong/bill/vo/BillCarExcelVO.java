package org.example.weiyuntong.bill.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 账单车次 Excel VO
 *
 * @author 维运通
 */
@Data
public class BillCarExcelVO {

    @ExcelProperty("账单ID")
    private Long billId;

    @ExcelProperty("车次ID")
    private Long waybillCarId;

}
