package org.example.weiyuntong.monitor.vo;

import lombok.Data;

import java.util.List;

@Data
public class MonitorGpsRequestVO {
    private String carStatus;

    private List<String> carNumber;
}
