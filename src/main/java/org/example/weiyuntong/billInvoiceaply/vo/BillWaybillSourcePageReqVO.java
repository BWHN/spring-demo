package org.example.weiyuntong.billInvoiceaply.vo;

import com.weiyuntong.framework.common.pojo.PageParam;
import lombok.Data;

@Data
public class BillWaybillSourcePageReqVO extends PageParam {

    // 登记ID
    private Long registerId;
    // 申请ID
    private Long applyId;
    // 账单ID
    private Long billId;
    // 装货日期
    private String loadedDateStart;
    private String loadedDateEnd;
    // 卸货日期
    private String unloadedDateStart;
    private String unloadedDateEnd;
    // 车牌号
    private String carNumber;

}
