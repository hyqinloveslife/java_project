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
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.CharSet;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.testSSM.test.common.ListObject;
import com.testSSM.test.common.Other;

import net.sf.json.JSONObject;

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
	public ListObject getZhihuList(HttpServletRequest request,HttpServletResponse response){
		//设置跨域访问
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
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
	@RequestMapping(value = "/zhihuMessageInfo.do",method=RequestMethod.GET)
	public ListObject msgDetails(HttpServletRequest request,HttpServletResponse response){
		ListObject listObject = new ListObject();
		
		//设置跨域访问
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
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
	
	
	public String testHttpClient() throws Exception{ 
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("");
		
		NameValuePair pair = new BasicNameValuePair("", "");
		
		httpPost.setEntity(new StringEntity("string", Charset.forName("")));
		httpPost.setEntity(new UrlEncodedFormEntity(new ArrayList<NameValuePair>()));
		
		HttpResponse response = client.execute(httpPost);
		response.getStatusLine().getStatusCode();
		
		return null;
	}
	
}
