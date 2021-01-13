package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OwnerDao {
	private static String READ_ALL = "select * from owner";
	private static String CREATE = "insert into owner(first_name, last_name) values (?, ?)";
	private static String READ_BY_ID = "select * from owner where id = ?";
	private static String UPDATE_BY_ID = "update owner set first_name=?, last_name=? where id=?";
	private static String DELETE_BY_ID = "delete from owner where id=?";	
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public OwnerDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Owner owner) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, owner.getFirstName());
		preparedStatement.setString(2, owner.getLastName());
		preparedStatement.executeUpdate();				
	}
	
	public Owner read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return OwnerMapper.map(result);
	}
	
	public void update(Owner owner) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, owner.getFirstName());
		preparedStatement.setString(2, owner.getLastName());
		preparedStatement.setInt(3, owner.getId());
		
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		
		preparedStatement.executeUpdate();
	}
	
	public List<Owner> readAll() throws SQLException {
		List<Owner> listOfOwner = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);		
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfOwner.add(OwnerMapper.map(result));
		}
		return listOfOwner;
	}
}
