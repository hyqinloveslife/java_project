package com.testSSM.test.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class Test1 {
	/**
	 * ��ȡ�����
	 * 
	 * @author huangyq
	 * @date 2017-8-6
	 * @version 1.0.0
	 * @param min
	 *            ��Сȡֵ��Χ
	 * @param max
	 *            ���ȡֵ��Χ
	 * @param num
	 *            ���������
	 */
	public static void getRandomSets(int min, int max, int num)
			throws Exception {
		Set<Integer> set = new HashSet<Integer>();
		// �жϴ����ֵ�Ƿ�Ϸ�
		if (num > (max - min + 1) || min > max || num == 0) {
			throw new Exception("����Ĳ�������");
		}
		// ��������ֵС��num������Ҫ�õݹ������������
		int setSize = 0;
		while (setSize < num) {
			// ����Math.random()����
			int result = (int) (Math.random() * (max - min)) + min;
			set.add(result);
			setSize = set.size();
		}
		System.out.println(set);
	}

	/**
	 * �����������������ķ�ʽ����
	 * 
	 * @author huangyq
	 * @date 2017-8-6
	 * @version 1.0.0
	 * @param min
	 * @param max
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public static int[] getRandomArrays(int min, int max, int num)
			throws Exception {
		Set<Integer> set = new HashSet<Integer>();
		// int result[] = new int[num];
		// �жϴ����ֵ�Ƿ�Ϸ�
		if (num > (max - min + 1) || min > max || num == 0) {
			throw new Exception("����Ĳ�������");
		}
		// ��������ֵС��num������Ҫ�õݹ������������
		int setSize = 0;
		while (setSize < num) {
			// ����Math.random()����
			int result = (int) (Math.random() * (max - min)) + min;
			set.add(result);
			setSize = set.size();
		}
		System.out.println(set);
		int[] ints = new int[num];
		Iterator<Integer> it = set.iterator();
		int n = 0;
		while (it.hasNext()) {
			int element = it.next();
			ints[n] = element;
			n++;
		}
		return ints;
	}

	/**
	 * ��ӡ���顢���ϵķ���
	 * 
	 * @author huangyq
	 * @date 2017-8-6
	 * @version 1.0.0
	 * @param param
	 * @return
	 */
	public static <T extends Object> void print(T[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + "	  ");
		}
	}
	
	/**
	 * 
	 * @author huangyq
	 * @date 2017-8-6  
	 * @version 1.0.0 
	 * @param t
	 */
	public static <T extends Collection<?>> void print(T t){
		if(t instanceof List){
			List list = new ArrayList(t);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+"   ");
			}
		}
		if(t instanceof Set){
			Set set = new TreeSet(t);
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Object object = (Object) it.next();
				System.out.print(object+"  ");
			}
		}
		
	}

	@Test
	public void test() {
		try {
			// getRandomSets(0, 10, 4);
			/*int result[] = getRandomArrays(1, 10, 6);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + "   ");
			}*/
			
			List<String> list = new ArrayList<String>();
			list.add("1");
			list.add("2");
			list.add("3");
			list.add("4");
			print(list);
			//print(getRandomArrays(0, 100, 9));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
