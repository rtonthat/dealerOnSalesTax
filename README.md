**DealerOn Coding Test**

Application will take a String input of "Quantitiy" "Import" "Name" at "Price" 

e.g.:

1 Book at 12.49

1 Imported Bottle of perfume at 47.50

Input will continue until a blank line is entered (enter button is hit twice on input)
Taxes will be calculated for each item and added into the output receipt (Note that the receipt will include the taxes in the item)

**Architecture Notes**

Application is split into 6 java classes
ShoppingCartParser.java is used to take the items given in the input and parse into seperate Item.java objects which are added to a hashmap which emulates a shopping cart
CheckoutService.java takes a shopping cart and prints the receipt. This is where future improvements can be easily implemented such as processing coupouns
TaxTypes.java contains 2 finals representing Tax rates that can be changed for future updates
ItemType.java contains 4 enumerations which can be changed in the future. Application will not work if different types are used that are not in this class
