package databaseCart;

import java.io.File;
import java.util.List;
import java.util.Map;

// to add functionalities like handling user login, saving/loading carts & managing a user database

public class shoppingCartDB {

    String username;

    public shoppingCartDB (String username) {
        this.username = username;
    }

    public Map<String, List<String>> loadCart() {
        // to load the user's cart
        

        FileReader readCart = new FileReader();
    }

    if (!cartdb.exists()) {
        cartdb.mkdirs();
    }
    File cartdb = new File(username + ".db");

    // if user exists 
    public void userDir (String dirName) {
        File userFile = new File()
    }

}
