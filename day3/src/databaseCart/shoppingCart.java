package databaseCart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class shoppingCart {

    public boolean loggedIn = false; 
    private static String cartDatabaseDir = "db";

    public static void main(String[] args) throws Exception {

        System.out.println("HELLO!! Welcome to your shopping cart!!");

        // check if a directory is specified as a command-line argument
        if(args.length > 0) {
            cartDatabaseDir = args[0];
        }

        LinkedList<String> cartList = new LinkedList<> ();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("> ");
            String input = sc.nextLine().toLowerCase().trim();

            if (input.startsWith("login")) {
                // read user input & scan if user exist
                System.out.print("Please input your username: ");
                userLogin(input.substring(6).trim());

            } else if (input.startsWith("save")) {
                saveCart();

            } else if (input.startsWith("users")) {
                userList();

            } else if (input.startsWith("list")) {
                listItems(cartList);

            } else if (input.startsWith("add")) {
                String addedItem = input.trim().substring(4);
                addItems(cartList, addedItem);

            } else if (input.startsWith("delete")) {
                try {
                    int itemIndex = Integer.parseInt(input.trim().substring(7).replaceAll("[^0-9]", ""));
                    deleteItems(cartList, itemIndex);
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid input! please input item index instead!");
                }

            } else if (input.startsWith("help")) {
                System.out.println("To view your cart, type: list");
                System.out.println("To save your current cart list, type: save");
                System.out.println("To view the list of users, type: users");
                System.out.println("To view your cart, type: list");
                System.out.println("To add something to your cart, type: add");
                System.out.println("To remove something from your cart, type: delete");
                System.out.println("To end your session, type: exit");

            } else if (input.startsWith("exit")) {
                System.out.println("Thank you for shopping with us!");
                sc.close();

            } else {
                System.out.println("Invalid input! Enter \"help\" for a list of commands.");
            }
        }

    }

    public static void listItems(LinkedList<String> cartList) {
        if(cartList.isEmpty()) {
            System.out.println("Your cart is empty! Add something?");
        } else {
            System.out.println("Items in cart: ");
            for (int i = 0; i < cartList.size(); i++) {
                System.out.println((i+1) + ". " + cartList.get(i));
            }
        }
    }

    public static void addItems(LinkedList<String> cartList, String addedItem) {
        String[] items = addedItem.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (cartList.contains(trimmedItem)) {
                System.out.println(trimmedItem + " already in cart! Add something else?");
            } else {
                cartList.add(trimmedItem);
                System.out.println(trimmedItem + " added to your cart!");
            }
        }
    }

    public static void deleteItems(LinkedList<String> cartList, int itemIndex) {

        if (itemIndex >= 1 && itemIndex <= cartList.size()) {
            String deletedItem = cartList.remove(itemIndex - 1);
            System.out.println(deletedItem + " removed from your cart!");
        } else {
            System.out.println("Invalid input!");
        }

    }

    private static void userLogin (String username) {
        // if the user has no acc, print smth to prompt creation && create new dir in the db?
        // create an instance of the database 
        shoppingCartDB database = new shoppingCartDB(username);
        
    }

    private static void saveCart () {
        // buffered writer?

    }

    private static void userList() {
        List<String> allUsers = new ArrayList<>();
        System.out.println(allUsers);

    }
}
