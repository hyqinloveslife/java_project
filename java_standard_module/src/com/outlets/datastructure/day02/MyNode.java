package com.outlets.datastructure.day02;

/**
 * 定义一个节点接口，链表的上层接口。
 * 作为一个节点的数据结构，需要有哪些基本的方法？
 * 1.大小
 * 2.是否为空
 */
public interface MyNode<T> extends DataStructure {
    /**
     * 判断数据结构的大小
     *
     * @return
     */
    int size();

    /**
     * 判断该数据结构是否为空
     *
     * @return
     */
    boolean isEmpty();
}
