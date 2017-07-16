/**
 * @author huangyq
 * @date 2017-7-9  
 * @version 1.0.0 
 */
package com.testSSM.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.testSSM.test.model.DownloadRecord;

public interface IFileRecordDao {
	public List<DownloadRecord> query();
	
	public int insert(DownloadRecord file);
}
