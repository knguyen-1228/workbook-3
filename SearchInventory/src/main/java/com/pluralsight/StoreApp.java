package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {
        //runs scanner for user input
        Scanner scanner = new Scanner(System.in);

        //call get inventory method
        ArrayList<Product> inventory = getInventory();
        //Sorts inventory using by comparing the arrays by the id
        Collections.sort(inventory, Comparator.comparing(Product::getId));

        System.out.println("Welcome to K Hardware");
        System.out.println("\n[1] List all Products \n[2] Lookup a product by its id \n[3]Find all product within a price range\n[4] Add a new product \n[5] Quit the application");
        System.out.println("\nWhat would you like to do?");
        int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    //for loop to display products
                    for(int i = 0; i < inventory.size(); i++) {
                        Product p = inventory.get(i);
                        System.out.printf("id: %d - Product: %s - Price: $%.2f%n",
                                p.getId(), p.getName(), p.getPrice());
                    }
                    break;
                case 2:
                    System.out.println("Enter the id of the product");
                    int pId = scanner.nextInt();
                    for(int i=0; i < inventory.size(); i++){
                        Product p = inventory.get(i);
                        if(pId == p.getId()){
                            System.out.printf("id: %d - Product: %s - Price: $%.2f%n",
                                    p.getId(), p.getName(), p.getPrice());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the minimum price");
                    float minPrice = scanner.nextFloat();
                    System.out.println("Enter the maximum price");
                    float maxPrice = scanner.nextFloat();
                    for(int i=0; i < inventory.size(); i++) {
                        Product p = inventory.get(i);
                        if (minPrice >= p.getPrice() && maxPrice <= p.getPrice()) {
                            System.out.printf("id: %d - Product: %s - Price: $%.2f%n",
                                    p.getId(), p.getName(), p.getPrice());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the product id of the product:");
                    int productId = scanner.nextInt();
                    System.out.println("Enter the name of the product");
                    String pName = scanner.nextLine();
                    System.out.println("Enter the price of the product");
                    float pPrice = scanner.nextFloat();
                    inventory.add(new Product(productId,pName,pPrice));
                    break;
                case 5:
                    System.out.println("Goodbye! Thank you for visiting K hardware!");
                    break;
                default:
                    System.out.println("Invalid input, Try again!");
                    break;
            }

        //runs scanner for user input
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("We carry the following inventory: ");

        //call get inventory method
//        ArrayList<Product> inventory = getInventory();

        //Sorts inventory using by comparing the arrays by the id
//        Collections.sort(inventory, Comparator.comparing(Product::getId));

        //for loop to display products
//        for (int i = 0; i < inventory.size(); i++) {
//            Product p = inventory.get(i);
//            System.out.printf("id: %d - Product: %s - Price: $%.2f%n",
//                    p.getId(), p.getName(), p.getPrice());
//        }
    }

    //our getInventory method that creates an array list of product and returns it
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory // and its details are not shown
//        inventory.add(new Product(1,"phone case",27.99f));
//        inventory.add(new Product(2, "coke", 3.99f));
//        inventory.add(new Product(3, "chips", 5.99f));
//        inventory.add(new Product(4, "water", 3.99f));
//        inventory.add(new Product(5, "red bull", 5.99f));
        try{
            //create a file and buffered reader object
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String theLine;
            while((theLine = bufReader.readLine()) != null){

                //splitting the file by ( | ) and printing it by parts
                String[] theLineParts = theLine.split("\\|");

                //creating variables to set each part of the string to
                int id = Integer.parseInt(theLineParts[0].trim());
                String name = theLineParts[1].trim();
                float price = Float.parseFloat(theLineParts[2].trim());

                //adding the variables to the array
                Product p = new Product(id,name,price);
                inventory.add(p);

            }

        }catch (Exception e){
            e.getMessage();
        }
        return inventory;
    }

}