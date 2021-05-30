package com.outlets.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @description
 * @author: huangyeqin
 * @create : 2021/3/17  21:25
 */

class Apple {

  private int id;
  private String color;
  private int weigh;
  private String origin;

  public Apple(int id, String color, int weigh, String origin) {
    this.id = id;
    this.color = color;
    this.weigh = weigh;
    this.origin = origin;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getWeigh() {
    return weigh;
  }

  public void setWeigh(int weigh) {
    this.weigh = weigh;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Apple apple = (Apple) o;
    return id == apple.id &&
        weigh == apple.weigh &&
        Objects.equals(color, apple.color) &&
        Objects.equals(origin, apple.origin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, color, weigh, origin);
  }

  @Override
  public String toString() {
    return "Apple{" +
        "id=" + id +
        ", color='" + color + '\'' +
        ", weigh=" + weigh +
        ", origin='" + origin + '\'' +
        '}';
  }
}

public class TestLambda1 {

  static List<Apple> appleStore = new ArrayList<>();

  static {
    appleStore.add(new Apple(1, "red", 300, "湖南"));
    appleStore.add(new Apple(2, "red", 400, "湖北"));
    appleStore.add(new Apple(3, "yello", 200, "湖南"));
    appleStore.add(new Apple(4, "yello", 320, "山东"));
    appleStore.add(new Apple(5, "green", 500, "北京"));
    appleStore.add(new Apple(6, "green", 600, "湖南"));
    appleStore.add(new Apple(7, "blue", 360, "湖南"));
  }

  private static <T> Predicate<T> distinctKey(Function<? super T, ?> keyExtractor) {
    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
  }


  public static void main(String[] args) {
    List<Apple> collect = appleStore.stream().filter(distinctKey(e -> e.getColor()))
        .collect(Collectors.toList());
    collect.stream().forEach(e -> System.out.println(e.toString()));
  }

  // 求每个颜色的平均重量
  public static void getAvgWeighByColor() {
    appleStore.stream().collect(
        Collectors.groupingBy(e -> e.getColor(),
            Collectors.averagingInt(e -> e.getWeigh()))
    ).forEach((k, v) -> System.out.println(k + ":" + v));

  }


}
