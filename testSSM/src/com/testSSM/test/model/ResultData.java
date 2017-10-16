/**
 * @author wws
 * @date 2017-7-7  
 * @version 1.0.0 
 */
package com.testSSM.test.model;

/**
 * @author Administrator
 *
 */
public class ResultData<T> {
	private T data;
	
	private int code =200;
	
	private String msg;
	
	private Boolean success = true;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
