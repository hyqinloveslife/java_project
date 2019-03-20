package com.testSSM.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.common.WeixinUtils;
import com.testSSM.test.dao.IWeixinDao;
import com.testSSM.test.model.WeixinCard;
import com.testSSM.test.model.weixin.TextMessage;
import com.testSSM.test.service.IWeixinService;

@Transactional
@Service("weixinService")
public class WeixinServiceImpl implements IWeixinService {
	private static Logger log = Logger.getLogger(WeixinServiceImpl.class);
	
	@Resource
	private IWeixinDao weixinDao;
	
	@Override
	public WeixinCard findById(WeixinCard t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(WeixinCard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WeixinCard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<WeixinCard> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processRequest(HttpServletRequest request) {
		Map<String, String> map = WeixinUtils.xmlToMap(request);

        log.info(map);

        // ���ͷ��ʺţ�һ��OpenID��

        String fromUserName = map.get("FromUserName");

        // ������΢�ź�

        String toUserName = map.get("ToUserName");

        // ��Ϣ����

        String msgType = map.get("MsgType");

        // Ĭ�ϻظ�һ��"success"

        String responseMessage = "success";

        // ����Ϣ���д���

        if (WeixinUtils.MESSAGE_TEXT.equals(msgType)) {// �ı���Ϣ

            TextMessage textMessage = new TextMessage();

            textMessage.setMsgType(WeixinUtils.MESSAGE_TEXT);

            textMessage.setToUserName(fromUserName);

            textMessage.setFromUserName(toUserName);

            textMessage.setCreateTime(System.currentTimeMillis());

            textMessage.setContent("���Ѿ��ܵ��㷢������Ϣ��");

            responseMessage = WeixinUtils.textMessageToXml(textMessage);

        }

        log.info(responseMessage);

        return responseMessage;
	}

}
