package com.testSSM.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IMatchDao;
import com.testSSM.test.model.fifa.Match;
import com.testSSM.test.service.MatchService;

@Transactional
@Service("matchService")
public class MatchServiceImpl implements MatchService {

	@Resource
	private IMatchDao matchDao;
	
	@Override
	public Match findById(Match t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Match t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Match t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Match> query() {
		// TODO Auto-generated method stub
		return null;
	}

}
