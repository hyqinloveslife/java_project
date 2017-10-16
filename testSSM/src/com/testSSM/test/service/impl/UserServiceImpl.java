package com.testSSM.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.testSSM.test.common.PageHelper;
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

	/* (non-Javadoc)
	 * @see com.testSSM.test.service.UserService#selectUserByPage(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<User> selectUserByPage(@Param("startPos") Integer startPos,
			@Param("pageSize") Integer pageSize, @Param("id") Integer id) {
		
		return testMapper.selectUserByPage(startPos, pageSize, id);
	}

	/* (non-Javadoc)
	 * @see com.testSSM.test.service.UserService#getUsersCount(java.lang.Integer)
	 */
	@Override
	public long getUsersCount(@Param("id") Integer id) {
		
		return testMapper.getUsersCount(id);
	}

	/* (non-Javadoc)
	 * @see com.testSSM.test.service.UserService#showProductsByPage(javax.servlet.http.HttpServletRequest, org.springframework.ui.Model, int)
	 */
	@Override
	public void showProductsByPage(HttpServletRequest request, Model model,
			int loginUserId) {
		String pageNow = request.getParameter("pageNow");
		PageHelper helper=null;
		
		List<User> users = new ArrayList<User>();
		
		int totalCount = (int) testMapper.getUsersCount(loginUserId);
		
		if(pageNow!=null){
			helper = new PageHelper(totalCount, Integer.parseInt(pageNow));
			users = this.testMapper.selectUserByPage(helper.getStartPos(), helper.getPageSize());
		}else{
			helper = new PageHelper(totalCount, 1);
			users = this.testMapper.selectUserByPage(helper.getStartPos(), helper.getPageSize());
		}
		model.addAttribute("users",users);
		model.addAttribute("page",helper);
	}

	/* (non-Javadoc)
	 * @see com.testSSM.test.service.UserService#selectUserByPage(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<User> selectUserByPage(int startPos,  int pageSize) {
		return this.testMapper.selectUserByPage(startPos, pageSize);
	}

}
