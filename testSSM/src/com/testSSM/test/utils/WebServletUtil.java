package com.testSSM.test.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.junit.Test;

public class WebServletUtil {

	/**
	 * 获取地址
	 * 
	 * @param params
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public String getAddress(String params, String encoding) throws Exception {

		String path = "http://ip.taobao.com/service/getIpInfo.php";

		String returnStr = this.getRs(path, params, encoding);

		JSONObject json = null;

		if (returnStr != null) {

			json = JSONObject.fromObject(returnStr);

			if ("0".equals(json.get("code").toString())) {

				StringBuffer buffer = new StringBuffer();

				buffer.append(decodeUnicode(json.optJSONObject("data").getString("country")));//国家

				// buffer.append(decodeUnicode(json.optJSONObject("data").getString("area")));//地区
				//buffer.append(decodeUnicode(json.optJSONObject("data").getString("country")));//国家
				
				buffer.append(decodeUnicode(json.optJSONObject("data")
						.getString("region")));// 省份

				buffer.append(decodeUnicode(json.optJSONObject("data")
						.getString("city")));// 市区

				buffer.append(decodeUnicode(json.optJSONObject("data")
						.getString("county")));// 地区

				buffer.append(decodeUnicode(json.optJSONObject("data")
						.getString("isp")));// ISP公司

				System.out.println(buffer.toString());

				return buffer.toString();

			} else {

				return "获取地址失败?";

			}

		}

		return null;

	}

	/**
	 * 从url获取结果
	 * 
	 * @param path
	 * @param params
	 * @param encoding
	 * @return
	 */
	public String getRs(String path, String params, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(path);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫�?
			connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫�?
			connection.setDoInput(true);// 是否打开输出�? true|false
			connection.setDoOutput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.writeBytes(params);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encoding));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();// 关闭连接
		}
		return null;
	}

	/**
	 * 字符转码
	 * 
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer buffer = new StringBuffer(len);
		for (int i = 0; i < len;) {
			aChar = theString.charAt(i++);
			if (aChar == '\\') {
				aChar = theString.charAt(i++);
				if (aChar == 'u') {
					int val = 0;
					for (int j = 0; j < 4; j++) {
						aChar = theString.charAt(i++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							val = (val << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							val = (val << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							val = (val << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
							"Malformed      encoding.");
						}
					}
					buffer.append((char) val);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					}
					if (aChar == 'r') {
						aChar = '\r';
					}
					if (aChar == 'n') {
						aChar = '\n';
					}
					if (aChar == 'f') {
						aChar = '\f';
					}
					buffer.append(aChar);
				}
			} else {
				buffer.append(aChar);
			}
		}

		return buffer.toString();

	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (null != ip && !"".equals(ip.trim())
				&& !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (null != ip && !"".equals(ip.trim())
				&& !"unknown".equalsIgnoreCase(ip)) {
			// get first ip from proxy ip
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

	@Test
	public void name2() {
        WebServletUtil webServletUtil = new WebServletUtil();
		
        String ip = "113.240.234.201";  
          
        String address = "";  
          
        try {  
              
         address = webServletUtil.getAddress("ip="+ip, "utf-8");  
           
        } catch (Exception e) {  
              
            e.printStackTrace();  
        }  
          
        System.out.println(address);  
	}
	
	@Test
	public void name() {
		String SERVER_DP = null;
		try {
			Enumeration allNetInterfaces = NetworkInterface
					.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
						.nextElement();
				System.out.println(netInterface.getName());
				Enumeration addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						System.out.println("本机的IP = " + ip.getHostAddress());
					}
				}
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
