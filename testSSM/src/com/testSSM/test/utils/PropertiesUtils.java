package com.testSSM.test.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private static final String filePath = "config/weixinConfig.properties";
	public static String readValue(String key){
		//获取绝对路径
		String file = PropertiesUtils.class.getResource("/"+filePath).toString();
		//
		file = file.substring(6);
		Properties pro = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(file));
			pro.load(in);
			in.close();
			String value = pro.getProperty(key);
			return value;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
