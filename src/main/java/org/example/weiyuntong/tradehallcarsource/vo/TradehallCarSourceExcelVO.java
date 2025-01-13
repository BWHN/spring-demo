package org.example.weiyuntong.tradehallcarsource.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.weiyuntong.module.bizcenter.enums.VehicleSourcesStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 交易大厅-车源管理 Excel VO
 *
 * @author 维运通
 */
@Data
public class TradehallCarSourceExcelVO {

    @ExcelProperty("编码")
    private String code;

    @ExcelProperty("租户名称")
    private String tenantName;

    @ExcelProperty("起始地省级编码")
    private String startProvinceCode;

    @ExcelProperty("起始地市级编码")
    private String startCityCode;

    @ExcelProperty("起始地区级编码")
    private String startDistrictCode;

    @ExcelProperty("起始地所在省名称")
    private String startProvinceName;

    @ExcelProperty("起始地所在市名称")
    private String startCityName;

    @ExcelProperty("起始地所在区名称")
    private String startDistrictName;

    @ExcelProperty("目的地省级编码")
    private String endProvinceCode;

    @ExcelProperty("目的地市级别编码")
    private String endCityCode;

    @ExcelProperty("目的地区级编码")
    private String endDistrictCode;

    @ExcelProperty("目的地所在省名称")
    private String endProvinceName;

    @ExcelProperty("目的地地所在市名称")
    private String endCityName;

    @ExcelProperty("目的地所在区名称")
    private String endDistrictName;

    @ExcelProperty("空车数量")
    private Integer emptyCarCount;

    @ExcelProperty("空车开始日期")
    private LocalDate emptyCarStartDate;

    @ExcelProperty("空车开始时间：上午、下午、00:00-24:00")
    private String emptyCarStartTime;

    @ExcelProperty("空车结束日期")
    private LocalDate emptyCarEndDate;

    @ExcelProperty("空车结束时间：上午、下午、00:00-24:00")
    private String emptyCarEndTime;

    @ExcelProperty("关联车牌号，多车使用逗号分隔")
    private String carIds;

    @ExcelProperty("车队名称是否可见，true/false")
    private Boolean isFleetVisible;

    @ExcelProperty("车牌号是否可见，true/false")
    private Boolean isCarVisible;

    @ExcelProperty("最后一次承运介质名称")
    private String lastMediumName;

    @ExcelProperty("车辆载重")
    private BigDecimal carWeight;

    @ExcelProperty("允许可装介质，类别之间用逗号分隔")
    private String allowMedium;

    @ExcelProperty("排放标准")
    private String emissionStandard;

    @ExcelProperty("所需的车辆类型")
    private String carType;

    @ExcelProperty("是否保温:1.保温")
    private Boolean isWarm;

    @ExcelProperty("是否加热:1.加热")
    private Boolean isHeat;

    @ExcelProperty("状态:待匹配:UN_MATCHED,待接单:PENDING_ORDER 待下发:WAIT_DISPATCHED,已撤销:TO_CANCELED")
    private VehicleSourcesStatusEnum status;

    @ExcelProperty("排序")
    private Short rowSort;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("版本号")
    private Integer version;

}
