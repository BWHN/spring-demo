package org.example.weiyuntong.userpayaccount;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.module.bizcenter.controller.admin.userbankaccount.vo.UserBankAccountPageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.userbankaccount.vo.UserBankAccountRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.userpayaccount.vo.UserPayAccountCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.userpayaccount.vo.UserPayAccountPageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.userpayaccount.vo.UserPayAccountPageRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.userpayaccount.vo.UserPayAccountUpdateReqVO;
import com.weiyuntong.module.bizcenter.convert.userbankaccount.UserBankAccountConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.userbankaccount.UserBankAccountDO;
import com.weiyuntong.module.bizcenter.service.userpayaccout.UserPayAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

@Tag(name = "用户付款账户信息管理")
@RestController
@RequestMapping("/bizcenter/user-pay-account")
@Validated
public class UserPayAccountController {

    @Resource
    private UserPayAccountService userPayAccountService;

    @PostMapping("/create")
    @Operation(summary = "创建付款账户信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:user-pay-account:create')")
    public CommonResult<Long> create(@Valid @RequestBody UserPayAccountCreateReqVO createReqVO) {
        return userPayAccountService.create(createReqVO);
    }

    @PutMapping("/update")
    @Operation(summary = "更新付款账户信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:user-pay-account:update')")
    public CommonResult<Long> update(@Valid @RequestBody UserPayAccountUpdateReqVO updateReqVO) {
        return userPayAccountService.update(updateReqVO);
    }

    @GetMapping("/defaultAccount")
    @Operation(summary = "设置默认账户")
    @PreAuthorize("@ss.hasPermission('bizcenter:user-pay-account:defaultAccount')")
    public CommonResult<Boolean> defaultAccount(Long id) {
        userPayAccountService.defaultAccount(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获得付款账户信息分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:user-pay-account:page')")
    public CommonResult<PageResult<UserPayAccountPageRespVO>> page(@Valid UserPayAccountPageReqVO pageVO) {
        return success(userPayAccountService.page(pageVO));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除付款账户信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:user-bank-account:delete')")
    public CommonResult<Boolean> delete(@RequestParam("id") Long id) {
        userPayAccountService.delete(id);
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "获得付款账户信息列表")
    @PreAuthorize("@ss.hasPermission('bizcenter:user-pay-account:list')")
    public CommonResult<List<UserPayAccountPageRespVO>> list(@RequestParam(required = false) String accountNumber,
                                                             @RequestParam(required = false) Integer onlineStatus) {
        return success(userPayAccountService.list(accountNumber, onlineStatus));
    }

}
