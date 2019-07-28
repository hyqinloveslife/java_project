/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SessionFactory
 * Author:   hyqin
 * Date:     2019-07-28 13:53
 * Description: 单例模式的写法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.singleton;

/**
 * 〈一句话功能简述〉<br>
 * 〈单例模式的写法〉
 * 饿汉式的写法,在类加载的时候就初始化了
 * <p>
 * 避免了多线程的问题，但是会造成内存浪费。
 *
 * @author hyqin
 * @create 2019-07-28
 * @since 1.0.0
 */
public class SessionFactory {
    //私有化构造器
    private SessionFactory() {
    }

    //静态变量
    private final static SessionFactory sessionFactory = new SessionFactory();


    //静态代码块的写法
    private static SessionFactory session;

    //在静态代码块中初始化单例对象
    static {
        session = new SessionFactory();
    }


    //写一个静态方法用于获取实例
    public static SessionFactory getInstance() {

        return sessionFactory;
    }


}
