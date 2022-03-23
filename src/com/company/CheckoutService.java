package com.company;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

//Author: Ryan Tonthat

public class CheckoutService {

    //Checkout (LinkedHashMap for insertion order)
    public void checkOut(LinkedHashMap<Item, Integer> shoppingCart) {
        //(Future improvements) Process coupons or take value num or go to payment
        //Print receipt
        printReceipt(shoppingCart);
    }

    private void printReceipt(HashMap<Item, Integer> shoppingCart) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        //Iterate through hashmap
        double totalTax = 0;
        String receipt = "";
        double total = 0;
        //Shopping cart is <item, quantity>
        for(Item item : shoppingCart.keySet()) {
            totalTax += item.getTaxes() * shoppingCart.get(item);
            receipt = receipt + item.toString(shoppingCart.get(item)) + "\n";
            total += (item.getShelfPrice()) * shoppingCart.get(item);
        }

        //Bottom of receipt
        receipt += "Sales Taxes: " + decimalFormat.format(totalTax) + "\n" +
                "Total: " + decimalFormat.format(total);
        System.out.println(receipt);
    }
}
