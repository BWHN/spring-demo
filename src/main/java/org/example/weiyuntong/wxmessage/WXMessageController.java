package org.example.weiyuntong.wxmessage;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.weiyuntong.framework.common.pojo.CommonResult;
import com.weiyuntong.framework.idempotent.core.annotation.Idempotent;
import com.weiyuntong.framework.operatelog.core.annotations.OperateLog;
import com.weiyuntong.module.bizcenter.service.wxmessage.WXMessageService;
import com.weiyuntong.module.bizcenter.util.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.weiyuntong.framework.common.pojo.CommonResult.success;

/**
 * 微信消息订阅相关
 */

@Tag(name = "微信订阅")
@RestController
@RequestMapping("/wxmessage")
@Slf4j
@Validated
public class WXMessageController {


    /**
     * 消息推送模块 配置的Token令牌
     */
    private static final String Token = "aaaaaaaaaaa";
    /**
     * EncodingAESKey(消息加密密钥)
     */
    private static final String EncodingAESKey = "S5k9uskSAs9A0F6yt8BsaDeAneqPmXjRmbofVeBBVc4";


    @Resource
    private WXMessageService wxMessageService;

    /**
     * 微信回调接口
     * 用于小程序用户向我发送是否同意授权通知  此接口需要配置成不需登录 /api 配置成无需登录
     * @return
     */
    @RequestMapping(value = "/api/get")
    @ResponseBody
    public String get(HttpServletRequest request,
                      String signature, String timestamp, String nonce, String echostr ,
                      String openId , String msg_signature , String encrypt_type) {
        if (request.getMethod().equalsIgnoreCase("get")) {
            //校验 参数
            String sha1 = SHA1Util.getSHA1(Token, timestamp, nonce);
            if (!sha1.equals(signature)){
                return "error";
            }
            return echostr;
        } else if (request.getMethod().equalsIgnoreCase("POST")) {
            //接收用户的相关行为事件结果
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
                StringBuilder requestContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    requestContent.append(line);
                }
                reader.close();

                //校验 参数
                JSONObject jsonObject = JSONUtil.parseObj(requestContent.toString());
                String sha1 = SHA1Util.getSHA1(Token, timestamp, nonce, (String) jsonObject.get("Encrypt"));
                if (!sha1.equals(msg_signature)){
                    log.info("不正确的回调");
                    return "error";
                }
                log.info("正常接收微信回调:" + requestContent.toString());

                byte[] aesKey  = Base64.decode(EncodingAESKey + "=");

                // 解密 存储回调相关信息
                wxMessageService.saveWXCallbackMessage(aesKey ,(String) jsonObject.get("Encrypt"));

                return "success";
            } catch (Exception e) {
                // 处理异常情况
                e.printStackTrace();
                log.error("异常接收微信回调：" + e.getMessage());
                return e.toString();
            }
        } else {
            log.info("微信回调接口异常");
            return "";
        }
    }



    @GetMapping("/sendSubscribeMessageTest")
    @Operation(summary = "根据车次编号向用户发生订阅信息")
    @OperateLog(enable = false)
    @Idempotent
    public CommonResult<Boolean> checkCode(@RequestParam("waybillCarNo") String waybillCarNo) {
//        wxMessageService.sendSubscribeMessageByWaybillCarNoDeparted(waybillCarNo);
        return success(true);
    }





}
