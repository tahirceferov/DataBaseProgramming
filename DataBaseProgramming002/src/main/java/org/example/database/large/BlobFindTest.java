package org.example.database.large;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class BlobFindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        String path ="C:\\Users\\tahir\\OneDrive\\Masaüstü\\projeler\\base\\blob.jpg";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);


        long largeId=1;
        String sql = "select * from Large where largeId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1,largeId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
         InputStream is = resultSet.getBinaryStream("blobField");
            FileOutputStream fos = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int actual;
            while((actual=is.read(buffer))>0){
                fos.write(buffer,0,actual);
            }
            fos.close();
            is.close();
        }





        connection.close();
    }
}
