package org.example.weiyuntong.home;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.util.string.StringUtil;
import com.weiyuntong.framework.datapermission.core.annotation.DataPermission;
import com.weiyuntong.framework.tenant.core.context.TenantContextHolder;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.home.vo.*;
import com.weiyuntong.module.bizcenter.service.home.HomeService;
import com.weiyuntong.module.bizcenter.service.transporttaskentrustorder.TransportTaskEntrustorderService;
import com.weiyuntong.module.bizcenter.service.transporttaskorder.TransportTaskOrderService;
import com.weiyuntong.module.opecenter.controller.admin.capacity.vo.CapacityUserVO;
import com.weiyuntong.module.system.dal.dataobject.enterprise.EnterpriseDO;
import com.weiyuntong.module.system.dal.dataobject.permission.RoleDO;
import com.weiyuntong.module.system.enums.permission.DataScopeEnum;
import com.weiyuntong.module.system.service.enterprise.EnterpriseService;
import com.weiyuntong.module.system.service.permission.RoleService;
import com.weiyuntong.module.system.service.user.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "管理后台 - 首页")
@RestController
@RequestMapping("/bizcenter/home")
public class HomeController {

    @Resource
    private TransportTaskOrderService transportTaskOrderService;
    @Resource
    private TransportTaskEntrustorderService transportTaskEntrustorderService;
    @Resource
    private AdminUserService adminUserService;
    @Resource
    private RoleService roleService;
    @Resource
    private EnterpriseService enterpriseService;
    @Resource
    private HomeService homeService;

    @RequestMapping("/getTaskCount")
    @DataPermission(enable = true)
    public CommonResult getTaskCount(String createDate) {
        TaskCountVO taskCountVO = new TaskCountVO();
        List<RoleDO> roleList = roleService.getUserRoleByUserId(WebFrameworkUtils.getLoginUserId());
        List<String> roleNameList = new ArrayList<>();
        roleList.forEach(item -> {
            roleNameList.add(item.getName());
        });

        taskCountVO.setRoleName(StringUtil.join(roleNameList));

        Long tenantId = TenantContextHolder.getTenantId();
        EnterpriseDO enterpriseDO = enterpriseService.getEnterprise(tenantId);
        if (enterpriseDO != null) {
            taskCountVO.setEntName(enterpriseDO.getName());
        }

        TaskCountReqVO reqVO = new TaskCountReqVO();
        reqVO.setCreateDate(createDate);
        if (!adminUserService.containsDataScope(DataScopeEnum.ALL)) {
            if (adminUserService.containsDataScope(DataScopeEnum.DEPT_AND_CHILD, DataScopeEnum.DEPT_CUSTOM, DataScopeEnum.DEPT_ONLY)) {
                reqVO.setDeptList(adminUserService.getMyDeptByDataScope());
            } else {
                reqVO.setCreator(WebFrameworkUtils.getLoginUserId());
            }
        }

        taskCountVO.setAssignWeight(transportTaskOrderService.getAssignWeight(reqVO));
        taskCountVO.setEntrustWeight(transportTaskEntrustorderService.getEntrustWeight(reqVO));
        taskCountVO.setAcceptWeight(transportTaskEntrustorderService.getAcceptWeight(reqVO));
        return CommonResult.success(taskCountVO);
    }

    @RequestMapping("/getToDoCount")
    @Operation(summary = "获取我的代办统计")
    public CommonResult<List<ToDoCountVO>> getToDoCount() {
        return CommonResult.success(homeService.getToDoCount());
    }

    @RequestMapping("/capacity-summary")
    @Operation(summary = "获取运力统计")
    public CommonResult<CapacityUserVO> getCapacityUserVO(ChartQueryReqVO reqVO) {
        return CommonResult.success(homeService.capacitySummary(reqVO));
    }

    @RequestMapping("/getFinanceChart")
    @Operation(summary = "获取财务经营图表")
    public CommonResult<FinanceChartVO> getFinanceChart(ChartQueryReqVO reqVO) {
        return CommonResult.success(homeService.getFinanceChart(reqVO));
    }

    @RequestMapping("/getExpenseChart")
    @Operation(summary = "获取业务数据图表")
    public CommonResult<ExpenseChartVO> getExpenseChart(ChartQueryReqVO reqVO) {
        return CommonResult.success(homeService.getExpenseChart(reqVO));
    }

    @RequestMapping("/getCustomerChart")
    @Operation(summary = "获取客商数据图表")
    public CommonResult<CustomerChartVO> getCustomerChart(ChartQueryReqVO reqVO) {
        return CommonResult.success(homeService.getCustomerChart(reqVO));
    }

}
