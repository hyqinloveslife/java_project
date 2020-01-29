package bean;

import java.io.Serializable;

public class Articles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 622466095721882943L;
	
	private String id;
	private String title;
	private String users_id;
	private String author;
	private String writeTime;
	private String editTime;
	private String content;
	private String praise;
	private String oppose;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	public String getEditTime() {
		return editTime;
	}
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPraise() {
		return praise;
	}
	public void setPraise(String praise) {
		this.praise = praise;
	}
	public String getOppose() {
		return oppose;
	}
	public void setOppose(String oppose) {
		this.oppose = oppose;
	}
	@Override
	public String toString() {
		return "Articles [id=" + id + ", title=" + title + ", users_id=" + users_id + ", author=" + author
				+ ", writeTime=" + writeTime + ", editTime=" + editTime + ", content=" + content + ", praise=" + praise
				+ ", oppose=" + oppose + "]";
	}
	
}
