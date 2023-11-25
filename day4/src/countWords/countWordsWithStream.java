package countWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;


public class countWordsWithStream {
    public static void main(String[] args) throws Exception {
        String path = "/Users/ruthie/Desktop/java/vttp23/SDF/day4/road_not_taken.txt/";
        long count = 0;

            BufferedReader br = new BufferedReader(new FileReader(path));
            count = br.lines()
                // clean the liune, replace all punctuations & trailing whitespaces
                .map (line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", ""))
                // further clean up by removing empty lines. filtering out what we want: lines that are not empty
                .filter(line -> line.length() > 0)
                // transforming the lines into individual words; split the word by spaces; each line is split into an array of words
                .map (line -> line.split(" "))
                .flatMap (words -> Stream.of(words))
                .count();
                // words -> count
                //.map (words -> words.length);

            
            System.out.println("Number of words: " + count);
            br.close();   

    }
}