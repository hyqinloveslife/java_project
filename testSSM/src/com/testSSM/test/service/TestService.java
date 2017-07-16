package com.testSSM.test.service;

import com.testSSM.test.model.User;

public interface TestService {
	public User queryTest();
	
	public User findById(String id);

	public User queryAccount(String account);
}
