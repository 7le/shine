package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.DictCategory;

import java.util.List;

public interface DictCategoryMapper extends BaseMapper<DictCategory> {
    int deleteByPrimaryKey(Integer id);

  /*  int insert(DictCategory record);*/

    int insertSelective(DictCategory record);

    DictCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictCategory record);

    int updateByPrimaryKey(DictCategory record);

    List<DictCategory> getByAllDicts();


}