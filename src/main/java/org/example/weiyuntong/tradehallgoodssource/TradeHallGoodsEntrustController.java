package org.example.weiyuntong.tradehallgoodssource;

import cn.hutool.core.util.ObjectUtil;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.common.util.date.LocalDateTimeUtils;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.framework.tenant.core.context.TenantContextHolder;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.refuserecord.vo.RefuseRecordRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.revokerecord.vo.RevokeRecordRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodsreportprice.vo.TradehallGoodsReportPriceCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.*;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallprocess.vo.MyEntrustReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallprocess.vo.MyEntrustRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallprocess.vo.TradehallProcessPageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallprocess.vo.TradehallProcessRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.transporttaskentrustorder.vo.*;
import com.weiyuntong.module.bizcenter.convert.refuserecord.RefuseRecordConvert;
import com.weiyuntong.module.bizcenter.convert.revokerecord.RevokeRecordConvert;
import com.weiyuntong.module.bizcenter.convert.tradehallprocess.TradehallProcessConvert;
import com.weiyuntong.module.bizcenter.convert.transporttaskentrustorder.TransportTaskEntrustorderConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.customer.CustomerDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.refuserecord.RefuseRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.revokerecord.RevokeRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallcarsource.TradehallCarSourceDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallprocess.TradehallProcessDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.*;
import com.weiyuntong.module.bizcenter.service.carconfig.CarConfigService;
import com.weiyuntong.module.bizcenter.service.customer.CustomerService;
import com.weiyuntong.module.bizcenter.service.favorites.FavoritesService;
import com.weiyuntong.module.bizcenter.service.refuserecord.RefuseRecordService;
import com.weiyuntong.module.bizcenter.service.revokerecord.RevokeRecordService;
import com.weiyuntong.module.bizcenter.service.tradehallcarsource.TradehallCarSourceService;
import com.weiyuntong.module.bizcenter.service.tradehallgoodssource.TradeHallGoodsEntrustService;
import com.weiyuntong.module.bizcenter.service.tradehallgoodssource.TransportGoodsEntrustorderService;
import com.weiyuntong.module.bizcenter.service.tradehallprocess.TradehallProcessService;
import com.weiyuntong.module.bizcenter.service.transporttaskentrustorder.TransportTaskEntrustorderService;
import com.weiyuntong.module.fleetcenter.dal.dataobject.carconfig.CarConfigDO;
import com.weiyuntong.module.fleetcenter.dal.dataobject.cardesc.CarDescDO;
import com.weiyuntong.module.fleetcenter.service.cardesc.CarDescService;
import com.weiyuntong.module.system.dal.dataobject.enterprise.EnterpriseDO;
import com.weiyuntong.module.system.dal.dataobject.goods.GoodsDO;
import com.weiyuntong.module.system.service.enterprise.EnterpriseService;
import com.weiyuntong.module.system.service.goods.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "货源交易大厅-货源管理")
@RestController
@RequestMapping("/bizcenter/entrust-order")
@Validated
public class TradeHallGoodsEntrustController {
    @Resource
    private TradeHallGoodsEntrustService tradeHallGoodsEntrustService;

    @Resource
    private TransportGoodsEntrustorderService transportGoodsEntrustorderService;
    @Resource
    private RefuseRecordService refuseRecordService;
    @Resource
    private RevokeRecordService revokeRecordService;
    @Resource
    private GoodsService goodsService;
    @Resource
    CarDescService carDescService;

    @Resource
    EnterpriseService enterpriseService;
    @Resource
    private TradehallProcessService tradehallProcessService;

    @Resource
    private TradehallCarSourceService tradehallCarSourceService;
    @Resource
    private TransportTaskEntrustorderService transportTaskEntrustorderService;

    @Resource
    private CarConfigService carConfigService;

    @Resource
    private FavoritesService favoritesService;

    @Resource
    private CustomerService customerService;

    @PostMapping("/create")
    @Operation(summary = "发布货源委托")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:create')")
    public CommonResult<Long> createTransportTaskEntrustorder(@Valid @RequestBody TradehallGoodsSourceCreateReqVO createReqVO) {
        return success(transportGoodsEntrustorderService.createTransportTaskEntrustorder(createReqVO));
    }

    @PostMapping("/getCreateJson")
    @Operation(summary = "获得创建任务的json")
    public CommonResult<String> createTransportTaskEntrustorder(Long id) {
        return success(transportGoodsEntrustorderService.getTransportTaskEntrustOrderSingle(id).getCreateJson());
    }


