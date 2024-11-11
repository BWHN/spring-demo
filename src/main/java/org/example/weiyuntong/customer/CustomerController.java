package org.example.weiyuntong.customer;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.datapermission.core.annotation.DataPermission;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.customer.vo.*;
import com.weiyuntong.module.bizcenter.convert.customer.CustomerConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.customer.CustomerDO;
import com.weiyuntong.module.bizcenter.manager.QccEnterprise;
import com.weiyuntong.module.bizcenter.manager.QccManager;
import com.weiyuntong.module.bizcenter.service.customer.CustomerService;
import com.weiyuntong.module.bizcenter.service.customercontacts.CustomerContactsService;
import com.weiyuntong.module.bizcenter.service.customercreditchange.CustomerCreditChangeService;
import com.weiyuntong.module.bizcenter.service.customerline.CustomerLineService;
import com.weiyuntong.module.system.controller.admin.enterpriseusedinfo.vo.EnterpriseUsedInfoRespVO;
import com.weiyuntong.module.system.enums.EnterpriseTypeEnum;
import com.weiyuntong.module.system.service.enterpriseusedinfo.EnterpriseUsedInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;


@Tag(name = "业务中心 - 客户管理")
@RestController
@RequestMapping("/bizcenter/customer/")
@Validated
public class CustomerController {

