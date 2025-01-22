package org.example.weiyuntong.taskorderrefuserecord.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 任务单拒绝记录信息 Excel VO
 *
 * @author 维运通
 */
@Data
public class TaskorderRefuseRecordExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("关联的任务Id")
    private Long taskId;

    @Schema(description = "关联的任务委托单Id", example = "13038")
    private Long taskEntrustId;

    @ExcelProperty("企业id")
    private Long entId;

    @ExcelProperty("拒绝其他备注信息")
    private String remark;

    @ExcelProperty("拒绝原因，支持多选，以逗号分隔")
    private String refuseReason;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