    @PutMapping("/update")
    @Operation(summary = "修改货源委托")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:update')")
    public CommonResult<Boolean> updateTransportTaskEntrustorder(@Valid @RequestBody TransportTaskEntrustorderUpdateReqVO updateReqVO) {
        transportGoodsEntrustorderService.updateTransportTaskEntrustorder(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除货源委托")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:delete')")
    public CommonResult<Boolean> deleteTransportTaskEntrustorder(@RequestParam("id") Long id) {
        transportGoodsEntrustorderService.deleteTransportTaskEntrustorder(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "货源委托-详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<TradehallGoodsSourceRespVO> getTransportTaskEntrustorder(@RequestParam("id") Long id) {
        TransportTaskEntrustorderDO transportTaskEntrustOrder = transportTaskEntrustorderService.getTransportTaskEntrustorderById(id);
        if (null != transportTaskEntrustOrder) {
            //处理过期日期的设置
            if (null == transportTaskEntrustOrder.getExpireDate() || LocalDateTimeUtils.EMPTY_STR.equals(LocalDateTimeUtils.dateToStrYMD(transportTaskEntrustOrder.getExpireDate()))) {
                transportTaskEntrustOrder.setExpireDateTips("永久有效");
            } else {
                transportTaskEntrustOrder.setExpireDateTips(transportTaskEntrustOrder.getExpireDate() + " " + transportTaskEntrustOrder.getExpireTime());
            }

            //托运人（货主）企业类型
            CustomerTypeEnums consignorEntType = null;

            //处理托运人（货主）信息
            EnterpriseDO enterpriseDO = enterpriseService.getEnterprise(transportTaskEntrustOrder.getTenantId());
            if (null != enterpriseDO) {
                transportTaskEntrustOrder.setConsignor(enterpriseDO.getName());
                transportTaskEntrustOrder.setConsignorId(enterpriseDO.getId());
                consignorEntType = customerService.getCustomerTypeByName(enterpriseDO.getName());
            }
            if (consignorEntType == null) {
                CustomerDO customerDO = customerService.get(transportTaskEntrustOrder.getCustomerId());
                if (customerDO != null) {
                    consignorEntType = customerDO.getType();
                }
            }
            TradehallGoodsSourceRespVO respVO = TransportTaskEntrustorderConvert.INSTANCE.convertGoodsRespVo(transportTaskEntrustOrder);
            if (null != respVO) {
                //报价列表
                List<TradehallProcessDO> reportPriceList = tradehallProcessService.getGoodsReportPriceListByGoodsId(transportTaskEntrustOrder.getId());
                reportPriceList = reportPriceList.stream().sorted(Comparator.comparing(TradehallProcessDO::getSortIndex)).collect(Collectors.toList());
                initProcess(reportPriceList,transportTaskEntrustOrder);
                respVO.setReportPriceList(reportPriceList);
                respVO.setConsignorEntType(consignorEntType);
                GoodsDO goods = goodsService.getGoods(respVO.getMediumId());
                if (goods != null) {
                    respVO.setGoodsSortNorm(goods.getGoodsSortNorm());
                }
                Set<String> processStatusSet = new LinkedHashSet<>();
                //发起方已拒绝
                List<TradehallProcessDO> sendList = new ArrayList<>();
                //接单放已拒绝
                List<TradehallProcessDO> receiveList = new ArrayList<>();
                //已确认报价列表
                List<TradehallProcessDO> dealReportPriceList= new ArrayList<>();
                //待确认报价列表
                List<TradehallProcessDO> waitReportPriceList= new ArrayList<>();
                for (TradehallProcessDO reportPriceDO : reportPriceList) {
                    if (reportPriceDO.getProcessStatus() == GoodsReportPriceStatusEnum.TO_SEND_REFUSED) {
                        processStatusSet.add("存在已拒绝信息");
                    } else if (reportPriceDO.getProcessStatus() == GoodsReportPriceStatusEnum.TO_RECEIVE_REVOKED) {
                        processStatusSet.add("存在已撤销信息");
                        receiveList.add(reportPriceDO);
                    } else if (reportPriceDO.getProcessStatus() == GoodsReportPriceStatusEnum.TO_SEND_REVOKED) {
                        sendList.add(reportPriceDO);
                    }else if (reportPriceDO.getProcessStatus() == GoodsReportPriceStatusEnum.TO_WAIT_ISSUED){
                        dealReportPriceList.add(reportPriceDO);
                    }if (reportPriceDO.getProcessStatus() == GoodsReportPriceStatusEnum.TO_CONFIRMED){
                        waitReportPriceList.add(reportPriceDO);
                    }
                }
                respVO.setSendRevokedProcessDOList(sendList);
                respVO.setReceiveRevokedProcessDOList(receiveList);
                respVO.setTips(StringUtils.join(processStatusSet, ","));
                //已确认报价列表
//                List<GoodsReportPriceStatusEnum> goodsReportPriceStatusEnum = new ArrayList<>();
//                goodsReportPriceStatusEnum.add(GoodsReportPriceStatusEnum.TO_WAIT_ISSUED);
                //List<TradehallProcessDO> dealReportPriceList = tradehallProcessService.getGoodsReportPriceListByStatusInList(id, goodsReportPriceStatusEnum);
                respVO.setDealReportPriceList(dealReportPriceList);
                //待确认报价列表
//                List<TradehallProcessDO> waitReportPriceList = tradehallProcessService.getGoodsReportPriceListByGoodsIdAndStatus(id, GoodsReportPriceStatusEnum.TO_CONFIRMED);
//                initProcess(waitReportPriceList,transportTaskEntrustOrder);
                respVO.setWaitReportPriceList(waitReportPriceList);
                //货源委托撤销记录
                List<RevokeRecordDO> revokeRecordList = revokeRecordService.getRevokeRecordByAssociatedId(id);
                respVO.setRevokeRecordList(revokeRecordList);
                //货源委托拒绝记录
                List<RefuseRecordDO> goodsRefuseRecordList = refuseRecordService.getRefuseByAssociatedId(id);
                respVO.setGoodsRefuseRecordList(goodsRefuseRecordList);
                if (WebFrameworkUtils.getTenantId().equals(respVO.getTenantId())) {
                    respVO.setIsControl(true);
                }
                //用车记录
                List<TradehallProcessDO> vehicleUsageList = tradehallProcessService.getEntrustOrderVehicleUsageListByOrderId(id, TradeHallDataSourceEnum.VEHICLE_USAGE);
                respVO.setVehicleUsageList(vehicleUsageList);
                if (tradehallProcessService.checkGoodsNameIsDisabled(respVO.getId(), respVO.getTenantId())) {
                    respVO.setMediumName("***");
                }
                if (transportGoodsEntrustorderService.checkUpperNeedInvoiceIsDisabled(respVO.getId(), respVO.getConsignorId())) {
                    respVO.setUpperNeedInvoiceTips("***");
                }
                if (transportGoodsEntrustorderService.checkUpBillingCycleIsDisabled(respVO.getId(), respVO.getConsignorId())) {
                    respVO.setUpBillingCycle("***");
                }
                if (transportGoodsEntrustorderService.checkConsignorIsDisabled(respVO.getConsignor(), respVO.getConsignorId())) {
                    respVO.setConsignor("******");
                }
                respVO.setAddressDistance(transportTaskEntrustOrder.getTransportDistance());
                respVO.setTransportDistance(transportTaskEntrustOrder.getTransportDistance());
                //添加状态
                respVO.setTradehallProcessStatus(TaskOrderStatusTypeEnums.instanceOf(transportTaskEntrustOrder.getStatus()));


                if (!transportTaskEntrustOrder.getCreator().equals(WebFrameworkUtils.getLoginUserId())) {
                    transportTaskEntrustorderService.andViewNum(transportTaskEntrustOrder);
                }
                return success(respVO);
            }
        }
        return success(null);
    }

    public void initProcess(List<TradehallProcessDO> list,TransportTaskEntrustorderDO entrustOrderDO){
        for (TradehallProcessDO tradehallProcessDO : list) {
            if (ObjectUtil.equals(tradehallProcessDO.getCarrierId(), entrustOrderDO.getConsignorId())) {
                tradehallProcessDO.setEntrustPrice(entrustOrderDO.getEntrustPrice());
                tradehallProcessDO.setEntrustPriceUnit(entrustOrderDO.getEntrustPriceUnit());
            } else {
                tradehallProcessDO.setEntrustPrice(entrustOrderDO.getSearchCarPrice());
                tradehallProcessDO.setEntrustPriceUnit(entrustOrderDO.getSearchCarPriceUnit());
            }
        }
    }

    @GetMapping("/list")
    @Operation(summary = "货源交易大厅-货源列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<List<TradehallGoodsSourceRespVO>> getTradehallGoodsSourceList(@RequestParam("ids") Collection<Long> ids) {
        List<TransportTaskEntrustorderDO> list = transportGoodsEntrustorderService.getTransportTaskEntrustorderList(ids);
        return success(TransportTaskEntrustorderConvert.INSTANCE.convertGoodsResvList(list));
    }

    @GetMapping("/deal-page")
    @Operation(summary = "货源委托已成交分页查询")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<PageResult<TradehallGoodsSourceRespVO>> getTransportTaskDealEntrustorderPage(@Valid MyEntrustReqVO pageVO) {
        return success(transportGoodsEntrustorderService.getTransportTaskDealEntrustorderPage(pageVO));
    }

    @GetMapping("/page")
    @Operation(summary = "货源委托分页查询")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<PageResult<TradehallGoodsSourceRespVO>> getTransportTaskEntrustorderPage(@Valid TransportTaskEntrustorderPageReqVO pageVO) {
        pageVO.setType(WaybillTypeEnum.ENTRUST);
        pageVO.setVersion(2);
        String activeName = pageVO.getActiveName();
        if (StringUtils.isNotBlank(activeName) && activeName.equals("40")) {//我的委托待确认4
            //使用sql关联查询
            PageResult<TransportTaskEntrustorderDO> entrustorderDOPageResult = transportGoodsEntrustorderService.findList(pageVO);
            PageResult<TradehallGoodsSourceRespVO> pageEntrustGood = TransportTaskEntrustorderConvert.INSTANCE.convertPageEntrustGood(entrustorderDOPageResult);
            return success(pageEntrustGood);
        } else if (StringUtils.isNotBlank(activeName) && activeName.equals("8")) {
            PageResult<TransportTaskEntrustorderDO> pageResult = transportGoodsEntrustorderService.getTransportTaskMyEntrustOrderPage(pageVO);
            PageResult<TradehallGoodsSourceRespVO> pageResultNew = TransportTaskEntrustorderConvert.INSTANCE.convertPageEntrustGood(pageResult);
            for (TradehallGoodsSourceRespVO item : pageResultNew.getList()) {
                List<TradehallProcessDO> reportPriceList = tradehallProcessService.getGoodsReportPriceListByGoodsId(pageVO.getTaskId());
                //上报车辆信息列表
                item.setReportPriceList(reportPriceList);
                if (WebFrameworkUtils.getTenantId().equals(item.getTenantId())) {
                    item.setIsControl(true);
                }
                if (Objects.equals(item.getStatus(), TaskOrderStatusTypeEnums.TASK_ORDER_WAIT_COMPLETE.getType())) {
                    item.setProcessStatusDesc("已完成");
                }
            }
            return success(pageResultNew);
        } else {
            PageResult<TransportTaskEntrustorderDO> pageResult = transportGoodsEntrustorderService.getTransportTaskEntrustorderPage(pageVO);
            PageResult<TradehallGoodsSourceRespVO> pageResultNew = TransportTaskEntrustorderConvert.INSTANCE.convertPageEntrustGood(pageResult);
            for (TradehallGoodsSourceRespVO item : pageResultNew.getList()) {
                List<TradehallProcessDO> reportPriceList = tradehallProcessService.getGoodsReportPriceListByGoodsId(item.getId());
                //上报车辆信息列表
                item.setReportPriceList(reportPriceList);
                if (WebFrameworkUtils.getTenantId().equals(item.getTenantId())) {
                    item.setIsControl(true);
                }
                if (Objects.equals(item.getStatus(), TaskOrderStatusTypeEnums.TASK_ORDER_WAIT_CONFIRM.getType())) {
                    item.setProcessStatusDesc("待确认");
                    item.setToConfirmedNum((int) reportPriceList.stream().filter(e -> e.getProcessStatus().equals(GoodsReportPriceStatusEnum.TO_CONFIRMED)).count());
                }

            }
            return success(pageResultNew);
        }
    }

    @GetMapping("/entrustPage")
    @Operation(summary = "货源委托分页查询")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<PageResult<TradehallProcessRespVO>> getMyEntrustPage(@Valid TradehallProcessPageReqVO pageVO) {
        PageResult<TradehallProcessDO> pageResult = tradehallProcessService.getTradehallProcessPage(pageVO);
        PageResult<TradehallProcessRespVO> respVOPageResult = TradehallProcessConvert.INSTANCE.convertPage(pageResult);
        for (TradehallProcessRespVO item : respVOPageResult.getList()) {
            TransportTaskEntrustorderDO entrustOrderDO = transportGoodsEntrustorderService.getTransportTaskEntrustorder(item.getOrderId());
            item.setTransportTaskEntrustorderDO(entrustOrderDO);
        }
        return success(respVOPageResult);
    }

    @GetMapping("/goodsBoardPage")
    @Operation(summary = "用于货源广场货源分页查询")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<PageResult<TradehallGoodsSourceRespVO>> goodsBoardPage(@Valid TransportTaskEntrustorderPageReqVO pageVO) {
        pageVO.setType(WaybillTypeEnum.ENTRUST);
        PageResult<TransportTaskEntrustorderDO> pageResult = transportGoodsEntrustorderService.goodsBoardPage(pageVO);
        PageResult<TradehallGoodsSourceRespVO> pageResultNew = TransportTaskEntrustorderConvert.INSTANCE.convertPageEntrustGood(pageResult);
        for (TradehallGoodsSourceRespVO item : pageResultNew.getList()) {
            List<TradehallProcessDO> reportPriceList = tradehallProcessService.getGoodsReportPriceListByGoodsId(pageVO.getTaskId());
            //上报车辆信息列表
            item.setReportPriceList(reportPriceList);
            if (WebFrameworkUtils.getTenantId().equals(item.getTenantId())) {
                item.setIsControl(true);
            }
            if (tradehallProcessService.checkGoodsNameIsDisabled(item.getId(), item.getTenantId())) {
                item.setMediumName("***");
            }
            if (transportGoodsEntrustorderService.checkUpperNeedInvoiceIsDisabled(item.getId(), item.getConsignorId())) {
                item.setUpperNeedInvoiceTips("***");
            }
            if (transportGoodsEntrustorderService.checkUpBillingCycleIsDisabled(item.getId(), item.getConsignorId())) {
                item.setUpBillingCycle("***");
            }
            if (transportGoodsEntrustorderService.checkConsignorIsDisabled(item.getConsignor(), item.getConsignorId())) {
                item.setConsignor("******");
            }

            item.setHasFavorites(favoritesService.hasFavorites(item.getId()));

            // 包装规格
            GoodsDO goods = goodsService.getGoods(item.getMediumId());
            if (goods != null) {
                item.setGoodsSortNorm(goods.getGoodsSortNorm());
            }
        }
        return success(pageResultNew);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "货源委托-导出Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:export')")
    @OperateLog(type = EXPORT)
    public void exportTransportTaskEntrustorderExcel(@Valid TransportTaskEntrustorderExportReqVO exportReqVO, HttpServletResponse response) throws IOException {
        exportReqVO.setType(WaybillTypeEnum.ENTRUST.name());
        List<TransportTaskEntrustorderDO> list = transportGoodsEntrustorderService.getTransportTaskEntrustorderList(exportReqVO);
        // 导出 Excel
        List<TransportTaskEntrustorderExcelVO> datas = TransportTaskEntrustorderConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "货源委托单.xls", "数据", TransportTaskEntrustorderExcelVO.class, datas);
    }

    @PostMapping("/quotedprice")
    @Operation(summary = "货源交易大厅-货源报价")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:quotedprice')")
    public CommonResult<Boolean> quotedPrice(@Valid @RequestBody List<TradehallGoodsReportPriceCreateReqVO> createReqVO) {
        transportGoodsEntrustorderService.quotedPrice(createReqVO);
        return success(true);
    }

    @PostMapping("/publishRemainingWeight")
    @Operation(summary = "货源交易大厅-我的委托-发布剩余")
    @Parameter(name = "id", description = "货源id", required = true)
    public CommonResult<Boolean> publishRemainingWeight(@RequestBody Map<String, Object> paramMap) {
        tradeHallGoodsEntrustService.publishRemainingWeight(paramMap);
        return success(true);
    }

    @PostMapping("/ignore")
    @Operation(summary = "货源交易大厅-我的委托-忽略")
    @Parameter(name = "id", description = "忽略id", required = true)
    public CommonResult<Boolean> ignore(@RequestBody Map<String, Object> paramMap) {
        tradeHallGoodsEntrustService.ignoreEntrust(paramMap);
        return success(true);
    }

    @PostMapping("/revokeAll")
    @Operation(summary = "货源交易大厅-我的委托-撤销全部")
    @Parameter(name = "ids", description = "支持批量全部撤销", required = true)
    @Parameter(name = "reason", description = "撤销原因")
    @Parameter(name = "remark", description = "撤销备注")
    public CommonResult<Boolean> revokeAll(@RequestBody Map<String, Object> paramMap) {
        tradeHallGoodsEntrustService.revokeAll(paramMap);
        return success(true);
    }

    @PostMapping("/revokeTask")
    @Operation(summary = "货源交易大厅-委托列表-待接单撤销")
    @Parameter(name = "ids", description = "支持批量撤销", required = false)
    @Parameter(name = "ignoreAll", description = "需要传入ignoreAll参数（true：全部，false：剩余）", required = false)
    @Parameter(name = "weight", description = "部分的时候，需要提供撤销量")
    @Parameter(name = "reason", description = "撤销原因")
    @Parameter(name = "remark", description = "撤销备注")
    public CommonResult<Boolean> revokeTask(@RequestBody Map<String, Object> paramMap) {
        tradeHallGoodsEntrustService.revokeTask(paramMap);
        return success(true);
    }

    @PostMapping("/goods-statistical")
    @Operation(summary = "货源交易大厅-货源统计")
    @Parameter(name = "tenantId", description = "企业id")
    @Parameter(name = "userId", description = "用户id")
    public CommonResult<Map<String, Object>> goodsStatistic(@RequestBody Map<String, Object> paramMap) {
        return success(transportGoodsEntrustorderService.goodsStatistic(paramMap));
    }

    @PostMapping("/issuedTask")
    @Operation(summary = "货源委托-下发到运单车次")
    //@PreAuthorize("@ss.hasPermission('bizcenter::issuedTask')")
    public CommonResult<Boolean> issuedTask(@Valid @RequestBody GoodsEntrustDistributeCreateReqVO createReqVO) {
        transportGoodsEntrustorderService.issuedTask(createReqVO);
        return success(true);
    }

    @GetMapping("/detail")
    @Operation(summary = "货源委托-详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<TradehallGoodsSourceRespVO> getTransportTaskEntrustorderDetail(@RequestParam("id") Long id) {
        TransportTaskEntrustorderDO transportTaskEntrustOrder = transportGoodsEntrustorderService.getTransportTaskEntrustorder(id);
        TradehallGoodsSourceRespVO respVO = TransportTaskEntrustorderConvert.INSTANCE.convertGoodsRespVo(transportTaskEntrustOrder);
        if (null != respVO) {
            TradehallProcessDO reportPriceDO = tradehallProcessService.getTradehallProcess(id);
            //车辆信息
            List<Long> ids = new ArrayList<>();
            ids.add(reportPriceDO.getCarId());
            List<CarDescDO> carDescDOList = carDescService.getCarDescList(ids);
            respVO.setCarDescDOList(carDescDOList);
        }
        return success(respVO);
    }

    @GetMapping("/revokeDetail")
    @Operation(summary = "货源委托-撤销详情")
    @Parameter(name = "id", description = "委托单id", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<List<RevokeRecordRespVO>> getTransportTaskEntrustOrderRevokeDetail(@RequestParam("id") Long id) {
        List<RevokeRecordDO> revokeRecordList = revokeRecordService.getRevokeRecordByAssociatedId(id);
        List<RevokeRecordRespVO> respVOList = RevokeRecordConvert.INSTANCE.convertList(revokeRecordList);
        for (RevokeRecordRespVO revokeRecord : respVOList) {
            RevokeTypeEnum revokeTypeEnum = revokeRecord.getType();
            //处理撤销方企业信息
            Long tenantId = revokeRecord.getTenantId();
            EnterpriseDO enterpriseDO = enterpriseService.getEnterprise(tenantId);
            if (ObjectUtil.isAllNotEmpty(enterpriseDO)) {
                revokeRecord.setEnterpriseName(enterpriseDO.getName());
            }
            //处理撤销关联的是运单还是委托单、用车、报价等信息
            Long associatedId = revokeRecord.getAssociatedId();
            if (RevokeTypeEnum.ENTRUST.equals(revokeTypeEnum)) {
                TransportTaskEntrustorderDO entrustOrderDO = transportGoodsEntrustorderService.getTransportTaskEntrustorder(associatedId);
                if (null != entrustOrderDO) {
                    revokeRecord.setAssociatedCode(entrustOrderDO.getEntrustCode());
                    revokeRecord.setEntrustOrderDO(entrustOrderDO);
                }
            }
        }
        return success(respVOList);
    }

    @GetMapping("/refuseDetail")
    @Operation(summary = "货源委托-拒绝详情")
    @Parameter(name = "id", description = "委托单id", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<List<RefuseRecordRespVO>> getRefuseDetail(@RequestParam("id") Long id) {
        List<RefuseRecordDO> refuseRecordList = refuseRecordService.getRefuseByAssociatedId(id);
        List<RefuseRecordRespVO> respVOList = RefuseRecordConvert.INSTANCE.convertList(refuseRecordList);
        for (RefuseRecordRespVO refuseRecordRespVO : respVOList) {
            RefuseTypeEnum revokeTypeEnum = refuseRecordRespVO.getType();
            //处理拒绝方企业信息
            Long tenantId = refuseRecordRespVO.getTenantId();
            EnterpriseDO enterpriseDO = enterpriseService.getEnterprise(tenantId);
            if (ObjectUtil.isAllNotEmpty(enterpriseDO)) {
                refuseRecordRespVO.setEnterpriseName(enterpriseDO.getName());
            }
            //处理撤销关联的是运单还是委托单、用车、报价等信息
            Long associatedId = refuseRecordRespVO.getAssociatedId();
            if (RefuseTypeEnum.ENTRUST.equals(revokeTypeEnum)) {
                TransportTaskEntrustorderDO entrustOrderDO = transportGoodsEntrustorderService.getTransportTaskEntrustorder(associatedId);
                if (null != entrustOrderDO) {
                    refuseRecordRespVO.setAssociatedCode(entrustOrderDO.getEntrustCode());
                    refuseRecordRespVO.setEntrustOrderDO(entrustOrderDO);
                }
            }
        }
        return success(respVOList);
    }

    @GetMapping("/revokePage")
    @Operation(summary = "获得撤销记录信息分页")
    //@PreAuthorize("@ss.hasPermission('bizcenter:revoke-record:query')")
    public CommonResult<PageResult<TradehallProcessRespVO>> getRevokeRecordPage(@Valid TradehallProcessPageReqVO pageVO) {
        // 增加筛选条件 装货地-卸货地-装货时间
        List<Long> longs = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(pageVO.getLoadAddressName()) ||
                ObjectUtil.isNotEmpty(pageVO.getUnloadAddressName()) ||
                ObjectUtil.isNotEmpty(pageVO.getLoadDate()) ||
                ObjectUtil.isNotEmpty(pageVO.getCustomerName())) {
            longs = transportGoodsEntrustorderService.selectByAddressAndTime(pageVO);
            if (longs.size() == 0) {
                // 如何过滤查询无结果 直接返回空的返回结构
                PageResult<TradehallProcessRespVO> pageResult = new PageResult<>();
                pageResult.setTotal(0L);
                pageResult.setList(null);
                return success(pageResult);
            }
        }
        pageVO.setLongs(longs);
        PageResult<TradehallProcessDO> pageResult = tradehallProcessService.getTradehallProcessPageMyEntrust(pageVO);
        PageResult<TradehallProcessRespVO> priceRespVOPageResult = TradehallProcessConvert.INSTANCE.convertPage(pageResult);
        for (TradehallProcessRespVO reportPriceDO : priceRespVOPageResult.getList()) {
            //通过货源id封装货源信息
            Long goodsId = reportPriceDO.getOrderId();
            TransportTaskEntrustorderDO tradeHallGoodsSourceDO = transportGoodsEntrustorderService.getTransportTaskEntrustorder(goodsId);
            if (null != tradeHallGoodsSourceDO) {
                if (WebFrameworkUtils.getTenantId().equals(tradeHallGoodsSourceDO.getTenantId())) {
                    tradeHallGoodsSourceDO.setIsControl(true);
                }
                reportPriceDO.setTransportTaskEntrustorderDO(tradeHallGoodsSourceDO);
            }
        }
        return success(priceRespVOPageResult);
    }

    @GetMapping("/app-revokePage")
    @Operation(summary = "小程序已撤销信息分页")
    public CommonResult<PageResult<MyRevokeRespVO>> getAppRevokeRecordPage(@Valid MyEntrustReqVO myEntrustReqVO) {
        PageResult<MyRevokeRespVO> pageResult = tradeHallGoodsEntrustService.getAppRevokeRecordPage(myEntrustReqVO);
        return success(pageResult);
    }

    @GetMapping("/app-toBeQuotedPage")
    @Operation(summary = "小程序我的报价-待报价信息分页")
    public CommonResult<PageResult<MyRevokeRespVO>> getAppToBeQuotedPage(@Valid MyEntrustReqVO myEntrustReqVO) {
        PageResult<MyRevokeRespVO> pageResult = tradeHallGoodsEntrustService.getAppToBeQuotedPage(myEntrustReqVO);
        return success(pageResult);
    }

    @GetMapping("/app-toSureProcessPage")
    @Operation(summary = "小程序我的报价-待确认信息分页")
    public CommonResult<PageResult<MyRevokeRespVO>> getAppToSureProcessPage(@Valid MyEntrustReqVO myEntrustReqVO) {
        PageResult<MyRevokeRespVO> pageResult = tradeHallGoodsEntrustService.getAppToSureProcessPage(myEntrustReqVO);
        return success(pageResult);
    }

    @GetMapping("/app-toRefusedProcessPage")
    @Operation(summary = "小程序我的报价-被拒绝信息分页")
    public CommonResult<PageResult<MyRevokeRespVO>> getAppToRefusedProcessPage(@Valid MyEntrustReqVO myEntrustReqVO) {
        PageResult<MyRevokeRespVO> pageResult = tradeHallGoodsEntrustService.getAppToRefusedProcessPage(myEntrustReqVO);
        return success(pageResult);
    }

    @GetMapping("/refusePage")
    @Operation(summary = "获得拒绝记录信息分页")
    //@PreAuthorize("@ss.hasPermission('bizcenter:revoke-record:query')")
    public CommonResult<PageResult<TradehallProcessRespVO>> getRefusedRecordPage(@Valid TradehallProcessPageReqVO pageVO) {
        // 增加筛选条件 装货地-卸货地-装货时间
        List<Long> longs = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(pageVO.getLoadAddressName()) ||
                ObjectUtil.isNotEmpty(pageVO.getUnloadAddressName()) ||
                ObjectUtil.isNotEmpty(pageVO.getLoadDate())) {
            longs = transportGoodsEntrustorderService.selectByAddressAndTime(pageVO);
            if (longs.size() == 0) {
                // 如何过滤查询无结果 直接返回空的返回结构
                PageResult<TradehallProcessRespVO> pageResult = new PageResult<>();
                pageResult.setTotal(0L);
                pageResult.setList(null);
                return success(pageResult);
            }
        }
        pageVO.setLongs(longs);
        PageResult<TradehallProcessDO> pageResult = tradehallProcessService.getTradehallProcessPageMyEntrust(pageVO);
        PageResult<TradehallProcessRespVO> priceRespVOPageResult = TradehallProcessConvert.INSTANCE.convertPage(pageResult);
        for (TradehallProcessRespVO reportPriceDO : priceRespVOPageResult.getList()) {
            //通过货源id封装货源信息
            Long goodsId = reportPriceDO.getOrderId();
            TransportTaskEntrustorderDO tradeHallGoodsSourceDO = transportGoodsEntrustorderService.getTransportTaskEntrustorder(goodsId);
            if (null != tradeHallGoodsSourceDO) {
                if (WebFrameworkUtils.getTenantId().equals(tradeHallGoodsSourceDO.getTenantId())) {
                    tradeHallGoodsSourceDO.setIsControl(true);
                }
                reportPriceDO.setTransportTaskEntrustorderDO(tradeHallGoodsSourceDO);
            }
        }
        return success(priceRespVOPageResult);
    }

    @GetMapping("/getWaitOrderPage")
    @Operation(summary = "我的委托-待接单的货源委托查询")
    //@PreAuthorize("@ss.hasPermission('bizcenter:revoke-record:query')")
    public CommonResult<PageResult<TradehallProcessRespVO>> getWaitOrderPage(@Valid TradehallProcessPageReqVO pageVO) {
        // 增加筛选条件 装货地-卸货地-装货时间
        List<Long> longs = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(pageVO.getLoadAddressName()) ||
                ObjectUtil.isNotEmpty(pageVO.getUnloadAddressName()) ||
                ObjectUtil.isNotEmpty(pageVO.getLoadDate())) {
            longs = transportGoodsEntrustorderService.selectByAddressAndTime(pageVO);
            if (longs.size() == 0) {
                // 如何过滤查询无结果 直接返回空的返回结构
                PageResult<TradehallProcessRespVO> pageResult = new PageResult<>();
                pageResult.setTotal(0L);
                pageResult.setList(null);
                return success(pageResult);
            }
        }
        pageVO.setLongs(longs);
        //获取待接单委托单货源信息，这里指的是用车时，待接单车源信息
        pageVO.setDataSource(TradeHallDataSourceEnum.VEHICLE_USAGE);
        pageVO.setProcessStatus(GoodsReportPriceStatusEnum.PENDING_ORDER);
        pageVO.setOrderType(WaybillTypeEnum.ENTRUST.name());
        PageResult<TradehallProcessDO> pageResult = tradehallProcessService.getTradehallProcessPageMyEntrust(pageVO);
        PageResult<TradehallProcessRespVO> priceRespVOPageResult = TradehallProcessConvert.INSTANCE.convertPage(pageResult);
        for (TradehallProcessRespVO reportPriceDO : priceRespVOPageResult.getList()) {
            //货源信息
            Long goodsId = reportPriceDO.getOrderId();
            TransportTaskEntrustorderDO tradeHallGoodsSourceDO = transportGoodsEntrustorderService.getTransportTaskEntrustorder(goodsId);
            if (null != tradeHallGoodsSourceDO) {
                if (WebFrameworkUtils.getTenantId().equals(tradeHallGoodsSourceDO.getTenantId())) {
                    tradeHallGoodsSourceDO.setIsControl(true);
                }
                reportPriceDO.setTransportTaskEntrustorderDO(tradeHallGoodsSourceDO);
            }
            //车源信息
            Long carSourcesId = reportPriceDO.getCarsSourceId();
            TradehallCarSourceDO tradehallCarSourceDO = tradehallCarSourceService.getTradehallCarSource(carSourcesId);
            if (null != tradeHallGoodsSourceDO) {
                reportPriceDO.setTradehallCarSourceDO(tradehallCarSourceDO);
            }
        }
        return success(priceRespVOPageResult);
    }

