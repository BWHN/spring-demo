package org.example.weiyuntong.billcontacts.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 账单联系人 Excel VO
 *
 * @author 维运通
 */
@Data
public class BillContactsExcelVO {

    @ExcelProperty("账单id")
    private Long billId;

    @ExcelProperty("接单方：CARRIER；发布方：CONSIGNOR")
    private String type;

    @ExcelProperty("联系人姓名")
    private String contactsName;

    @ExcelProperty("联系人电话")
    private String contactsPhone;

    @ExcelProperty("负责人姓名")
    private String headName;

    @ExcelProperty("负责人电话")
    private String headPhone;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("创建者联系电话")
    private String creatorPhone;

}
