/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DulNode
 * Author:   hyqin
 * Date:     2019-04-20 13:02
 * Description: 自定义双向链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.day02;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义双向链表〉
 *
 * @author hyqin
 * @create 2019-04-20
 * @since 1.0.0
 */
public class DulNode<T> extends ListNode<T> implements MyNode {
    //数据域
    private T value;

    //指向前驱的指针域
    private DulNode<T> prior;

    //指向后继的指针域
    private DulNode<T> next;

    public DulNode() {

    }

    public DulNode(T value) {
        this.value = value;
    }

    public DulNode(MyNode node) {
        node = next;
        node = prior;
        ((DulNode) node).next.prior = ((DulNode) node).prior.next;
    }

    /**
     * 新增节点 使用尾插法
     * 1.注意，在使用尾插法的时候，新插入的节点，next域要指向null
     *
     * @param value
     * @return
     */
    @Override
    public boolean add(T value) {
        if (isEmpty()) {
            next = new DulNode();
            prior = next;
            next.prior = prior;
            prior.prior = next;
        }
        DulNode<T> newNode = new DulNode<>(value);
        DulNode<T> p = next;
        while (p.next != null) {
            p = p.next;
        }
        newNode.prior = p;
        p.next = newNode;

        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return next == null;
    }

    @Override
    public void print() {
        DulNode<T> p = next.next;
        while (p != null) {
            System.out.print(p.value + "  ");
            p = p.next;
        }
        System.out.println();
    }
}
