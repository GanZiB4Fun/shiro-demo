package com.ganzib.entity;

import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * url地址
     */
    private String url;

    /**
     * url描述
     */
    private String name;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取url地址
     *
     * @return url - url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url地址
     *
     * @param url url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取url描述
     *
     * @return name - url描述
     */
    public String getName() {
        return name;
    }

    /**
     * 设置url描述
     *
     * @param name url描述
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}