package com.eyric.base.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Entity - 插件配置
 */
@Entity
@Table(name = "xx_plugin_config")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "xx_plugin_config_sequence")
public class PluginConfig extends OrderEntity {

    private static final long serialVersionUID = -4357367409438384806L;

    /**
     * 插件ID
     */
    private String pluginId;

    /**
     * 是否启用
     */
    private Boolean isEnabled;

    /**
     * 是否是移动端
     */
    private Boolean isMobile;

    /**
     * 是否是电脑端
     */
    private Boolean isPc;

    /**
     * 属性
     */
    private Map<String, String> attributes = new HashMap<String, String>();

    /**
     * 获取插件ID
     *
     * @return 插件ID
     */
    @Column(nullable = false, updatable = false, unique = true, length = 100)
    public String getPluginId() {
        return pluginId;
    }

    /**
     * 设置插件ID
     *
     * @param pluginId 插件ID
     */
    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    /**
     * 获取是否启用
     *
     * @return 是否启用
     */
    @Column(nullable = false)
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * 设置是否启用
     *
     * @param isEnabled 是否启用
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * 获取是否是移动端
     *
     * @return 是否是移动端
     */
    @Column(nullable = false)
    public Boolean getIsMobile() {
        return isMobile;
    }

    /**
     * 设置是否是移动端
     *
     * @param isMobile 是否是移动端
     */
    public void setIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
    }

    /**
     * 获取是否是电脑端
     *
     * @return 是否是电脑端
     */
    @Column(nullable = false)
    public Boolean getIsPc() {
        return isPc;
    }

    /**
     * 设置是否是电脑端
     *
     * @param isPc 是否是电脑端
     */
    public void setIsPc(Boolean isPc) {
        this.isPc = isPc;
    }

    /**
     * 获取属性
     *
     * @return 属性
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "xx_plugin_config_attribute")
    @MapKeyColumn(name = "name", length = 100)
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * 设置属性
     *
     * @param attributes 属性
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * 获取属性值
     *
     * @param name 属性名称
     * @return 属性值
     */
    @Transient
    public String getAttribute(String name) {
        if (getAttributes() != null && name != null) {
            return getAttributes().get(name);
        } else {
            return null;
        }
    }

    /**
     * 设置属性值
     *
     * @param name  属性名称
     * @param value 属性值
     */
    @Transient
    public void setAttribute(String name, String value) {
        if (getAttributes() != null && name != null) {
            getAttributes().put(name, value);
        }
    }
}