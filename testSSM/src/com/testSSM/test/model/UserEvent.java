package com.testSSM.test.model;

import java.sql.Date;

public class UserEvent {
	private String id;
	private Date register_time;
	private Date last_login_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	@Override
	public String toString() {
		return "UserEvent [id=" + id + ", register_time=" + register_time
				+ ", last_login_time=" + last_login_time + "]";
	}
	
}
