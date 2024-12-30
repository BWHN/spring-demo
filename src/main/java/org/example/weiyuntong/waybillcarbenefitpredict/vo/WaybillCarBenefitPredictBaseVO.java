package org.example.weiyuntong.waybillcarbenefitpredict.vo;

import com.weiyuntong.module.bizcenter.enums.WaybillCarBenefitTypeEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WaybillCarBenefitPredictBaseVO {

    /**
     * 公司ID
     */
    private Long entId;

    /**
     * 效益类型：自营、外协
     */
    private WaybillCarBenefitTypeEnum type;

    /**
     * 车辆ID
     */
    private Long carId;

    /**
     * 车次表ID
     */
    private Long waybillCarId;

    /**
     * 车次编号
     */
    private String waybillCarNo;

    /************************************ 配置部分 **********************************************/

    /**
     * 油价
     */
    private BigDecimal oilPrice;

    /**
     * 税点
     */
    private BigDecimal taxPoint;

    /**
     * 重车司机提成
     */
    private BigDecimal loadedDriverPercentage;

    /**
     * 空车司机提成
     */
    private BigDecimal emptyDriverPercentage;

    /**
     * 重车油耗
     */
    private BigDecimal loadedOilConsumption;

    /**
     * 空车油耗
     */
    private BigDecimal emptyOilConsumption;

    /**
     * 固定成本均摊
     */
    private BigDecimal fixedCost;

    /**
     * 账期成本
     */
    private BigDecimal billCost;

    /**
     * 资金成本
     */
    private BigDecimal fundCost;

    /**
     * 尿素价格
     */
    private BigDecimal ureaPrice;

    /**
     * 百公里尿素消耗
     */
    private BigDecimal ureaConsumption;

    /**
     * 承兑成本比例
     */
    private BigDecimal settleRate;

    /**
     * 单日人工成本
     */
    private BigDecimal personCost;

    /************************************ 中间过程部分 **********************************************/

    /**
     * ETC（元）
     */
    private BigDecimal etcCost;

    /**
     * 重车ETC（元）
     */
    private BigDecimal loadedEtcCost;

    /**
     * 空车ETC（元）
     */
    private BigDecimal emptyEtcCost;

    /**
     * 燃油（元） = 重车燃油（元） +  空车燃油（元）
     */
    private BigDecimal oilCost;

    /**
     * 重车燃油（元）
     */
    private BigDecimal loadedOilCost;

    /**
     * 空车燃油（元）
     */
    private BigDecimal emptyOilCost;

    /**
     * 尿素费（元） = 重车尿素费（元） + 空车尿素费（元）
     */
    private BigDecimal ureaCost;

    /**
     * 重车尿素费
     */
    private BigDecimal loadedUreaCost;

    /**
     * 空车尿素费
     */
    private BigDecimal emptyUreaCost;

    /**
     * 路桥费
     */
    private BigDecimal roadBridgeCost;

    /**
     * 重车路桥费
     */
    private BigDecimal loadedRoadBridgeCost;

    /**
     * 空车路桥费
     */
    private BigDecimal emptyRoadBridgeCost;

    /**
     * 货物重量
     */
    private BigDecimal goodsWeight;

    /**
     * 总里程
     */
    private BigDecimal totalMileage;

    /**
     * 重车里程
     */
    private BigDecimal loadedMileage;

    /**
     * 空车里程
     */
    private BigDecimal emptyMileage;

    /**
     * 空驶率
     */
    private BigDecimal emptyDriveRate;

    /**
     * 运行天数
     */
    private BigDecimal runDay;

    /**
     * 重车运行天数
     */
    private BigDecimal loadedRunDay;

    /**
     * 空车运行天数
     */
    private BigDecimal emptyRunDay;

    /**
     * 账期时长
     */
    private BigDecimal billCycle;

    /**
     * 垫付天数
     */
    private BigDecimal advanceDay;

    /************************************ 成本部分 **********************************************/

    /**
     * 车辆成本（元）
     */
    private BigDecimal carCost;

    /**
     * 司机成本（元）
     */
    private BigDecimal driverCost;

    /**
     * 重车司机成本（元）
     */
    private BigDecimal loadedDriverCost;

    /**
     * 空车司机成本（元）
     */
    private BigDecimal emptyDriverCost;

    /**
     * 自身成本（元）
     */
    private BigDecimal ownCost;

    /**
     * 账期成本（元）
     */
    private BigDecimal billingCycleCost;

    /**
     * 承兑成本（元）
     */
    private BigDecimal settleCost;

    /**
     * 固定成本均摊（元）
     */
    private BigDecimal fixedAmount;

    /**
     * 重车固定成本均摊（元）
     */
    private BigDecimal loadedFixedAmount;

    /**
     * 空车固定成本均摊（元）
     */
    private BigDecimal emptyFixedAmount;

    /**
     * 垫付成本（元）
     */
    private BigDecimal advanceCost;

    /**
     * 总成本（元）
     */
    private BigDecimal totalCost;

    /**
     * 重车成本（元）
     */
    private BigDecimal loadedCost;

    /**
     * 空车成本（元）
     */
    private BigDecimal emptyCost;

    /**
     * 变动成本（元）
     */
    private BigDecimal changeCost;

    /************************************ 利润部分 **********************************************/

    /**
     * 应收金额
     */
    private BigDecimal receivableAmount;

    /**
     * 应付金额
     */
    private BigDecimal payableAmount;

    /**
     * 不含税应收
     */
    private BigDecimal receiveWithoutTax;

    /**
     * 不含税应付
     */
    private BigDecimal payWithoutTax;

    /**
     * 车次业务利润（元）
     */
    private BigDecimal waybillCarProfit;

    /**
     * 车次业务利润率
     */
    private BigDecimal waybillCarProfitRate;


}
