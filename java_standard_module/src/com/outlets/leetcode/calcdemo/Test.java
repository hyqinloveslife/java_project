package com.outlets.leetcode.calcdemo;

import java.util.LinkedList;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/8  11:00
 */
public class Test {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("1");
    list.add("2");
    list.add("3");

    String first = list.removeFirst();
    System.out.println("first:" + first);

    System.out.println(list);

  }

}
