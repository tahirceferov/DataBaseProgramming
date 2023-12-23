package org.example.database.nulls;

import java.sql.*;

public class NullListTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from Data where integerType is NULL";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long dataId = resultSet.getLong("dataId");
            String stringType = resultSet.getString("stringType");
            int integerType = resultSet.getInt("integerType");
            float floatType = resultSet.getFloat("floatType");

            System.out.printf("%10d %-20s %10d  %10.2f \r\n",dataId,stringType,integerType,floatType);
        }




        connection.close();
    }
}
