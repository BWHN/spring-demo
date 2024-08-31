package org.example.ali_ev.talk;

import com.alibaba.dashscope.aigc.multimodalconversation.*;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.exception.UploadFileException;
import org.example.ali_ev.holder.ApyKeyHolder;

import java.util.Arrays;

public class TalkPicture extends ApyKeyHolder {

    public static void simpleMultiModalConversationCall(String imageUrl) throws ApiException, NoApiKeyException, UploadFileException {
        MultiModalConversation conv = new MultiModalConversation();
        MultiModalMessageItemImage userImage = new MultiModalMessageItemImage(imageUrl);
        MultiModalMessageItemText userText = new MultiModalMessageItemText("请以:{\"金额\": 从图片中读取, \"加油量\": 从图片中读取, \"升数\": " +
                "从图片中读取}的JSON格式，告诉我加油机上的金额、加油量、升数");
        MultiModalConversationMessage userMessage =
                MultiModalConversationMessage.builder().role(Role.USER.getValue())
                        .content(Arrays.asList(userImage, userText)).build();
        MultiModalConversationParam param = MultiModalConversationParam.builder()
                .model(MultiModalConversation.Models.QWEN_VL_CHAT_V1)
                .message(userMessage).build();
        MultiModalConversationResult result = conv.call(param);
        System.out.print(result);
    }

}
