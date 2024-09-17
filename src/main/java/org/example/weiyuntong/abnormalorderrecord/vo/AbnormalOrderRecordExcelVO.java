package org.example.weiyuntong.abnormalorderrecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 委托失效记录 Excel VO
 *
 * @author 维运通
 */
@Data
public class AbnormalOrderRecordExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("关联的id")
    private Long associatedId;

    @ExcelProperty("类型")
    private String type;

    @ExcelProperty("备注信息")
    private String remark;

    @ExcelProperty("处理状态:已处理、未处理")
    private String status;

    @ExcelProperty("记录最后的状态")
    private String finalStatus;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
