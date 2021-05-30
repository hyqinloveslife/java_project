package com.outlets.jdbc.utils;

import java.sql.Connection;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/4/13  19:37
 */
public class JDBCTools<T> {

  /**
   * @param connection 一个数据库连接
   * @param sql 执行sql
   * @param tClass 需要生成的类
   * @Desc :
   * @Author : huangyeqin
   * @Date : 2021/4/16 21:45
   * @Result : T
   */
  public static <T> T getBean(Connection connection, String sql, Class<T> tClass) {
    Object obj = new Object();

    return (T) obj;
  }
}
