package org.example.prepared;

import java.sql.*;

public class FindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from Product where product_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,35);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            long productId = resultSet.getLong("product_id");
            String productName = resultSet.getString("product_name");
            double sales_price = resultSet.getDouble("sales_price");
            System.out.println("Urun no " + productId);
            System.out.println("Urun Adi " + productName);
            System.out.println("Urun Fiyati " + sales_price);
        }
        else{
            System.out.println("Urun bulunamadi");
        }




        connection.close();
    }
}
