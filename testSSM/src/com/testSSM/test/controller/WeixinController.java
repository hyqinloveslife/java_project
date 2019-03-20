package com.testSSM.test.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testSSM.test.common.CheckUtils;
import com.testSSM.test.model.WeixinCard;
import com.testSSM.test.service.IWeixinService;
import com.testSSM.test.utils.PropertiesUtils;
import com.weixin.api.AccessTokenTool;

/**
 * 微信的一些接口测试
 * @author hyqin
 *
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController {
	private static Logger logger = Logger.getLogger(WeixinController.class);
	
	private static final String CARDTYPE_CASH = "CASH";//现金券
	private static final String CARDTYPE_GROUPON = "GROUPON";//团购券
	private static final String CARDTYPE_GIFT = "GIFT";//兑换券
	private static final String CARDTYPE_DISCOUNT = "DISCOUNT";//折扣券
	private static final String CARDTYPE_GENERAL_COUPON = "GENERAL_COUPON";//优惠券
	
	@Resource
	private IWeixinService weixinService; 
	/**
	 * 生成卡券
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/card.do")
	public String createCards(){
		Map<String, Object> cardMap = new HashMap<String, Object>();
		Map<String, Object> cardType = new HashMap<String, Object>();
		WeixinCard base_info = new WeixinCard();
		cardMap.put("card_type", CARDTYPE_CASH);
		cardMap.put(CARDTYPE_CASH, cardType);
		cardType.put("base_info", base_info);
		cardType.put("gift", "兑换可口可乐一杯");
		return null;
	}
	
	/**
	 * 获取token信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/token.do")
	public String testToken(HttpServletRequest request,HttpServletResponse response){
		String token = AccessTokenTool.getAccessToken();
		logger.info(PropertiesUtils.readValue("appsecret"));
		logger.info(token);
		return token;
	}
	
	/**
	 * 接收来自微信的请求
	 * 每一次与微信服务器关联，都需要通过这个工具类
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/weixin.do")
	public void getWeixinRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("=============>接收来自微信的请求");
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		//获取方法
		String method = request.getMethod().toLowerCase();
		OutputStream pw = response.getOutputStream();
		if(method.equalsIgnoreCase("get")){
			if(CheckUtils.checkSignature(signature, timestamp, nonce)){
				if(echostr==null){
					echostr="111";
				}
				
				pw.write(echostr.getBytes());
			}
			pw.flush();
			pw.close();
		}else if(method.equalsIgnoreCase("post")){
			
			wechatServicePost(request, response, pw);
		}
	}
	
	/**
	 * 接收
	 * @param request
	 * @param response
	 * @param out
	 */
	@ResponseBody
	@RequestMapping(value="/wechat.do",method = RequestMethod.POST)
	public void wechatServicePost(HttpServletRequest request,HttpServletResponse response,OutputStream out){
		String responseMessage = weixinService.processRequest(request);

        try {
			out.write(responseMessage.getBytes());

			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
