package com.testSSM.test.service;

import java.util.List;
import java.util.Map;

import com.testSSM.test.model.fifa.FootballTeam;
import com.testSSM.test.model.fifa.Match;

public interface MatchService extends IBaseService<Match>{

	int addMatch(Map<?, ?> paramMap);

	public List getFootBallTeam();

	int addFootballTeam(Map<?, ?> paramMap) throws Exception;

}
