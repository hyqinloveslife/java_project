package com.testSSM.test.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testSSM.test.dao.IRoadDao;
import com.testSSM.test.model.entity.Route;
import com.testSSM.test.model.entity.Station;
import com.testSSM.test.pojo.RoadPojo;
import com.testSSM.test.service.IRoadService;

@Transactional
@Service
public class RoadServiceImpl implements IRoadService {
	@Resource
	private IRoadDao roadDao;
	
	@Override
	public List<Station> queryStation() {
		return roadDao.queryStation();
	}

	@Override
	public Station getStation(String id) {
		return roadDao.getStation(id);
	}

	@Override
	public List<Route> queryRoute() {
		return roadDao.queryRoute();
	}

	@Override
	public Route getRoute(String id) {
		return roadDao.getRoute(id);
	}

	@Override
	public int saveStation(Station station) {
		if(StringUtils.isNotEmpty(station.getUseTime().toString())){
			station.setUseTime(new Date());
		}
		return roadDao.saveStation(station);
	}

	@Override
	public int saveRoute(Route route) {
		return roadDao.saveRoute(route);
	}

	@Override
	public int saveRoad(RoadPojo roadPojo) {
		return roadDao.saveRoad(roadPojo);
	}

}
