/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestMain
 * Author:   hyqin
 * Date:     2019-07-28 13:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.design.singleton;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-07-28
 * @since 1.0.0
 */
public class TestMain {
    public static void main(String[] args) {
        /**饿汉式*/
//        SessionFactory s1 = SessionFactory.getInstance();
//        SessionFactory s2 = SessionFactory.getInstance();
//        System.out.println(s1==s2);
//        System.out.println("s1 的hashcode :"+s1.hashCode());
//        System.out.println("s2 的hashcode :"+s2.hashCode());

        /**懒汉式**/
        LazyLoaderFacotry f1 = LazyLoaderFacotry.getInstance();
        LazyLoaderFacotry f2 = LazyLoaderFacotry.getInstance();
        System.out.print(f1 == f2);

    }
}
