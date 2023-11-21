package countWords;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class countWordsFromFile {
    public static void main(String[] args) throws Exception {

        String path = "/Users/ruthie/Desktop/java/vttp23/SDF/day4/road_not_taken.txt/";
        String line; 
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null ) {
                line = line.trim().replaceAll("[^\\sa-zA-Z0-9]", "");
                if (line.length() <= 0) {
                    continue;
                }
                String[] words = line.split(" ");
                count += words.length;
            }
            br.close();
            System.out.println("Total number of words is: " + count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        


    }
}
