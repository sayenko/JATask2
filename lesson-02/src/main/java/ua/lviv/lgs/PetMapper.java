package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetMapper {
	
	public static Pet map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		String kind = result.getString("kind");
		int owner_id = result.getInt("owner_id");
				
		return new Pet(id, name, kind, owner_id);
	}
	
}
