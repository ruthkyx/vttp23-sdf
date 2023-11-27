package bookSorter.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    // use the csv file to count the no of book published by the diff publishers (books.csv)
    // use streams and the function groupingBy

    // title in in col 1 (array start from 0) & publisher in col 11. 
    // capitalising is a common naming convention for variables that are constants that should not change
    final int COL_TITLE = 1;
    final int COL_PUBLISHER = 11;

    public static void main (String[] args) throws Exception {
        String path = "/Users/ruthie/Desktop/java/vttp23/SDF/day5/bookSorter/books.csv";
        int count = 0; 

        BufferedReader br = new BufferedReader(new FileReader(path));

        // map String publisher to list of books published by them
        Map <String, List<Book>> sorter = br.lines()
            // skip first row to filter out column with titles
            .skip(1)
            // map each row to an array of strings
            .map(row -> row.split(",").trim())
            // map string array to 'Book' object. 'Book' constructor takes title & publisher as parameters
            .map(fields -> new Book(fields[COL_TITLE], fields[COL_PUBLISHER]))
            // groupingBy is a class from collectors class. mapping the books(value) to each publisher(key)
            // works the same as: .collect(Collectors.groupingBy(Book::getPublisher));
            .collect(Collectors.groupingBy(book -> book.getPublisher()));
            for(String publisher : sorter.keySet()) {
                List<Book> books = sorter.get(publisher);
                System.out.printf("%s (%d)\n", publisher, books.size());
                for(Book book: books) {
                    System.out.printf("\t%s\n", book.getTitle());
                }
            }

    }

}
