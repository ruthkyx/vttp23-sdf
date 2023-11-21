package countWords;

import java.io.BufferedReader;
import java.io.FileReader;

public class countWords {
    
    public static void main(String[] args) throws Exception {
        /* exception is thrown bcos we may expect FileNotFoundException when creating FileReader. issa checked exception as it extends IOException; 
         * it must be declared/caught to prevent compilation errors. 
         * working with IO operations can cause IOExceptions like reading from other closed files. 
        */

        // first need to open the file using file reader
        // (args[0] is a command line argument that takes input from terminal(command-line). so you pass txt file through terminal to run the program
        // type <java countWords road_not_taken.txt> in the terminal to count words from that file

        FileReader fr = new FileReader(args[0]);

        // read the text in the file using buffered reader 
        BufferedReader br = new BufferedReader(fr);

        // string to hold each line of text while reading; count to count the no of words 
        String line;
        int count = 0;
        // (line =br.readLine()) is not a boolean so can't put in the while loop. != null is to read till no lines to read & return null
        while ((line = br.readLine()) != null) {
            // [^\\sa-zA-Z0-9] matches any charactoer that is not a whitespace, letter a-zA-Z, or digit 0-9
            // the replaceAll function below will replace ^characters with an empty string effectively removing them
            // trim is to clean the line & ensure there's no unecessary space
            line = line.trim().replaceAll("[^\\sa-zA-Z0-9]", "");

            // check if line is empty. necessary bcos the above may not have handled leading and trailing whitespaces
            // the step below will ensure that lines with only whitespaces will be skipped
            if (line.length() <= 0)
                continue; 

            // splitting the words by space
            String [] words = line.split(" ");

            count += words.length;
        }

        br.close();

        System.out.println("Total number of words is: " + count);
    }
}
