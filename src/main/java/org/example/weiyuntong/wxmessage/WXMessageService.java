package org.example.weiyuntong.wxmessage;

import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillCarDO;

import java.util.List;

/**
 * 微信订阅相关接口
 */
public interface WXMessageService{


    /**
     * 批量下发车次通知接口 - 调用
     * @param waybillCarList
     */
    void sendSubscribeMessageByWaybillCarList(List<WaybillCarDO> waybillCarList);

    /**
     * 发车提醒
     * @param waybillCarIds
     */
    void sendSubscribeMessageByWaybillCarNoDeparted(List<Long> waybillCarIds);

    /**
     * 装货、卸货 提醒  - 调用
     */
    void sendSubscribeMessageByWaybillCarNo(String waybillCarNo);

    /**
     * 解密 存储回调相关信息
     * @param aesKey
     * @param encrypt
     */
    void saveWXCallbackMessage(byte[] aesKey, String encrypt);


}
