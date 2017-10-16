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
		Date d1 = new SimpleDateFormat("yyyyMM").parse("201506");// ������ʼ����

		Date d2 = new SimpleDateFormat("yyyyMM").parse("201605");// �����������

		Calendar dd = Calendar.getInstance();// ��������ʵ��

		dd.setTime(d1);// ����������ʼʱ��

		while (dd.getTime().before(d2)) {// �ж��Ƿ񵽽�������

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

			String str = sdf.format(dd.getTime());

			System.out.println(str);// ������ڽ��

			dd.add(Calendar.MONTH, 1);// ���е�ǰ�����·ݼ�1
		}
		System.out.println(dd);
	}
}
