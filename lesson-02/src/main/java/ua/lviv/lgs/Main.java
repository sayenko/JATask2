package ua.lviv.lgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		workWhithOwnerTable();
		workWhithPetTable();
	}

	public static void workWhithOwnerTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		OwnerDao ownerDao = new OwnerDao(ConnectionToOwnerAndPets.openConnection());
		
		List<Owner> listOfOwner = new ArrayList<>();
		listOfOwner.add(new Owner("Marlon", "Brando"));
		listOfOwner.add(new Owner("Alia", "Bhatt"));
		listOfOwner.add(new Owner("Jack", "Nicholson"));
		listOfOwner.add(new Owner("Daniel", "Day-Lewis"));
		listOfOwner.add(new Owner("Katrina", "Kaiff"));
		
		//INSERT
		listOfOwner.forEach(owner->{
			try {
				ownerDao.insert(owner);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		//READ_ALL
		ownerDao.readAll().stream().forEach(System.out::println);
		System.out.println("************************************************\n");
		
		//READ_BY_ID
		Owner ownerFromBD = ownerDao.read(2);
		System.out.println(ownerFromBD);
		System.out.println("************************************************\n");
		
		//UPDATE_BY_ID
		ownerFromBD.setLastName(ownerFromBD.getLastName()+"-Olivier");
		ownerDao.update(ownerFromBD);
		
		//READ_ALL
		ownerDao.readAll().stream().forEach(System.out::println);
		System.out.println("************************************************\n");
		
		//DELETE_BY_ID
		ownerDao.delete(3);
		
		//READ_ALL
		ownerDao.readAll().stream().forEach(System.out::println);
		System.out.println("************************************************\n");
	}
	
	public static void workWhithPetTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PetDao petDao = new PetDao(ConnectionToOwnerAndPets.openConnection());
		
		List<Pet> listOfOwner = new ArrayList<>();
		listOfOwner.add(new Pet("Rosie", "Cat", 1));
		listOfOwner.add(new Pet("Max", "Dog", 2));
		listOfOwner.add(new Pet("Buddy", "Cat", 1));
		listOfOwner.add(new Pet("Jack", "Parrot", 4));
		listOfOwner.add(new Pet("Molly", "Hamster", 5));
		
		//INSERT
		listOfOwner.forEach(pet->{
			try {
				petDao.insert(pet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		//READ_ALL
		petDao.readAll().stream().forEach(System.out::println);
		System.out.println("************************************************\n");
		
		//READ_BY_ID
		Pet petFromBD = petDao.read(2);
		System.out.println(petFromBD);
		System.out.println("************************************************\n");
		
		//UPDATE_BY_ID
		petFromBD.setKind("Rabbit");
		petDao.update(petFromBD);
		
		//READ_ALL
		petDao.readAll().stream().forEach(System.out::println);
		System.out.println("************************************************\n");
		
		//DELETE_BY_ID
		petDao.delete(5);
		
		//READ_ALL
		petDao.readAll().stream().forEach(System.out::println);
		System.out.println("************************************************\n");
	}
}
