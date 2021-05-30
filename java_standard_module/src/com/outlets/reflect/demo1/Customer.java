package com.outlets.reflect.demo1;

/**
 * @description 消费者类
 * @author: huangyeqin
 * @create : 2021/5/4  22:00
 */

public class Customer {

  @ApiModelProperty("姓名")
  private String name;

  @ApiModelProperty("消费者类型")
  private String type;

  @ApiModelProperty("消费者年龄")
  private Integer age;

  @ApiModelProperty("消费者地址")
  private String address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
