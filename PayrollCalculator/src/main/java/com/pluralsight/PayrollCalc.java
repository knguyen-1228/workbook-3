package com.pluralsight;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalc {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {

        try{
            //file name
            String employeeInfo = "employees.csv";
            String outputFile = "payroll-sept-2023.csv";
            //file reader
            FileReader employeeFile = new FileReader("src/main/resources/" + employeeInfo);
            BufferedReader employeeList = new BufferedReader(employeeFile);
            //file writer
            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFile);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write("ID:, Employee:, Gross Pay:\n");

            System.out.println("What is the file you would like to process?");
            employeeInfo = myScanner.nextLine();

            System.out.println("What is the file you would like to create?");
            outputFile = myScanner.nextLine();


            String theLine;

            while((theLine = employeeList.readLine()) != null){
                String[] employeeDetails = theLine.split("\\|");
                if (employeeDetails[0].equalsIgnoreCase("id")){
                    continue;
                }
                int id = Integer.parseInt(employeeDetails[0]);
                String names = employeeDetails[1];
                double hoursWorked = Double.parseDouble(employeeDetails[2]);
                double payRate = Double.parseDouble(employeeDetails[3]);

                Employee theEmployee = new Employee(id, names, hoursWorked, payRate);
                System.out.printf("ID: %d | Name: %s | Gross: $%.2f%n", theEmployee.getEmployeeId(), theEmployee.getEmployeeName(),theEmployee.getGrossPay());

                String outputFileLine = theEmployee.getEmployeeId() + ", " + theEmployee.getEmployeeName() + ", " + theEmployee.getGrossPay() + "\n";
                bufWriter.write(outputFileLine);

            }

            bufWriter.close();
            employeeList.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
