package com.testSSM.test.service;

import javax.servlet.http.HttpServletRequest;

import com.testSSM.test.model.WeixinCard;

public interface IWeixinService extends IBaseService<WeixinCard>{
	public String processRequest(HttpServletRequest request);
}
