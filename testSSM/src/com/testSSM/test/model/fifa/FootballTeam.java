package com.testSSM.test.model.fifa;
/**
 * 足球队
 * @author hyqin
 *
 */
public class FootballTeam {
	private String id;//主键
	private String registerCode;//注册码
	private String teamName;//队名
	private String homeField;//主场
	private String teamBoss;//球队老板
	private String teamManager;//球队经理
	private String registDate;//注册时间
	private String registStatus;//注册状态
	private String cancelDate;//注销时间
	private String registAddress;//注册地
	private String ageLimit;//注册年限
	private String championNum;//获得冠军数
	
	public String getChampionNum() {
		return championNum;
	}
	public void setChampionNum(String championNum) {
		this.championNum = championNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegisterCode() {
		return registerCode;
	}
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHomeField() {
		return homeField;
	}
	public void setHomeField(String homeField) {
		this.homeField = homeField;
	}
	public String getTeamBoss() {
		return teamBoss;
	}
	public void setTeamBoss(String teamBoss) {
		this.teamBoss = teamBoss;
	}
	public String getTeamManager() {
		return teamManager;
	}
	public void setTeamManager(String teamManager) {
		this.teamManager = teamManager;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getRegistStatus() {
		return registStatus;
	}
	public void setRegistStatus(String registStatus) {
		this.registStatus = registStatus;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getRegistAddress() {
		return registAddress;
	}
	public void setRegistAddress(String registAddress) {
		this.registAddress = registAddress;
	}
	public String getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}
	public FootballTeam(String id, String registerCode, String teamName, String homeField, String teamBoss,
			String teamManager, String registDate, String registStatus, String cancelDate, String registAddress) {
		super();
		this.id = id;
		this.registerCode = registerCode;
		this.teamName = teamName;
		this.homeField = homeField;
		this.teamBoss = teamBoss;
		this.teamManager = teamManager;
		this.registDate = registDate;
		this.registStatus = registStatus;
		this.cancelDate = cancelDate;
		this.registAddress = registAddress;
	}
	public FootballTeam() {
		
	}
	@Override
	public String toString() {
		return "FootballTeam [id=" + id + ", registerCode=" + registerCode + ", teamName=" + teamName + ", homeField="
				+ homeField + ", teamBoss=" + teamBoss + ", teamManager=" + teamManager + ", registDate=" + registDate
				+ ", registStatus=" + registStatus + ", cancelDate=" + cancelDate + ", registAddress=" + registAddress
				+ "]";
	}
	
}
