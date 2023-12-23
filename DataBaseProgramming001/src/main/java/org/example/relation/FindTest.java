package org.example.relation;

import java.sql.*;

public class FindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        int employeeId=5;
        String sql = " select * from employee_view where employeeId =? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,employeeId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

            String employeeName = resultSet.getString("employeeName");
            double monthlySalary = resultSet.getDouble("monthlySalary");
            String departmentName = resultSet.getString("departmentName");
            System.out.println("Calisan Adi " + employeeName);
            System.out.println("Ayliq maas " + monthlySalary);
            System.out.println("Departman adi " + departmentName);

        }
        else{
            System.out.println("Calisan bulunamadi");
        }




        connection.close();
    }
}
