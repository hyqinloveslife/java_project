package com.testSSM.test.dao;

import java.util.List;

import com.testSSM.test.model.entity.Route;
import com.testSSM.test.model.entity.Station;
import com.testSSM.test.pojo.RoadPojo;
import com.testSSM.test.service.impl.RoadEvent;

public interface IRoadDao {
	public List<Station> queryStation();
	
	public Station getStation(String id);
	
	public List<Route> queryRoute();
	
	public Route getRoute(String id);
	
	public int saveStation(Station station);
	
	public int saveRoute(Route route);
	
	public int saveRoad(RoadPojo roadPojo);

	/**
	 * @author huangyq
	 * @date 2017-11-13  
	 * @version 1.0.0 
	 * @param roadEvent
	 */
	public void saveRoadEvent(RoadEvent roadEvent);
}
