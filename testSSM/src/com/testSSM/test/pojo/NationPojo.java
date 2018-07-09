package com.testSSM.test.pojo;

public class NationPojo {
	private String id;
	private String name;
	private String desc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public NationPojo(String id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	public NationPojo() {
		
	}
	@Override
	public String toString() {
		return "NationPojo [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
	
}
