package com.company;

import java.text.DecimalFormat;

public class Item {
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    private final String name;
    private final double shelfPrice;
    private final double taxes;

    public Item(double shelfPrice, ItemType type, boolean isImport, String name) {
        this.name = name;
        taxes = processTaxes(type, isImport, shelfPrice);
        //Shelf price has to include taxes for the receipt
        this.shelfPrice = shelfPrice + taxes;
    }

    private double processTaxes(ItemType type, boolean isImport, double shelfPrice) {
        double tax = 0;
        if(type == ItemType.OTHER) {
            //Apply sales tax
             tax += roundUp(shelfPrice * TaxTypes.SALESTAX);
        }
        if(isImport) {
            //Apply import tax
            tax += roundUp(shelfPrice * TaxTypes.IMPORTTAX);
        }
        return tax;
    }

    public String getName() {
        return name;
    }

    public double getShelfPrice() {
        return shelfPrice;
    }

    public double getTaxes() {
        return taxes;
    }

    @Override
    public String toString() {
        return name + ": " + decimalFormat.format(shelfPrice);
    }

    //If quantity is more than one, we need to apply it here to print receipt
    public String toString(int quantity) {
        if(quantity > 1) {
            return name + ": " + (decimalFormat.format(shelfPrice * quantity)) + " (" + quantity + " @ "
                    + decimalFormat.format(shelfPrice) + ")";
        }
        return this.toString();
    }

    private double roundUp(double amount) {
        //Convert to pennies (% only works with ints)
        int pennies = (int)Math.ceil(amount * 100);
        if((pennies % 5) != 0) {
            return ((double)pennies + (5 - (pennies % 5))) / 100;
        }
        return (double)pennies / 100;
    }

    public boolean equals(Item item) {
       return (this.getName().equals(item.getName()) && (this.getShelfPrice() == item.getShelfPrice()));
    }
}
