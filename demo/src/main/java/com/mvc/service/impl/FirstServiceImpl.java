package com.mvc.service.impl;

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
        FirstModel record = firstModelMapper.selectByPrimaryKey(1L);
        if(record!=null){
            return record.getUserName();
        }
		return str;
	}
}


