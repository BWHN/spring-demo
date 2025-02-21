package org.example.weiyuntong.waybillshare.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.Waybill;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class WaybillShareVO {

    @Schema(description = "运单进度")
    private BigDecimal progress = BigDecimal.ZERO;

    @Schema(description = "运单距离")
    private BigDecimal km = BigDecimal.ZERO;

    private Waybill waybill;

    private List<WaybillCarDO> waybillCarDOList;


    @Schema(description = "已发车")
    private List<WaybillCarDO> toDepartedList;

    @Schema(description = "已到达装货地")
    private List<WaybillCarDO> getLoadedList;

    @Schema(description = "已待装货")
    private List<WaybillCarDO> toLoadedList;

    @Schema(description = "已到达卸货地")
    private List<WaybillCarDO> getUnloadedList;

    @Schema(description = "已待卸货")
    private List<WaybillCarDO> toUnloadedList;
}
