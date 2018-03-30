/**
 * @author huangyq
 * @date 2018-3-30  
 * @version 1.0.0 
 */
package com.testSSM.test.exception;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Administrator
 *
 */
public class BaseExceptionHandleAction {
	protected HttpServletRequest getServletRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	protected ServletContext getServletContext() {
		HttpServletRequest request = getServletRequest();
		if (request!=null) {
			return request.getSession().getServletContext();
		}
		return null;
	}
	
	protected HttpServletResponse getServletResponse() {
		return  (HttpServletResponse) (RequestContextHolder.getRequestAttributes());
	}
	
}
