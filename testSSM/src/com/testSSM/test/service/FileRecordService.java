/**
 * @author huangyq
 * @date 2017-7-9  
 * @version 1.0.0 
 */
package com.testSSM.test.service;

import java.util.List;

import com.testSSM.test.model.DownloadRecord;


public interface FileRecordService extends IBaseService<DownloadRecord>{
	public int insert(DownloadRecord file);
	
	public List<DownloadRecord> query();
	
	@Override
	int remove(String id);
}
