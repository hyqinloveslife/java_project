/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestQueue
 * Author:   hyqin
 * Date:     2019-04-17 10:52
 * Description: 自定义队列的测试用例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.datastructure.day01;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义队列的测试用例〉
 *
 * @author hyqin
 * @create 2019-04-17
 * @since 1.0.0
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue queue = Queue.getInstance();
        queue.push(6);
        queue.push(9);
        queue.push(3);
        queue.push(1);
        queue.print();
        System.out.println(queue.pop());
        queue.print();
    }
}
