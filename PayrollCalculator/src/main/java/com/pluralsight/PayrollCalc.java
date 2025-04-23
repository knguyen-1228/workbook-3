package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalc {
    public static void main(String[] args) {

        try{

            FileReader employeeFile = new FileReader("src/main/resources/employees.csv");

            BufferedReader employeeList = new BufferedReader(employeeFile);
            String employeeInfo;
            while((employeeInfo = employeeList.readLine()) != null){
                String[] employeeDetails = employeeInfo.split("\\|");
                if (employeeDetails[0].equalsIgnoreCase("id")){
                    continue;
                }
                int id = Integer.parseInt(employeeDetails[0]);
                String names = employeeDetails[1];
                double hoursWorked = Double.parseDouble(employeeDetails[2]);
                double payRate = Double.parseDouble(employeeDetails[3]);

                Employee theEmployee = new Employee(id, names, hoursWorked, payRate);
                System.out.printf("ID: %d | Name: %s | Gross: $%.2f%n", theEmployee.getEmployeeId(), theEmployee.getEmployeeName(),theEmployee.getGrossPay());

            }

            employeeList.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
