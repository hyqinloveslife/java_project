/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CirculNode
 * Author:   hyqin
 * Date:     2019-04-18 14:55
 * Description: 单循环链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.day02;

/**
 * 〈一句话功能简述〉<br>
 * 〈单循环链表〉
 * 特点：链表的尾指针不为空，而是指向头节点
 * 实现单循环链表，主要功能是对链表进行翻转。
 *
 * @author hyqin
 * @create 2019-04-18
 * @since 1.0.0
 */
public class CirculNode<T> extends ListNode<T> implements MyNode {
    //定义尾指针
    private CirculNode next;


    //数据域
    private T value;

    public CirculNode() {
    }

    public CirculNode(MyNode<T> node) {

    }

    public CirculNode(T data) {
        this.value = data;
    }

    @Override
    public boolean add(T value) {
        if (isEmpty()) {
            next = new CirculNode();
            //这一行代码是重点，在这里思考了差不多十分钟。循环链表的重点是尾指针指向了头节点
            next.next = next;
        }
        CirculNode<T> p = new CirculNode<T>(value);
        CirculNode<T> head = next;
        CirculNode<T> tail = head;
        //tail.next = head;
        //由于是单向循环链表，所以先找到尾节点的位置
        while (tail.next != head) {
            tail = tail.next;
        }
        p.next = head;
        tail.next = p;

        return true;
    }

    @Override
    public boolean isEmpty() {
        if (next == null) {
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        CirculNode<T> head = next.next;
        CirculNode<T> tail = head;
        while (tail.next != head) {
            System.out.print(tail.value + "   ");
            tail = tail.next;
        }
        System.out.println("--------分割线---------");
    }

    /**
     * 实现循环列表的翻转
     * 1.需要逆转每个节点的指针域，即把原来指向其直接后继的指针，改为指向其直接前驱的指针。
     * 可用指针p扫描表的节点，并用指针q，r来指示p的直接前驱与直接后继，每次均逆转p的指针域。
     */
    public void reverse() {
        CirculNode<T> q = next;
        CirculNode<T> p = q.next;
        CirculNode<T> r = p.next;

        do {
            p.next = q;
            q = p;
            p = r;
            r = r.next;
        } while (q != next);
    }


}
