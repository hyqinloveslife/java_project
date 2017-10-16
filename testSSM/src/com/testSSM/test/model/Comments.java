package com.testSSM.test.model;

import java.sql.Date;

public class Comments {
	private String id;
	private Date time;
	private String commentContent;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", time=" + time + ", commentContent="
				+ commentContent + "]";
	}
	
}
