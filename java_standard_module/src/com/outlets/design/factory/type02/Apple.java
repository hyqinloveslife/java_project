package com.outlets.design.factory.type02;

import java.io.Serializable;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/6  23:37
 */
public class Apple implements Serializable {

  private String name;
  private double price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Apple{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
