package com.weiyuntong.module.bizcenter.controller.admin.billnew.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillCarDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillDO;
import lombok.Data;

import java.util.List;

@Data
public class BillCheckVO {
    private BillDO billDO;

    private List<BillCarDO> billCarDOS;
}
