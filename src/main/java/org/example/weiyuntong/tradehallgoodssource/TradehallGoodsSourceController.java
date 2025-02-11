package org.example.weiyuntong.tradehallgoodssource;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodsreportprice.vo.TradehallGoodsReportPriceCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.*;
import com.weiyuntong.module.bizcenter.convert.tradehallgoodssource.TradehallGoodsSourceConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallgoodssource.TradehallGoodsSourceDO;
import com.weiyuntong.module.bizcenter.service.tradehallgoodsreportprice.TradehallGoodsReportPriceService;
import com.weiyuntong.module.bizcenter.service.tradehallgoodssource.TradehallGoodsSourceService;
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
import java.util.Map;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;

@Tag(name = "货源交易大厅-货源看板")
@RequestMapping("/bizcenter/tradehall-goods")
@Validated
public class TradehallGoodsSourceController {

    @Resource
    private TradehallGoodsSourceService tradehallGoodsSourceService;
    @Resource
    TradehallGoodsReportPriceService reportPriceService;
    @PostMapping("/create")
    @Operation(summary = "货源交易大厅-创建货源管理")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:create')")
    public CommonResult<Long> createTradehallGoodsSource(@Valid @RequestBody TradehallGoodsSourceCreateReqVO createReqVO) {
        return success(tradehallGoodsSourceService.createTradehallGoodsSource(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "货源交易大厅-修改货源信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:update')")
    public CommonResult<Boolean> updateTradehallGoodsSource(@Valid @RequestBody TradehallGoodsSourceUpdateReqVO updateReqVO) {
        tradehallGoodsSourceService.updateTradehallGoodsSource(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "货源交易大厅-删除货源")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:delete')")
    public CommonResult<Boolean> deleteTradehallGoodsSource(@RequestParam("id") Long id) {
        tradehallGoodsSourceService.deleteTradehallGoodsSource(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "货源交易大厅-货源详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<TradehallGoodsSourceRespVO> getTradehallGoodsSource(@RequestParam("id") Long id) {
        TradehallGoodsSourceDO tradehallGoodsSource = tradehallGoodsSourceService.getTradehallGoodsSource(id);
        //货源报价详情
        tradehallGoodsSource.setReportPriceList(reportPriceService.getGoodsReportPriceListByGoodsId(id));
        return success(TradehallGoodsSourceConvert.INSTANCE.convert(tradehallGoodsSource));
    }

    @GetMapping("/list")
    @Operation(summary = "货源交易大厅-货源列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<List<TradehallGoodsSourceRespVO>> getTradehallGoodsSourceList(@RequestParam("ids") Collection<Long> ids) {
        List<TradehallGoodsSourceDO> list = tradehallGoodsSourceService.getTradehallGoodsSourceList(ids);
        return success(TradehallGoodsSourceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "货源交易大厅-货源列表分页查询")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<PageResult<TradehallGoodsSourceRespVO>> getTradehallGoodsSourcePage(@Valid TradehallGoodsSourcePageReqVO pageVO) {
        PageResult<TradehallGoodsSourceDO> pageResult = tradehallGoodsSourceService.getTradehallGoodsSourcePage(pageVO);
        return success(TradehallGoodsSourceConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "货源交易大厅-货源导出Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:export')")
    @OperateLog(type = EXPORT)
    public void exportTradehallGoodsSourceExcel(@Valid TradehallGoodsSourceExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TradehallGoodsSourceDO> list = tradehallGoodsSourceService.getTradehallGoodsSourceList(exportReqVO);
        // 导出 Excel
        List<TradehallGoodsSourceExcelVO> datas = TradehallGoodsSourceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "交易大厅-货源管理.xls", "数据", TradehallGoodsSourceExcelVO.class, datas);
    }

    @PostMapping("/quotedprice")
    @Operation(summary = "货源交易大厅-货源报价")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:quotedprice')")
    public CommonResult<Boolean> quotedPrice(@Valid @RequestBody TradehallGoodsReportPriceCreateReqVO createReqVO) {
        tradehallGoodsSourceService.quotedPrice(createReqVO);
        return success(true);
    }

    @PostMapping("/goods-statistical")
    @Operation(summary = "货源交易大厅-货源统计")
    @Parameter(name = "tenantId", description = "企业id")
    @Parameter(name = "userId", description = "用户id")
    public CommonResult<Map<String,Object>> goodsStatistic(@RequestBody Map<String,Object> paramMap) {
        return success(tradehallGoodsSourceService.goodsStatistic(paramMap));
    }
}
