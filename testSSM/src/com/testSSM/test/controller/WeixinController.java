package com.testSSM.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testSSM.test.model.WeixinCard;

/**
 * ΢�ŵ�һЩ�ӿڲ���
 * @author hyqin
 *
 */
@Controller("/weixin")
public class WeixinController {
	private static final String CARDTYPE_CASH = "CASH";//�ֽ�ȯ
	private static final String CARDTYPE_GROUPON = "GROUPON";//�Ź�ȯ
	private static final String CARDTYPE_GIFT = "GIFT";//�һ�ȯ
	private static final String CARDTYPE_DISCOUNT = "DISCOUNT";//�ۿ�ȯ
	private static final String CARDTYPE_GENERAL_COUPON = "GENERAL_COUPON";//�Ż�ȯ
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
	
}
