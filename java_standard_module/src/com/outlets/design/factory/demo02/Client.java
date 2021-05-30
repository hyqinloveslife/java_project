package com.outlets.design.factory.demo02;

import com.outlets.design.factory.demo.WhiteHuman;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:43
 */
public class Client {

  public static void main(String[] args) {

    ComputerFactory computerFactory = new ComputerFactory();
    DellComputer dellComputer = computerFactory.doProduct(DellComputer.class);
    dellComputer.productMethod();

    XiaomiComputer xiaomiComputer = computerFactory.doProduct(XiaomiComputer.class);
    xiaomiComputer.productMethod();

    LenoveComputer lenoveComputer = computerFactory.doProduct(LenoveComputer.class);
    lenoveComputer.productMethod();

    System.out.println("--------------------------");

    PeopleFactory peopleFactory = new PeopleFactory();
    BlackPeople blackPeople = peopleFactory.doProduct(BlackPeople.class);
    blackPeople.say();

    WhitePeople whitePeople = peopleFactory.doProduct(WhitePeople.class);
    whitePeople.say();

    YellowPeople yellowPeople = peopleFactory.doProduct(YellowPeople.class);
    yellowPeople.say();
  }
}
