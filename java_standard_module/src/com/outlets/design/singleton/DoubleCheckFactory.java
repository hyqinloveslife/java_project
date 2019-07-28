/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DoubleCheckFactory
 * Author:   hyqin
 * Date:     2019-07-28 14:22
 * Description: 单例模式-懒汉式-双重检查模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.singleton;

/**
 * 〈一句话功能简述〉<br>
 * 〈单例模式-懒汉式-双重检查模式〉
 *
 * @author hyqin
 * @create 2019-07-28
 * @since 1.0.0
 */
public class DoubleCheckFactory {
    private DoubleCheckFactory() {
    }

    private static DoubleCheckFactory factory;

    /**
     * 推荐使用双重检查模式。
     *
     * @return
     */
    public static DoubleCheckFactory getFactory() {
        if (null == factory) {
            synchronized (DoubleCheckFactory.class) {
                if (null == factory) {
                    factory = new DoubleCheckFactory();
                }
            }
        }
        return factory;
    }
}
