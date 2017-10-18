package com.testSSM.test.pojo;

import java.io.Serializable;
import java.util.Date;

public class RoadPojo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String station_id;
	private String route_id;
	private String start_st;//起始站
	private String end_st;//终点站
	private int price;//票价
	private int stNumber;//站点数
	private String type;//路线类型
	private String startTime;//开始时间
	private String endTime;//结束时间
	private Date useTime;//启用时间
	private String route_name;//路线名称
	private String station_name;//站点名称
	public String getStation_id() {
		return station_id;
	}
	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	public String getStart_st() {
		return start_st;
	}
	public void setStart_st(String start_st) {
		this.start_st = start_st;
	}
	public String getEnd_st() {
		return end_st;
	}
	public void setEnd_st(String end_st) {
		this.end_st = end_st;
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
	public String getRoute_name() {
		return route_name;
	}
	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	
}
