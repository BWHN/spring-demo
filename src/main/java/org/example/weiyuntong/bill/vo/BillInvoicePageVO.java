package org.example.weiyuntong.bill.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillInvoiceStatusEnum;
import com.weiyuntong.module.bizcenter.dal.dataobject.bill.BillStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.weiyuntong.framework.common.util.date.DateUtils.FORMAT_HOUR_MINUTE_SECOND;

/**
 * 开票登记 返回用实体类
 */

@Data
public class BillInvoicePageVO {

    @Schema(description = "账单表主键id")
    private Long id;

    @Schema(description = "账单编号")
    private String billNo;

    @Schema(description = "托运人", example = "山东化链云科技有限公司")
    private String consignor;

    @Schema(description = "承运人", example = "陕西原池物流有限公司")
    private String carrier;

    @Schema(description = "发票抬头")
    @TableField(exist = false)
    private String invoiceTitle;

    @Schema(description = "税号")
    private String taxNum;

    @Schema(description = "应开票金额")
    private BigDecimal invoiceAmount;

    @Schema(description = "登记开票金额")
    private BigDecimal registerInvoiceAmount;

    // 当前发票分配给这个订单的金额
    @Schema(description = "本次开票金额")
    private BigDecimal nowInvoiceAmount;

    // 剩余开票金额 = 应开票金额 - 登记开票金额
    @Schema(description = "剩余开票金额")
    private BigDecimal surplusInvoiceAmount;

    @Schema(description = "创建者姓名", example = "小有可维")
    private String creatorName;

    @Schema(description = "账单创建时间")
    private String createTime;

    // 增加字段
    @Schema(description = "账单状态", example = "2")
    private BillStatusEnum billStatus;


    @Schema(description = "开票日期")
    @DateTimeFormat(pattern = FORMAT_HOUR_MINUTE_SECOND)
    private LocalDate invoiceDate;

    // 加入 已开发票返回字段
    @Schema(description = "发票代码")
    private String invoiceSn;

    @Schema(description = "电话号")
    private String phone;

    // bbi 表数据的穿件日期
    @Schema(description = "登记日期")
    private String invoiceCreateTime;

    @Schema(description = "开票状态")
    private BillInvoiceStatusEnum invoiceStatus;

    @Schema(description = "申请时间", example = "2023-8-22 11:31:20")
    private LocalDateTime applyTime;

    @Schema(description = "结算金额")
    private BigDecimal settleAmount;

    @Schema(description = "结束开票 0：否 1：是")
    private Integer finishInvoice;

}
