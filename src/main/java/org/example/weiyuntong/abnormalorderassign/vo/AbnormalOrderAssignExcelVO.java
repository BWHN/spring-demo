package org.example.weiyuntong.abnormalorderassign.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 委托失效分配记录 Excel VO
 *
 * @author 维运通
 */
@Data
public class AbnormalOrderAssignExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("关联的id")
    private Long associatedId;

    @ExcelProperty("公司id")
    private String companyId;

    @ExcelProperty("公司名称")
    private String companyName;

    @ExcelProperty("人员id")
    private String userId;

    @ExcelProperty("人员名称")
    private String userName;

    @ExcelProperty("分配状态设定")
    private String assignStatus;

    @ExcelProperty("备注信息")
    private String remark;

    @ExcelProperty("状态")
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
