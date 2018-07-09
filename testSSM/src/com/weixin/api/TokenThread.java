package com.weixin.api;

import java.util.Properties;

public class TokenThread implements Runnable {
	// 微信公众号的凭证和秘钥
	public static final String appID = "wx6d7cea528d5abbbb";
	public static final String appScret = "7d2a8f9f8ed0ab5cf45eaaf351e2eed2";
	public static AccessToken access_token = null;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				
				// 调用工具类获取access_token(每日最多获取100000次，每次获取的有效期为7200秒)
				access_token = AccessTokenUtil.getAccessToken(appID, appScret);
				if (null != access_token) {
					System.out.println("accessToken获取成功：" + access_token.getExpires_in());
					// 7000秒之后重新进行获取
					Thread.sleep((access_token.getExpires_in() - 200) * 1000);
				} else {
					// 获取失败时，60秒之后尝试重新获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
