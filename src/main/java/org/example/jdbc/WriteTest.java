package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql = "insert into Product(product_name,sales_price) values('Bulasik Makinesi',450)";
        Statement statement = connection.createStatement();
        int affected = statement.executeUpdate(sql);
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
