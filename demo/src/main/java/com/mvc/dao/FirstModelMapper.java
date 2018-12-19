package com.mvc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.model.FirstModel;

/**
 * Created by AB052409 on 2016/12/7.
 */
@Mapper
public interface FirstModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FirstModel record);

    int insertSelective(FirstModel record);

    FirstModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirstModel record);

    int updateByPrimaryKey(FirstModel record);
}
