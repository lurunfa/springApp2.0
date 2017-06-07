package com.eyric.base.utils.wx;


/**
 * 模板消息发送工具类
 *
 * @author lwt
 */
public class Provider {

    private static final String TEST_TEMPLATE_ID = "GV3c3NYtMzO4lc1gyUtL9YouWOyDFCNUnuecjAVwxO8";

    private Provider() {
    }

    /**
     * 发送测试信息
     *
     * @param messageBody 模板消息
     * @return 是否发送成功
     */
    public static Integer sendTestMessage(MessageBody messageBody) {
        messageBody.setTemplateId(TEST_TEMPLATE_ID);
        return MessageUtil.send(messageBody);
    }

}