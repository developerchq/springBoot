package com.mvc.service;

import java.util.List;

import com.mvc.model.FirstModel;


/**
 * Created by AB052409 on 2016/12/6.
 */
public interface FirstService  {
    public String getSomethingFromService(String str , FirstModel firstModel);
    public List<FirstModel> findAll();
    public FirstModel selectByPrimaryKey(String id);
	public int update(FirstModel firstModel);
	public int insert(FirstModel firstModel);
	public int delete(String id);
}
