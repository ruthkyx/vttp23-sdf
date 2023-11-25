package databaseCart;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

// to add functionalities like handling user login, saving/loading carts & managing a user database

public class shoppingCartDB {

    String username;
    String baseDir = "/Users/ruthie/Desktop/java/vttp23/SDF/day3/cartdb";

    // constructor
    protected shoppingCartDB (String username) {
        this.username = username;
    }

    protected void userExists (String directoryPath) {
        Path dirPath = dirPath.getFileName();
        // cartdb/fred.db
        if (!dirPath.exists()){
            // .mkdirs();
        } else {
            // load the user's cart
            loadCart(username);
        }
        
    }

    protected void saveCart() {
        FileWriter = new FileWriter();
    }    

    protected Map<String, List<String>> loadCart(String username) {
        // to load the user's cart
        
        File userFile = new File(username);
        boolean userExists = userFile.exists();
        if (userExists) {  
            FileReader readCart = new FileReader(userFile); 
            for (String items : readCart) {
                System.out.println(items);
            }
        }

        
    }

    File cartdb = new File(username + ".db");

    // if user exists 
    public void userDir (String dirName) {
        File userFile = new File();
    }

}
