package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToOwnerAndPets {
    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "root";
    private static String URL = "jdbc:mysql://localhost/owners_and_pets?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";


    public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, SQLException {
        Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
//        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
    }
}
