package com.testSSM.test.dao;

import java.util.List;

import com.testSSM.test.model.User;

public interface IUserDao {
	public List<User> query();
	
	public User queryTest();
	
	public User findById(String id);

	public User queryAccount(String account);
	
	public int save(User user);

	public List<User> queryUserList(String param);
	
	public int remove(String id);
}
