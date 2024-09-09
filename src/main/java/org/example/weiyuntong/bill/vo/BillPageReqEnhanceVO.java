package org.example.weiyuntong.bill.vo;

import com.weiyuntong.framework.common.util.StringUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Schema(description = "管理后台 - 开票列表 增加 查询条件")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BillPageReqEnhanceVO extends BillPageReqVO {

    @Schema(description = "发票抬头", example = "xxx公司")
    private String invoiceTitle;

    @Schema(description = "发票号", example = "")
    private String invoiceSn;

    @Schema(description = "搜索开票日期开始 yyyy-MM-dd")
    private String invoiceDateStart;

    @Schema(description = "搜索开票日期结束 yyyy-MM-dd")
    private String invoiceDateEnd;

    @Schema(description = "搜索开票登记日期开始 yyyy-MM-dd")
    private String createTimeInvoiceStart;

    @Schema(description = "搜索开票登记日期结束 yyyy-MM-dd")
    private String createTimeInvoiceEnd;


    public String getInvoiceDateStart() {
        if (StringUtil.isEmpty(invoiceDateStart)) {
            return null;
        }
        return invoiceDateStart + " 00:00:00";
    }

    public String getInvoiceDateEnd() {
        if (StringUtil.isEmpty(invoiceDateEnd)) {
            return null;
        }
        return invoiceDateEnd + " 23:59:59";
    }

    public String getCreateTimeInvoiceStart() {
        if (StringUtil.isEmpty(createTimeInvoiceStart)) {
            return null;
        }
        return createTimeInvoiceStart + " 00:00:00";
    }

    public String getCreateTimeInvoiceEnd() {
        if (StringUtil.isEmpty(createTimeInvoiceEnd)) {
            return null;
        }
        return createTimeInvoiceEnd + " 23:59:59";
    }

}
