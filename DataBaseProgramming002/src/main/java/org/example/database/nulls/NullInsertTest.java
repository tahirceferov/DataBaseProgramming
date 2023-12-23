package org.example.database.nulls;

import java.sql.*;

public class NullInsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql = "insert into Data(stringType,integerType,floatType) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,null);
        statement.setNull(2, Types.INTEGER);
        statement.setNull(3,Types.FLOAT);

        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
