package org.example.ali_ev;

import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.exception.UploadFileException;
import com.alibaba.dashscope.utils.JsonUtils;
import org.example.ali_ev.talk.TalkPicture;
import org.example.ali_ev.talk.TalkSingle;

public class Main {

    public static void main(String[] args) {
        // 单轮对话
        try {
            GenerationResult result = TalkSingle.callWithMessage("马云是世界上最聪明的人吗？");
            System.out.println(JsonUtils.toJson(result));
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            // 使用日志框架记录异常信息
            // Logger.error("An error occurred while calling the generation service", e);
            System.err.println("An error occurred while calling the generation service: " + e.getMessage());
        }
        System.exit(0);

        // 图片对话
        try {
            TalkPicture.simpleMultiModalConversationCall("https://osslianfile.oss-cn-beijing.aliyuncs.com/南京维链数字科技公司/车辆相关/efcae81caa36f3e26524456ca27ae7d753ea649a5fbb6ef240c5c32e0b50d2da.jpg");
        } catch (ApiException | NoApiKeyException | UploadFileException e) {
            System.out.println(e.getMessage());
        }
        System.exit(0);
    }

}