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
		System.out.println("====================>ִ�з�����afterCompletion");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView view)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("====================>ִ�з�����postHandle ");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("====================���뷽��"+this.getClass().getSimpleName());
		/*
		 * ��spring-mvc�����������Ժ󣬵�һ����ȥ�ķ�����
		 * ����true�������ִ�С�
		 * ����false����ִ��
		 */
		String url = request.getRequestURL().toString();
		String message = request.getParameter("message");
		log.info(message);
		return true;
	}
	
	/**
	 * ҳ����ת
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
