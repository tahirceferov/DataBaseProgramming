package org.example.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);
        connection.setAutoCommit(false);

        String sql = "insert into Product(product_name,sales_price) values(?,?)";

        PreparedStatement statement1 = connection.prepareStatement(sql);
        statement1.setString(1,"Masaustu bilgisayar");
        statement1.setDouble(2,1850);
        int affected1 = statement1.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected1);

        PreparedStatement statement2 = connection.prepareStatement(sql);
        statement2.setString(1,"Utu");
        statement2.setDouble(2,145);
        int affected2 = statement2.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected2);

        PreparedStatement statement3 = connection.prepareStatement(sql);
        statement3.setString(1,"Utu");
        statement3.setDouble(2,145);
        int affected3 = statement3.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected3);


        connection.commit();

        connection.close();
    }
}
