package com.testSSM.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IUserDao;
import com.testSSM.test.model.User;
import com.testSSM.test.service.UserService;

import freemarker.template.Template;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private IUserDao testMapper;
	
	@Override
	public User findById(User t) {
		return this.testMapper.findById(t.getAccount());
	}

	@Override
	public int save(User user) {
		return this.testMapper.save(user);
	}

	@Override
	public List<User> query() {
		return this.testMapper.query();
	}

	@Override
	public User findById(String id) {
		return testMapper.findById(id);
	}

	@Override
	public int remove(String id) {
		return testMapper.remove(id);
	}

	@Override
	public int update(User user) {
		return 0;
	}

	@Override
	public User queryAccount(String account) {
		return testMapper.queryAccount(account);
	}

	@Override
	public List<User> queryUserList(String param) {
		return testMapper.queryUserList(param);
	}

}
