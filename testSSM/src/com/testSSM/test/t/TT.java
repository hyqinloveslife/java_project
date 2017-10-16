/**
 * @author wws
 * @date 2017-8-21  
 * @version 1.0.0 
 */
package com.testSSM.test.t;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author Administrator
 * 
 */
public class TT {

	@Test
	public void getTimePeriod() throws Exception {
		String d1 = "201201";
		String d2 = "201002";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(d1));
		int year1 = c.get(Calendar.YEAR);
		int month1 = c.get(Calendar.MONTH);

		c.setTime(sdf.parse(d2));
		int year2 = c.get(Calendar.YEAR);
		int month2 = c.get(Calendar.MONTH);

		int result;
		if (year1 == year2) {
			result = month1 - month2;
		} else {
			result = 12 * (year1 - year2) + month1 - month2;
		}
		System.out.println(result);

	}

	@Test
	public void test2() throws Exception {
		Date d1 = new SimpleDateFormat("yyyyMM").parse("201506");// 定义起始日期

		Date d2 = new SimpleDateFormat("yyyyMM").parse("201605");// 定义结束日期

		Calendar dd = Calendar.getInstance();// 定义日期实例

		dd.setTime(d1);// 设置日期起始时间

		while (dd.getTime().before(d2)) {// 判断是否到结束日期

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

			String str = sdf.format(dd.getTime());

			System.out.println(str);// 输出日期结果

			dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
		}
		System.out.println(dd);
	}
}
