package org.example.database.large;

import java.io.*;
import java.sql.*;

public class ClobFindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        String path ="C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\base\\Clob.txt";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);


        long largeId=3;
        String sql = "select * from Large where largeId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1,largeId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Reader reader  = resultSet.getCharacterStream("clobField");
            FileWriter fr = new FileWriter(path);
            char[] buffer = new char[1024];
            int actual;
            while((actual=reader.read(buffer))>0){
                fr.write(buffer,0,actual);
            }
            fr.close();
            reader.close();
        }





        connection.close();
    }
}
