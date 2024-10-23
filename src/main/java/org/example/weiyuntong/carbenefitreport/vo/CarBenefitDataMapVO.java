package org.example.weiyuntong.carbenefitreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 自营车辆效益 图表展示
 */

@Data
public class CarBenefitDataMapVO {

    @Schema(description = "利润率环形图")
    private CarBenefitDataMapVO.ProfitChartData profitChartData = new ProfitChartData();
    @Schema(description = "总收入环形图")
    private CarBenefitDataMapVO.ReceiveChartData receiveChartData = new ReceiveChartData();
    @Schema(description = "总成本矩形树图")
    private CarBenefitDataMapVO.Node costChartData = new Node();

    @Data
    public static class ProfitChartData {
        @Schema(description = "总车辆")
        private Long carCount = 0L;
        @Schema(description = "利润率>=0%")
        private Long profitRateOver0 = 0L;
        @Schema(description = "利润率<0%")
        private Long profitRateUnder0 = 0L;
    }

    @Data
    public static class ReceiveChartData {
        @Schema(description = "总收入")
        private BigDecimal receivedAmount = BigDecimal.ZERO;
        @Schema(description = "利润")
        private BigDecimal profit = BigDecimal.ZERO;
        @Schema(description = "成本")
        private BigDecimal totalCost = BigDecimal.ZERO;
    }

    @Data
    @NoArgsConstructor
    public static class Node {
        @Schema(description = "名称")
        private String name = "";
        @Schema(description = "值")
        private BigDecimal value = BigDecimal.ZERO;
        @Schema(description = "子节点")
        private List<Node> children = new ArrayList<>(8);

        public Node(String name, BigDecimal value, List<Node> children) {
            this.name = name;
            this.value = value;
            this.children = children;
        }
    }



}
