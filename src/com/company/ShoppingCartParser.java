package com.company;

import java.util.LinkedHashMap;

public class ShoppingCartParser {

    public static LinkedHashMap<Item, Integer> parse(String input) {
        //Breaks up line (item)
        String[] items = input.split("\n");
        LinkedHashMap<Item, Integer> shoppingCart = new LinkedHashMap<>();
        LinkedHashMap<String, Item> itemNames = new LinkedHashMap<>();
        for (String s : items) {
            String[] itemParts;
            itemParts = s.split(" ");
            Integer quantity = Integer.parseInt(itemParts[0]);
            Item item = getItem(itemParts);
            if (itemNames.containsKey(item.getName())) {
                //Check to see if items are the same
                Item inCart = itemNames.get(item.getName());
                if (inCart.equals(item)) {
                    //If the same then increase quantity
                    shoppingCart.put(inCart, shoppingCart.get(inCart) + 1);
                } else {
                    //If not the same add new item to shopping cart
                    shoppingCart.put(item, quantity);
                }
            } else {
                itemNames.put(item.getName(), item);
                shoppingCart.put(item, quantity);
            }
        }

        return shoppingCart;
    }

    private static Item getItem(String[] itemParts) {
        double shelfPrice = Double.parseDouble((itemParts[itemParts.length -1]));
        boolean isImported = false;
        StringBuilder name = new StringBuilder();
        ItemType type = ItemType.OTHER;
        //Checks for words after quantity and before "at"
        for(int i = 1; i < itemParts.length - 2; i++) {
            //Checks if imported
            if(itemParts[i].equalsIgnoreCase("Imported")) {
                isImported = true;
            }

            //Checks the item type
            if(itemParts[i].equalsIgnoreCase("Book")) {
                type = ItemType.BOOK;
            } else if(itemParts[i].equalsIgnoreCase("Chocolate") ||
                    itemParts[i].equalsIgnoreCase("Chocolates")) {
                type = ItemType.FOOD;
            } else if(itemParts[i].equalsIgnoreCase("Pills")) {
                type = ItemType.MEDICAL;
            }

            //Makes the name of the item
            if(i == itemParts.length - 3) {
                name.append(itemParts[i]);
            } else {
                name.append(itemParts[i]).append(" ");
            }
        }

        return new Item(shelfPrice, type, isImported, name.toString());
    }
}
