package mapper;

import model.Actor;
import utils.RowMapper;

import java.sql.ResultSet;

public class ActorMapper implements RowMapper<Actor> {

	@Override
	public Actor mapRow(ResultSet rs) throws Exception {
		return new Actor(rs.getString("actor_id"), rs.getString("first_name"), rs.getString("last_name"),
				rs.getTimestamp("last_update"));
	}

}
