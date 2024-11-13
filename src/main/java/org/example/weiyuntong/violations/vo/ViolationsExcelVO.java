package org.example.weiyuntong.violations.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 违规管理 Excel VO
 *
 * @author 维运通
 */
@Data
public class ViolationsExcelVO {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("车队名称")
    private String fleetName;

    @ExcelProperty("违规时间")
    private LocalDateTime violationTime;

    @ExcelProperty("车队id")
    private Long fleetId;

    @ExcelProperty("处理方法")
    private String method;

    @ExcelProperty("违规行为名称")
    private String violation;

    @ExcelProperty("车牌号")
    private String carNumber;

    /**
     * 类型id
     */
    private Long violationTypeId;
    /**
     * 车辆id
     */
    private Long carId;

    @ExcelProperty("驾驶员id")
    private Long driverId;

    @ExcelProperty("押运员id")
    private Long followId;

    @ExcelProperty("违规类型")
    private String type;

    @ExcelProperty("审核状态")
    private String status;

    @ExcelProperty("罚金")
    private BigDecimal money;

    @ExcelProperty("备注")
    private String remarks;

    @ExcelProperty("视频截图路径")
    private String file;

    @ExcelProperty("司机名称")
    private String driverName;

    @ExcelProperty("押运员名称")
    private String followName;
}
