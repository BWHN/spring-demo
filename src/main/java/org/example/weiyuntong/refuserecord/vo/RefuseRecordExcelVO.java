package org.example.weiyuntong.refuserecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 撤销信息记录 Excel VO
 *
 * @author 维运通
 */
@Data
public class RefuseRecordExcelVO {

    @ExcelProperty("拒绝编码")
    private String code;

    @ExcelProperty("关联的id")
    private Long associatedId;

    @ExcelProperty("拒绝类型:")
    private String type;

    @ExcelProperty("拒绝原因，支持多选，以逗号分隔")
    private String refuseReason;

    @ExcelProperty("备注信息")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
