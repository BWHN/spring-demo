package org.example.weiyuntong.xintong.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weiyuntong.framework.common.enums.XinTongWaybillStatusEnums;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class XinTongWaybillStatusChangeCallBackRequest {

    private Long entId;

    // 运单编号
    @NotNull
    private String waybillSourceNo;
    // 节点状态
    @NotNull
    private XinTongWaybillStatusEnums waybillSourceStatus;

    // 经纬度
    private String lng;
    private String lat;
    // 事件图片
    private String eventImages;
    // 事件时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventTime;
    // 事件车辆里程图片
    private String mileageUrl;
    // 事件车辆里程
    private Double mileage;
    // 事件回单图片
    private String receiptUrl;

    // 装货图片
    private String loadedImgUrl;
    // 装货时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loadedTime;
    // 装货重量
    private BigDecimal loadedWeight;

    // 卸货时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime unloadedTime;
    // 卸货重量
    private BigDecimal unloadedWeight;
    // 卸货图片
    private String unloadedImgUrl;

}
