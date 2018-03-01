/**
 * @author wws
 * @date 2017-7-6  
 * @version 1.0.0 
 */
package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.testSSM.test.service.FileRecordService;



/**
 * @author Administrator
 *
 */
public class BaseController {
	public static final int SUCCESS_STATUS_CODE=1;
	public static final int ERROR_STATUS_CODE=0;
	public static final String FILE_PATH = "D:\\ssm_img";
	
	public static final String USER = "user";
	
	@Resource
	public FileRecordService fileRecordService;
	
	/**
	 * 获取当前用户信息
	 * @author huangyq
	 * @date 2017-11-13  
	 * @version 1.0.0 
	 * @return
	 */
	public String getCommonUser(HttpServletRequest request ){
		String username = (String)request.getSession().getAttribute(USER);
		if (StringUtils.isEmpty(username)) {
			return "0";
		}
		return username;
	}
	
}
