package org.example.database.large;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClobInsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {

        String path ="C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\base\\GodoroSubject.txt";
        FileReader fr = new FileReader(path);
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql = "insert into Large(clobField) values(?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setCharacterStream(1,fr);
        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
