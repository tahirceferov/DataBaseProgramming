package org.example.relation;

import java.sql.*;

public class FilterTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);
        int departmentId =2;

        String sql = " select * from employee_view where departmentId =? "        ;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,departmentId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int employeeId = resultSet.getInt("employeeId");
            String employeeName = resultSet.getString("employeeName");
            double monthlySalary = resultSet.getDouble("monthlySalary");
            String departmentName = resultSet.getString("departmentName");
            System.out.printf("%10d %-20s %10.2f  %s \r\n",employeeId,employeeName,monthlySalary,departmentName);
        }




        connection.close();
    }
}
