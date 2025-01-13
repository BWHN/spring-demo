package org.example.weiyuntong.tradehallcarsource;

import cn.hutool.core.util.ObjectUtil;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.pojo.PageResult;
import com.weiyuntong.framework.common.util.StringUtil;
import com.weiyuntong.framework.common.util.date.DateUtils;
import com.weiyuntong.framework.excel.core.util.ExcelUtils;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.framework.web.core.util.WebFrameworkUtils;
import com.weiyuntong.module.bizcenter.controller.admin.refuserecord.vo.RefuseRecordCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.refuserecord.vo.RefuseRecordRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.revokerecord.vo.RevokeRecordCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.revokerecord.vo.RevokeRecordRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallcarsource.vo.*;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallgoodssource.vo.TradehallGoodsSourceRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallprocess.vo.TradehallProcessPageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallprocess.vo.TradehallProcessRespVO;
import com.weiyuntong.module.bizcenter.controller.admin.tradehallvehicleusage.vo.TradehallVehicleUsageCreateReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.transporttaskentrustorder.vo.TransportTaskEntrustorderPageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.transporttaskorder.vo.TransportTaskOrderPageReqVO;
import com.weiyuntong.module.bizcenter.controller.admin.transporttaskorder.vo.TransportTaskOrderRespVO;
import com.weiyuntong.module.bizcenter.convert.refuserecord.RefuseRecordConvert;
import com.weiyuntong.module.bizcenter.convert.revokerecord.RevokeRecordConvert;
import com.weiyuntong.module.bizcenter.convert.tradehallcarsource.TradehallCarSourceConvert;
import com.weiyuntong.module.bizcenter.convert.tradehallprocess.TradehallProcessConvert;
import com.weiyuntong.module.bizcenter.convert.transporttaskentrustorder.TransportTaskEntrustorderConvert;
import com.weiyuntong.module.bizcenter.convert.transporttaskorder.TransportTaskOrderConvert;
import com.weiyuntong.module.bizcenter.dal.dataobject.refuserecord.RefuseRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.revokerecord.RevokeRecordDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallcarsource.TradehallCarSourceDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.tradehallprocess.TradehallProcessDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskentrustorder.TransportTaskEntrustorderDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.transporttaskorder.TransportTaskOrderDO;
import com.weiyuntong.module.bizcenter.dal.dataobject.waybill.WaybillTypeEnum;
import com.weiyuntong.module.bizcenter.enums.RefuseTypeEnum;
import com.weiyuntong.module.bizcenter.enums.RevokeTypeEnum;
import com.weiyuntong.module.bizcenter.service.refuserecord.RefuseRecordService;
import com.weiyuntong.module.bizcenter.service.revokerecord.RevokeRecordService;
import com.weiyuntong.module.bizcenter.service.tradehallcarsource.TradehallCarSourceService;
import com.weiyuntong.module.bizcenter.service.tradehallprocess.TradehallProcessService;
import com.weiyuntong.module.bizcenter.service.tradehallvehicleusage.TradeHallVehicleUsageService;
import com.weiyuntong.module.bizcenter.service.transporttaskentrustorder.TransportTaskEntrustorderService;
import com.weiyuntong.module.bizcenter.service.transporttaskorder.TransportTaskOrderService;
import com.weiyuntong.module.bizcenter.service.waybill.WaybillAppraiseService;
import com.weiyuntong.module.fleetcenter.dal.dataobject.cardesc.CarDescDO;
import com.weiyuntong.module.fleetcenter.service.cardesc.CarDescService;
import com.weiyuntong.module.opecenter.service.carqualified.CarQualifiedService;
import com.weiyuntong.module.opecenter.service.driverqualified.DriverQualifiedService;
import com.weiyuntong.module.opecenter.service.enterprisequalified.EnterpriseQualifiedService;
import com.weiyuntong.module.system.dal.dataobject.enterprise.EnterpriseDO;
import com.weiyuntong.module.system.dal.dataobject.tenant.TenantDO;
import com.weiyuntong.module.system.service.enterprise.EnterpriseService;
import com.weiyuntong.module.system.service.tenant.TenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.weiyuntong.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.weiyuntong.framework.common.pojo.CommonResult.success;
import static com.weiyuntong.framework.operatelog.core.enums.OperateTypeEnum.*;
import static com.weiyuntong.module.bizcenter.enums.ErrorCodeConstants.TRADEHALL_CAR_NOT_EXISTS;

