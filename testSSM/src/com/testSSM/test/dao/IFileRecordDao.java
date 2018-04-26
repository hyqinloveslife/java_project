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

	public int removeFile(String id);

	/**
	 * @author huangyq
	 * @date 2018-4-8  
	 * @version 1.0.0 
	 * @param id
	 * @return
	 */
	public DownloadRecord findById(String id);

	/**
	 * @author huangyq
	 * @date 2018-4-8  
	 * @version 1.0.0 
	 * @param paramRecord
	 * @return
	 */
	public int updateFile(DownloadRecord paramRecord);
}
