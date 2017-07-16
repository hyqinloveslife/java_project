package com.testSSM.test.service;

import java.util.List;

import com.testSSM.test.model.User;

public interface UserService extends IBaseService<User>{
	public int save(User user);
	
	public List<User> query();
	
	public User findById(String id);
	
	public int remove(String id);
	
	public int update(User user);
	
	public User queryAccount(String account);

	public List<User> queryUserList(String param);
}
