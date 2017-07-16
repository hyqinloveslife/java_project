package com.testSSM.test.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String account;
	private String id;
	private String name;
	private String password;
	private String birth;
	private String gender;
	private String age;
	private String phone;
	private String identifyNo;
	private String addr;
	private String mail;
	private String manager;
	private String status;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", id=" + id + ", name=" + name
				+ ", password=" + password + ", birth=" + birth + ", gender="
				+ gender + ", age=" + age + ", phone=" + phone
				+ ", identifyNo=" + identifyNo + ", addr=" + addr + ", mail="
				+ mail + ", manager=" + manager + "]";
	}
	
}