package org.example.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql = "update Product set product_name =?, sales_price=? where product_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,"Laptop");
        statement.setDouble(2,2300);
        statement.setInt(3,4);
        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
