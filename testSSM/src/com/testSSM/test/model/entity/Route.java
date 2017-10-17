package com.testSSM.test.model.entity;

import java.util.Date;

/**
 * 路线bean
 * @author hyqin
 *
 */
public class Route {
	private String id;
	private String startST;//起始站
	private String endST;//终点站
	private int price;//票价
	private int stNumber;//站点数
	private String type;//路线类型
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private Date useTime;//启用时间
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
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
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
