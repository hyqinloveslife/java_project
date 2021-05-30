package com.outlets.design.factory.demo;

import com.outlets.design.factory.type01.DellComputer;
import com.outlets.design.factory.type01.LenoveComputer;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/8  9:21
 */
public class Client {

  public static void main(String[] args) {
    HumanFactory factory = new HumanFactory();
    YellowHuman yellowHuman = factory.createHuman(YellowHuman.class);
    yellowHuman.say();

    WhiteHuman whiteHuman = factory.createHuman(WhiteHuman.class);
    whiteHuman.say();

    BlackHuman blackHuman = factory.createHuman(BlackHuman.class);
    blackHuman.say();

    System.out.println("-------------------------------------");
    PhoneFactory phoneFactory = new PhoneFactory();
    DellComputer dell = phoneFactory.createHuman(DellComputer.class);
    dell.productMethod();

    LenoveComputer lenove = phoneFactory.createHuman(LenoveComputer.class);
    lenove.productMethod();
  }
}
