package org.example.weiyuntong.billcontacts;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.billcontacts.vo.*;
import com.weiyuntong.module.bizcenter.convert.billcontacts.BillContactsConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.billcontacts.BillContactsDO;
import com.weiyuntong.module.bizcenter.service.billcontacts.BillContactsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "管理后台 - 账单联系人")
@RestController
@RequestMapping("/bizcenter/bill-contacts")
@Validated
public class BillContactsController {

    @Resource
    private BillContactsService billContactsService;

    @PostMapping("/create")
    @Operation(summary = "创建账单联系人")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:create')")
    public CommonResult<Long> createBillContacts(@Valid @RequestBody BillContactsCreateReqVO createReqVO) {
        return success(billContactsService.createBillContacts(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新账单联系人")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:update')")
    public CommonResult<Boolean> updateBillContacts(@Valid @RequestBody BillContactsUpdateReqVO updateReqVO) {
        billContactsService.updateBillContacts(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除账单联系人")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:delete')")
    public CommonResult<Boolean> deleteBillContacts(@RequestParam("id") Long id) {
        billContactsService.deleteBillContacts(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得账单联系人")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:query')")
    public CommonResult<BillContactsRespVO> getBillContacts(@RequestParam("id") Long id) {
        BillContactsDO billContacts = billContactsService.getBillContacts(id);
        return success(BillContactsConvert.INSTANCE.convert(billContacts));
    }

    @GetMapping("/list")
    @Operation(summary = "获得账单联系人列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:query')")
    public CommonResult<List<BillContactsRespVO>> getBillContactsList(@RequestParam("ids") Collection<Long> ids) {
        List<BillContactsDO> list = billContactsService.getBillContactsList(ids);
        return success(BillContactsConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得账单联系人分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:query')")
    public CommonResult<PageResult<BillContactsRespVO>> getBillContactsPage(@Valid BillContactsPageReqVO pageVO) {
        PageResult<BillContactsDO> pageResult = billContactsService.getBillContactsPage(pageVO);
        return success(BillContactsConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出账单联系人 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-contacts:export')")
    @OperateLog(type = EXPORT)
    public void exportBillContactsExcel(@Valid BillContactsExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BillContactsDO> list = billContactsService.getBillContactsList(exportReqVO);
        // 导出 Excel
        List<BillContactsExcelVO> datas = BillContactsConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "账单联系人.xls", "数据", BillContactsExcelVO.class, datas);
    }

}
