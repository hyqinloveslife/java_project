package com.weixin.api;

import java.util.Properties;

public class TokenThread implements Runnable {
	// ΢�Ź��ںŵ�ƾ֤����Կ
	public static final String appID = "wx6d7cea528d5abbbb";
	public static final String appScret = "7d2a8f9f8ed0ab5cf45eaaf351e2eed2";
	public static AccessToken access_token = null;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				
				// ���ù������ȡaccess_token(ÿ������ȡ100000�Σ�ÿ�λ�ȡ����Ч��Ϊ7200��)
				access_token = AccessTokenUtil.getAccessToken(appID, appScret);
				if (null != access_token) {
					System.out.println("accessToken��ȡ�ɹ���" + access_token.getExpires_in());
					// 7000��֮�����½��л�ȡ
					Thread.sleep((access_token.getExpires_in() - 200) * 1000);
				} else {
					// ��ȡʧ��ʱ��60��֮�������»�ȡ
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
