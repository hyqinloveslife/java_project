package com.testSSM.test.model.fifa;

import org.apache.commons.lang.time.DateUtils;

/**
 * ��Ա
 * @author hyqin
 *
 */
public class Player {
	private String id;//����
	private String playerName;//����
	private String playerCode;//��Ա���
	private String idCard;//���֤��
	private String nativePlace;//����
	private int age;//����
	private String nation;//����
	private String birth;//����
	private String householdPlace;//�������ڵ�
	private String address;//���ھ�ס��
	private String identity;//���  ��Աor����or�ϰ�or����
	private String status;//״̬   ��ְor����
	private String gender;//�Ա�
	private String workDate;//�μ�ʱ��
	private String education;//ѧ��
	private String maritalStatus;//����״��
	private String liveStatus;//����״̬
	private String registDate;//ע��ʱ��
	private String firstPlayDate;//��һ�α���ʱ��
	private String phone;//��ϵ�绰/
	private String email;//����
	private String deadDate;//�����¼�
	private String charactor;//����λ��
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
