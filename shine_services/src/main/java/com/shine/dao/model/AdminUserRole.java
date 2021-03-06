package com.shine.dao.model;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("admin_user_role")
public class AdminUserRole {
    private Long id;

    private Long uid;

    private Long rid;

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

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}