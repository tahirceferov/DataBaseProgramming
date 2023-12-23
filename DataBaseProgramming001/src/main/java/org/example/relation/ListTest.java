package org.example.relation;

import java.sql.*;

public class ListTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = " select * from employee_view";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int employeeId = resultSet.getInt("employeeId");
            String employeeName = resultSet.getString("employeeName");
            double monthlySalary = resultSet.getDouble("monthlySalary");
            int departmentId = resultSet.getInt("departmentId");
            String departmentName = resultSet.getString("departmentName");
            System.out.printf("%10d %-20s %10.2f %10d %s \r\n",employeeId,employeeName,monthlySalary,departmentId,departmentName);
        }




        connection.close();
    }
}
