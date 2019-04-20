/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ListNode
 * Author:   hyqin
 * Date:     2019-04-18 10:51
 * Description: 自定义链表的实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.day02;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义链表的实现〉
 * 概念：链表在逻辑上属于顺序结构，但在物理结构上，并不是顺序的。
 * 链表可以分为【单链表】结构和【双链表】结构
 * 单链表的一个节点，有两个域，一个是数据域，一个是指针域，数据域存在值，指针域存放指向下一个节点的地址。
 * 双链表的一个节点，有三个域，一个是数据域，两个是指针域。分表指向上一个节点和下一个节点。
 * <p>
 * 在面向对象中，如果要实现单链表，可以先定义一个接口，叫做Node，然后通过实现ListNode。这就是面向接口编程。
 *
 * @author hyqin
 * @create 2019-04-18
 * @since 1.0.0
 */
public class ListNode<T> implements MyNode {
    //定义指针域，指向下一个节点
    private ListNode next;
    //数据域
    private T value;


    public ListNode() {
    }


    public ListNode(T value) {
        this.value = value;
    }

    /**
     * 向链表中插入数据，可以选择“头插法”和“尾插法”，如果没有指定，默认是尾插法
     *
     * @param value
     * @return
     */
    public boolean add(T value) {
        if (next == null) {
            next = new ListNode();
        }
        //定义一个新的指针节点，始终指向最后一个节点
        ListNode<T> p = next;
        while (p.next != null) {
            p = p.next;
        }
        ListNode<T> newNode = new ListNode<>(value);
        p.next = newNode;

        return true;
    }

    /**
     * 根据传入的数据，删除某个节点
     *
     * @param value
     * @return
     */
    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }
        if (null == value || "".equals(value)) {
            throw new NullPointerException("传入的值为空");
        }
        ListNode<T> p = next;
        while (p != null) {
            //这里只能去判断p.next.value，如果判断p.next，那么会删除下一个节点
            if (value.equals(p.next.value)) {
                p.next = p.next.next;
                return true;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * 查找链表中是否存在该元素
     *
     * @param t
     * @return
     */
    public boolean find(T t) {
        if (isEmpty()) {
            return false;
        }
        ListNode<T> p = next;
        while (p.next != null) {
            if (t.equals(p.value)) {
                return true;
            }
            p = p.next;
        }

        return false;
    }

    /**
     * 判断该链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return next == null ? true : false;
    }

    /**
     * 判断链表的长度
     *
     * @return
     */
    public int size() {
        int len = 0;
        ListNode<T> p = next;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        return len;
    }

    /**
     * 打印链表中的数据域
     */
    public void print() {
        //头指针的数据域是不存放值的
        ListNode<T> p = next.next;
        while (p != null) {
            System.out.print(p.value + "   ");
            p = p.next;
        }
        System.out.println();
    }

}
