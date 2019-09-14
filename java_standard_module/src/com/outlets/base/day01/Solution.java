/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Solution
 * Author:   hyqin
 * Date:     2019-08-24 15:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.base.day01;

/**
 * 〈一句话功能简述〉<br> 
 * 〈题目要求：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）〉
 *  只能用递归来算
 *
 * @author hyqin
 * @create 2019-08-24
 * @since 1.0.0
 */
public class Solution {
    public static int sum_result(int max_num){
        int sum = max_num;
        boolean b = (max_num>0)&&((sum+=(sum_result(max_num-1)))>0);
        return sum;
    }


    public static void main(String[] args) {
//        System.out.println(Solution.sum_result(10));
        //位运算，向左移动一位就乘以一个2.向右移动一位就除以一个2
        System.out.println(8>>3);
        System.out.println(1<<3);

        System.out.println("7>>1  :  "+(7>>1));
        System.out.println(3<<1);
    }

}
