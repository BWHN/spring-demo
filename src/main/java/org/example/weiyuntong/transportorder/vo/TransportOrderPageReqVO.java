package org.example.weiyuntong.transportorder.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Schema(description = "管理后台 - 订单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransportOrderPageReqVO extends PageParam {

    @Schema(description = "企业id", example = "13373")
    private Long entId;

    @Schema(description = "计划id", example = "5787")
    private Long planId;

    @Schema(description = "企业名称", example = "张三")
    private String enterpriseName;

    @Schema(description = "货物名称", example = "9735")
    private String mediumName;

    @Schema(description = "开始日期开始")
    private String beginDateStart;
    @Schema(description = "开始日期结束")
    private String beginDateEnd;

    @Schema(description = "结束日期结束")
    private String endDateStart;
    @Schema(description = "结束日期结束")
    private String endDateEnd;

    @Schema(description = "状态", example = "1")
    private List<String> status;

    @Schema(description = "是否结束 1 待接单 2已结束")
    private String isOver;

    @Schema(description = "是否不分页")
    private Integer isNotPage;

    private Long ownRoleLabelId;

    @Schema(description = "前端自定义排序规则")
    private String customOrder;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "编号")
    private String code;

    @Schema(description = "装货地城市名称")
    private String sendCityName;
    @Schema(description = "卸货地城市名称")
    private String receiveCityName;
    @Schema(description = "查询关键字")
    private String keyword;

    @Schema(description = "计划单号")
    private String planCode;




}
