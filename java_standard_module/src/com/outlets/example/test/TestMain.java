package com.outlets.example.test;

/**
 * @description
 * @author: hyqin
 * @create : 2020/6/22
 */
public class TestMain {

  public static void main(String[] args) {
    Object obj = new Object();
    int h;
    /**
     * ^ 表示异或 相同为0 不同为1
     */
    System.out.println(obj.hashCode());
    System.out.println(" obj的hash值二进制表达： " + Integer.toBinaryString(obj.hashCode()));
    System.out.println(obj.hashCode() >>> 16);
    System.out.println(" obj的hash值无符号右移二进制表达 :" + Integer.toBinaryString(obj.hashCode() >>> 16));
    System.out.println((h = obj.hashCode()) ^ (h >>> 16));
    System.out.println(" 最终结果的二进制表示：" + Integer.toBinaryString((h = obj.hashCode()) ^ (h >>> 16)));
  }

  public int test(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

}
