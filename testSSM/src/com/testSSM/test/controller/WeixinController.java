package com.testSSM.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testSSM.test.model.WeixinCard;

/**
 * 微信的一些接口测试
 * @author hyqin
 *
 */
@Controller("/weixin")
public class WeixinController {
	private static final String CARDTYPE_CASH = "CASH";//现金券
	private static final String CARDTYPE_GROUPON = "GROUPON";//团购券
	private static final String CARDTYPE_GIFT = "GIFT";//兑换券
	private static final String CARDTYPE_DISCOUNT = "DISCOUNT";//折扣券
	private static final String CARDTYPE_GENERAL_COUPON = "GENERAL_COUPON";//优惠券
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
	
}
