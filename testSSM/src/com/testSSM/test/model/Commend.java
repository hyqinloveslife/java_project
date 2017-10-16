package com.testSSM.test.model;

import java.sql.Date;

public class Commend {
	private String id;
	private Date commend_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCommend_time() {
		return commend_time;
	}
	public void setCommend_time(Date commend_time) {
		this.commend_time = commend_time;
	}
	@Override
	public String toString() {
		return "Commend [id=" + id + ", commend_time=" + commend_time + "]";
	}
	
}
