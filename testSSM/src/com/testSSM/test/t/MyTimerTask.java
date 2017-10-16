/**
 * @author hyqin
 * @date 2017-8-12  
 * @version 1.0.0 
 */
package com.testSSM.test.t;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
	private String params;
	
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public MyTimerTask(String params) {
		super();
		this.params = params;
	}

	@Override
	public void run() {
		System.out.println("The input param is :"+params);
		
	}

}
