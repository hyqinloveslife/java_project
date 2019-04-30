/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Resursion
 * Author:   hyqin
 * Date:     2019-04-28 9:33
 * Description: 简单的测试一下递归算法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.example;

import com.outlets.datastructure.tree.BinaryTree;
import com.outlets.datastructure.tree.BinaryTree2;
import com.outlets.datastructure.tree.Node;

/**
 * 〈一句话功能简述〉<br>
 * 〈简单的测试一下递归算法〉
 *
 * @author hyqin
 * @create 2019-04-28
 * @since 1.0.0
 */
public class Resursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        test(arr, 0);
//        test2(arr);

//        print(arr);
//        bubleSort(arr);
//        testTree(arr);
//        BinaryTree2 tree = new BinaryTree2();
//        tree.buildTree(arr);
//        tree.preOrder();

//        Node node = null;
//        for (int i=0;i<arr.length;i++){
//            node = tree.insertBinaryTree(node,arr[i]);
//        }
//        tree.preOrder(node);

    }


    /**
     * 用递归的方式来实现99乘法表
     *
     * @param arr
     * @param index
     */
    public static void test(int[] arr, int index) {
        if (index <= arr.length - 1) {
            System.out.println();
            for (int i = index; i < arr.length; i++) {
                System.out.print((index + 1) + "*" + (i + 1) + "=" + arr[i] * (index + 1) + "   ");
            }
            System.out.println();
            test(arr, ++index);
        }
    }

    /**
     * 用递归的方法，可以将一个数组，有限次数的拆开成多个。
     * 并归排序用的就是递归的方法
     * 慢慢的开始了解递归了
     *
     * @param arr
     */
    public static void test2(int[] arr) {
        //不断的截取数据，从中间切断
        if (arr.length != 1) {
            int mid = arr.length / 2;

            int front[] = new int[mid];
            int latter[] = new int[arr.length - mid];

            System.out.print("截取的前半部分  ");
            for (int i = 0; i < mid; i++) {
                front[i] = arr[i];
                System.out.print(arr[i]);
            }

            System.out.println();
            System.out.print("截取的后半部分   ");
            for (int i = 0; i < arr.length - mid; i++) {
                latter[i] = arr[mid + i];
                System.out.print(arr[mid + i]);
            }
            System.out.println();
            test2(front);
            test2(latter);
        }
    }


    public static void print(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }

    /**
     * 简单的冒泡排序
     *
     * @param arr
     */
    public static void bubleSort(int[] arr) {
        System.out.println("排序前");
        print(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            print(arr);
        }
    }

    public static void testTree(int[] arr) {
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = arr[i];

        }
        insertTree(null, integers, 0);

    }

    /**
     * 创建二叉排序树
     * 定义：二叉排序树是一种特殊的二叉树，它的每个节点的值都大于等于该节点的左子树上的所有节点的值，
     * 并且小于该节点的右子树上的所有的节点的值。
     *
     * @param tree
     * @return
     */
    public static BinaryTree<Integer> insertTree(BinaryTree<Integer> tree, Integer[] integers, int index) {
        Integer value = integers[0];
        if (tree == null) {
            BinaryTree<Integer> newNode = new BinaryTree<>();
            newNode.setValue(value);
            index++;
        }

        for (int i = index; i < integers.length; i++) {
            if (integers[index] <= tree.getValue()) {
                tree.setlChild(insertTree(tree.getlChild(), integers, ++index));
            } else if (integers[index] > tree.getValue()) {
                tree.setrChild(insertTree(tree.getrChild(), integers, ++index));
            }
        }
        return tree;
    }


}
