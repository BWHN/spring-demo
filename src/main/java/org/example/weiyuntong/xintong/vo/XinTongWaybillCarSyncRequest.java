package org.example.weiyuntong.xintong.vo;

import lombok.Data;

import java.util.List;

@Data
public class XinTongWaybillCarSyncRequest {

    // 商户编号
    private String merchantCode;
    // 商户ID
    private String merchantId;
    //运单号
    private List<String> waybillIdsArr;

}
