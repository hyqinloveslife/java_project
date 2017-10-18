package com.testSSM.test.model.entity;

import java.util.Date;

/**
 * 站点bean
 * @author huangyeq
 *
 */
public class Station {
	private String id;
	private String name;
	private Date useTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	public Station(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Station() {
		
	}
	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + "]";
	}
	
}
