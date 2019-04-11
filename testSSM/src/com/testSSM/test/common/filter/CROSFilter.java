package com.testSSM.test.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;


public class CROSFilter implements Filter{

	private static Logger logger = Logger.getLogger(CROSFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if(logger.isDebugEnabled()){
			logger.debug("-------------½øÈëÀ¹½ØÆ÷-------------");
		}
		
//		if(origin==null){
//			String referer = request.getHeader("Referer");
//			if(referer!=null){
//				origin = referer.substring(0,referer.indexOf("/",7));
//			}
//		}
		
		
		if(RequestMethod.OPTIONS.toString().equals(request.getMethod())){
			String origin = request.getHeader("Origin");
			response.setHeader("Access-Control-Allow-Origin", origin);
			response.setHeader("Access-Control-Allow-Credentials", "true");
			
			String allowMethod = request.getHeader("Access-Control-Request-Method");
			String allowHeaders = request.getHeader("Access-Control-Request-Headers");
			response.setHeader("Access-Control-Max-Age", "86400");
			response.setHeader("Access-Control-Allow-Methods", allowMethod);
			response.setHeader("Access-Control-Allow-Headers", allowHeaders);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
