/**
 * @author huangyq
 * @date 2017-8-31  
 * @version 1.0.0 
 */
package com.testSSM.test.utils;

import java.util.ArrayList;

/**
 * 贪心算法
 * @author Administrator
 *
 */
public class Greedy {
	private static double M = 20;//背包能携带的总重量 
	
	private static int NUM =3 ;//背包能携带的数量
	
	public static void main(String[] args) {
		MyObject object = new MyObject(17, 30);
		
		MyObject object2 = new MyObject(13, 8);
		
		MyObject object3 = new MyObject(7, 13);
		
		ArrayList<MyObject> myObjects = new ArrayList<MyObject>(NUM);
		
		//算出每个物品的性价比
		object.priceRatio = (object.price*1.0)/(object.weight);
		//object2
		
	}
}

class MyObject{
	public int weight = 0;
	
	public int price = 0;
	
	public double x =0;
	
	public double priceRatio = 0;
	
	public MyObject(int weight,int price){
		this.weight = weight;
		this.price = price;
	}
}