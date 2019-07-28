/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LazyLoaderFacotry
 * Author:   hyqin
 * Date:     2019-07-28 14:08
 * Description: 单例模式-懒汉式-线程不安全
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.singleton;

import jdk.nashorn.internal.ir.IfNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈单例模式-懒汉式-线程不安全〉
 *
 * @author hyqin
 * @create 2019-07-28
 * @since 1.0.0
 */
public class LazyLoaderFacotry {
    //定义实例
    private static LazyLoaderFacotry facotry;

    //私有化构造方法
    private LazyLoaderFacotry() {
    }

    //判断，只有在为空的时候，才会去实例化
    public static LazyLoaderFacotry getInstance() {
        if (null == facotry) {
            facotry = new LazyLoaderFacotry();
        }
        return facotry;
    }

    /**
     * 效率太低了
     *
     * @return
     */
    public static synchronized LazyLoaderFacotry getFacotry() {
        if (null == facotry) {
            facotry = new LazyLoaderFacotry();
        }
        return facotry;
    }


}
