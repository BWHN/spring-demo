package org.example.weiyuntong.bill.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.billpay.BillPayDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;
import lombok.Data;

import java.util.List;

@Data
public class BillPayCarVO {
    BillRespVO billDO;
    List<WaybillCarDO> waybillCarDOS;
    List<String> invoiceUrl;
    List<BillPayDO> billPayDO;
}
