package com.testSSM.test.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;

@Controller
@RequestMapping("/weather")
public class WeatherController extends BaseController{
	private static Logger logger=Logger.getLogger(UserController.class);
	
	@ResponseBody
	@RequestMapping(value="/getWeather.do",method=RequestMethod.GET)
	public String getWeather() {
		System.out.println(1);
		return "";
	}
	
	/**
	 * 
	 * @author wws
	 * @date 2017-7-6  
	 * @version 1.0.0 
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value="/weather.do",method=RequestMethod.GET)
	public ListObject weather(HttpServletRequest request) {
		ListObject listObject=new ListObject();
		String cityName=request.getParameter("city");
		String weatherUrl="https://api.seniverse.com/v3/weather/now.json?" +
				"key=y6bfhmh0qfno77ls&location="+cityName+"&language=zh-Hans&unit=c";
		StringBuilder sb = new StringBuilder();
		try {
			URL url=new URL(weatherUrl);
			URLConnection conn=url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line+"  ");
			}
			reader.close();
			Other other=new Other();
			other.setCode(SUCCESS_STATUS_CODE);
			JSONObject json=JSONObject.fromObject(sb.toString());
			listObject.setOther(other);
			listObject.setData(json);
		}catch (Exception e) {
			try {
				throw new Exception(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return listObject;
	}
	
}
