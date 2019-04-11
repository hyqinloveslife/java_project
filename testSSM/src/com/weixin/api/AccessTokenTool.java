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
	 * 过期时间7200秒， 因为微信token过期时间为2小时，即7200秒
	 */
	private static int expireTime = 7200 * 1000;
	private static long refreshTime;

	/**
	 * 获取微信accesstoken
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
	 * 根据配置文件来读取id
	 * @return
	 */
	private static String getUrl(){
		String AppId = PropertiesUtils.readValue("appID");
		String AppSecret = PropertiesUtils.readValue("appsecret");
		if(AppId==null||AppSecret==null){
			log.info("============> 没有获取到id和secret");
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
				log.error("获取token失败 errcode:" + object.get("errcode") + " errmsg:" + object.getString("errmsg"));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

}
