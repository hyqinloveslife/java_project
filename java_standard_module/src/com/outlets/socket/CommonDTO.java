package com.outlets.socket;

import java.io.Serializable;

/**
 * @description 公共的传输数据类
 * @author: huangyeqin
 * @create : 2021/2/10  23:01
 */
public class CommonDTO implements Serializable {

  private static final long serialVersionUID = -6983124596738500703L;

  private String name;

  private String address;

  private Integer age;

  public CommonDTO() {
  }

  public CommonDTO(String name, String address, Integer age) {
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "CommonDTO{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", age=" + age +
        '}';
  }
}