    @PostMapping("/revokeUsageCar")
    @Operation(summary = "货源交易大厅-我的委托-待接单-撤销用车需求")
    @Parameter(name = "ids", description = "支持批量全部撤销,多个以逗号分隔", required = true)
    public CommonResult<Boolean> revokeUsageCar(@RequestBody Map<String, Object> paramMap) {
        tradeHallGoodsEntrustService.revokeUsageCar(paramMap);
        return success(true);
    }

    @PostMapping("/buildEntrustGrossProfit")
    @Operation(summary = "货源交易大厅-我的委托-新建货源-预计毛利润测算")
    public CommonResult<BigDecimal> buildEntrustGrossProfit(@RequestBody EntrustOrderGrossPrifitVO entrustOrderGrossPrifitVO) {
        CarConfigDO carConfig = carConfigService.getCarConfig(TenantContextHolder.getTenantId());
        return success(tradeHallGoodsEntrustService.buildEntrustGrossProfit(entrustOrderGrossPrifitVO, carConfig));
    }

    @PostMapping("/buildReportPriceGrossProfit")
    @Operation(summary = "货源交易大厅-我的委托-报价-预计毛利润测算")
    public CommonResult<EntrustOrderProfitAmountRespVO> buildReportPriceGrossProfit(@RequestBody EntrustOrderGrossPrifitVO entrustOrderGrossPrifitVO) {
        return success(tradeHallGoodsEntrustService.buildReportPriceGrossProfit(entrustOrderGrossPrifitVO));
    }

