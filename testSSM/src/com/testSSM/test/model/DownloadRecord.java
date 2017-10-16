/**
 * @author huangyq
 * @date 2017-7-9  
 * @version 1.0.0 
 */
package com.testSSM.test.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
@Alias("downloadRecord")
public class DownloadRecord {
	public static final int STATUS_SUCCESS = 1;
    private String id;
    private String ip;
    private int port;
    private String type;
    private String fileName;
    private String filePath;
    private long length;
    private int status;
    private Timestamp startTime;
    private Timestamp endTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public DownloadRecord(String uid, String ip, int port, String type,
			String fileName, String filePath, long length, int status,
			Timestamp startTime, Timestamp endTime) {
		super();
		this.id = uid;
		this.ip = ip;
		this.port = port;
		this.type = type;
		this.fileName = fileName;
		this.filePath = filePath;
		this.length = length;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public DownloadRecord() {
		super();
	}
    
}
