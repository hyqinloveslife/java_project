/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Books
 * Author:   hyqin
 * Date:     2019-10-05 21:02
 * Description: 书本的实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈书本的实体类〉
 *
 * @author hyqin
 * @create 2019-10-05
 * @since 1.0.0
 */
public class Books {
    private Integer id;
    private String name;
    private String referred;//简称
    private Double price;  //价格
    private String published;  //出版社
    private String author; //作者
    private String publishDate; //出版时间
    private String description;  //简介
    private String isbn;  //国际标准书号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferred() {
        return referred;
    }

    public void setReferred(String referred) {
        this.referred = referred;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", referred='" + referred + '\'' +
                ", price=" + price +
                ", published='" + published + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", desc='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
