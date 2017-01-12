package com.shine.dao;

import com.shine.dao.model.DictCategory;

import java.util.List;

public interface DictCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCategory record);

    int insertSelective(DictCategory record);

    DictCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictCategory record);

    int updateByPrimaryKey(DictCategory record);

    List<DictCategory> getByAllDicts();


}