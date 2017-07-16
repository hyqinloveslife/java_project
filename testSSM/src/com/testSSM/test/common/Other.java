package com.testSSM.test.common;

import java.io.Serializable;


public class Other implements Serializable{

	private static final long serialVersionUID = 7056923100747992504L;

	private int code=0;    
	private String message=""; 
	private String time="";    
	private int currpage=0;
	private String next="";    
	private String forward=""; 
	private String refresh="";
	private String first="";
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	public String getRefresh() {
		return refresh;
	}
	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public Other() {
		super();
	}
	public Other(int code) {
		super();
		this.code = code;
	}
	public Other(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	} 

}
