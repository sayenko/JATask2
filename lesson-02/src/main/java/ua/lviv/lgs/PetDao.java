package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PetDao {
	private static String READ_ALL = "select * from pets";
	private static String CREATE = "insert into pets(name, kind, owner_id) values (?, ?, ?)";
	private static String READ_BY_ID = "select * from pets where id = ?";
	private static String UPDATE_BY_ID = "update pets set name=?, kind=?, owner_id=? where id=?";
	private static String DELETE_BY_ID = "delete from pets where id=?";	
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public PetDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Pet pet) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, pet.getName());
		preparedStatement.setString(2, pet.getKind());
		preparedStatement.setInt(3, pet.getOwner_id());
		preparedStatement.executeUpdate();				
	}
	
	public Pet read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return PetMapper.map(result);
	}
	
	public void update(Pet pet) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, pet.getName());
		preparedStatement.setString(2, pet.getKind());
		preparedStatement.setInt(3, pet.getOwner_id());
		preparedStatement.setInt(4, pet.getId());
		
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		
		preparedStatement.executeUpdate();
	}
	
	public List<Pet> readAll() throws SQLException {
		List<Pet> listOfPet = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);		
		ResultSet result = preparedStatement.executeQuery();
		while(result.next()) {
			listOfPet.add(PetMapper.map(result));
		}
		return listOfPet;
	}
}
