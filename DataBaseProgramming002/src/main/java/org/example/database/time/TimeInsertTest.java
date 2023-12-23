package org.example.database.time;

import java.sql.*;
import java.util.Calendar;

public class TimeInsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

//        Calendar calendarDate = Calendar.getInstance();
//        calendarDate.set(1923, 9, 29);
//        Date date = new Date(calendarDate.getTimeInMillis());
//
//
//        Calendar calendarTime = Calendar.getInstance();
//        calendarTime.set(Calendar.HOUR_OF_DAY, 12);
//        calendarTime.set(Calendar.MINUTE, 30);
//        calendarTime.set(Calendar.SECOND, 15);
//        Time time = new Time(calendarTime.getTimeInMillis());
//
//
//        Calendar calendarStamp = Calendar.getInstance();
//        calendarStamp.set(1980,8,12,12,30,15);
//        Timestamp stamp = new Timestamp(calendarStamp.getTimeInMillis());

        Date date = SqlTimeUtils.getDate(1923,10,29);
        Time time = SqlTimeUtils.getTime(12,30,15);
        Timestamp stamp = SqlTimeUtils.getTimeStamp(1997,2,23,12,30,15);


        String sql = "insert into event(dateField,timeField,stampField) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, date);
        statement.setTime(2, time);
        statement.setTimestamp(3, stamp);


        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }
}
