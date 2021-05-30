package com.outlets.leetcode.calcdemo;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description 给定两个计算公式，一个#号，一个$ ，其中 x#y = x*2 + y*3 , x$y = x*3 + y +2 ，录入一个字符串，来计算
 * @author: huangyeqin
 * @create : 2021/3/8  10:48
 */
public class Client {

  public static void main(String[] args) {
    // 突然发现，这种算法只能用来计算一位数，超过一位数就无法识别了
    String pat = "22#3$5#72$100";

    LinkedList<String> list = new LinkedList<>();
    // 想要计算多位，就必须将分割的算法修改一下

    LinkedList<String> strList = new LinkedList<>(Arrays.asList(pat.split("")));
    StringBuilder sb = new StringBuilder();
    while (strList.size() > 0) {
      String e = strList.removeFirst();
      // 如果从字符串中取出的数，是# 或者 $ 就特殊处理
      if (e.equalsIgnoreCase("#") || e.equalsIgnoreCase("$")) {
        list.add(sb.toString());
        sb.delete(0, sb.length());
        list.add(e);
        continue;
      }
      sb.append(e);

      // 处理最后一个数字
      if (strList.size() == 0) {
        list.add(sb.toString());
      }
    }

    System.out.println(list);

    System.out.println(calcTotal(list).removeFirst());
  }

  /**
   * 计算逻辑： 1、拿到一个链表，然后依次取出三个字符 2、根据第二个字符来判断，需要调哪个函数 3、调用函数计算后，再将结果插入链表头部 4、当链表的长度为1时停止
   */
  public static LinkedList<String> calcTotal(LinkedList<String> list) {
    while (list.size() > 1) {
      String x = list.removeFirst();
      String calcFlag = list.removeFirst();
      String y = list.removeFirst();

      int result = 0;
      if ("#".equalsIgnoreCase(calcFlag)) {
        result = calc3(Integer.valueOf(x), Integer.valueOf(y));
      } else if ("$".equalsIgnoreCase(calcFlag)) {
        result = calc4(Integer.valueOf(x), Integer.valueOf(y));
      } else {
        throw new RuntimeException("请输入正确的公式");
      }

      list.addFirst(String.valueOf(result));
    }
    return list;
  }


  // 方法名里面不能写# ，所以用该键上的数字来表示
  public static int calc3(int x, int y) {
    return x * 2 + y * 3;
  }

  // 方法名里面不能写$ ，所以用该键上的数字来表示
  public static int calc4(int x, int y) {
    return x * 3 + y + 2;
  }
}
