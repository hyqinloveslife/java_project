package com.testSSM.test.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;


import com.testSSM.test.model.User;

public interface IUserDao {
	public List<User> query();
	
	public User queryTest();
	
	public User findById(String id);

	public User queryAccount(String account);
	
	public int save(User user);

	public List<User> queryUserList(String param);
	
	public int remove(String id);
	
	/**
	 * 使用注解方式传入多个参数，用户产品分页，通过登录用户ID查询 
	 * @date 2017-7-29  
	 * @version 1.0.0 
	 * @param startPos  
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public List<User> selectUserByPage(@Param(value="startPos") Integer startPos
			,@Param(value="pageSize") Integer pageSize,@Param(value="id") Integer id);
	
	public List<User> selectUserByPage(int startPos, int pageSize);
	/**
	 * 取得产品数量信息，通过登录用户ID查询
	 * @date 2017-7-29  
	 * @version 1.0.0 
	 * @param id
	 * @return
	 */
	public long getUsersCount(@Param(value="id") Integer id);
	
	
}
