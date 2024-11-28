package org.example.weiyuntong.home.vo;

import com.weiyuntong.module.datacenter.controller.admin.billreport.vo.CustomerCount;
import lombok.Data;

@Data
public class CustomerChartVO {

    // 客户数
    private Long customerNum;
    // 新增客户数
    private Long newCustomerNum;
    // 承运商数
    private Long consignorNum;
    // 新增承运商数
    private Long newConsignorNum;
    // 图表
    private CustomerCount customerCount;
    // 去年/上月数据
    private CustomerChartVO preCustomerChart;

    public CustomerChartVO(Long customerNum, Long newCustomerNum, Long consignorNum, Long newConsignorNum) {
        this.customerNum = customerNum;
        this.newCustomerNum = newCustomerNum;
        this.consignorNum = consignorNum;
        this.newConsignorNum = newConsignorNum;
    }
}
