package org.example.weiyuntong.tradehallgoodssource;

import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.tradehall.*;
import com.weiyuntong.module.bizcenter.controller.admin.transportorder.vo.TransportOrderCountVO;
import com.weiyuntong.module.bizcenter.service.tradehallgoodssource.TradeHallService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;


@Tag(name = "平台大厅")
@RestController
@RequestMapping("/bizcenter/trade-hall")
public class TradeHallController {

    @Resource
    private TradeHallService tradeHallService;

    @GetMapping("/page")
    @Operation(summary = "平台大厅分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:page')")
    public CommonResult<PageResult<TradeHallPageResVO>> page(TradeHallPageReqVO pageReqVO) {
        return success(tradeHallService.page(pageReqVO));
    }

    @GetMapping("/summary")
    @Operation(summary = "平台大厅统计")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:summary')")
    public CommonResult<TradeHallSummaryVO> summary(TradeHallPageReqVO pageReqVO) {
        return success(tradeHallService.summary(pageReqVO));
    }

    @GetMapping("/order-page")
    @Operation(summary = "接单管理分页")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-page')")
    public CommonResult<PageResult<TradeHallOrderPageResVO>> orderPage(TradeHallOrderPageReqVO pageReqVO) {
        return success(tradeHallService.orderPage(pageReqVO));
    }

    @GetMapping("/order-summary")
    @Operation(summary = "接单管理统计")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-summary')")
    public CommonResult<TransportOrderCountVO> orderSummary() {
        return success(tradeHallService.orderSummary(true));
    }

    @GetMapping("/order-detail")
    @Operation(summary = "接单详情")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-detail')")
    public CommonResult<TradeHallOrderDetailVO> orderDetail(Long id) {
        return success(tradeHallService.orderDetail(id));
    }

    @GetMapping("/order-take-detail")
    @Operation(summary = "我要接单详情页面")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-detail')")
    public CommonResult<TradeHallOrderTakeVO> orderTakeDetail(Long id) {
        return success(tradeHallService.orderTakeDetail(id));
    }

    @PostMapping("/order-take-save")
    @Operation(summary = "接单保存")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-save')")
    public CommonResult<List<Long>> orderTakeSave(@RequestBody TradeHallOrderProcessSubmitDTO submitDTO) {
        return success(tradeHallService.orderTakeSave(submitDTO, WebFrameworkUtils.getEntId()));
    }

    @PostMapping("/order-take-save-extra")
    @Operation(summary = "接单保存额外信息")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-save')")
    public CommonResult<Boolean> orderTakeSaveExtra(@RequestBody TradeHallOrderProcessExtraDTO saveDTO) {
        return success(tradeHallService.orderTakeSaveExtra(saveDTO));
    }

    @PostMapping("/order-take-submit")
    @Operation(summary = "接单提交")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-submit')")
    public CommonResult<Boolean> orderTakeSubmit(@RequestBody List<Long> ids) {
        return tradeHallService.orderTakeSubmit(ids);
    }

    @PostMapping("/order-take-revoke")
    @Operation(summary = "接单撤回")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-revoke')")
    public CommonResult<Boolean> orderTakeRevoke(@RequestBody List<Long> ids) {
        return success(tradeHallService.orderTakeRevoke(ids));
    }

    @PostMapping("/order-take-delete")
    @Operation(summary = "接单删除")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-delete')")
    public CommonResult<Boolean> orderTakeDelete(@RequestBody List<Long> ids) {
        return success(tradeHallService.orderTakeDelete(ids));
    }

    @GetMapping("/order-take-refuse")
    @Operation(summary = "接单放弃")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-refuse')")
    public CommonResult<Boolean> orderTakeRefuse(Long id) {
        return success(tradeHallService.orderTakeRefuse(id));
    }


    /**
     * 小程序司机扫码接单相关接口  ⬇️⬇️⬇️⬇️⬇️⬇️⬇️
     */
    @GetMapping("/app/order-detail/{id}")
    @Operation(summary = "app - 接单详情")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-detail')")
    public CommonResult<AppTradeHallOrderTakeVO> appOrderDetail(@PathVariable Long id) {
        return success(tradeHallService.appOrderDetail(id));
    }


    @PostMapping("/app/order-take-save")
    @Operation(summary = "app - 司机扫码接单")
    @PreAuthorize("@ss.hasPermission('bizcenter:trade-hall:order-take-save')")
    public CommonResult<Object> appOrderTakeSave(@RequestBody AppTradeHallOrderProcessSubmitDTO appSubmitDTO) {
        return tradeHallService.appOrderTakeSave(appSubmitDTO, WebFrameworkUtils.getEntId());
    }




}
