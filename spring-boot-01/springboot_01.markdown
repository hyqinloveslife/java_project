# springboot学习过程中的一些问题

## 一、已经完成的功能
### 1.实现的基础的yaml配置，实现了数据源的配置。
### 2.实现了restful风格的api接口
#### 2.1.1 实现了restful api风格的提交表单，前端框架采用vue.js，前台ui采用element ui。

### 3.实现了poi来操作excel的功能，能实现将批量数据写入同一个excel的不同sheet中
#### 3.1 Java对excel的操作，根据根据模板，生成多个sheet。[Java实现poi操作excel](https://github.com/hyqinloveslife/java_project/blob/master/spring-boot-01/src/test/java/com/hyqin/moduletest/POIUtils.java) 的源代码
- 预先在模板文件中设置唯一字符 如 ${hello} 这样的
- 在Java中用map生成一个集合，key就用${hello}，value就用需要替换的值，如 张三
```java
  Map<String,String> param = new HashMap<String,String>();
  param.put("${hello}","张三");
```
- 循环替换已经复制好的sheet中的内容



## 二、待实现的功能
### 1.与vue.js组合起来实现一个完整的系统
### 2.vue.js的前端框架搭建
### 3.vue.js的首页面菜单树的实现
### 4.基于Java的权限设计基础
