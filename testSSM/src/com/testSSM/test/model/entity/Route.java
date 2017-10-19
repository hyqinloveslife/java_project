package com.testSSM.test.model.entity;

import java.util.Date;

/**
 * 路线bean
 * @author hyqin
 *
 */
public class Route {
	private String id;
	private String route_name;
	private String startST;//起始站
	private String endST;//终点站
	private int price;//票价
	private int stNumber;//站点数
	private String type;//路线类型
	private String startTime;//开始时间
	private String endTime;//结束时间
	private Date useTime;//启用时间
	public String getRoute_name() {
		return route_name;
	}
	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}
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
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
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
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", startST=" + startST + ", endST=" + endST + ", price=" + price + ", stNumber="
				+ stNumber + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
