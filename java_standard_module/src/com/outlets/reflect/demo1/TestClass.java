package com.outlets.reflect.demo1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @description 通过反射机制来获取属性注解上的内容
 * @author: huangyeqin
 * @create : 2021/5/4  21:55
 */
public class TestClass {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();

    // 通过反射，首先要找到是哪个类
    Field[] fields = Customer.class.getDeclaredFields();
    for (Field field : fields) {
      // 获取字段名
      String fieldName = field.getName();

      boolean annotationPresent = field.isAnnotationPresent(ApiModelProperty.class);
      if (annotationPresent) {
        map.put(fieldName, field.getAnnotation(ApiModelProperty.class).value());
      }
    }

    System.out.println(">>>>>>>>>>>>>查看字段名及对应注释>>>>>>>>>>>>");
    // 遍历map
    for (Entry<String, String> entry : map.entrySet()) {
      System.out.println("key = " + entry.getKey() + "; value = " + entry.getValue());
    }
  }
}
