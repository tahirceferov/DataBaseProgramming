package org.example.prepared;

import java.sql.*;

public class ListTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long productId = resultSet.getLong("product_id");
            String productName = resultSet.getString("product_name");
            double sales_price = resultSet.getDouble("sales_price");
            System.out.printf("%10d %-20s %10.2f \r\n",productId,productName,sales_price);
        }




        connection.close();
    }
}
