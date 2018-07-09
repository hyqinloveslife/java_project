package com.testSSM.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IWeixinDao;
import com.testSSM.test.model.WeixinCard;
import com.testSSM.test.service.IWeixinService;

@Transactional
@Service("weixinService")
public class WeixinServiceImpl implements IWeixinService {
	@Resource
	private IWeixinDao weixinDao;
	
	@Override
	public WeixinCard findById(WeixinCard t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(WeixinCard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(WeixinCard t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<WeixinCard> query() {
		// TODO Auto-generated method stub
		return null;
	}

}
