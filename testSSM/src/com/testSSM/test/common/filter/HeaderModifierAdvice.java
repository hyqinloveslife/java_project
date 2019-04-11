package com.testSSM.test.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public class HeaderModifierAdvice implements ResponseBodyAdvice {

	

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		ServletServerHttpRequest ssReq = (ServletServerHttpRequest) request;
		ServletServerHttpResponse ssRes = (ServletServerHttpResponse) response;
		
		if(ssReq==null||ssRes==null||ssReq.getServletRequest()==null||ssRes.getServletResponse()==null){
			return body;
		}
		
		// 对于未添加跨域消息头的响应进行处理
		HttpServletRequest req = ssReq.getServletRequest();
		HttpServletResponse res = ssRes.getServletResponse();
		
		String originHeader = "Access-Control-Allow-Origin";
		if(!res.containsHeader(originHeader)){
			String origin = req.getHeader("Origin");
			if(origin==null){
				String referer = req.getHeader("Referer");
				if(referer!=null){
					origin = referer.substring(0,referer.indexOf("/",7));
				}
			}
			res.setHeader("Access-Control-Allow-Origin", origin);
		}
		String credentialHeader = "Access-Control-Allow-Credentials";
        if(!res.containsHeader(credentialHeader)) {
            res.setHeader(credentialHeader, "true");
        }
        return body;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
