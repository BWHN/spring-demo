package org.example.weiyuntong.home.vo;

import lombok.Data;

@Data
public class ChartQueryReqVO {

    // 单元 MONTH、YEAR
    private String unit;
    // 开始时间
    private String timeStart;
    // 结束时间
    private String timeEnd;
    // 上月/年开始时间
    private String prevTimeStart;
    // 上月/年结束时间
    private String prevTimeEnd;

    public boolean ifNull() {
        return unit == null || timeStart == null || timeEnd == null || prevTimeStart == null || prevTimeEnd == null;
    }

}
