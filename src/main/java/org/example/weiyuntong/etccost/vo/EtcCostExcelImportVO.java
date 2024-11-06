package org.example.weiyuntong.etccost.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false) // 设置 chain = false，避免用户导入有问题
public class EtcCostExcelImportVO {

    @ExcelProperty("客户名称")
    private String customer;
    @ExcelProperty("产品名称")
    private String product;
    @ExcelProperty("账单归属日")
    private Date billDate;
    @ExcelProperty("车牌号")
    private String carNumber;
    @ExcelProperty("车牌颜色")
    private String carColor;
    @ExcelProperty("ETC卡号")
    private String etcNumber;
    @ExcelProperty("金额(元)")
    private BigDecimal money;
    @ExcelProperty("入站时间")
    private Date inTime;
    @ExcelProperty("出站时间")
    private Date outTime;
    @ExcelProperty("入站口")
    private String startAddressName;
    @ExcelProperty("出站口")
    private String endAddressName;
    @Schema(description = "空重车 0 空车 1 重车")
    private Integer loaded;

}
