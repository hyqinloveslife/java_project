package com.testSSM.test.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.testSSM.test.model.WeatherItems;

import net.sf.json.JSONObject;



/**
 * secret:y6bfhmh0qfno77ls
 * id:U7DA73CD04
 * url:https://api.seniverse.com/v3/weather/now.json?key=y6bfhmh0qfno77ls&location=beijing&language=zh-Hans&unit=c
 * @author Administrator
 *
 */
public class HttpWeather {
	/**
	 * 获取json数据 
	 * @param cityName
	 * @return
	 */
	public static String getWeatherInfo(String cityName) {
		String weatherUrl="https://api.seniverse.com/v3/weather/now.json?key=y6bfhmh0qfno77ls&location=changsha&language=zh-Hans&unit=c";
		StringBuffer sb=new StringBuffer();
		
		try {
			URL url=new URL(weatherUrl);
			URLConnection conn=url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line+"  ");
			}
			reader.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	/**
	 * 解析json 数据
	 * @return
	 */
	public WeatherItems resoveJsonInfo(String strJson) {
		JSONObject dataObject=JSONObject.fromObject(strJson);
		if (dataObject.getInt("error")!=0) {
			return null;
		}
		
		//保存全部的天气信息
		WeatherItems weatherItems=new WeatherItems();
		
		
		return null;
		
	}
	
	public static void main(String[] args) {
		HttpWeather.getWeatherInfo("长沙");
	}
}
