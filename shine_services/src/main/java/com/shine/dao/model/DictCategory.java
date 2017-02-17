package com.shine.dao.model;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("dict_category")
public class DictCategory {
    private Integer id;

    private String dictName;

    private Byte isConfig;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public Byte getIsConfig() {
        return isConfig;
    }

    public void setIsConfig(Byte isConfig) {
        this.isConfig = isConfig;
    }
}