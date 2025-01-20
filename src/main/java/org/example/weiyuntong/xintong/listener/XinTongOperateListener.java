package org.example.weiyuntong.xintong.listener;


import com.weiyuntong.module.bizcenter.api.xintong.vo.XinTongWaybillStatusChangeCallBackRequest;

public interface XinTongOperateListener {

    void operate(XinTongWaybillStatusChangeCallBackRequest req);

}
