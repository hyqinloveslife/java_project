package com.testSSM.test.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testSSM.test.common.ListObject;
import com.testSSM.test.service.MatchService;

/**
 * ������controller
 * @author hyqin
 *
 */
@Controller
@RequestMapping("/match")
public class MatchController extends BaseController{
	private static Logger logger = Logger.getLogger(MatchController.class);
	
	@Resource
	private MatchService matchService;
	
	/**
	 * ����������Ϣ
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/save.do",method=RequestMethod.POST)
	public ListObject saveMatchInfo(HttpServletRequest request,HttpServletResponse response){
		Map<?,?> paramMap = getParameterMap(request);
		Object object = request.getParameter("data");
		logger.info("�Ѿ�����save����"+paramMap);
		String ss = (String) paramMap.get("SupplierID");
		String str1 = MapUtils.getString(paramMap, "SupplierID");
		logger.info("��map�н����������ַ���   :   "+str1+"  ----"+ss);
		return null;
	}
	

}
