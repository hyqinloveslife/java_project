/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Singleton
 * Author:   hyqin
 * Date:     2019-07-28 14:32
 * Description: 单例模式-静态内部类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.singleton;

/**
 * 〈一句话功能简述〉<br>
 * 〈单例模式-静态内部类〉
 * 解决了线程安全问题
 *
 * @author hyqin
 * @create 2019-07-28
 * @since 1.0.0
 */
public class Singleton {
    private Singleton() {
    }

    private static class SingletonInstance {
        private static Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}
