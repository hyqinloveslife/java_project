package com.testSSM.test.model.entity;

import java.util.Date;

/**
 * Â·Ïß
 * @author hyqin
 *
 */
public class Route {
	private String id;
	private String startST;
	private String endST;
	private int price;
	private int stNumber;
	private String type;
	private Date startTime;
	private Date endTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartST() {
		return startST;
	}
	public void setStartST(String startST) {
		this.startST = startST;
	}
	public String getEndST() {
		return endST;
	}
	public void setEndST(String endST) {
		this.endST = endST;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStNumber() {
		return stNumber;
	}
	public void setStNumber(int stNumber) {
		this.stNumber = stNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Route() {
		
	}
	public Route(String id, String startST, String endST, int price, int stNumber, String type, Date startTime,
			Date endTime) {
		super();
		this.id = id;
		this.startST = startST;
		this.endST = endST;
		this.price = price;
		this.stNumber = stNumber;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", startST=" + startST + ", endST=" + endST + ", price=" + price + ", stNumber="
				+ stNumber + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
