package com.testSSM.test.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

	private final Logger log = Logger.getLogger(MyInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e)
			throws Exception {
		System.out.println("====================>执行方法：afterCompletion");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView view)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("====================>执行方法：postHandle ");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("====================进入方法"+this.getClass().getSimpleName());
		/*
		 * 在spring-mvc里面配置了以后，第一个进去的方法。
		 * 返回true，则继续执行。
		 * 返回false，则不执行
		 */
		String url = request.getRequestURL().toString();
		String message = request.getParameter("message");
		log.info(message);
		return true;
	}
	
	/**
	 * 页面跳转
	 * @param request
	 * @param response
	 * @param url
	 * @throws Exception
	 */
	private void fowardMessage(HttpServletRequest request,HttpServletResponse response,String url) throws Exception{
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	

}
