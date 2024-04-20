package daos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    public static final String URL = "jdbc:mysql://localhost:3306/Bikes";
    public static final String USER = "shijin";
    public static final String PASS = "fujingjoeman";

    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


    public static void main(String[] args) {
        Connection connection = DBconnection.getConnection();
    }
}
