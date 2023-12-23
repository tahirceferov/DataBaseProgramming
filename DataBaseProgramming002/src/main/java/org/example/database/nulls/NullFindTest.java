package org.example.database.nulls;

import java.sql.*;

public class NullFindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);
        long dataId = 2;

        String sql = "select * from Data where dataId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1,dataId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String stringType = resultSet.getString("stringType");
            System.out.println("Katar turu " + stringType);
            int integerType = resultSet.getInt("integerType");
            System.out.println("Tamsayi tutu " + integerType);
            System.out.println("NULL mu? " + resultSet.wasNull());
            float floatType = resultSet.getFloat("floatType");
            System.out.println("Kesir turu " + floatType);
            System.out.println("NULL mu? " + resultSet.wasNull());
            

        }
        else{
            System.out.println("Urun bulunamadi");
        }




        connection.close();
    }
}
