package com.weixin.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

public class AccessTokenUtil {

	/**
	 * ��ȡaccessToken
	 * 
	 * @param appID
	 *            ΢�Ź��ں�ƾ֤
	 * @param appScret
	 *            ΢�Ź��ں�ƾ֤��Կ
	 * @return
	 */
	public static AccessToken getAccessToken(String appID, String appScret) {
		AccessToken token = new AccessToken();
		// ����΢�ŷ�����
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret="
				+ appScret;
		try {
			URL getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);

			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b, "UTF-8");

			JSONObject json = JSONObject.fromObject(message);

			token.setAccess_token(json.getString("access_token"));
			token.setExpires_in(new Integer(json.getString("expires_in")));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}

	
	public static String getAccessToken(String get_token_url) {
		String accessToken= "";
		try {
			URL getUrl = new URL(get_token_url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);

			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			accessToken = new String(b, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		return accessToken;
	}
	
	
}
