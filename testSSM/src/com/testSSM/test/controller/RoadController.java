package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.testSSM.test.pojo.RoadPojo;
import com.testSSM.test.service.IRoadService;

/**
 * 交通查询系统控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/road")
public class RoadController {
	private static Logger logger=Logger.getLogger(RoadController.class);
	@Resource
	private IRoadService roadService;
	
	/**
	 * 保存路线-站点
	 * @param request
	 * @param model
	 * @param road
	 * @return
	 */
	@RequestMapping(value="/save.do")
	public ModelAndView saveRoad(HttpServletRequest request,ModelAndView model,RoadPojo road){
		System.out.println(road);
		try {
			int result = roadService.saveRoad(road);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}
	
}
