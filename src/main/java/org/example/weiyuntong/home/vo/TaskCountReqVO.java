package org.example.weiyuntong.home.vo;

import lombok.Data;

import java.util.Collection;

@Data
public class TaskCountReqVO {

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 部门列表
     */
    private Collection<Long> deptList;

    /**
     * 创建者
     */
    private Long creator;
}
