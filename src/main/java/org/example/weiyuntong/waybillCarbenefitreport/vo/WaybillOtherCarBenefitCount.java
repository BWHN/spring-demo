package org.example.weiyuntong.waybillCarbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class WaybillOtherCarBenefitCount {

    @Schema(description = "预测业务利润(元)")
    private BigDecimal predictProfit = BigDecimal.ZERO;
    @Schema(description = "实际业务利润(元)")
    private BigDecimal realProfit = BigDecimal.ZERO;
    @Schema(description = "实际业务利润率")
    private BigDecimal realProfitRate = BigDecimal.ZERO;
    @Schema(description = "实际收款金额(元)")
    private BigDecimal receivedAmount = BigDecimal.ZERO;
    @Schema(description = "总成本(元)")
    private BigDecimal totalCost = BigDecimal.ZERO;
    @Schema(description = "总支出(元)")
    private BigDecimal paidAmount = BigDecimal.ZERO;
    @Schema(description = "利润率环形图")
    private ProfitChartData profitChartData = new ProfitChartData();
    @Schema(description = "总收入环形图")
    private ReceiveChartData receiveChartData = new ReceiveChartData();
    @Schema(description = "总成本矩形树图")
    private Node costChartData = new Node();

    @Data
    public static class ProfitChartData {
        @Schema(description = "总车次")
        private Integer waybillCarCount = 0;
        @Schema(description = "利润率>=7%车次数")
        private Integer profitRateOver7 = 0;
        @Schema(description = "利润率<7%车次数")
        private Integer profitRateUnder7 = 0;
    }

    @Data
    public static class ReceiveChartData {
        @Schema(description = "总收入")
        private BigDecimal receivedAmount = BigDecimal.ZERO;
        @Schema(description = "利润")
        private BigDecimal profit = BigDecimal.ZERO;
        @Schema(description = "成本")
        private BigDecimal totalCost = BigDecimal.ZERO;
        @Schema(description = "运费支出")
        private BigDecimal paidAmount = BigDecimal.ZERO;
    }

    @Data
    public static class Node {
        @Schema(description = "名称")
        private String name = "";
        @Schema(description = "值")
        private BigDecimal value = BigDecimal.ZERO;
        @Schema(description = "子节点")
        private List<WaybillOwnCarBenefitCount.Node> children = new ArrayList<>(8);
    }

}
