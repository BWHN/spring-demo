package org.example.weiyuntong.tradehallgoodssource.vo;

import com.weiyuntong.module.bizcenter.dal.dataobject.refuserecord.RefuseRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.revokerecord.RevokeRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallprocess.TradehallProcessDO;
import com.weiyuntong.module.bizcenter.enums.CustomerTypeEnums;
import com.weiyuntong.module.bizcenter.enums.GoodsReportPriceStatusEnum;
import com.weiyuntong.module.bizcenter.enums.TaskOrderStatusTypeEnums;
import com.weiyuntong.module.fleetcenter.dal.dataobject.cardesc.CarDescDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 交易大厅-货源管理 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradehallGoodsSourceRespVO extends TradehallGoodsSourceBaseVO {

    @Schema(description = "主键id", example = "20485")
    private Long id;
    /**
     * 货物包装规格（sort_norm_type罐装/桶装/袋装/其它）
     */
    private String goodsSortNorm;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "货源报价列表")
    List<TradehallProcessDO> reportPriceList;

    private List<TradehallProcessDO> sendRevokedProcessDOList;

    private List<TradehallProcessDO> receiveRevokedProcessDOList;

    @Schema(description = "已确认报价列表")
    List<TradehallProcessDO> dealReportPriceList;

    @Schema(description = "待确认信息列表")
    List<TradehallProcessDO> waitReportPriceList;

    @Schema(description = "货源拒绝列表")
    List<RefuseRecordDO> goodsRefuseRecordList;

    @Schema(description = "撤销列表")
    List<RevokeRecordDO> revokeRecordList;

    @Schema(description = "车辆信息列表")
    private List<CarDescDO> carDescDOList;

    @Schema(description = "状态描述")
    private String processStatusDesc;

    @Schema(description = " 状态:0.待发布 1.已发布 .2.待报价 3.待接单4.待确认5.货主已拒绝6.货主已撤销7.待下发.8.已下发.9承运商已拒绝.10承运商已撤销")
    private TaskOrderStatusTypeEnums tradehallProcessStatus;

    @Schema(description = "用车记录列表")
    List<TradehallProcessDO> vehicleUsageList;

    @Schema(description = "货物级别id", example = "1")
    private String goodsLevelId;

    @Schema(description = "货物级别名称", example = "张三")
    private String goodsLevel;

    @Schema(description = "上游是否需要开票",example = "false")
    private String upperNeedInvoiceTips;

    @Schema(description = "存在已拒绝信息/存在已撤销信息")
    private String tips;

    @Schema(description = "是否存在发起方已拒绝")
    public Boolean getExistSendRefused() {
        return existStatus(GoodsReportPriceStatusEnum.TO_SEND_REFUSED);
    }

    @Schema(description = "是否存在接单方已拒绝")
    public Boolean getExistReceiveRefused() {
        return existStatus(GoodsReportPriceStatusEnum.TO_RECEIVE_REFUSED);
    }
    @Schema(description = "是否存在发起方已撤销")
    public Boolean getExistSendRevoked() {
        return existStatus(GoodsReportPriceStatusEnum.TO_SEND_REVOKED);
    }

    @Schema(description = "是否存在接单方已撤销")
    public Boolean getExistReceiveRevoked() {
        return existStatus(GoodsReportPriceStatusEnum.TO_RECEIVE_REVOKED);
    }

    private Boolean existStatus(GoodsReportPriceStatusEnum status) {
        if (reportPriceList != null) {
            for (TradehallProcessDO tradehallProcessDO : reportPriceList) {
                if (tradehallProcessDO.getProcessStatus().equals(status)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Schema(description = "运输距离")
    private BigDecimal transportDistance;

    private BigDecimal addressDistance;

    @Schema(description = "托运人企业类型")
    private CustomerTypeEnums consignorEntType;

    @Schema(description = "是否收藏")
    private Boolean hasFavorites;

    @Schema(description = "待确认数量")
    private Integer toConfirmedNum;
}
