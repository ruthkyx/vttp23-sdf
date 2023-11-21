package src;

import java.util.ArrayList;
import java.util.Scanner;

public class shoppingCart {

    public static void main(String[] args) {

        ArrayList<String> myCart = new ArrayList<>();
        System.out.println("Welcome to your shopping cart!");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(">");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("list")){ 
                listCart(myCart);

            } else if(input.startsWith("add")) {
                // need to read user input and trim out the item to be added. substring is to read the 4th char after "add"
                String item = input.trim().substring(4);
                addItems(item, myCart);

            } else if (input.startsWith("delete")) {
                // extracts the substring starting from the 8th character of the user input. if "delete 1" is input, "1." is extracted
                String itemIndex = input.trim().substring(7);
                deleteItems(itemIndex, myCart);
                
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for shopping with us!");
                sc.close();
                
            } else {
                System.out.println("Invalid input!");
            }
        }

    }
    private static void listCart(ArrayList<String> myCart) {
        if (myCart.isEmpty()) {
            System.out.println("Your cart is empty!");
        } else {
            System.out.println("Items in your cart:");
            // to add index+1 to the item in the list; eg: 1. apple
            for (int i = 0; i < myCart.size(); i ++) {
                System.out.println((i + 1) + ". " + myCart.get(i)); 
            }
        }
    }

    private static void addItems (String itemToAdd, ArrayList<String> myCart) {
        /* if (myCart.contains(itemToAdd)) {
            System.out.println(itemToAdd + " is already in your cart!");
        } else {
            myCart.add(itemToAdd);
            System.out.println(itemToAdd + " added to cart");
        } */ 
        // previous code before edit^


        // split the items by comma, trim each item and add to the cart
        String[] itemsarray = itemToAdd.split(",");
        // for each item in the itemsarray (the individual items obtained after split), do the trimming 
        for (String item : itemsarray) {
            // trim away spaces from the item & store as trimmed item 
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty()) {
                // cfm that user input is not empty (so that there's meaningful content added & not add some random spaces)
                if (myCart.contains(trimmedItem)) {
                    System.out.println(trimmedItem + " is already in your cart!");
                } else {
                    myCart.add(trimmedItem);
                    System.out.println(trimmedItem + " added to cart");

                }
            }
        }

    }
    private static void deleteItems (String itemIndex, ArrayList<String> myCart) {
        // try catch exception handling is used to catch if user inputs things that will make the program crash (eg input word instead of number)
        // error -> catch block executed instead
        try { 
            // user input will be read as a string. convert to int to and -1 to get item's index in arraylist 
            // the (.replaceAll("[^0-9]", "") will remove any non-digit characters 
            int index = Integer.parseInt(itemIndex.replaceAll("[^0-9]", "")) - 1;
            // checks if the index is in valid range of the arraylist for shoppingCart
            if (index >= 0 && index < myCart.size()) {
                // if index is valid then can delete the item 
                String deletedItem = myCart.remove(index);
                System.out.println(deletedItem + " deleted from cart");
            } else {
                System.out.println("Invalid item index");
            }
    
        //if conversion to int fails
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please input index of item to be removed from cart.");
        }




        /* DO NOT DO THIS: 
        when an item is deleted, the list is supposed to shift up (index shift up) so if this methods is used then 1 item is missed
        YOU SHOULD NOT MODIFY THE LOOP

         * if(items.get(i).equals(Item)) {
         * items.remove(i); }
         
         it this is used, make sure to update the list:
        updated list after deletion of item from cart 
        myCart = updatedCart;
        */
    }

}

/* additional notes:
 * item.replaceAll("[^0-9]", ""): This line removes any non-digit characters (like the dot) from the extracted item. 
 * The regular expression [^0-9] matches any character that is not a digit.
 * ^ adding this will make sure that the item will be parsed as an Integer without the dot, which couldve caused exceptions
 */

