package org.example.weiyuntong.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ToDoCountVO {

    // 名称
    private String name;
    // 子项
    private List<Item> itemList = new ArrayList<>(8);
    // 排序
    private int sort;

    @Data
    @AllArgsConstructor
    public static class Item {
        // 名称
        private String name;
        // 数量
        private Long count;
        // 跳转路由
        private String path;
    }

    public ToDoCountVO(String name, int sort) {
        this.name = name;
        this.sort = sort;
    }

}
