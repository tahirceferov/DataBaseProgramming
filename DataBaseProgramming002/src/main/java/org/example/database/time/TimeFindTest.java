package org.example.database.time;

import java.sql.*;
import java.util.Calendar;

public class TimeFindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        int eventId=10;
        String sql = "select * from event where eventId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,eventId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Date dateField = resultSet.getDate("dateField");
            Time timeField = resultSet.getTime("timeField");
            Timestamp stampField = resultSet.getTimestamp("stampField");

            System.out.println("Tarih " + dateField);
            System.out.println("Zaman" + timeField);
            System.out.println("Damga " + stampField);



            Calendar calendarDate = Calendar.getInstance();
            calendarDate.setTimeInMillis(dateField.getTime());
            Calendar calendarTime = Calendar.getInstance();
            calendarTime.setTimeInMillis(timeField.getTime());
            Calendar calendarStamp = Calendar.getInstance();
            calendarStamp.setTimeInMillis(stampField.getTime());
            System.out.println("Tarih " + calendarDate);
            System.out.println("Zaman" + calendarTime);
            System.out.println("Damga " + calendarStamp);
        }
        




        connection.close();
    }
    
}
