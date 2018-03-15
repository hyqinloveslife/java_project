/**
 * @author huangyq
 * @date 2018-3-15  
 * @version 1.0.0 
 */
package com.testSSM.test.utils.sort;

import org.junit.Test;

/**
 * @author huangyeqin
 *
 */
public class SortUtils {
	int [] nums = new int[]{5,2,3,8,5,10};
	/**
	 * 求数组中的最大值
	 * @author huangyq
	 * @date 2018-3-15  
	 * @version 1.0.0
	 */

	public int maxNum(){
		int maxNum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxNum<nums[i]) {
				int temp = maxNum;
				maxNum = nums[i];
				nums[i] = temp;
			}
		}
		return maxNum;
	}
	
	/**
	 * 桶排序
	 * @author huangyq
	 * @date 2018-3-15  
	 * @version 1.0.0
	 */
	@Test
	public void bookSort(){
		int [] bookSort = new int [maxNum()+1];
		for (int i = 0; i < nums.length; i++) {
			bookSort[nums[i]]++;
		}
		for (int i = 0; i < bookSort.length; i++) {
			if (bookSort[i]!=0) {		
				for (int j = 0; j < bookSort[i]; j++) {					
					System.out.print(i+"  ");
				}
			}
		}
		System.out.println();
		print(bookSort);
	}
	
	

	private static void print(int [] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}
}
