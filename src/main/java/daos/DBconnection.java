package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconnection {
    public static final String URL = "jdbc:mysql://localhost:3306/Bikes";
    public static final String USER = "USER";
    public static final String PASS = "PASS";

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

}
