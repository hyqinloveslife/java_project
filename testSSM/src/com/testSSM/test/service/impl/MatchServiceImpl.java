package com.testSSM.test.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IMatchDao;
import com.testSSM.test.model.fifa.FootballTeam;
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

	@Override
	public int addMatch(Map<?, ?> paramMap) {
		
		return 0;
	}

	@Override
	public List getFootBallTeam() {
		// TODO Auto-generated method stub
		return matchDao.getFootBallTeam();
	}

	@Override
	public int addFootballTeam(Map<?, ?> paramMap) throws Exception{
		//在service里面对数据进行处理
		FootballTeam team = new FootballTeam();
		if(!StringUtils.isEmpty(MapUtils.getString(paramMap, "homefield"))){
			team.setHomeField(MapUtils.getString(paramMap, "homefield"));
		}
		if(!StringUtils.isEmpty(MapUtils.getString(paramMap, "registerCode"))){
			team.setHomeField(MapUtils.getString(paramMap, "registerCode"));
		}
		team.setRegistAddress(MapUtils.getString(paramMap, "registAddress"));
		team.setRegistDate(MapUtils.getString(paramMap, "registDate"));
		team.setTeamBoss(MapUtils.getString(paramMap, "teamBoss"));
		team.setTeamManager(MapUtils.getString(paramMap, "teamManager"));
		team.setTeamName(MapUtils.getString(paramMap, "teamName"));
		team.setAgeLimit(MapUtils.getString(paramMap, "ageLimit"));
		
		return matchDao.saveTeam(team);
	}

}