    @GetMapping("/myEntrust")
    @Operation(summary = "我的委托-根据关键字查询货源委托")
    public CommonResult<PageResult<MyEntrustRespVO>> myEntrust(MyEntrustReqVO myEntrustReqVO) {
        PageResult<MyEntrustRespVO> pageResult = tradeHallGoodsEntrustService.getMyEntrust(myEntrustReqVO);
        return success(pageResult);
    }


    @GetMapping("/getWeightFlow")
    @Operation(summary = "我的委托-根据关键字查询货源委托")
    public CommonResult<EntrustOrderWeightVO> getWeightFlow(EntrustOrderWeightReqVO reqVO) {
        EntrustOrderWeightVO orderWeightVO = tradeHallGoodsEntrustService.getWeightFlow(reqVO);
        return success(orderWeightVO);
    }

    @GetMapping("/countNumContracts")
    @Operation(summary = "货源交易大厅-我的委托-统计")
    public CommonResult<EntrustOrderCountVO> countNumContracts() {
        return success(tradeHallGoodsEntrustService.getCountNumContracts());
    }

    @GetMapping("/countNumOffer")
    @Operation(summary = "货源交易大厅-我的报价-统计")
    public CommonResult<EntrustOrderCountVO> countNumOffer() {
        return success(tradeHallGoodsEntrustService.getCountNumOffer());
    }


}
