package LibraryManagementSystem;

/**
 * Creation of Book class which contains details of books in library.
 */


import java.util.Date;
import java.util.List;

public class Book extends LibraryItem {

    //declaring the variables and array lists.
    private String author;
    private String publisher;
    private int noOfPages;


    //String[] booksAvailable = new String[100];//creation of books array to store the books as stated number of elements

    public Book(int isbn_num, String title, String sector, String published_date,
                String author, String publisher, int noOfPages) {
        super(isbn_num, title, sector, published_date);
        this.author = author;
        this.publisher = publisher;
        this.noOfPages = noOfPages;
    }

    //getters
    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNoOfPages() {
        return noOfPages;
    }


}

