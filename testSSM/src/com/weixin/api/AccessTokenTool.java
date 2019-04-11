package com.weixin.api;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.testSSM.test.utils.PropertiesUtils;

import net.sf.json.JSONException;

public class AccessTokenTool {
	private static Logger log = Logger.getLogger(AccessTokenTool.class);

	public static final String AppId = "wx97bbd9ca195d50df";
	public static final String AppSecret = "763d0ec54e097798898227f120273af5";

	
	public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ AppId + "&secret=" + AppSecret;
	public static String access_token = "";

	/**
	 * ����ʱ��7200�룬 ��Ϊ΢��token����ʱ��Ϊ2Сʱ����7200��
	 */
	private static int expireTime = 7200 * 1000;
	private static long refreshTime;

	/**
	 * ��ȡ΢��accesstoken
	 * 
	 * @return
	 */
	public static synchronized String getAccessToken() {
		return getAccessToken(false);
	}

	public static synchronized String getAccessToken(boolean refresh) {
		if (StringUtils.isBlank(access_token) || (System.currentTimeMillis() - refreshTime) > expireTime || refresh) {
			access_token = initAccessToken();
			refreshTime = System.currentTimeMillis();
		}

		return access_token;
	}
	
	/**
	 * ���������ļ�����ȡid
	 * @return
	 */
	private static String getUrl(){
		String AppId = PropertiesUtils.readValue("appID");
		String AppSecret = PropertiesUtils.readValue("appsecret");
		if(AppId==null||AppSecret==null){
			log.info("============> û�л�ȡ��id��secret");
		}
		return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
		+ AppId + "&secret=" + AppSecret;
	}
	
	private static String initAccessToken() {
		String responseContent = AccessTokenUtil.getAccessToken(getUrl());
		JSONObject object = new JSONObject();
		try {
			if(responseContent.contains("errcode")){
				return responseContent;
			}
			object = new JSONObject(responseContent);
			
			return (String) object.get("access_token");				
			
		} catch (JSONException e) {
			try {
				log.error("��ȡtokenʧ�� errcode:" + object.get("errcode") + " errmsg:" + object.getString("errmsg"));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

}
