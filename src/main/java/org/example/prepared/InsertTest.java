package org.example.prepared;

import java.sql.*;

public class InsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql = "insert into Product(product_name,sales_price) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,"Dizustu bilgisayar");
        statement.setDouble(2,1450);
        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
