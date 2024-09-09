package org.example.weiyuntong.bill.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class BillExcel {

    private String carrier;

    @Schema(description = "联系人")
    private String contact;

    @Schema(description = "联系人电话")
    private String contactMobile;

    private String customer;

    @Schema(description = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;

    @Schema(description = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private List<WaybillCarDO> waybillCarDOList;

    private List<BillMonthVO> billMonthVOS;

    @Schema(description = "发票抬头")
    private String billTitle;

    @Schema(description = "发票吨数")
    private BigDecimal billWeight;

    @Schema(description = "开票金额")
    private BigDecimal invoiceMoney;

    @Schema(description = "备注")
    private String remark;
}
