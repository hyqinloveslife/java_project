/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestListNode
 * Author:   hyqin
 * Date:     2019-04-18 11:10
 * Description: 自定义链表的测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义链表的测试类〉
 *
 * @author hyqin
 * @create 2019-04-18
 * @since 1.0.0
 */
public class TestListNode {
    public static void main(String[] args) {
//        ListNode<String> strNode = new ListNode<>();
//        strNode.add("hello");
//        strNode.add("world");
//        strNode.print();

        //测试单链表
//        ListNode<Integer> intNode = new ListNode<>();
//        intNode.add(1);
//        intNode.add(3);
//        intNode.add(5);
//        intNode.add(7);
//        intNode.add(9);
//        intNode.print();
//        System.out.println("链表中节点值为7的元素知否删除？ " + intNode.remove(7));
//        System.out.println("链表是否中存在 6 " + intNode.find(6));
//        intNode.print();
        //测试单链表
//        MyNode<Integer> circulNode = new CirculNode<Integer>();
//        ((CirculNode) circulNode).add(9);
//        ((CirculNode) circulNode).add(5);
//        ((CirculNode) circulNode).add(2);
//        ((CirculNode) circulNode).add(7);
//        ((CirculNode) circulNode).print();
//        ((CirculNode) circulNode).reverse();
//        ((CirculNode) circulNode).print();


        DulNode<Integer> dulNode = new DulNode<>();
        dulNode.add(9);
        dulNode.add(5);
        dulNode.add(2);
        dulNode.add(7);
        dulNode.print();

    }
}
