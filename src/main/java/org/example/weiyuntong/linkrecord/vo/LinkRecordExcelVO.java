package org.example.weiyuntong.linkrecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 客户关联 Excel VO
 *
 * @author 维运通
 */
@Data
public class LinkRecordExcelVO {

    @ExcelProperty("关联货主ID")
    private Long linkId;

    @ExcelProperty("关联状态（1.待审核 2.通过审核 3.审核不通过）")
    private String status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
