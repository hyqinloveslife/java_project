/**
 * @author huangyq
 * @date 2017-7-26  
 * @version 1.0.0 
 */
package com.testSSM.test.common;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StringUitl {
	/**
	 * �ж�һ���ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return
	 */
	public static boolean IsNull(String str) {
		if (str == null || "".equals(str) || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * �ж�һ���ַ����Ƿ�Ϊ�ǿ�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean IsNotNull(String str) {
		if (str == null || "".equals(str) || "".equals(str.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * ת����Сд
	 * 
	 * @author wangym
	 * @date Aug 15, 2012 9:16:41 AM
	 * @param src
	 * @return
	 */
	public static String tranStartCharToLower(String src) {
		if (src == null || src.equals("")) {

			return null;
		} else {
			char target = src.charAt(0);
			return src.replaceFirst(
					(new StringBuilder(String.valueOf(target))).toString(),
					(new StringBuilder(String.valueOf(Character.toLowerCase(src
							.charAt(0))))).toString());
		}
	}

	/**
	 * ȥ���ַ������˵Ŀո�
	 * 
	 * @author wangym
	 * @date Aug 15, 2012 9:13:47 AM
	 * @param str
	 * @return
	 */
	public static String toTrim(String str) {
		if (str == null)
			return "";
		if (str.trim().equalsIgnoreCase("null"))
			return "";
		else
			return str.trim();
	}

	/**
	 * ��ȡ��Ŀ·��
	 * 
	 * @return
	 */
	public static String getWebRootPath() {
		String filePath = new StringUitl().getClass().getResource("/")
				.getPath();
		if (filePath.indexOf("/") == 0) {
			filePath = filePath.substring(1, filePath.lastIndexOf("WEB-INF"));
		} else {
			filePath = filePath.substring(0, filePath.lastIndexOf("WEB-INF"));
		}
		return filePath;
	}

	public static void main(String[] args) {
		System.out.println(StringUitl.getWebRootPath());
	}

	/**
	 * �����null���ؿ��ַ���
	 * 
	 * @return arg
	 */
	public static String SiftNull(String arg) {
		String rt = "";
		if (arg != null && !"".equals(arg)) {
			rt = arg;
		}
		return rt;
	}

	/**
	 * �����null���ؿ��ַ���
	 * 
	 * @return arg
	 */
	public static String SiftNull(Object arg) {
		String rt = "";
		if (arg != null) {
			rt = arg.toString();
		}
		return rt;
	}

	/**
	 * ��ȡ��������map����
	 * 
	 * @return
	 */
	public static Map<String, Object> getReportHashMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		// Code��������
		map.put("condition_code", "code <> 'yw'");
		// mallCode��������
		map.put("condition_mallCode", "mall_code <> 'yw'");
		// buyMallCode��������
		map.put("condition_buyMallCode", "buy_mall_code <> 'yw'");
		// sellMallCode��������
		// map.put("condition_sellMallCode", "sell_mall_code NOT IN ('yw')");
		// portalorg_ou��������
		map.put("condition_portalorgOU", "portalorg_ou <> '00330040731'");
		// portalorg_ou��������
		map.put("condition_provinceOU", "province_orgou <> '00330040731'");
		// shopType��������
		map.put("condition_shopType", "shopType NOT IN (2,3,5,8)");
		// shopType��������
		map.put("condition_pid", "pid = -1");
		// ��������������yw
		map.put("yw", "'yw'");
		// ��ѯ�����е�group by��������
		map.put("condition_groupBy", "");
		return map;
	}

	/**
	 * ��ȡ��װList�Ĺ���map����
	 * 
	 * @return
	 */
	public static Map getCombineListMap() {
		Map map = new HashMap();
		map.put("mall_code", "zongji");
		map.put("mall_orgou", "zongji");
		map.put("orgName", "�ܼ�");
		map.put("amount", "0");
		map.put("sellNum", "0");
		map.put("saveamount", "0");
		map.put("prdUpNum", "0");
		map.put("OrderNum", "0");
		map.put("aver", "0");
		return map;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�绰���� String
	 * 
	 * @param arg
	 * @return
	 * @antuor zhangyanbing Aug 22, 2014
	 */
	public static boolean isTel(String arg) {
		String matches = "(^[0-9]{11,12}$)";
		boolean result = false;
		if (arg != null && !"".equals(arg)) {
			result = Pattern.matches(matches, arg);
		}
		return result;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ������(�ж��Ƿ�Ϊ13λ�������� String
	 * 
	 * @param arg
	 * @return
	 * @antuor shaozj 2014-9-22 14:51:38
	 */
	public static boolean isBarCode(String arg) {
		String matches = "(^[0-9]{13}$)";
		boolean result = false;
		if (arg != null && !"".equals(arg)) {
			result = Pattern.matches(matches, arg);
		}
		return result;
	}

	public static String arrayToString(String[] strArry, String exp) {
		StringBuilder str = null;
		str = new StringBuilder();
		for (int i = 0; i < strArry.length; i++) {
			String s = strArry[i];
			str.append(s);
			if (i != strArry.length - 1) {
				str.append(exp);
			}
		}
		return str.toString();
	}

	/**
	 * �쳣��ϢtoString
	 * 
	 * @param ex
	 * @return
	 */
	public static String getExceString(Exception ex) {
		StackTraceElement[] arry_ex = ex.getStackTrace();
		String temp = ex.toString();
		for (int i = 0; i < arry_ex.length; i++) {
			temp += "\n" + arry_ex[i].toString();
		}
		System.out.println(temp);
		return temp;
	}
}
