package com.shine.dao.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("admin_sys_log")
public class AdminSysLog {
    private Long id;

    private Long uid;

    private String content;

    private String operation;

    private Long crtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public Long getCrtime() {
        return crtime;
    }

    public void setCrtime(Long crtime) {
        this.crtime = crtime;
    }
}