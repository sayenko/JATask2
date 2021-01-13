package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerMapper {
	
	public static Owner map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstName = result.getString("first_name");
		String lastName = result.getString("last_name");
				
		return new Owner(id, firstName, lastName);
	}
	
}
