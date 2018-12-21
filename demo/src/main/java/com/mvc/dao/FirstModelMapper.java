package com.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.model.FirstModel;

/**
 * Created by AB052409 on 2016/12/7.
 */
@Mapper
public interface FirstModelMapper {
	
	List<FirstModel> findAll();
	
    int deleteByPrimaryKey(String id);

    int insert(FirstModel record);

    int insertSelective(FirstModel record);

    FirstModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FirstModel record);

    int updateByPrimaryKey(FirstModel record);
}
