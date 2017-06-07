package com.eyric.base.utils.wx;

import com.eyric.base.utils.JsonUtils;
import com.eyric.base.utils.HttpUtil;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * 模板消息工具类
 *
 * @author lwt
 */
class MessageUtil {

    //添加模板id接口地址
    private static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
    //发送模板消息接口地址
    private static final String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

    private static Logger logger = Logger.getLogger(MessageUtil.class);

    private MessageUtil() {
    }

    /**
     * 获得模板id
     *
     * @param number 模板编号
     * @return 模板id
     */
    public static Integer getTemplateId(String number) {
        String url = GET_TEMPLATE_ID_URL + WxUtil.getAccessToken();
        String result = HttpUtil.sendPost(url, "{\"template_id_short\":\"" + number + "\"}");
        Map<String, Object> resultMap = JsonUtils.toObject(result, Map.class);
        Integer errcode = (Integer) resultMap.get("errcode");
        if (errcode != 0) {
            logger.error("获取模板id错误：" + resultMap.get("errmsg"));
            return null;
        }
        return (Integer) resultMap.get("template_id");
    }

    /**
     * 发送模板消息
     *
     * @param messageBody 消息
     * @return 消息id
     */
    public static Integer send(MessageBody messageBody) {
        String url = SEND_MSG_URL + WxUtil.getAccessToken();
        String json = "{\"touser\":\"" + messageBody.getTouser() + "\",\"template_id\":\"" + messageBody.getTemplateId() + "\",\"url\":\"" + messageBody.getUrl() + "\",\"topcolor\":\"" + messageBody.getTopcolor() + "\",\"data\": {";
        String data = "";
        for (MessageData messageData : messageBody.getMessageDatas()) {
            data += "\"" + messageData.getName() + "\":{\"color\":\"" + messageData.getColor() + "\",\"value\":\"" + messageData.getValue() + "\"},";
        }
        if (data.length() == 0) {
            return null;
        }
        json += data.substring(0, data.length() - 1);
        json += "}}";
        String result = HttpUtil.sendPost(url, json);
        Map<String, Object> resultMap = JsonUtils.toObject(result, Map.class);
        Integer errcode = (Integer) resultMap.get("errcode");
        if (errcode != 0) {
            logger.error("发送模板消息错误：" + resultMap.get("errmsg"));
            return null;
        }
        return (Integer) resultMap.get("msgid");
    }

}