package com.eyric.base.utils.wx;

import java.util.List;

/**
 * 模板消息
 *
 * @author lwt
 */
public class MessageBody {

    private String touser;

    private String templateId;

    private String url;

    private String topcolor;

    private List<MessageData> messageDatas;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public List<MessageData> getMessageDatas() {
        return messageDatas;
    }

    public void setMessageDatas(List<MessageData> messageDatas) {
        this.messageDatas = messageDatas;
    }

}