package com.outlets.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序是冒牌排序的进化版，效率会快很多
 *
 * @description 选择排序
 * @author: huangyeqin
 * @create : 2020/12/3  14:48
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] arr = {9, 8, 7, 6, 5, 4, 3, 1};
    System.out.println("排序之前：" + Arrays.toString(arr));
    selectSort(arr);
    System.out.println("排序之后：" + Arrays.toString(arr));
  }

  // 选择排序
  private static int[] selectSort(int[] arr) {
    // 采用逐步调试的过程，先调试第一遍
    for (int k = 0; k < arr.length - 1; k++) {

      System.out.println("第" + k + "遍调试");
      int minIndex = k;
      for (int i = k + 1; i < arr.length; i++) {
        if (arr[i] < arr[minIndex]) {
          minIndex = i;
        }
      }
//      System.out.println("最小值的下标是多少？" + minIndex);
      // 能找到下标，那么就和第一个元素换位置
      int temp = arr[k];
      arr[k] = arr[minIndex];
      arr[minIndex] = temp;

      System.out.println("第" + k + "遍调试结果:" + Arrays.toString(arr));
    }

    return arr;
  }


}
