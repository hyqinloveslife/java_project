package com.weixin.api;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import net.sf.json.JSONException;

public class AccessTokenTool {
	private static Logger log = Logger.getLogger(AccessTokenTool.class);

	public static final String AppId = "wx6d7cea528d5abbbb";
	public static final String AppSecret = "7d2a8f9f8ed0ab5cf45eaaf351e2eed2";

	
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

	private static String initAccessToken() {
		String responseContent = AccessTokenUtil.getAccessToken(GET_ACCESS_TOKEN_URL);
		JSONObject object = new JSONObject();
		try {
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
