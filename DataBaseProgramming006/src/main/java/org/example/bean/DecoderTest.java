package org.example.bean;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DecoderTest {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\project\\XML\\department.xml";
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder decoder = new XMLDecoder(bis);

        Department department = (Department) decoder.readObject();
        System.out.println("Bolum No: " + department.getDepartmentId() +"\n"+
                "Bolum adi: " + department.getDepartmentName());

        for (Employee employee : department.getEmployeeList()){
            System.out.println("Calisan No: " + employee.getEmployeeId() + "\n"+
                    "Calisan Adi: " +employee.getEmployeeName() +"\n"+
                    "Calisan Maasi: " +employee.getMonthlySalary());
        }
        decoder.close();
    }
}
