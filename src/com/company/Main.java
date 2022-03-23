package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

//Author: Ryan Tonthat

public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<Item, Integer> shoppingCart;
        CheckoutService checkoutService = new CheckoutService();
        String input;
        StringBuilder tokens = new StringBuilder();
        System.out.println("Provide list of items in cart to check out");

        try {
            input = br.readLine();
            //Assumption is made that inputs are formatted exactly like the sample inputs
            //(e.g. Quantity Import Name at Price)

            //Additional assumptions:
            //All foods contain either chocolates or chocolate
            //All medical contains pills
            //All books contain book
            //All imports contain imported
            //Anything that was not mentioned above is considered other

            //Will stop input when next line is blank (enter is hit again)
            while(input.length() > 0) {
                tokens.append(input).append("\n");
                input = br.readLine();
            }
            shoppingCart = ShoppingCartParser.parse(tokens.toString());
            checkoutService.checkOut(shoppingCart);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        //Manual Testing
//        //CTRL + / to uncomment everything
//        //Making items for test
//        //Building shopping cart 1
//        Item book = new Item(12.49, ItemType.BOOK, false, "Book");
//        Item musicCD = new Item(14.99, ItemType.OTHER, false, "Music CD");
//        Item chocolateBar = new Item(0.85, ItemType.FOOD, false, "Chocolate Bar");
//        LinkedHashMap<Item, Integer> shoppingCart = new LinkedHashMap<>();
//        shoppingCart.put(book, 2);
//        shoppingCart.put(musicCD, 1);
//        shoppingCart.put(chocolateBar, 1);
//
//        //Building shopping cart 2
//        LinkedHashMap<Item, Integer> shoppingCart2 = new LinkedHashMap<>();
//        Item importedChocolate = new Item(10.00, ItemType.FOOD, true, "Imported box of chocolates");
//        Item importedPerfume = new Item(47.50, ItemType.OTHER, true, "Imported bottle of perfume");
//        shoppingCart2.put(importedChocolate, 1);
//        shoppingCart2.put(importedPerfume, 1);
//
//        //Building shopping cart 3
//        LinkedHashMap<Item, Integer> shoppingCart3 = new LinkedHashMap<>();
//        Item importedChocolate2 = new Item(11.25, ItemType.FOOD, true, "Imported box of chocolates");
//        Item importedPerfume2 = new Item(27.99, ItemType.OTHER, true, "Imported bottle of perfume");
//        Item perfume = new Item(18.99, ItemType.OTHER, false, "Bottle of perfume");
//        Item pills = new Item(9.75, ItemType.MEDICAL, false, "Packet of Headache Pills");
//        shoppingCart3.put(importedPerfume2, 1);
//        shoppingCart3.put(perfume, 1);
//        shoppingCart3.put(pills, 1);
//        shoppingCart3.put(importedChocolate2, 2);
//
//        //Checkout service
//
//        //Process shopping cart 1
//
//        System.out.println();
//        //Process shopping cart 2
//        checkoutService.checkOut(shoppingCart2);
//        System.out.println();
//        //Process shopping cart 3
//        checkoutService.checkOut(shoppingCart3);
//        System.out.println();
    }
}
