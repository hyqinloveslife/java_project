package com.testSSM.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.common.db.Wrapper;
import com.testSSM.test.dao.IUserDao;
import com.testSSM.test.model.User;
import com.testSSM.test.service.TestService;

@Service
@Transactional
public class TestServiceImpl extends JdbcDaoSupport implements TestService{

	@Resource
	private IUserDao testMapper;

	@Override
	public User queryTest() {
		
		List<Map<String, Object>> list = this.getJdbcTemplate().query("",new Wrapper(User.class));
		System.out.println(list);
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
