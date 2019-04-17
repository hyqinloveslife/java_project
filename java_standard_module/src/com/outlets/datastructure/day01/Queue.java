/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Queue
 * Author:   hyqin
 * Date:     2019-04-17 10:38
 * Description: 用数组实现queue
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.day01;

import java.security.NoSuchAlgorithmException;

/**
 * 〈一句话功能简述〉<br>
 * 〈用数组实现queue的数据结构〉
 * 特性：先进先出。
 * 有两种实现方法：
 * 1.按数组下标从小到大存储。
 * <p>
 * 2.按数据下表从大到小存储。
 *
 * @author hyqin
 * @create 2019-04-17
 * @since 1.0.0
 */
public class Queue {
    private static int[] queue;

    private static int DEFAULT_SIZE = 10;

    //定义队列的大小
    private static int queue_size = 0;

    //定义队列末尾元素的位置
    private int location = 0;

    //私有化构造方法，写成单例模式
    private Queue() {
    }

    /**
     * 根据传入的值来指定队列的大小
     *
     * @param len
     * @return
     */
    public static Queue getInstance(int len) {
        if (len == 0) {
            len = DEFAULT_SIZE;
        } else if (len < 0) {
            throw new IllegalArgumentException("请输入正确的数");
        }
        queue = new int[len];
        queue_size = len;
        Queue q = new Queue();
        return q;
    }

    /**
     * 默认队列的长度
     *
     * @return
     */
    public static Queue getInstance() {
        queue = new int[DEFAULT_SIZE];
        queue_size = DEFAULT_SIZE;
        Queue q = new Queue();
        return q;
    }

    /**
     * 入队
     * 由于定义的数组是无法改变长度的，所以每次入队的时候，都要去检查是否已经越界了。
     *
     * @param value
     */
    public void push(int value) {
        if (isEmpty()) {
            throw new NullPointerException("队列为空，无法做入队操作");
        }
        //如果数组越界了，需要重新申请空间
        if (isFull()) {
            //TODO 先抛出一个数组越界的问题，以后再根据hash的算法进行改进
            throw new IndexOutOfBoundsException("先抛出一个数组越界的问题，以后再根据hash的算法进行改进");
        }
        queue[location++] = value;
    }

    /**
     * 弹出队首的元素，并返回值
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new NullPointerException("当前队列为空，无法做出队操作");
        }
        int returnValue = queue[0];
        //获取了队首元素后，要将位置向前移动
        for (int i = 0; i < location; i++) {
            queue[i] = queue[i + 1];
        }
        location--;
        return returnValue;
    }

    /**
     * 添加一个元素，并返回true，如果队列已经满了，则返回false
     *
     * @param value
     * @return
     */
    public boolean offer(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            return false;
        }
        queue[location++] = value;
        return true;
    }

    /**
     * 根据坐标查找队列中的元素
     *
     * @param pos
     * @return
     */
    public int findElement(int pos) {
        if (pos > location || pos < 0) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        return queue[pos];
    }

    /**
     * 根据值来获取队列位置
     *
     * @param value
     * @return -1 表示没有找到该元素的值
     */
    public int findPos(int value) {
        for (int i = 0; i < location; i++) {
            if (queue[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断当前队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return location == 0 ? true : false;
    }

    /**
     * 判断当前队列是否已经满了
     *
     * @return
     */
    public boolean isFull() {
        return location == queue_size ? true : false;
    }

    //打印队列的元素
    public void print() {
        for (int i = 0; i < queue_size; i++) {
            if (queue[i] == 0) {
                continue;
            }
            System.out.print(queue[i] + "   ");
        }
        System.out.println();
    }


}
