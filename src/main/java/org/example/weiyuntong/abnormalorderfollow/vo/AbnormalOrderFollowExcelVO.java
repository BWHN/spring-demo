package org.example.weiyuntong.abnormalorderfollow.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 委托失效记录跟进记录 Excel VO
 *
 * @author 维运通
 */
@Data
public class AbnormalOrderFollowExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("关联的id")
    private Long associatedId;

    @ExcelProperty("跟进方式")
    private String followMethod;

    @ExcelProperty("跟进时间")
    private LocalDateTime followTime;

    @ExcelProperty("业务需求")
    private String businessRequirements;

    @ExcelProperty("开发计划")
    private String developPlan;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("状态")
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
