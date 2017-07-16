package com.testSSM.test.service;

import java.util.List;

public interface IBaseService<T>{
	public T findById(T t);
	
	public int save(T t);
	
	public int remove(String id);
	
	public int update(T t);
	
	public List<T> query();
	
}
