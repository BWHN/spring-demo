package org.example.weiyuntong.xintong.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class XinTongOrderSyncResponse {

    // 返回码 0-成功，其他-失败
    private int code;
    // 返回信息
    private String message;
    // 返回数据
    private InnerData data;

    public XinTongOrderSyncResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Data
    public static class InnerData {
        // 星通北斗订单号
        private String xtbdOrderNumber;
        // 请求标识
        private String uuid;
    }

}