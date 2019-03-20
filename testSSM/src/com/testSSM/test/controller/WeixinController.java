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
 * ΢�ŵ�һЩ�ӿڲ���
 * @author hyqin
 *
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController {
	private static Logger logger = Logger.getLogger(WeixinController.class);
	
	private static final String CARDTYPE_CASH = "CASH";//�ֽ�ȯ
	private static final String CARDTYPE_GROUPON = "GROUPON";//�Ź�ȯ
	private static final String CARDTYPE_GIFT = "GIFT";//�һ�ȯ
	private static final String CARDTYPE_DISCOUNT = "DISCOUNT";//�ۿ�ȯ
	private static final String CARDTYPE_GENERAL_COUPON = "GENERAL_COUPON";//�Ż�ȯ
	
	@Resource
	private IWeixinService weixinService; 
	/**
	 * ���ɿ�ȯ
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
		cardType.put("gift", "�һ��ɿڿ���һ��");
		return null;
	}
	
	/**
	 * ��ȡtoken��Ϣ
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
	 * ��������΢�ŵ�����
	 * ÿһ����΢�ŷ���������������Ҫͨ�����������
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/weixin.do")
	public void getWeixinRequest(HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("=============>��������΢�ŵ�����");
		// ΢�ż���ǩ��
		String signature = request.getParameter("signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		// ����ַ���
		String echostr = request.getParameter("echostr");
		//��ȡ����
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
	 * ����
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
