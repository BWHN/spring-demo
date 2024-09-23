package org.example.weiyuntong.billpay;

import cn.hutool.json.JSONUtil;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.billpay.vo.*;
import com.weiyuntong.module.bizcenter.convert.billpay.BillPayConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.billpay.BillPayDO;
import com.weiyuntong.module.bizcenter.service.billpay.BillPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "管理后台 - 登记收付款")
@RestController
@RequestMapping("/bizcenter/bill-pay")
@Validated
public class BillPayController {

    @Resource
    private BillPayService billPayService;

    @PostMapping("/create")
    @Operation(summary = "创建登记收付款")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay:create')")
    public CommonResult<Long> createBillPay(@Valid String createReqVO, @RequestParam("imgs") MultipartFile[] imgs) throws IOException {
        BillPayCreateReqVO billPayCreateReqVO = JSONUtil.toBean(createReqVO, BillPayCreateReqVO.class);
        return success(billPayService.createBillPay(billPayCreateReqVO,imgs));
    }

    @PutMapping("/update")
    @Operation(summary = "更新登记收付款")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay:update')")
    public CommonResult<Boolean> updateBillPay(@Valid @RequestBody BillPayUpdateReqVO updateReqVO) {
        billPayService.updateBillPay(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除登记收付款")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay:delete')")
    public CommonResult<Boolean> deleteBillPay(@RequestParam("id") Long id) {
        billPayService.deleteBillPay(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得登记收付款")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay:query')")
    public CommonResult<BillPayRespVO> getBillPay(@RequestParam("id") Long id) {
        BillPayDO billPay = billPayService.getBillPay(id);
        return success(BillPayConvert.INSTANCE.convert(billPay));
    }

    @GetMapping("/list")
    @Operation(summary = "获得登记收付款列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay:query')")
    public CommonResult<List<BillPayRespVO>> getBillPayList(@RequestParam("ids") Collection<Long> ids) {
        List<BillPayDO> list = billPayService.getBillPayList(ids);
        return success(BillPayConvert.INSTANCE.convertList(list));
    }

    @PostMapping("/page")
    @Operation(summary = "获得登记收付款分页")
    public CommonResult<PageResult<BillPayRespVO>> getBillPayPage(@RequestBody @Valid BillPayPageReqVO pageVO) {
        pageVO.setCreator(WebFrameworkUtils.getLoginUserId());
        PageResult<BillPayDO> pageResult = billPayService.getBillPayPage(pageVO);
        PageResult<BillPayRespVO> respVOPageResult =  BillPayConvert.INSTANCE.convertPage(pageResult);
//        for(BillPayRespVO item:respVOPageResult.getList()){
//            //item.setRemainAmount(BigDecimalUtil.subtract(item.getReceivablesAmount(), item.getPaidAmount()));
//        }
        return success(respVOPageResult);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出登记收付款 Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:bill-pay:export')")
    @OperateLog(type = EXPORT)
    public void exportBillPayExcel(@Valid BillPayExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<BillPayDO> list = billPayService.getBillPayList(exportReqVO);
        // 导出 Excel
        List<BillPayExcelVO> datas = BillPayConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "登记收付款.xls", "数据", BillPayExcelVO.class, datas);
    }

}
