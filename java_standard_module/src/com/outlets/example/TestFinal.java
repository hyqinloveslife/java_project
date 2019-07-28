/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestFinal
 * Author:   hyqin
 * Date:     2019-07-28 14:45
 * Description: 测试一下final关键字的用法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.outlets.example;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试一下final关键字的用法〉
 * <p>
 * 1.当用final修饰一个类时，表明这个类不能被继承。
 * 2.如果只有在想明确禁止 该方法在子类中被覆盖的情况下才将方法设置为final的。
 * 类的private方法会隐式地被指定为final方法。
 * 3.对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
 * 如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象
 *
 * @author hyqin
 * @create 2019-07-28
 * @since 1.0.0
 */
public class TestFinal {
    public static void main(String[] args) {
//        int a = 10;
//        final int b = 2;
//
//        //b=5;    //这样赋值时错误的
//        //b = a+2;
//
//        final Son son1 = new Son();
//        son1.setParantName("Tom");  //可以对内部的变量赋值
//        son1.say();
//
//        Son son2 = new Son();
////        son1 = son2;     //但是无法将整个对象指向另外的对象了


        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);

    }
}


class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}

class Parent {
    public void say() {
        System.out.println("hello My son");
    }

    private void drink() {
        System.out.println("drink...");
    }
}

class Son extends Parent {

    private String parantName;

    public String getParantName() {
        return parantName;
    }

    public void setParantName(String parantName) {
        this.parantName = parantName;
    }

    @Override
    public void say() {
        System.out.println(parantName + "  hello my father");
    }

}