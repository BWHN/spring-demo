package org.example.weiyuntong.xintong.aop;

import com.alibaba.fastjson.JSONObject;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.common.util.string.StringUtil;
import com.weiyuntong.module.agencycenter.agency.util.hz.exception.EsignDemoException;
import com.weiyuntong.module.bizcenter.api.xintong.util.CommonUtil;
import com.weiyuntong.module.bizcenter.dal.dataobject.openapi.OpenApiConfigDO;
import com.weiyuntong.module.bizcenter.dal.mysql.openapi.OpenApiConfigMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
@Aspect
@Slf4j
public class SignatureCheckAspect {

    @Resource
    private OpenApiConfigMapper openApiConfigMapper;

    @Pointcut("within(com.weiyuntong.module.bizcenter.api.xintong.XinTongController)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        // 获取请求体
        String requestBody = getResponseBody(request);
        // 验签
        CommonResult<String> checkResult = checkSignature(request, requestBody);
        if (checkResult.isSuccess()) {
            // 验签通过，执行实际方法
            return joinPoint.proceed();
        } else {
            return checkResult;
        }
    }

    private String getResponseBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while(line != null){
            builder.append(line);
            line = reader.readLine();
        }
        reader.close();
        return builder.toString();
    }


    private CommonResult<String> checkSignature(HttpServletRequest request, String requestBody) throws EsignDemoException {
        String merchantCode = request.getHeader("merchantCode");
        String merchantId = request.getHeader("merchantId");
        String signature = request.getHeader("signature");
        if (StringUtil.isEmpty(merchantCode)) {
            return CommonResult.error(400001,"merchantCode不能为空");
        } else if (StringUtil.isEmpty(merchantId)) {
            return CommonResult.error(400002,"merchantId不能为空");
        } else if (StringUtil.isEmpty(signature)) {
            return CommonResult.error(400003,"signature不能为空");
        }
        OpenApiConfigDO configDO = openApiConfigMapper.selectByCodeId(merchantCode, merchantId);
        if (configDO == null) {
            return CommonResult.error(400004,"商户不存在");
        }
        String merchantSecret = configDO.getMerchantSecret();
        JSONObject json = JSONObject.parseObject(requestBody);
        String generateSignature = createSignature(request.getRequestURI(), json, merchantSecret);
//        if (!signature.equals(generateSignature)) {
//            return CommonResult.error(400005,"非法签名");
//        }
        return CommonResult.success();
    }

    // url 获取方式为 request.getRequestURI()
    private String createSignature(String url, Map<String, Object> params, String merchantSecret) throws EsignDemoException {
        StringBuilder sb = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<>(String::compareTo);
        sortParams.putAll(params);
        // 遍历排序的字典,并拼接 "key=value" 格式
        for (Map.Entry<String, Object> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                String valueString = entry.getValue().toString();
                if (StringUtils.isNotEmpty(valueString)) {
                    sb.append("&").append(key).append("=").append(value);
                }
            }
        }
        String stringA = sb.toString().replaceFirst("&","?");
        String stringSignTemp = url + stringA + "&merchantSecret=" + merchantSecret;
        //将签名使用MD5加密并全部字母变为大写
        String signValue = CommonUtil.encryptMD5(stringSignTemp).toUpperCase();
        log.info("MD5加密+转换全部大写生成sign为：{}", signValue);
        return signValue;
    }

    public static void main(String[] args) throws EsignDemoException {
        String url = "/bizcenter/api/changeWaybillStatusCallBack";
        Map<String, Object> params = new HashMap<>();
        params.put("waybillSourceNo", "YD202501170005");
        params.put("waybillSourceStatus", "TO_UNLOADED");
        params.put("eventImages", "https://xtbdfile.oss-cn-hangzhou.aliyuncs.com/200000/202501/20250116/8638310849716480.jpg");
        params.put("lng", "118.70137709305754");
        params.put("lat", "32.081968676389515");
        params.put("eventTime", "2025-01-17 12:00:00");
        new SignatureCheckAspect().createSignature(url, params, "OAFnSzM1cKebNerJi52dijGc3xjhctaM");
    }

}
