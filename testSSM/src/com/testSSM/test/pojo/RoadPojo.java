package com.testSSM.test.pojo;

import java.io.Serializable;
import java.util.Date;

public class RoadPojo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String station_id;
	private String route_id;
	private String startST;//始发站
	private String endST;//缁堢偣绔�
	private int price;//绁ㄤ环
	private int stNumber;//绔欑偣鏁�
	private String type;//璺嚎绫诲瀷
	private String startTime;//寮�鏃堕棿
	private String endTime;//缁撴潫鏃堕棿
	private Date useTime;//鍚敤鏃堕棿
	private String route_name;//璺嚎鍚嶇О
	private String station_name;//绔欑偣鍚嶇О
	
	/**
	 * 新增参数
	 * @author huangyq
	 * @date 2017-11-13  
	 * @version 1.0.0 
	 * @return
	 */
	private String createMan;
	private String createTime;
	private String modifyMan;
	private String modifyTime;
	private String checkMan;
	private String checkTime;
	private String checkFlag;
	
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyMan() {
		return modifyMan;
	}
	public void setModifyMan(String modifyMan) {
		this.modifyMan = modifyMan;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getCheckMan() {
		return checkMan;
	}
	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}
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
