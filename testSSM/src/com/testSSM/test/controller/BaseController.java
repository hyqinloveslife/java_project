/**
 * @author wws
 * @date 2017-7-6  
 * @version 1.0.0 
 */
package com.testSSM.test.controller;

import javax.annotation.Resource;

import com.testSSM.test.service.FileRecordService;



/**
 * @author Administrator
 *
 */
public class BaseController {
	public static final int SUCCESS_STATUS_CODE=1;
	public static final int ERROR_STATUS_CODE=0;
	public static final String FILE_PATH = "D:\\ssm_img";
	
	@Resource
	public FileRecordService fileRecordService;
}
