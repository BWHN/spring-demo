package org.example.module.bizcenter.enums;

import com.weiyuntong.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    // ========== 业务中心发送 1002029000 ==========
    ErrorCode TRANSPORT_TASK_ORDER_NOT_EXISTS = new ErrorCode(1002029000, "平台未查询该任务需求单信息,请检查是否有误");

    // ========== 业务中心-任务单审核 1002029001 ==========
    ErrorCode TASKORDER_BIDDING_RECORD_NOT_EXISTS = new ErrorCode(1002029001, "平台未查询该任务单审核信息");
    // ========== 业务中心-任务单拒绝 1002029002 ==========
    ErrorCode TASKORDER_REFUSE_RECORD_NOT_EXISTS = new ErrorCode(1002029002, "平台未查询到该任务单记录");

    // ========== 业务中心-任务单编码存在 1002029002 ==========
    ErrorCode TRANSPORT_TASK_ORDER_CODE_EXISTS = new ErrorCode(1002029003, "任务单编码已存在");
    // ========== 业务中心-任务单编码存在 1002029002 ==========
    ErrorCode TRANSPORT_TASK_ORDER_REVOKED = new ErrorCode(1002029004, "任务单当前状态不支持撤销");

    ErrorCode TRANSPORT_TASK_ENTRUSTORDER_NOT_EXISTS = new ErrorCode(1002029005, "平台未查询该任务需求单,请检查是否有误");

    ErrorCode TRANSPORT_TASK_MATCH_NOT_EXISTS = new ErrorCode(1002029006, "平台未查询到任务匹配信息,请检查是否有误");
    ErrorCode TRANSPORT_TASK_ASSIGN_NOT_EXISTS = new ErrorCode(1002029007, "平台未查询该指派信息,请检查是否有误");

    ErrorCode TRANSPORT_TASK_ENTRUSTORDER_ISSUED_TASK = new ErrorCode(1002029005, "平台检测到该任务未处于待下发环节，请核查后重新提交!");

    ErrorCode TRANSPORT_TASK_ENTRUSTORDER_RECEIVED_TASK = new ErrorCode(1002029005, "平台检测到该任务未处于待接单环节，请核查后重新提交!");

    ErrorCode ENTRUSTORDER_ISSUED_RECORD_NOT_EXISTS = new ErrorCode(1002029006, "平台检测到任务下发记录信息，请核查后重新提交!");

    ErrorCode TRANSPORT_TASK_ORDER_CHILD_NOT_EXIST = new ErrorCode(1002029007, "平台检测到当前无关联任务信息，请核查后重新提交!");
    ErrorCode TRANSPORT_TASK_ORDER_VALID_WEIGHT = new ErrorCode(1002029008, "剩余吨数与总吨数计算不符，请核查后重新提交!");

    ErrorCode TRANSPORT_TASK_ORDER_VALID_PUBLISH = new ErrorCode(1002029009, "总吨数目前不支持在此再次发布，请检查!");

    ErrorCode TRANSPORT_TASK_ORDER_REVOKE_REMAIN = new ErrorCode(1002029010, "该任务需求可能被忽略或剩余量已小于0，不能执行撤销操作");
    ErrorCode TRANSPORT_TASK_ORDER_REVOKE = new ErrorCode(1002029010, "分配重量大于剩余重量");

    ErrorCode TRANSPORT_TASK_MATCH_ENT_NOT_EXISTS= new ErrorCode(1002029010, "平台未检测到企业信息，请核查后重新提交");
    ErrorCode TRANSPORT_TASK_MATCH_WEIGHT_COMPARE= new ErrorCode(1002029010, "分配量超过车辆核载量【{}】，请修改后重新提交");
    ErrorCode TRANSPORT_TASK_CAR_WEIGHT_COMPARE= new ErrorCode(1002029010, "分配量已超过委托量，请修改后重新提交");
    ErrorCode TRANSPORT_TASK_ORDER_PUBLISH= new ErrorCode(1002029010, "您发布的任务单当前未处于待发布状态或已被他人操作，请核实后重新发布");

    ErrorCode TRANSPORT_WAYBILL_NOT_EXISTS= new ErrorCode(1002029010, "平台未检测到与当前任务匹配的运单，请核实后重新操作");

    // ========== 交易大厅-货源大厅 ==========
    ErrorCode TRADEHALL_GOODS_SOURCE_NOT_EXISTS= new ErrorCode(1002029011, "平台未检测到相关货源信息，请核实后重新操作");
    ErrorCode TRADEHALL_GOODS_REPORT_PRICE_NOT_EXISTS= new ErrorCode(1002029012, "平台未检测到相关货源报价信息，请核实后重新操作");
    ErrorCode TRADEHALL_GOODS_RECOMMEND_CONFIG_NOT_EXISTS= new ErrorCode(1002029013, "平台未检测到相关货源推荐设置信息，请核实后重新操作");
    ErrorCode TRADEHALL_CAR_RECOMMEND_CONFIG_NOT_EXISTS= new ErrorCode(1002029014, "平台未检测到相关车源推荐设置信息，请核实后重新操作");
    ErrorCode TRADEHALL_CAR_SOURCE_NOT_EXISTS= new ErrorCode(1002029015, "平台未检测到相关车源信息，请核实后重新操作");
    ErrorCode TRADEHALL_CAR_NOT_EXISTS= new ErrorCode(1002029016, "平台未检测到相关车源车辆信息，请核实后重新操作");
    ErrorCode GOODS_REFUSE_RECORD_NOT_EXISTS= new ErrorCode(1002029017, "平台未检测到相关拒绝记录信息，请核实后重新操作");
    ErrorCode REFUSE_RECORD_NOT_EXISTS= new ErrorCode(1002029018, "平台未检测到相关拒绝记录信息，请核实后重新操作");

    ErrorCode REVOKE_RECORD_NOT_EXISTS= new ErrorCode(1002029019, "平台未检测到相关撤销记录信息，请核实后重新操作");

    ErrorCode TRADEHALL_GOODS_REPORT_PRICE_FAIL= new ErrorCode(1002029020, "当前货源委托不能满足本次报价的确认,下次请尽快确认");
    ErrorCode TRADEHALL_GOODS_REPORT_PRICE_WEIGHT_COMPARE= new ErrorCode(1002029021, "上报运量不能超过剩余运量");
    ErrorCode GOONDS_CONFIRM_FAIL= new ErrorCode(1002029020, "您确认的报价信息已被确认或关闭，请更换其它货源委托!");
    ErrorCode GOONDS_REPORT_REFUSE= new ErrorCode(1002029021, "您所拒绝的报价信息识别有误，请更换其它货源委托!");

    ErrorCode GOONDS_REPORT_REVOKE= new ErrorCode(1002029022, "您所撤销的报价信息识别有误，请更换或重试!");

    ErrorCode TRADEHALL_VEHICLEUSER_PRICE= new ErrorCode(1002029022, "您的用车数据中存在价格未分配或输入有误，请核实后提交!");

    ErrorCode TRADEHALL_VEHICLEUSER_WEIGHT= new ErrorCode(1002029023, "您的用车数据中重量有误，请核实后提交!");

    ErrorCode ORDER_INFO_NOT_EXIST= new ErrorCode(1002029024, "未查询到该信息【{}】请检查是否有误或已被抢先匹配用车");
    ErrorCode VEHICLE_REVOKE_TIPS= new ErrorCode(1002029025, "当前未处于待接单状态，不可进行撤销用车，可能已被其它人员操作，请刷新后再试");

    ErrorCode VEHICLE_REFUSE_TIPS= new ErrorCode(1002029026, "您所拒绝信息可能已被关联方撤销，请核实检查!");
    ErrorCode VEHICLE_RECEIVE_ORDER_TIPS= new ErrorCode(1002029027, "未查询当前提供的车源信息，请核实或刷新再试!");

    ErrorCode TRADEHALL_PROCESS_NOT_EXISTS= new ErrorCode(1002029028, "您查询的记录不存在或已被操作，请更换或刷新再试!");
    ErrorCode ENTERPRICE_INFO_NOT_EXISTS= new ErrorCode(1002029029, "参与企业信息有误，请更换或联系您的企业管理员!");
    ErrorCode REPORT_PRICES_CAR_FAIL= new ErrorCode(1002029030, "当前参与报价车辆信息有误，请更换其它车辆或联系您的企业管理员!");
    ErrorCode REPORT_PRICES_ESCORT_FAIL= new ErrorCode(1002029031, "当前参与报价车辆押运员信息有误，请更换其它车辆或联系您的企业管理员!");
    ErrorCode ADDRESS_FAIL_TIPS= new ErrorCode(1002029032, "您装货地址信息有误或信息不全，请重新录入或更换其它地址!");
    ErrorCode UNLOAD_ADDRESS_FAIL_TIPS= new ErrorCode(1002029033, "您的卸货地址信息有误或信息不全，请重新录入或更换其它地址!");
    ErrorCode WAYBILL_ISSUED_TASK= new ErrorCode(1002029034, "当前关联的运单有误，请重试或更换其它运单!");
    ErrorCode USAGE_WEIGHT_TIPS= new ErrorCode(1002029035, "您用车分配的重量超出了车辆承载重量，请重新输入或更换其它车源!");
    ErrorCode ABNORMAL_ORDER_RECORD_NOT_EXISTS= new ErrorCode(1002029036, "当前记录不存在，请重新输入或更换记录!");
    ErrorCode TRADE_HALL_GOODS_SOURCE_STATUS_ERROR= new ErrorCode(1002029037, "平台未检测到货源状态不匹配，请核实后重新操作");

    ErrorCode TRANSPORT_ENTRUSTORDER_NOT_EXISTS = new ErrorCode(1002029038, "平台未查询该单据信息,请检查是否有误");
    ErrorCode CAR_INFO_NOT_EXIST = new ErrorCode(1002029039, "平台未查询该所选车辆信息,请检查是否有误");
    ErrorCode REPORT_INFO_NOT_EXIST = new ErrorCode(1002029040, "您所提交的操作信息有误,请检查或刷新重试");
    ErrorCode TRADE_HALL_GOODS_REPORT_TIPS= new ErrorCode(1002029042, "平台检测到您的上报价格或上报运量有误，请核查后重新提交!");
    ErrorCode BIZ_EXPENSE_INFO_NOT_EXISTS= new ErrorCode(1002029043, "平台未检测到您的费用信息，请核查!");
    ErrorCode BIZ_EXPENSE_TYPE_NOT_EXISTS= new ErrorCode(1002029044, "平台未检测到您的费用类型信息，请核查!");
    ErrorCode EXPENSE_INFO_NOT_EXISTS= new ErrorCode(1002029045, "平台未检测到您的费用信息，请核查!");
    ErrorCode BIZ_EXPENSE_IMAGE_LIST_NOT_EXISTS= new ErrorCode(1002029046, "平台未检测到您的费用图片信息，请核查!");
    ErrorCode BIZ_EXPENSE_IMAGE_CONFIG_NOT_EXISTS= new ErrorCode(1002029047, "平台未检测到您的费用配置信息，请核查!");
    ErrorCode BIZ_IMPREST_EDIT_RECORD_NOT_EXISTS= new ErrorCode(1002029048, "平台未检测到您编辑费用记录信息，请核查!");
    ErrorCode BIZ_IMPREST_NOT_EXISTS= new ErrorCode(1002029049, "平台未检测到您备用金记录信息，请核查!");

    ErrorCode WAYBILL_CAR_NOT_EXISTS= new ErrorCode(1002029050, "您提供的车次信息不存在，请检查后重新提交!");
    ErrorCode DRIVER_NOT_EXISTS= new ErrorCode(1002029051, "您提供的司机信息不存在，请检查后重新提交!");
    ErrorCode CAR_NOT_EXISTS= new ErrorCode(1002029052, "您提供的车辆信息不存在，请检查后重新提交!");
    ErrorCode EXPENSE_PAYMENT_RELATE_NOT_EXISTS= new ErrorCode(1002029053, "您提供的信息不存在，请检查后重新提交!");
    ErrorCode BIZ_EXPENSE_PAYMENT_NOT_EXISTS= new ErrorCode(1002029054, "您提供的信息有误，可能已被处理。请检查后重新提交!");
    ErrorCode ABNORMAL_ORDER_ASSIGN_NOT_EXISTS = new ErrorCode(1002029056, "您提供的信息不存在，请核查后重新提交!");
    ErrorCode ABNORMAL_ORDER_FOLLOW_NOT_EXISTS = new ErrorCode(1002029056, "您提供的信息不存在，请核查后重新提交!");
    ErrorCode REVOKE_ENTRUST_NOT_EXISTS = new ErrorCode(1002029057, "您撤销的货源委托信息不存在，请核查后重新提交!");
    ErrorCode BIZ_EXPENSE_TYPE_IS_EXIST_TIPS= new ErrorCode(1002029044, "费用类型信息已存在，请更换其它名称!");
    ErrorCode BIZ_EXPENSE_TYPE_NAME_NOT_EXISTS= new ErrorCode(1002029044, "请输入费用类型名称");
    ErrorCode BIZ_IMPREST_SET_TIPS= new ErrorCode(1002029045, "备用金金额未发生变化，无需设置!");
    ErrorCode ORDER_EXPIRED_NOT_EXIST= new ErrorCode(1002029046, "当前任务单已过期，请重新尝试或更换其它任务单");
    ErrorCode ABNORMAL_ORDER_ASSIGN_TIPS = new ErrorCode(1002029047, "您所分配的客户信息在该企业已存在，请更换其它平台企业从新分配!");

    ErrorCode ABNORMAL_ORDER_ASSIGN_NOT_STATUS_TIPS = new ErrorCode(1002029048, "您当前分配的信息已处理，请核查后重新提交!");
    ErrorCode ABNORMAL_ORDER_FLOW_NOT_STATUS_TIPS = new ErrorCode(1002029049, "您当前跟进的信息已处理，请核查后重新提交!");
    ErrorCode ABNORMAL_ORDER_FLOW_NOT_ASSIGN_TIPS = new ErrorCode(1002029049, "您当前分配的委托信息不存在!");
    ErrorCode ENTRUST_ORDER_PROFIT_BILL_COST = new ErrorCode(1002029005, "您尚未设置参数，请到运营中心-车次效益中设置相关参数！");
    ErrorCode ENTRUST_PRICE_TIPS = new ErrorCode(1002029050, "请提供委托运价!");
    ErrorCode SEARCH_PRICE_TIPS = new ErrorCode(1002029051, "请提供寻车运价!");
    ErrorCode BILLING_CYCLE_TIPS = new ErrorCode(1002029051, "请提供下游结算周期!");
    ErrorCode UP_BILLING_CYCLE_TIPS = new ErrorCode(1002029052, "请提供上游结算周期!");

    ErrorCode WEIGHT_TIPS = new ErrorCode(1002029053, "请提供货物重量!");
    ErrorCode PRICE_UNIT_TIPS = new ErrorCode(1002029054, "请提供结算单位!");
    ErrorCode CAR_WEIGHT_TIPS = new ErrorCode(1002029055, "请提供车辆载重!");
    ErrorCode CAR_INFO_TIPS = new ErrorCode(1002029056, "请提供车辆!");
    ErrorCode ENTRUST_INFO_TIPS = new ErrorCode(1002029057, "请选择货源委托单!");
    ErrorCode USER_BANK_ACCOUNT_NOT_EXISTS = new ErrorCode(1002029058, "用户银行账户信息不存在!");

    ErrorCode USER_BANK_NAME_DUPLICATE = new ErrorCode(1002015059, "名字为【{}】的账户已存在");
    ErrorCode USER_BANK_NUMBER_DUPLICATE = new ErrorCode(1002015060, "名字为【{}】的卡号已存在");
    ErrorCode OCR_BANK_RECEIPT_TIPS = new ErrorCode(1002015061, "您提供的银行回单信息不匹配，不能正确识别,请更换其它图片再试");
    ErrorCode OCR_BANK_RECEIPT_TIPS_OTHER = new ErrorCode(1002015061, "您提供的银行回单不能正确识别,请更换其它图片或手动输入");
    ErrorCode USER_ACCOUNT_BILL_TIPS = new ErrorCode(1002015062, "请选择账单！");
    ErrorCode USER_ACCOUNT_TYPE_TIPS = new ErrorCode(1002015063, "请提供用户账户类型！");
    ErrorCode USER_ACCOUNT_NAME_TIPS = new ErrorCode(1002015064, "请输入用户账户名称!");
    ErrorCode USER_ACCOUNT_NUMBER_TIPS = new ErrorCode(1002015065, "请输入用户账号!");
    ErrorCode USER_ACCOUNT_OPENING_BANK_TIPS = new ErrorCode(1002015066, "请输入开户行!");
    ErrorCode USER_ACCOUNT_INFO_TIPS = new ErrorCode(1002015067, "请完善用户账户信息!");
    ErrorCode USER_BILL_INFO_TIPS = new ErrorCode(1002015068, "请选择账单!");
    ErrorCode ENTRUST_ORDER_NOT_EXISTS_TIPS = new ErrorCode(1002015069, "未查询到指定的货源委托信息!");
    ErrorCode ENTRUST_ORDER_REPORT_PRICE_TYPE_NOT_MATCH_TIPS = new ErrorCode(1002015070, "当前确认货源委托类型不匹配!");
    ErrorCode ENTRUST_ORDER_REPORT_PRICE_NOT_MATCH_TIPS = new ErrorCode(1002015071, "当前货源委托未处理于待确认环节!请核实");

    ErrorCode ENTRUST_ORDER_REPORT_WEIGHT_NOT_MATCH_TIPS = new ErrorCode(1002015072, "当前货源委托剩余重量无法满足上报重量，请操作拒绝或撤销即可");
    ErrorCode USER_BILL_PERIOD_INFO_TIPS = new ErrorCode(1002015073, "请完善账期信息");
    ErrorCode VEHICLE_REVOKE_TIPS_IDS= new ErrorCode(1002029074, "没有可供撤销的用车记录,请选择需要撤销的用车信息");

    ErrorCode VEHICLE_REVOKE_TIPS_NULL= new ErrorCode(1002029075, "未查询到所需撤销的用车信息，可能已被其它人员操作，请刷新后再试");

    ErrorCode VEHICLE_CONFIRM_ORDER_TIPS= new ErrorCode(1002029076, "当前货源可能已过期或无效,确认失败，请重新选择!");

    ErrorCode VEHICLE_REVOKE_NOT_EXIST_TIPS= new ErrorCode(1002029077, "未查询到记录,请刷新后重试");
    ErrorCode VEHICLE_REVOKE_NOT_PARAM_TIPS= new ErrorCode(1002029078, "未收到撤销参数记录,请刷新后重试");
    ErrorCode GOODS_REPORT_PRICE_EXIST_TIPS= new ErrorCode(1002029079, "车牌号【{}】已存在待确认的报价");
    ErrorCode REVOKE_WAYBILLCAR_TIPS= new ErrorCode(1002029080, "未查询到车次信息,请核实后再试");
    ErrorCode DINGDING_PHONE_IS_NOT_SAME= new ErrorCode(1002029081, "钉钉绑定的手机号和系统中绑定的手机号不一致，请联系管理员修改一致");
    ErrorCode DINGDING_DEPT_IS_NULL= new ErrorCode(1002029082, "未根据此手机号查到用户部门信息，请重新在钉钉中分配");
    ErrorCode BIZ_EXPENSE_REFUND_TIPS= new ErrorCode(1002029083, "该费用已处于退回状态，无需再次退回!");
    ErrorCode DYNAMIC_IMAGE_UPDATE_TIPS= new ErrorCode(1002029084, "当前动态未处理待发车、待装货、待卸货、待核对状态，不可修改图片内容!");
    ErrorCode DESENSITIZE_RECORD_NOT_EXISTS= new ErrorCode(1002029085, "未查询到信息,请核实后再试");
    ErrorCode SETTLE_TYPE_TIPS = new ErrorCode(1002029086, "请提供结算方式(承兑或电汇)!");
    ErrorCode REPORT_ENTRUST_ORDER_NOT_EXIST_TIPS = new ErrorCode(1002029087, "参与报价的货源委托可能过期已下线,请更换其它货源委托进行报价!");
    ErrorCode REPORT_ENTRUST_ORDER_WEIGHT_TIPS = new ErrorCode(1002029088, "参与报价的货源委托剩余量不足,下次尽早作出选择!");

    ErrorCode PHONE_IS_NULL = new ErrorCode(1002029087, "请输入分享人手机号");
    ErrorCode PHONE_IS_EXIST = new ErrorCode(1002029089, "手机号为【{}】已存在此运单分享记录，请5分钟后重试");
    ErrorCode ASSIGN_WEIGHT = new ErrorCode(1002029090, "请输入分配重量");

    ErrorCode PROCESS_CAR_IS_LOADED= new ErrorCode(1002029091, "车牌号为【{}】运单已经完成装货，无法撤销该运力信息");
}
