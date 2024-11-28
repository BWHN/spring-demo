package org.example.weiyuntong.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ExpenseChartVO {

    // 上游运单数
    private Integer upWaybillSourceCount;
    // 下游运单数
    private Integer downWaybillSourceCount;
    // 收入
    private BigDecimal receiveAmount;
    // 成本
    private BigDecimal weight;
    // 收入趋势
    private List<Item> receiveTrend;
    // 运量趋势
    private List<Item> weightTrend;
    // 上游运单分布
    private Proportion upProportion;
    // 下游运单分布
    private Proportion downProportion;
    // 上月/去年数据
    private ExpenseChartVO prevExpenseCount;

    public ExpenseChartVO(Integer upWaybillSourceCount, Integer downWaybillSourceCount, BigDecimal receiveAmount, BigDecimal weight) {
        this.upWaybillSourceCount = upWaybillSourceCount;
        this.downWaybillSourceCount = downWaybillSourceCount;
        this.receiveAmount = receiveAmount;
        this.weight = weight;
    }

    @Data
    public static class Item {
        private String name;
        private int waybillSourceCount = 0;
        private BigDecimal amount = BigDecimal.ZERO;

        public Item(String name) {
            this.name = name;
        }
    }

    @Data
    @AllArgsConstructor
    public static class Proportion {
        // 自营
        private Integer own;
        // 外协
        private Integer other;
    }

}
