package com.outlets.base.day04;

/**
 * @description 测试一下程序中的位运算
 * @author: hyqin
 * @create : 2020/6/10
 */
public class BitCalcTest {

  public static void main(String[] args) {
    System.out.println("=========测试一下位运算===========");
    /**
     * & 运算，针对相同的两个数，会合并成一个数
     */
    System.out.println("&运算 ,针对二进制，只要有一个为0，就为0 ; ");
    System.out.println(" 1 & 2 = " + (1 & 2));
    System.out.println(" 2 & 2 = " + (2 & 2));

    /**
     * 根据这个特性，可以用来判断两个值是否相等
     */
    System.out.println("^运算，也称为异或运算.相同的为0，不同的为1");
    System.out.println("1 ^ 2 = " + (1 ^ 2));
    System.out.println("2 ^ 2 = " + (2 ^ 2));

    System.out.println("<< 向左位移, x << y ,表示x的二进制值向左移y位,向左移位是乘法");
    System.out.println(" 5 << 3 = " + (5 << 3));

    System.out.println(">> 向右位移， x >> y 表示x的二进制值向右移动y位，向右移位是除法");
    System.out.println(" 5 >> 2 = " + (5 >> 2));
    System.out.println(" 2 >> 3 = " + (2 >> 3));

    System.out.println(">>>(无符号右移)  无符号右移，忽略符号位，空位都以0补齐");
    System.out.println("-16>>>2运算的结果是 :" + ((-16) >>> 2));
    System.out.println("16>>>2运算的结果是 :" + ((16) >>> 2));
  }
}
