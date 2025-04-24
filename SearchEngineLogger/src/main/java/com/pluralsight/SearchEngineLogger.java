package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    static Scanner myScanner = new Scanner(System.in);
    static DateTimeFormatter timeStamp= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //calls method to run
        logActions();

    }
    public static void logActions(){

        try{
            //create a file writer and today's date
            FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt",true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            LocalDateTime today = LocalDateTime.now();

            //prompts the user if they want to open the search engine
            System.out.println("Would you like to launch the search engine?");
            String launchInput = myScanner.nextLine();

            //if else statement to start the engine
            if(launchInput.equalsIgnoreCase("y") || launchInput.equalsIgnoreCase("yes")) {
                bufWriter.write(timeStamp.format(today) + " launch\n");
                //while loop to let user continue to search
                boolean appRunning = true;
                while (appRunning) {
                    System.out.println("What would you like to search? [x] To exit");
                    String searchInput = myScanner.nextLine();
                    bufWriter.write(timeStamp.format(today) + " Searched for: " + searchInput +"\n");
                    //if statement to stop the loop if user wants to exit
                    if(searchInput.equalsIgnoreCase("x")){
                        appRunning = false;
                        System.out.print("Exiting the search engine");
                        bufWriter.write(timeStamp.format(today) + " Exit\n");
                    }
                }
            //else statement to exit search engine if user does not want to open it
            }else{
                System.out.println("Exiting the search engine");
                bufWriter.write(timeStamp.format(today) + " Exit\n");
            }
            bufWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing to the file " + e.getMessage());
        }
    }
}
