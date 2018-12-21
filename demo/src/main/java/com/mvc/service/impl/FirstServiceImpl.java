package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.FirstModelMapper;
import com.mvc.model.FirstModel;
import com.mvc.service.FirstService;
@Service
public class FirstServiceImpl implements FirstService {

	@Autowired
	FirstModelMapper firstModelMapper;

	public String getSomethingFromService(String str, FirstModel firstModel) {
        FirstModel record = firstModelMapper.selectByPrimaryKey("1");
        if(record!=null){
            return record.getUserName();
        }
		return str;
	}
	public List<FirstModel> findAll() {
		List<FirstModel> list = firstModelMapper.findAll();
		return list;
	}
	public FirstModel selectByPrimaryKey(String id) {
		FirstModel beanFirstModel = firstModelMapper.selectByPrimaryKey(id);
		return beanFirstModel;
	}
	@Override
	public int update(FirstModel firstModel) {
		return firstModelMapper.updateByPrimaryKeySelective(firstModel);
	}
	public int insert(FirstModel firstModel) {
		return firstModelMapper.insertSelective(firstModel);
	}
	@Override
	public int delete(String id) {
		return firstModelMapper.deleteByPrimaryKey(id);
	}
}


