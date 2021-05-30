package com.outlets.leetcode;

/**
 * @description 测试一下二分查找
 * @author: hyqin
 * @create : 2020/6/9
 */
public class BiQuery {

  public static void main(String[] args) {
    int[] num = {1, 3, 5, 7, 9, 11, 12, 17};
    int target = 17;

    System.out.println(binaryQuery(num, target, 0, num.length - 1));
  }

  private static int binaryQuery(int[] num, int target, int start, int end) {
    if (target < num[start] || target > num[end] || start > end) {
      return -1;
    }

    int mid = start + (end - start) / 2;
    if (target < num[mid]) {
      return binaryQuery(num, target, start, mid);
    } else if (target > num[mid]) {
      return binaryQuery(num, target, mid, end);
    } else {
      return mid;
    }
  }

}
