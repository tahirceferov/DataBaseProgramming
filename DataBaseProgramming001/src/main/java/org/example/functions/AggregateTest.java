package org.example.functions;

import java.sql.*;

public class AggregateTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        //String sql = " select count(*) as countOfEmployee from employee";
        //String sql = " select sum(monthlySalary) as sumOfMonthlySalary from employee";
        String sql = " select count(*), departmentId from employee group by departmentId";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            int departmentId = resultSet.getInt(1);
            int count = resultSet.getInt(2);
             
            System.out.println("Bolum no " + departmentId + "sayi " + count);

        }
        




        connection.close();
    }
}
