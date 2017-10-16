/**
 * @author huangyq
 * @date 2017-8-14  
 * @version 1.0.0 
 */
package com.testSSM.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.Util;
import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;

@Controller
@RequestMapping("/zhihu")
public class ZhihuController extends BaseController{
	
	/**
	 * 
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/zhihuList.do")
	public ListObject getZhihuList(HttpServletRequest request){
		ListObject listObject = new ListObject();
		String paramUrl="http://news-at.zhihu.com/api/4/news/latest";//最新消息
		StringBuilder sb = new StringBuilder();
		String result = getNetInfo(paramUrl, sb);
		Other other = new Other();
		other.setCode(SUCCESS_STATUS_CODE);
		JSONObject object = JSONObject.fromObject(result);
		listObject.setOther(other);
		listObject.setData(object);
		return listObject;
	}

	/**
	 * 获取知乎消息
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/messageList.do")
	public ListObject getZhihuMessageList(HttpServletRequest request,HttpServletResponse response){
		ListObject listObject  = new ListObject();
		String param = request.getParameter("param");
		String url = request.getParameter("url");
		if(StringUtils.isEmpty(url)){
			listObject.setOther(new Other(ERROR_STATUS_CODE));
			return listObject;
		}
		StringBuilder sb = new StringBuilder();
		url=url+param;
		String result = getNetInfo(url, sb);
		JSONObject object = JSONObject.fromObject(result);
		listObject.setOther(new Other(SUCCESS_STATUS_CODE));
		listObject.setData(object);
		return listObject;
	}
	
	/**
	 * 知乎入口
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/zhihu.do")
	public ModelAndView zhihu(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView view  = new ModelAndView();
		view.setViewName("zhihu/zhihu");
		return view;
	}
	
	/**
	 * 获取消息详细信息
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/msgDetails.do")
	public ModelAndView getMsgDetails(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		String id = request.getParameter("id");
		view.addObject("id", id);
		view.setViewName("zhihu/msgDetails");
		return view;
	}
	
	/**
	 * 获取内容详情
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/zhihuMessageInfo.do")
	public ListObject msgDetails(HttpServletRequest request){
		ListObject listObject = new ListObject();
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			listObject.setOther(new Other(ERROR_STATUS_CODE));
			return listObject;
		}
		String paramUrl="http://news-at.zhihu.com/api/4/news/"+id;//最新消息
		StringBuilder sb = new StringBuilder();
		String result = getNetInfo(paramUrl, sb);
		Other other = new Other();
		other.setCode(SUCCESS_STATUS_CODE);
		JSONObject object = JSONObject.fromObject(result);
		listObject.setOther(other);
		listObject.setData(object);
		return listObject;
	}
	
	/**
	 * 获取历史消息列表
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/hisMsgList.do")
	public ModelAndView getHistoryMessage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date curDate = new Date(System.currentTimeMillis());
		String cur = sdf.format(curDate);
		view.addObject("curDate", cur);
		view.setViewName("zhihu/historyInfo");
		return view;
	}
	
	
	/**
	 * @author huangyq
	 * @date 2017-8-14  
	 * @version 1.0.0 
	 * @param paramUrl
	 * @param sb
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private String getNetInfo(String paramUrl, StringBuilder sb){
		BufferedReader reader = null;
		String result = "";
		try {
			URL url=new URL(paramUrl);
			URLConnection conn=url.openConnection();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line=null;
			while((line=reader.readLine())!=null){
				sb.append(line+"  ");
			}
			result = sb.toString();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{			
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
}
