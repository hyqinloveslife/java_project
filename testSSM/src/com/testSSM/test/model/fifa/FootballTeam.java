package com.testSSM.test.model.fifa;
/**
 * �����
 * @author hyqin
 *
 */
public class FootballTeam {
	private String id;//����
	private String registerCode;//ע����
	private String teamName;//����
	private String homeField;//����
	private String teamBoss;//����ϰ�
	private String teamManager;//��Ӿ���
	private String registDate;//ע��ʱ��
	private String registStatus;//ע��״̬
	private String cancelDate;//ע��ʱ��
	private String registAddress;//ע���
	private String ageLimit;//ע������
	private String championNum;//��ùھ���
	
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
