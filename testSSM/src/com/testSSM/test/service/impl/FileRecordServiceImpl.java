/**
 * @author huangyq
 * @date 2017-7-9  
 * @version 1.0.0 
 */
package com.testSSM.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IFileRecordDao;
import com.testSSM.test.model.DownloadRecord;
import com.testSSM.test.service.FileRecordService;

@Transactional
@Service("fileRecordService")
public class FileRecordServiceImpl implements FileRecordService{
	
	@Resource
	public IFileRecordDao recordDao;
	
	@Override
	public DownloadRecord findById(DownloadRecord t) {
		return null;
	}

	
	@Override
	public int save(DownloadRecord t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return recordDao.removeFile(id);
	}

	
	@Override
	public int update(DownloadRecord t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public List<DownloadRecord> query() {
		// TODO Auto-generated method stub
		return recordDao.query();
	}

	
	@Override
	public int insert(DownloadRecord file) {
		// TODO Auto-generated method stub
		return recordDao.insert(file);
	}

}
