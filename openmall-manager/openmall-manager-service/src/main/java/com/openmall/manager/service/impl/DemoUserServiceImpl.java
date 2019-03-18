package com.openmall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openmall.manager.dao.DemoUserMapper;
import com.openmall.manager.pojo.DemoUser;
import com.openmall.manager.service.DemoUserService;

@Service
public class DemoUserServiceImpl implements DemoUserService{
	
	@Autowired
	DemoUserMapper demouserMapper;

	@Override
	public List<DemoUser> getAll() {
		return demouserMapper.getAll();
	}
	
	

}