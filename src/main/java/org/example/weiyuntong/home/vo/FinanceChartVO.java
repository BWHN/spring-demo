package org.example.weiyuntong.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FinanceChartVO {

    // 总利润
    private BigDecimal totalProfit;
    // 总利润率
    private BigDecimal totalProfitRate;
    // 总收入
    private BigDecimal totalReceive;
    // 总成本
    private BigDecimal totalCost;
    // 趋势
    private List<Item> trend;
    // 利润分布
    private Proportion profitProportion;
    // 收入分布
    private Proportion receiveProportion;
    // 上月/去年数据
    private FinanceChartVO prevFinanceCount;

    public FinanceChartVO(BigDecimal totalProfit, BigDecimal totalProfitRate, BigDecimal totalReceive, BigDecimal totalCost) {
        this.totalProfit = totalProfit;
        this.totalProfitRate = totalProfitRate;
        this.totalReceive = totalReceive;
        this.totalCost = totalCost;
    }

    @Data
    public static class Item {
        private String name;
        private BigDecimal receive = BigDecimal.ZERO;
        private BigDecimal cost = BigDecimal.ZERO;
        private BigDecimal profit = BigDecimal.ZERO;
        private BigDecimal profitRate = BigDecimal.ZERO;

        public Item(String name) {
            this.name = name;
        }
    }

    @Data
    @AllArgsConstructor
    public static class Proportion {
        // 自营
        private BigDecimal own;
        // 外协
        private BigDecimal other;
    }

}