@Tag(name = "车源交易大厅-车源管理")
@RestController
@RequestMapping("/bizcenter/tradehall-car-source")
@Validated
public class TradehallCarSourceController {

    @Resource
    private TradehallCarSourceService tradehallCarSourceService;
    @Resource
    private CarDescService carDescService;

    @Resource
    private TradeHallVehicleUsageService tradehallVehicleUsageService;
    @Resource
    private EnterpriseService enterpriseService;
    @Resource
    private RevokeRecordService revokeRecordService;
    @Resource
    private TradehallProcessService tradehallProcessService;
    @Resource
    private RefuseRecordService refuseRecordService;
    @Resource
    TransportTaskOrderService transportTaskOrderService;
    @Resource
    CarQualifiedService carQualifiedService;
    @Resource
    DriverQualifiedService driverQualifiedService;
    @Resource
    EnterpriseQualifiedService enterpriseQualifiedService;
    @Resource
    WaybillAppraiseService waybillAppraiseService;
    @Resource
    TransportTaskEntrustorderService transportTaskEntrustorderService;
    @Resource
    private TenantService tenantService;
    @PostMapping("/create")
    @Operation(summary = "车源交易大厅-新建车源")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:create')")
    public CommonResult<Boolean> createTradehallCarSource(@Valid @RequestBody TradehallCarSourceCreateReqVO createReqVO) {
        String carIds = createReqVO.getCarIds();
        if (StringUtils.isNotBlank(carIds)) {
            List<Long> ids = Arrays.stream(carIds.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
            for (Long id : ids) {
                createReqVO.setCarIds(String.valueOf(id));
              CarDescDO carDescDO = carDescService.getCarDesc(id);
              if(null!=carDescDO){
                  createReqVO.setCarType(carDescDO.getCarTypeName());
                  createReqVO.setCarWeight(new BigDecimal(carDescDO.getCarMaxwgt()));
                  createReqVO.setAllowMedium(carDescDO.getCarMedium());
                  //createReqVO.setLastMediumName(carDescDO.getLastGoodsName());
                  createReqVO.setEmissionStandard(carDescDO.getCarEmission());
                  if(StringUtils.isNotBlank(carDescDO.getCarIshot())&&("1".equals(carDescDO.getCarIshot())||"是".equals(carDescDO.getCarIshot()))){
                      createReqVO.setIsWarm(true);
                  }else{
                      createReqVO.setIsWarm(false);
                  }
                  if(StringUtils.isNotBlank(carDescDO.getCarReheat())&&("1".equals(carDescDO.getCarReheat())||"是".equals(carDescDO.getCarReheat()))){
                      createReqVO.setIsHeat(true);
                  }else{
                      createReqVO.setIsHeat(false);
                  }
                  //承运商信息
                  EnterpriseDO enterpriseDO =enterpriseService.getEnterprise(carDescDO.getEntId());
                  if(null!=enterpriseDO){
                      createReqVO.setCarrierId(enterpriseDO.getId());
                      createReqVO.setCarrierName(enterpriseDO.getName());
                      createReqVO.setContactName(enterpriseDO.getContacts());
                      createReqVO.setContactMobile(enterpriseDO.getTelephone());
                  }
                  //承运商信息
                  TenantDO tenantInfo =tenantService.getTenant(WebFrameworkUtils.getTenantId());
                  if(null!=tenantInfo){
                      createReqVO.setTenantId(tenantInfo.getId());
                      createReqVO.setTenantName(tenantInfo.getName());
                  }
                  tradehallCarSourceService.createTradehallCarSource(createReqVO);
              }else{
                  throw exception(TRADEHALL_CAR_NOT_EXISTS);
              }
            }
        } else {
            throw exception(TRADEHALL_CAR_NOT_EXISTS);
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "车源交易大厅-车源列表-更新车源")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:update')")
    public CommonResult<Boolean> updateTradehallCarSource(@Valid @RequestBody TradehallCarSourceUpdateReqVO updateReqVO) {
        tradehallCarSourceService.updateTradehallCarSource(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "车源交易大厅-车源列表-删除车源")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:delete')")
    public CommonResult<Boolean> deleteTradehallCarSource(@RequestParam("id") Long id) {
        tradehallCarSourceService.deleteTradehallCarSource(id);
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "车源交易大厅-车源看板-列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    //@PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:query')")
    public CommonResult<List<TradehallCarSourceRespVO>> getTradehallCarSourceList(@RequestParam("ids") Collection<Long> ids) {
        List<TradehallCarSourceDO> list = tradehallCarSourceService.getTradehallCarSourceList(ids);
        return success(TradehallCarSourceConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "车源交易大厅-车源看板-车源分页查询")
    //@PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:query')")
    public CommonResult<PageResult<TradehallCarSourceRespVO>> getTradehallCarSourcePage(@Valid TradehallCarSourcePageReqVO pageVO) {
        PageResult<TradehallCarSourceDO> pageResult =new PageResult<>();
        if(StringUtils.isNotBlank(pageVO.getActiveName())&& "PENDING_ORDER".equals(pageVO.getActiveName())){
            pageResult = tradehallCarSourceService.getTradeHallCarSourcePendingOrder(pageVO);
        }else{
            pageResult = tradehallCarSourceService.getTradeHallCarSourceBoardPage(pageVO);
        }
        return success(TradehallCarSourceConvert.INSTANCE.convertPages(pageResult));
    }

    @GetMapping("/carBoardPage")
    @Operation(summary = "车源交易大厅-车源看板-车源分页查询")
    //@PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:query')")
    public CommonResult<PageResult<TradehallCarSourceRespVO>> getTradehallCarSourceBoardPage(@Valid TradehallCarSourcePageReqVO pageVO) {
        PageResult<TradehallCarSourceDO> pageResult = tradehallCarSourceService.getTradeHallCarBoardPage(pageVO);
        PageResult<TradehallCarSourceRespVO> pageRespVO = TradehallCarSourceConvert.INSTANCE.convertPages(pageResult);
        for (TradehallCarSourceRespVO item : pageRespVO.getList()) {
            if (item.getCreator().equals(StringUtil.trimNull(WebFrameworkUtils.getLoginUserId()))) {
                item.setIsControl(true);
            }
        }
        return success(pageRespVO);
    }

    @GetMapping("/export-excel")
    @Operation(summary = "车源交易大厅-车源看板-车源导出Excel")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-car-source:export')")
    @OperateLog(type = EXPORT)
    public void exportTradehallCarSourceExcel(@Valid TradehallCarSourceExportReqVO exportReqVO,
                                              HttpServletResponse response) throws IOException {
        List<TradehallCarSourceDO> list = tradehallCarSourceService.getTradehallCarSourceList(exportReqVO);
        // 导出 Excel
        List<TradehallCarSourceExcelVO> datas = TradehallCarSourceConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "交易大厅-车源管理.xls", "数据", TradehallCarSourceExcelVO.class, datas);
    }

    @PostMapping("/statistic")
    @Operation(summary = "车源交易大厅-车源看板-车源统计")
    @Parameter(name = "tenantId", description = "企业id")
    @Parameter(name = "userId", description = "用户id")
    public CommonResult<Map<String, Object>> statistic(@RequestBody Map<String, Object> paramMap) {
        return success(tradehallCarSourceService.carStatistic(paramMap));
    }

    @GetMapping("/pageCarList")
    @Operation(summary = "用车列表查询-委托单")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<PageResult<TradehallGoodsSourceRespVO>> getTransportTaskEntrustorderPage(@Valid TransportTaskEntrustorderPageReqVO pageVO) {
        //待确认之前的委托单、任务单可以选择用车
        pageVO.setType(WaybillTypeEnum.ENTRUST);
        PageResult<TransportTaskEntrustorderDO> pageResult = tradehallCarSourceService.getTransportTaskEntrustorderPage(pageVO);
        return success(TransportTaskEntrustorderConvert.INSTANCE.convertPageEntrustGood(pageResult));
    }

    @GetMapping("/pageCarTaskList")
    @Operation(summary = "用车列表查询-任务单")
    public CommonResult<PageResult<TransportTaskOrderRespVO>> pageCarTaskList(@Valid TransportTaskOrderPageReqVO pageVO) {
        //只有待发布
        PageResult<TransportTaskOrderDO> pageResult = transportTaskOrderService.getTransportTaskOrderPageByStatus(pageVO);
        return success(TransportTaskOrderConvert.INSTANCE.convertPage(pageResult));
    }

    @PostMapping("/vehicleUsage")
    @Operation(summary = "车源交易大厅-委托单用车")
    public CommonResult<Boolean> vehicleUsage(@RequestBody List<TradehallVehicleUsageCreateReqVO> createReqVOS) {
        tradehallCarSourceService.vehicleUsage(createReqVOS);
        return success(true);
    }

    @PostMapping("/vehicleUsageForTask")
    @Operation(summary = "车源交易大厅-任务单用车")
    public CommonResult<Boolean> vehicleUsageForTask(@RequestBody List<TradehallVehicleUsageCreateReqVO> createReqVOS) {
        tradehallCarSourceService.vehicleUsageForTask(createReqVOS);
        return success(true);
    }

    @PostMapping("/revoke")
    @Operation(summary = "车源交易大厅-车源列表-撤销")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    public CommonResult<Boolean> revokeCarSource(@Valid @RequestBody RevokeRecordCreateReqVO createReqVO) {
        tradehallCarSourceService.revokeCarSource(createReqVO);
        return success(true);
    }

    @PostMapping("/refuse")
    @Operation(summary = "车源交易大厅-车源列表-拒绝操作")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    public CommonResult<Boolean> refuseCarSource(@Valid @RequestBody RefuseRecordCreateReqVO createReqVO) {
        tradehallCarSourceService.refuseCarSource(createReqVO);
        return success(true);
    }

    @GetMapping("/revokeDetail")
    @Operation(summary = "车源-撤销详情")
    @Parameter(name = "id", description = "委托单id", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<List<RevokeRecordRespVO>> getRevokeDetail(@RequestParam("id") Long id) {
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
            if (RevokeTypeEnum.CAR_SOURCE.equals(revokeTypeEnum)) {
                TradehallProcessDO processDO = tradehallProcessService.getTradehallProcess(associatedId);
                if (null != processDO) {
                    revokeRecord.setReportPriceInfo(processDO);
                }
            }
        }
        return success(respVOList);
    }

    @GetMapping("/refuseDetail")
    @Operation(summary = "车源交易大厅-车源-拒绝详情")
    @Parameter(name = "id", description = "委托单id", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bizcenter:tradehall-goods-source:query')")
    public CommonResult<List<RefuseRecordRespVO>> getRefuseDetail(@RequestParam("id") Long id) {
        List<RefuseRecordDO> refuseRecordDOList = refuseRecordService.getRefuseByAssociatedId(id);
        List<RefuseRecordRespVO> respVOList = RefuseRecordConvert.INSTANCE.convertList(refuseRecordDOList);
        for (RefuseRecordRespVO refuseRecordRespVO : respVOList) {
            RefuseTypeEnum refuseTypeEnum = refuseRecordRespVO.getType();
            //处理拒绝方企业信息
            Long tenantId = refuseRecordRespVO.getTenantId();
            EnterpriseDO enterpriseDO = enterpriseService.getEnterprise(tenantId);
            if (ObjectUtil.isAllNotEmpty(enterpriseDO)) {
                refuseRecordRespVO.setEnterpriseName(enterpriseDO.getName());
            }
            //处理拒绝关联的是运单还是委托单、用车、报价等信息
            Long associatedId = refuseRecordRespVO.getAssociatedId();
            if (RefuseTypeEnum.CAR_SOURCE.equals(refuseTypeEnum)) {
                TradehallProcessDO processDO = tradehallProcessService.getTradehallProcess(associatedId);
                if (null != processDO) {
                    refuseRecordRespVO.setReportPriceInfo(processDO);
                }
            }
        }
        return success(respVOList);
    }
    @GetMapping("/getWaitReceivePage")
    @Operation(summary = "交易大厅-获得车源待接单记录")
    public CommonResult<PageResult<TradehallProcessRespVO>> getWaitReceivePage(@Valid TradehallProcessPageReqVO pageVO) {
        PageResult<TradehallProcessDO> pageResult = tradehallProcessService.getTradehallProcessPageByCarsourceId(pageVO);
        PageResult<TradehallProcessRespVO> priceRespVOPageResult= TradehallProcessConvert.INSTANCE.convertPage(pageResult);
        for (TradehallProcessRespVO reportPriceDO : priceRespVOPageResult.getList()) {
            //通过货源id封装货源信息
            Long goodsId = reportPriceDO.getOrderId();
            TransportTaskEntrustorderDO tradeHallGoodsSourceDO = transportTaskEntrustorderService.getTransportTaskEntrustorder(goodsId);
            if(null!=tradeHallGoodsSourceDO){
                if (WebFrameworkUtils.getTenantId().equals(tradeHallGoodsSourceDO.getTenantId())) {
                    tradeHallGoodsSourceDO.setIsControl(true);
                }
                //处理过期日期的设置
                if(null==tradeHallGoodsSourceDO.getExpireDate() || DateUtils.StringToYMDLocalDate("1970-01-01").equals(tradeHallGoodsSourceDO.getExpireDate())){
                    tradeHallGoodsSourceDO.setExpireDateTips("永久有效");
                }else{
                    tradeHallGoodsSourceDO.setExpireDateTips(tradeHallGoodsSourceDO.getExpireDate()+" "+tradeHallGoodsSourceDO.getExpireTime());
                }
                reportPriceDO.setTransportTaskEntrustorderDO(tradeHallGoodsSourceDO);
            }
            //处理车源信息
            Long carSourceId = reportPriceDO.getCarsSourceId();
            TradehallCarSourceDO tradehallCarSourceDO = tradehallCarSourceService.getTradehallCarSource(carSourceId);
            if(null!=tradehallCarSourceDO){
                reportPriceDO.setTradehallCarSourceDO(tradehallCarSourceDO);
            }
        }
        return success(priceRespVOPageResult);
    }
    @GetMapping("/getUserCarRecordPage")
    @Operation(summary = "交易大厅-获得用车记录")
    public CommonResult<List<TradehallProcessRespVO>> getUserCarRecordPage(@Valid TradehallProcessPageReqVO pageVO) {
        List<TradehallProcessDO> list = tradehallProcessService.getUserCarRecordPageByCarSourceId(pageVO.getCarsSourceId());
        List<TradehallProcessRespVO> priceRespVOPageResult = TradehallProcessConvert.INSTANCE.convertList(list);
        for (TradehallProcessRespVO reportPriceDO : priceRespVOPageResult) {
            TradehallCarSourceDO tradehallCarSourceDO = tradehallCarSourceService.getTradehallCarSource(reportPriceDO.getCarsSourceId());
            if(WaybillTypeEnum.ASSIGN.equals(reportPriceDO.getOrderType())){
                Long taskId = reportPriceDO.getTaskId();
                TransportTaskOrderDO transportTaskOrderDO =transportTaskOrderService.getSingleTransportTaskOrder(taskId);
                if(null!=transportTaskOrderDO){
                    if(null!=tradehallCarSourceDO &&(!tradehallCarSourceDO.getTenantId().equals(WebFrameworkUtils.getTenantId()))){
                        BigDecimal entrustPrice = transportTaskOrderDO.getEntrustPrice();
                        reportPriceDO.setEntrustPrice(null==entrustPrice?null:entrustPrice);
                    }else {
                        reportPriceDO.setEntrustPrice(null);
                    }
                    transportTaskOrderDO.setEntrustPrice(null);
                    transportTaskOrderDO.setPrice(null);
                    reportPriceDO.setGoodsWeight(transportTaskOrderDO.getWeight());
                    reportPriceDO.setTransportTaskOrderDO(transportTaskOrderDO);
                }
            }else{
                Long goodsId = reportPriceDO.getOrderId();
                TransportTaskEntrustorderDO tradeHallGoodsSourceDO = transportTaskEntrustorderService.getTransportTaskEntrustorder(goodsId);
                if(null!=tradeHallGoodsSourceDO){
                    if (WebFrameworkUtils.getTenantId().equals(tradeHallGoodsSourceDO.getTenantId())) {
                        tradeHallGoodsSourceDO.setIsControl(true);
                    }
                    if(null!=tradehallCarSourceDO &&(!tradehallCarSourceDO.getTenantId().equals(WebFrameworkUtils.getTenantId()))){
                        BigDecimal entrustPrice = tradeHallGoodsSourceDO.getEntrustPrice();
                        reportPriceDO.setEntrustPrice(null==entrustPrice?new BigDecimal(""):entrustPrice);
                    }else {
                        reportPriceDO.setEntrustPrice(null);
                    }
                    tradeHallGoodsSourceDO.setEntrustPrice(null);
                    tradeHallGoodsSourceDO.setSearchCarPrice(null);
                    tradeHallGoodsSourceDO.setDealPrice(null);
                    tradeHallGoodsSourceDO.setExpectedPrice(null);
                    tradeHallGoodsSourceDO.setGoodsPrice(null);
                    tradeHallGoodsSourceDO.setAssignPrice(null);
                    reportPriceDO.setGoodsWeight(tradeHallGoodsSourceDO.getWeight());
                    reportPriceDO.setTransportTaskEntrustorderDO(tradeHallGoodsSourceDO);
                }
            }
            //
        }
        return success(priceRespVOPageResult);
    }
}
