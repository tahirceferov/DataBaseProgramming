package org.example.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilities {
    public static String url ="jdbc:mysql://localhost:3306/godorodb";
    public static String user = "root";
    public static String password = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url,user,password);
        return  connection;
    }
}
