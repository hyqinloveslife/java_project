package bean;

import java.io.Serializable;

public class Comments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8109510612496636022L;
	
	private String id;
	private String article_id;
	private String reply_content;
	private String createTime;
	private String users_id;
	private String author;
	private String beComented;
	private String beConmentdName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public String getBeComented() {
		return beComented;
	}
	public void setBeComented(String beComented) {
		this.beComented = beComented;
	}
	public String getBeConmentdName() {
		return beConmentdName;
	}
	public void setBeConmentdName(String beConmentdName) {
		this.beConmentdName = beConmentdName;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", article_id=" + article_id + ", reply_content=" + reply_content
				+ ", createTime=" + createTime + ", users_id=" + users_id + ", author=" + author + ", beComented="
				+ beComented + ", beConmentdName=" + beConmentdName + "]";
	}
	
}
