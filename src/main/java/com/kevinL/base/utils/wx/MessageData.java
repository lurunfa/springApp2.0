package com.eyric.base.utils.wx;

/**
 * 模板消息数据
 *
 * @author lwt
 */
public class MessageData {

    //数据名称
    private String name;
    //数据值
    private String value;
    //数据颜色
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}