package com.testSSM.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IUserDao;
import com.testSSM.test.model.User;
import com.testSSM.test.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService{

	@Resource
	private IUserDao testMapper;

	@Override
	public User queryTest() {
		return this.testMapper.queryTest();
	}


	@Override
	public User findById(String id) {
		return this.testMapper.findById(id);
	}


	@Override
	public User queryAccount(String account) {
		// TODO Auto-generated method stub
		return this.testMapper.queryAccount(account);
	}

}
