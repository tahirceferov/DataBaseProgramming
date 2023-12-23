package org.example.relation;

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

        String sql = "delete from department where departmentId=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,3);

        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
