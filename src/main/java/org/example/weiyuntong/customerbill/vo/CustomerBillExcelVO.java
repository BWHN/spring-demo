package org.example.weiyuntong.customerbill.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 客户开票信息 Excel VO
 *
 * @author 维运通
 */
@Data
public class CustomerBillExcelVO {

    @ExcelProperty("编号")
    private String code;

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("抬头名称（公司名称）")
    private String name;

    @ExcelProperty("税号")
    private String taxNum;

    @ExcelProperty("开户行")
    private String bank;

    @ExcelProperty("支行")
    private String branchNum;

    @ExcelProperty("银行卡号")
    private String bankNum;

    @ExcelProperty("电话号")
    private String phone;

    @ExcelProperty("单位地址")
    private String address;

    @ExcelProperty("客户id")
    private Long customerId;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
