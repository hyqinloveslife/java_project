package com.outlets.design.prototype;

/**
 * @description 克隆羊模板
 * @author: huangyeqin
 * @create : 2020/12/16  23:08
 */
public class Sheep implements Cloneable {

  private String name;
  private String age;
  private String color;

  private Cat friend;

  public Sheep() {
  }

  public Sheep(String name, String age, String color) {
    this.name = name;
    this.age = age;
    this.color = color;
  }

  public Cat getFriend() {
    return friend;
  }

  public void setFriend(Cat friend) {
    this.friend = friend;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  protected Object clone() {
    Sheep clone = null;
    try {
      clone = (Sheep) super.clone();
    } catch (Exception e) {
      System.out.println("克隆失败：" + e.getMessage());
    }
    return clone;
  }

  @Override
  public String toString() {
    return "Sheep{" +
        "name='" + name + '\'' +
        ", age='" + age + '\'' +
        ", color='" + color + '\'' +
        '}' + "hashcode=" + this.hashCode();
  }

}
