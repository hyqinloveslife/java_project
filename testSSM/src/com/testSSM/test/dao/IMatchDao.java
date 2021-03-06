package com.testSSM.test.dao;

import java.util.List;
import java.util.Map;

import com.testSSM.test.model.fifa.FootballTeam;
import com.testSSM.test.model.fifa.Match;

public interface IMatchDao {
	public int insert(Match match);

	public List getFootBallTeam();

	public int saveTeam(FootballTeam team);

	public List getNations();

	public List getEducation();

	public int saveMatchInfo(Map<?, ?> paramMap);
}
