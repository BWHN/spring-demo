package org.example.weiyuntong.monitor.vo;

import lombok.Data;

@Data
public class TrackMonitorVO {
    private String carNumber;
    private String openId;
    private String lat;
    private String lng;
    private String speed;
    private String tmStr;
    private String direct;
    private String locName;
    private String mobile;
}
