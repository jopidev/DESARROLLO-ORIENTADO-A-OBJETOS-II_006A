package Computec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    private static final String URL = "jdbc:mysql://localhost:3306/Computec_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DatabaseConnection() {}

    public static Connection getInstance() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }
}


