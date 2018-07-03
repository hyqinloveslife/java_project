package com.testSSM.test.model.fifa;
/**
 * 比赛
 * @author hyqin
 *
 */
public class Match {
	private String id;
	private String matchCode;//比赛编号
	private String mainReferee;//主裁判
	private String secendReferee;//副裁判
	private String videoReferee;//视频裁判
	private String assistReferee;//助理裁判
	private String extraReferee;//附加的裁判
	private String playField;//比赛场地
	private String playCity;//比赛城市
	private String playCounty;//比赛国家
	private String teamBlue;//蓝方队伍
	private String teamRed;//红方队伍
	private String isDogfall;//是否平局
	private String matchDate;//比赛日期
	private String gameTime;//比赛时长
	private String beginTime;//开始时间
	private String endTime;//结束时间
	private String injoureingTime;//补时时间
	private String winner;//获胜队伍
	private String scoreRed;//红方分数
	private String scoreBlue;//蓝方分数
	private String status;//比赛状态
	private String matchType;//比赛类型  小组赛or淘汰赛or半决赛or角色
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
