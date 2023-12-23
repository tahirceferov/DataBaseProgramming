package org.example.functions;

import java.sql.*;

public class FunctionsTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);


        String sql = " select *, concat('EMP-', departmentId, '-', substring(employeeName,1,3))" +
                " as employeeCode from employee ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            String employeeName = resultSet.getString("employeeName");
            String employeeCode = resultSet.getString("employeeCode");

            System.out.println("Calisan  Adi " + employeeName + " Calisan Code " + employeeCode);

        }





        connection.close();
    }
}
