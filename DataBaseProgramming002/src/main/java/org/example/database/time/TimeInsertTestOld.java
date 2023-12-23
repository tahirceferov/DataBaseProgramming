package org.example.database.time;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;


public class TimeInsertTestOld {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/godorodb";
        String user = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, user, password);

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(1923, 9, 29);
//        java.util.Date date = new java.util.Date(112, 11, 10);
//        java.sql.Date sqlDate0 = new java.sql.Date(System.currentTimeMillis());
//        java.sql.Date sqlDate1 = new java.sql.Date(80, 9, 12);
//        java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());
          java.sql.Date sqlDate3 = new java.sql.Date(calendarDate.getTimeInMillis());


        Calendar calendarTime = Calendar.getInstance();
        calendarTime.set(Calendar.HOUR_OF_DAY, 12);
        calendarTime.set(Calendar.MINUTE, 30);
        calendarTime.set(Calendar.SECOND, 15);
//      java.sql.Time time1 = new java.sql.Time(12,30,15);
        java.sql.Time time2 = new java.sql.Time(calendarTime.getTimeInMillis());


        Calendar calendarStamp = Calendar.getInstance();
        calendarStamp.set(1980,8,12,12,30,15);
//        java.sql.Timestamp stamp1 = new java.sql.Timestamp(80,8,12,12,30,15,00);
        java.sql.Timestamp stamp2 = new java.sql.Timestamp(calendarStamp.getTimeInMillis());


        String sql = "insert into event(dateField,timeField,stampField) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, sqlDate3);
        statement.setTime(2, time2);
        statement.setTimestamp(3, stamp2);


        int affected = statement.executeUpdate();
        System.out.println("Etkilenen satir sayisi : " + affected);


        connection.close();
    }

}