    @Resource
    private CustomerService customerService;
    @Resource
    private CustomerCreditChangeService customerCreditChangeService;
    @Resource
    private CustomerLineService customerLineService;
    @Resource
    private CustomerContactsService customerContactsService;
    @Resource
    private QccManager qccManager;
    @Resource
    private EnterpriseUsedInfoService enterpriseUsedInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建客户")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:create')")
    @Idempotent(timeout = 3, message = "正在处理，请稍等")
    public CommonResult<Long> create(@Valid @RequestBody CustomerCreateReqVO createReqVO) {
        return success(customerService.create(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新客户")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:update')")
    public CommonResult<Boolean> update(@RequestBody CustomerBaseVO updateReqVO) throws IllegalAccessException {
        customerService.update(updateReqVO);
        return success(true);
    }

    @GetMapping("/getRealMobile")
    @Operation(summary = "获取脱敏后的数据")
    @Idempotent(timeout = 3, timeUnit = TimeUnit.SECONDS, message = "您点击的太频繁了，请休息三秒钟")
    @Parameter(name = "id", description = "企业id", required = true, example = "1024")
    @Parameter(name = "route", description = "查看路径", required = true, example = "车次列表-详情-车源负责人；")
    public CommonResult<Map<String,String>> getRealMobile(@RequestParam("id") Long id, @RequestParam("route") String route) {
        return success(customerService.getRealMobile(id, route));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除客户")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:delete')")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        customerService.delete(id);
        return success(true);
    }

    @GetMapping("/getNine")
    @Operation(summary = "九宫格数据统计")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<Map<String, List<CustomerDO>>> get() {
        return success(customerService.getCustomergetNine());
    }

    @GetMapping("/get")
    @Operation(summary = "获得客户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<CustomerRespVO> get(@RequestParam("id") Long id) {
        CustomerDO customerDO = customerService.get(id);
        CustomerRespVO convert = CustomerConvert.INSTANCE.convert(customerDO);
        customerCreditChangeService.getCustomerCreditChangeList(convert.getId());
        convert.setCustomerContactsDOS(customerContactsService.getCustomerContactsList(id));
        convert.setCustomerLineDOS(customerLineService.getCustomerLineList(id));
        EnterpriseUsedInfoRespVO enterpriseUsedInfo = enterpriseUsedInfoService.getEnterpriseUsedInfo(customerDO.getId(), EnterpriseTypeEnum.ENTERPRISE_CUSTOMER);
        if (enterpriseUsedInfo != null){
            convert.setEnterpriseUsedInfo(enterpriseUsedInfo);
        }
        return success(convert);
    }

    @GetMapping("/customer-users")
    @Operation(summary = "获得客户编码")
    public CommonResult<List<CustomerUserRespDTO>> getCustomerUsers(Long id) {
        return success(customerService.getCustomerUsers(id));
    }

    @GetMapping("/getCode")
    @Operation(summary = "获得客户编码")
    public CommonResult<String> getCode() {
        return success(customerService.getCode());
    }


    @GetMapping("/updateCustomerEnable")
    @Operation(summary = "更改用户是否启用")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:updateCustomerEnable')")
    public CommonResult<Boolean> updateCustomerEnable(@RequestParam("id") Long id,@RequestParam("status")Integer status) {
        customerService.updateCustomerEnable(id, status);
        return success(true);
    }


    @PostMapping("/pageFind")
    @Operation(summary = "条件查询获得客户分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<PageResult<CustomerRespVO>> getCustomerPageFind(@Valid @RequestBody CustomerFindVO customerFindVO) {
        PageResult<CustomerDO> pageResult = customerService.getCustomerPageFind(customerFindVO);
        return success(CustomerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/list")
    @Operation(summary = "获得客户列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<List<CustomerRespVO>> getList(@RequestParam("ids") Collection<Long> ids) {
        List<CustomerDO> list = customerService.getList(ids);
        return success(CustomerConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/allList")
    @Operation(summary = "关联货主中的客户列表")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<List<CustomerLinkInfoVO>> allList() {
        List<CustomerLinkInfoVO> customerLinkInfoVOS = customerService.allList();
        return success(customerLinkInfoVOS);
    }

    @GetMapping("/statusCustomerList")
    @Operation(summary = "客户首页沙漏（按照客户状态分类）客户列表")
    public CommonResult<Map<String, Long>> statusCustomerList() {
        return success(customerService.statusCustomerList());
    }

    @GetMapping("/typeCustomerList")
    @Operation(summary = "客户首页沙漏（按照客户类型分类）客户列表")
    public CommonResult<Map<String, Long>> typeCustomerList() {
        return success(customerService.typeCustomerList());
    }

    @GetMapping("/pages")
    @Operation(summary = "获得客户分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    @DataPermission(enable = true)
    public CommonResult<PageResult<CustomerRespVO>> getPage(@Valid CustomerPageReqVO pageVO) {
        PageResult<CustomerDO> pageResult = customerService.getPage(pageVO);
        return success(CustomerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/page")
    @Operation(summary = "获得客户分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<PageResult<CustomerRespVO>> getPages(@Valid CustomerPageReqVO pageVO) {
        PageResult<CustomerDO> pageResult = customerService.getPages(pageVO);
        return success(CustomerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/getCustomerLoansMoney")
    @Operation(summary = "刷新逾期金额")
    public CommonResult<PageResult<CustomerRespVO>> getCustomerLoansMoney(@Valid CustomerPageReqVO pageVO) {
        customerService.getCustomerLoansMoney();
        PageResult<CustomerDO> pageResult = customerService.getPage(pageVO);
        return success(CustomerConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/allCustomerList")
    @Operation(summary = "获得所有客户承运商列表")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<List<CustomerRespVO>> allCustomerList() {
        return success(customerService.allCustomerList());
    }

    @GetMapping("/allCustomer")
    @Operation(summary = "获得所有客户")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:query')")
    public CommonResult<List<CustomerRespVO>> allCustomer() {
        return success(customerService.allCustomer());
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出客户 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:customer:export')")
    @OperateLog(type = EXPORT)
    public void exportExcel(@Valid CustomerExportReqVO exportReqVO,
                            HttpServletResponse response) throws IOException {
        List<CustomerDO> list = customerService.getList(exportReqVO);
        // 导出 Excel
        List<CustomerExcelVO> datas = CustomerConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "客户.xls", "数据", CustomerExcelVO.class, datas);
    }

    @GetMapping("/searchEnterprise")
    @Operation(summary = "查询企查查企业信息")
    public CommonResult<List<QccEnterprise>> searchEnterprise(String keyword) {
        return success(qccManager.searchEnterprise(keyword));
    }

}
