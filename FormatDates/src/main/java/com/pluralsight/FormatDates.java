package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {

        LocalDateTime today = LocalDateTime.now();

        System.out.println("Today is: " + today);

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(format1));

        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(today.format(format4));

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(today.format(format2));

        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEEE, MMM d,yyyy HH:mm");
        System.out.println(today.format(format3));

        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("HH:mm 'on' dd-MMM-yyyy");
        System.out.println(today.format(format5));

    }
}
