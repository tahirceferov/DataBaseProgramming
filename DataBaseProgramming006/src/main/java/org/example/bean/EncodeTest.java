package org.example.bean;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EncodeTest {


    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\project\\XML\\department.xml";
        
        Department departmentA = new Department(421,"Maliyye");
        departmentA.setEmployeeList(new ArrayList<Employee>());

        Employee employee0 = new Employee(401,"Tahir Ceferov",4500);
        employee0.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee0);

        Employee employee1 = new Employee(402,"Mahir Ceferov",4200);
                employee1.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee1);

        Employee employee2 = new Employee(402,"Mahir Ceferov",4200);
        employee2.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee2);

        FileOutputStream fos = new FileOutputStream(path);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        XMLEncoder encoder = new XMLEncoder(bos);

        encoder.writeObject(departmentA);
        encoder.close();

    }
}
