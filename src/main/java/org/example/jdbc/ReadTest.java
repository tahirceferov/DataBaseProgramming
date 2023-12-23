package org.example.jdbc;

import java.sql.*;

public class ReadTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);
        String sql = "Select * from Product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            long productId = resultSet.getLong("product_id");
             String productName = resultSet.getString("product_name");
             double sales_price = resultSet.getDouble("sales_price");
            System.out.println(productId + " " + productName + " " + sales_price);
        }




        connection.close();
    }
}
