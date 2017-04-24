package bean;

public class News {
	private String sendTime;
	private String fromPerson;
	private String toPerson;
	private String content;
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getFromPerson() {
		return fromPerson;
	}
	public void setFromPerson(String fromPerson) {
		this.fromPerson = fromPerson;
	}
	public String getToPerson() {
		return toPerson;
	}
	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "News [sendTime=" + sendTime + ", fromPerson=" + fromPerson + ", toPerson=" + toPerson + ", content="
				+ content + "]";
	}
	
}
