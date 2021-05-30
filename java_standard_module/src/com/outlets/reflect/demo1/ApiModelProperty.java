package com.outlets.reflect.demo1;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description 自定义一个注解
 * @author: huangyeqin
 * @create : 2021/5/4  22:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented()
@Target(FIELD)
public @interface ApiModelProperty {

  String value() default "";
}
