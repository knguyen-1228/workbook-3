package com.pluralsight;

import java.io.FileInputStream;
import java.util.Scanner;

public class BedTimeStories {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("List of available story:\n Goldilocks\n Hansel and Gretel \n Mary had a little lamb");
            System.out.println("What story would you like to read?");
            String input = myScanner.nextLine().toLowerCase();
            switch(input){
                case "goldilocks":
                    try {
                        String fileName = "goldilocks.txt";
                        Scanner fileScanner = new Scanner(new FileInputStream("src/main/resources/" + fileName));
                        int lineNum = 1;
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    } catch (Exception e) {
                            System.out.println("That file does not exist");
                    }
                    break;
                case "hansel and gretel":
                    try {
                        String fileName = "hansel_and_gretel.txt";
                        Scanner fileScanner = new Scanner(new FileInputStream("src/main/resources/" + fileName));
                        int lineNum = 1;
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    } catch (Exception e) {
                        System.out.println("That file does not exist");
                    }
                    break;
                case "mary had a little lamb":
                    try {
                        String fileName = "mary_had_a_little_lamb.txt";
                        Scanner fileScanner = new Scanner(new FileInputStream("src/main/resources/" + fileName));
                        int lineNum = 1;
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    } catch (Exception e) {
                        System.out.println("That file does not exist");
                    }
                    break;
                default:
                    System.out.println("That file does not exist");
                    break;
            }
            System.out.println("Do you want to listen to another story?");
            String anotherStory = myScanner.nextLine();
            if(anotherStory.equalsIgnoreCase("y") || anotherStory.equalsIgnoreCase("yes")){
                continue;
            }else {
                appRunning = false;
            }

            /*
            tried using if statements but realized switch statements would output a cleaner look
            if (input.equalsIgnoreCase("goldilocks")) {
                try {
                    String fileName = "goldilocks.txt";
                    Scanner fileScanner = new Scanner(new FileInputStream("src/main/resources/" + fileName));
                    int lineNum = 1;
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                        appRunning = false;
                    }
                } catch (Exception e) {
                    System.out.println("That file does not exist");
                }
            }
            if (input.equalsIgnoreCase("hansel and gretel")) {
                try {
                    String fileName = "hansel_and_gretel.txt";
                    Scanner fileScanner = new Scanner(new FileInputStream("src/main/resources/" + fileName));
                    int lineNum = 1;
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                        appRunning = false;
                    }
                } catch (Exception e) {
                    System.out.println("That file does not exist");

                }
            }
            if (input.equalsIgnoreCase("mary had a little lamb")) {
                try {
                    String fileName = "mary_had_a_little_lamb.txt";
                    Scanner fileScanner = new Scanner(new FileInputStream("src/main/resources/" + fileName));
                    int lineNum = 1;
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                        appRunning = false;
                    }
                } catch (Exception e) {
                    System.out.println("That file does not exist");
                }
            }
            System.out.println("Do you want to read another story?");
            String anotherStory = myScanner.nextLine();
            if(anotherStory.equalsIgnoreCase("y") || anotherStory.equalsIgnoreCase("yes")){
                continue;
            }else {
                appRunning = false;
            }
            }
            */
        }
    }
}
