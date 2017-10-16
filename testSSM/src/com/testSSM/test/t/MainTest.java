/**
 * @author hyqin
 * @date 2017-8-12  
 * @version 1.0.0 
 */
package com.testSSM.test.t;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class MainTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		MyTimerTask task = new MyTimerTask("уехЩ");
		
		timer.schedule(task, 5000L, 3000L);
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		sdf.format(c.getTime());
		System.out.println(sdf.format(c.getTime()));
		timer.schedule(task, new Date());
	}
	
}
