package com.testSSM.test.model.fifa;

import org.apache.commons.lang.time.DateUtils;

/**
 * 球员
 * @author hyqin
 *
 */
public class Player {
	private String id;//主键
	private String playerName;//姓名
	private String playerCode;//球员编号
	private String idCard;//身份证号
	private String nativePlace;//籍贯
	private int age;//年龄
	private String nation;//民族
	private String birth;//生日
	private String householdPlace;//户口所在地
	private String address;//现在居住地
	private String identity;//身份  球员or经理or老板or裁判
	private String status;//状态   在职or退役
	private String gender;//性别
	private String workDate;//参加时间
	private String education;//学历
	private String maritalStatus;//婚姻状况
	private String liveStatus;//生存状态
	private String registDate;//注册时间
	private String firstPlayDate;//第一次比赛时间
	private String phone;//联系电话/
	private String email;//邮箱
	private String deadDate;//死亡事件
	private String charactor;//所踢位置
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCharactor() {
		return charactor;
	}
	public void setCharactor(String charactor) {
		this.charactor = charactor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerCode() {
		return playerCode;
	}
	public void setPlayerCode(String playerCode) {
		this.playerCode = playerCode;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHouseholdPlace() {
		return householdPlace;
	}
	public void setHouseholdPlace(String householdPlace) {
		this.householdPlace = householdPlace;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getLiveStatus() {
		return liveStatus;
	}
	public void setLiveStatus(String liveStatus) {
		this.liveStatus = liveStatus;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		
		this.registDate = registDate;
	}
	public String getFirstPlayDate() {
		return firstPlayDate;
	}
	public void setFirstPlayDate(String firstPlayDate) {
		this.firstPlayDate = firstPlayDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeadDate() {
		return deadDate;
	}
	public void setDeadDate(String deadDate) {
		this.deadDate = deadDate;
	}
	public Player(String id, String playerName, String playerCode, String idCard, String nativePlace, int age,
			String birth, String householdPlace, String address, String identity, String status, String gender,
			String workDate, String education, String maritalStatus, String liveStatus, String registDate,
			String firstPlayDate, String phone, String email, String deadDate) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.playerCode = playerCode;
		this.idCard = idCard;
		this.nativePlace = nativePlace;
		this.age = age;
		this.birth = birth;
		this.householdPlace = householdPlace;
		this.address = address;
		this.identity = identity;
		this.status = status;
		this.gender = gender;
		this.workDate = workDate;
		this.education = education;
		this.maritalStatus = maritalStatus;
		this.liveStatus = liveStatus;
		this.registDate = registDate;
		this.firstPlayDate = firstPlayDate;
		this.phone = phone;
		this.email = email;
		this.deadDate = deadDate;
	}
	public Player() {
		
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", playerCode=" + playerCode + ", idCard=" + idCard
				+ ", nativePlace=" + nativePlace + ", age=" + age + ", birth=" + birth + ", householdPlace="
				+ householdPlace + ", address=" + address + ", identity=" + identity + ", status=" + status
				+ ", gender=" + gender + ", workDate=" + workDate + ", education=" + education + ", maritalStatus="
				+ maritalStatus + ", liveStatus=" + liveStatus + ", registDate=" + registDate + ", firstPlayDate="
				+ firstPlayDate + ", phone=" + phone + ", email=" + email + ", deadDate=" + deadDate + "]";
	}
	
	
	
}
