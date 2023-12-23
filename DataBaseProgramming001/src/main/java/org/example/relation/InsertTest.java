package org.example.relation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql = "insert into Employee (employeeName,monthlySalary,departmentId) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,"Fikret Kizilok");
        statement.setDouble(2,1450);
        statement.setInt(3,2);
        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
