package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillSourceUpdateVO extends BillSourceCreateVO{

    @Schema(description = "id")
    private Long id;

}
