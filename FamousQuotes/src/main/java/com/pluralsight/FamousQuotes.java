package com.pluralsight;

import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        String[] quotes = {"less is more","stay hungry, stay foolish","dream big. start small","what you seek is seeking you", "be here now", "create your own sunshine", "do it with passion or not at all", "silence is an answer too", "you are enough", "no rain, no flower"};
        Scanner myScanner = new Scanner(System.in);
        boolean appRunning = true;
        while(appRunning) {
            try {
                System.out.print("Please enter a number 1 through 10: \t");
                int num = myScanner.nextInt();
                System.out.println(quotes[num - 1]);
            } catch (Exception e) {
                System.out.println("Number is invalid try again");
            }

            myScanner.nextLine();

            System.out.println("Do you want another quote?");
            String input = myScanner.nextLine();

            if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
                continue;
            }else{
                appRunning = false;
            }
        }
    }
}
