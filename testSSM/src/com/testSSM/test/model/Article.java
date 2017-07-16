package com.testSSM.test.model;

import java.sql.Date;

public class Article {
	private String id;
	private String title;
	private String content;
	private String bg_img;
	private String logo;
	private String author;
	private String author_id;
	private Date write_time;
	private Date edit_time;
	private Date apply_time;
	private String article_type;
	private String address;
	private String description;
	private String short_content;
	private String isExsit;
	private String allow_copy;
	private int likes;
	private int dislikes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBg_img() {
		return bg_img;
	}
	public void setBg_img(String bg_img) {
		this.bg_img = bg_img;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	public Date getEdit_time() {
		return edit_time;
	}
	public void setEdit_time(Date edit_time) {
		this.edit_time = edit_time;
	}
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public String getArticle_type() {
		return article_type;
	}
	public void setArticle_type(String article_type) {
		this.article_type = article_type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShort_content() {
		return short_content;
	}
	public void setShort_content(String short_content) {
		this.short_content = short_content;
	}
	public String getIsExsit() {
		return isExsit;
	}
	public void setIsExsit(String isExsit) {
		this.isExsit = isExsit;
	}
	public String getAllow_copy() {
		return allow_copy;
	}
	public void setAllow_copy(String allow_copy) {
		this.allow_copy = allow_copy;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", bg_img=" + bg_img + ", logo=" + logo
				+ ", author=" + author + ", author_id=" + author_id
				+ ", write_time=" + write_time + ", edit_time=" + edit_time
				+ ", apply_time=" + apply_time + ", article_type="
				+ article_type + ", address=" + address + ", description="
				+ description + ", short_content=" + short_content
				+ ", isExsit=" + isExsit + ", allow_copy=" + allow_copy
				+ ", likes=" + likes + ", dislikes=" + dislikes + "]";
	}
	
}
