package org.example.calls;

import java.sql.*;

public class CallabeTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);


        int employeeId =3;
        double increasePercentage =100;
         CallableStatement statement = connection.prepareCall("{call employeeSalaryIncrease(?,?)}");
         statement.setInt(1,employeeId);
        statement.setDouble(2,increasePercentage);
           statement.execute();
        connection.close();
    }
}
