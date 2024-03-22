package service;

import mapper.ActorMapper;
import model.Actor;
import utils.DBUtils;

import java.util.List;

public class ActorService {

	public static List<Actor> getListOfAllActors() {
		String query = "SELECT * FROM actor;";
		return DBUtils.executeQuery(query, new ActorMapper());
	}

	public static Actor getAnActor(String actorId){
		String query = "SELECT * FROM actor WHERE actor_id = " + actorId;
		return DBUtils.executeQuery(query,new ActorMapper()).get(0);
	}

}
