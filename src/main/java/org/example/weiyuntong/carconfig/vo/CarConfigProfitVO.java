package org.example.weiyuntong.carconfig.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Optional;

@Data
public class CarConfigProfitVO {

    @Schema(description = "总里程")
    private BigDecimal totalMileageKm;

    @Schema(description = "重车总里程")
    private BigDecimal tollDistanceKm;

    @Schema(description = "高速费用")
    private BigDecimal tolls;

    @Schema(description = "运营天数")
    private BigDecimal runDay;

    @Schema(description = "底道总里程")
    private BigDecimal roadDistanceKm;

    @Schema(description = "信息提示")
    private String message;

    @Schema(description = "空车总里程（高速+底道）")
    private BigDecimal emptyDistanceKm;

    @Schema(description = "重车总里程（高速+底道）")
    private BigDecimal loadedDistanceKm;

    public void computeTotalMileage() {
        this.totalMileageKm = this.loadedDistanceKm.add(Optional.ofNullable(this.emptyDistanceKm).orElse(BigDecimal.ZERO));
    }

    public void initZero() {
        if (totalMileageKm == null) {
            totalMileageKm = BigDecimal.ZERO;
        }

        if (tollDistanceKm == null) {
            tollDistanceKm = BigDecimal.ZERO;
        }

        if (tolls == null) {
            tolls = BigDecimal.ZERO;
        }

        if (runDay == null) {
            runDay = BigDecimal.ZERO;
        }

        if (roadDistanceKm == null) {
            roadDistanceKm = BigDecimal.ZERO;
        }

        if (emptyDistanceKm == null) {
            emptyDistanceKm = BigDecimal.ZERO;
        }

        if (loadedDistanceKm == null) {
            loadedDistanceKm = BigDecimal.ZERO;
        }

    }
}
