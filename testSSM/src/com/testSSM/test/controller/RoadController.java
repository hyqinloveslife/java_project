package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.testSSM.test.model.entity.Route;
import com.testSSM.test.model.entity.Station;
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
			Route route = new Route();
			BeanUtils.copyProperties(road, route);
			int result = roadService.saveRoute(route);
			if(result>0){
				model.setViewName("redirect:/index.jsp");
			}else{
				model.setViewName("");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * 保存站点
	 * @param request
	 * @param model
	 * @param road
	 * @return
	 */
	@RequestMapping("/saveSt.do")
	public ModelAndView saveStation(HttpServletRequest request,ModelAndView model,RoadPojo road){
		try {
			Station station = new Station();
			BeanUtils.copyProperties(station, road);
			int result = roadService.saveStation(station);
			if(result>0){
				model.setViewName("");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}
}
