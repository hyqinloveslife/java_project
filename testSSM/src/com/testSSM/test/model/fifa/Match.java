package com.testSSM.test.model.fifa;
/**
 * ����
 * @author hyqin
 *
 */
public class Match {
	private String id;
	private String matchCode;//�������
	private String mainReferee;//������
	private String secendReferee;//������
	private String videoReferee;//��Ƶ����
	private String assistReferee;//�������
	private String extraReferee;//���ӵĲ���
	private String playField;//��������
	private String playCity;//��������
	private String playCounty;//��������
	private String teamBlue;//��������
	private String teamRed;//�췽����
	private String isDogfall;//�Ƿ�ƽ��
	private String matchDate;//��������
	private String gameTime;//����ʱ��
	private String beginTime;//��ʼʱ��
	private String endTime;//����ʱ��
	private String injoureingTime;//��ʱʱ��
	private String winner;//��ʤ����
	private String scoreRed;//�췽����
	private String scoreBlue;//��������
	private String status;//����״̬
	private String matchType;//��������  С����or��̭��or�����or��ɫ
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatchCode() {
		return matchCode;
	}
	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}
	public String getMainReferee() {
		return mainReferee;
	}
	public void setMainReferee(String mainReferee) {
		this.mainReferee = mainReferee;
	}
	public String getSecendReferee() {
		return secendReferee;
	}
	public void setSecendReferee(String secendReferee) {
		this.secendReferee = secendReferee;
	}
	public String getVideoReferee() {
		return videoReferee;
	}
	public void setVideoReferee(String videoReferee) {
		this.videoReferee = videoReferee;
	}
	public String getAssistReferee() {
		return assistReferee;
	}
	public void setAssistReferee(String assistReferee) {
		this.assistReferee = assistReferee;
	}
	public String getExtraReferee() {
		return extraReferee;
	}
	public void setExtraReferee(String extraReferee) {
		this.extraReferee = extraReferee;
	}
	public String getPlayField() {
		return playField;
	}
	public void setPlayField(String playField) {
		this.playField = playField;
	}
	public String getPlayCity() {
		return playCity;
	}
	public void setPlayCity(String playCity) {
		this.playCity = playCity;
	}
	public String getPlayCounty() {
		return playCounty;
	}
	public void setPlayCounty(String playCounty) {
		this.playCounty = playCounty;
	}
	public String getTeamBlue() {
		return teamBlue;
	}
	public void setTeamBlue(String teamBlue) {
		this.teamBlue = teamBlue;
	}
	public String getTeamRed() {
		return teamRed;
	}
	public void setTeamRed(String teamRed) {
		this.teamRed = teamRed;
	}
	public String getIsDogfall() {
		return isDogfall;
	}
	public void setIsDogfall(String isDogfall) {
		this.isDogfall = isDogfall;
	}
	public String getGameTime() {
		return gameTime;
	}
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInjoureingTime() {
		return injoureingTime;
	}
	public void setInjoureingTime(String injoureingTime) {
		this.injoureingTime = injoureingTime;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getScoreRed() {
		return scoreRed;
	}
	public void setScoreRed(String scoreRed) {
		this.scoreRed = scoreRed;
	}
	public String getScoreBlue() {
		return scoreBlue;
	}
	public void setScoreBlue(String scoreBlue) {
		this.scoreBlue = scoreBlue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", matchCode=" + matchCode + ", mainReferee=" + mainReferee + ", secendReferee="
				+ secendReferee + ", videoReferee=" + videoReferee + ", assistReferee=" + assistReferee
				+ ", extraReferee=" + extraReferee + ", playField=" + playField + ", playCity=" + playCity
				+ ", playCounty=" + playCounty + ", teamBlue=" + teamBlue + ", teamRed=" + teamRed + ", isDogfall="
				+ isDogfall + ", gameTime=" + gameTime + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", injoureingTime=" + injoureingTime + ", winner=" + winner + ", scoreRed=" + scoreRed
				+ ", scoreBlue=" + scoreBlue + ", status=" + status + ", matchType=" + matchType + "]";
	}
	
	
	
}
