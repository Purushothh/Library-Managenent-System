package LibraryManagementSystem;

/**
 * Creation of DVD class which holds the details of dvds.
 */


import java.util.Date;
import java.util.List;

public class  DVD extends LibraryItem {

    //declaring the variables and array lists.
    private String available_languages;
    private String available_subtitles;
    private String producer;
    private String actors;




    // String[] dvd = new String[50];//creation of dvd array to store the stated number of elements.

    public DVD(int isbn_num, String title, String sector, String published_date, String available_languages,
               String available_subtitles, String producer, String actors) {
        super(isbn_num, title, sector, published_date);
        this.available_languages = available_languages;
        this.available_subtitles = available_subtitles;
        this.producer = producer;
        this.actors = actors;
    }

    //getters

    public String getAvailable_languages() {
        return available_languages;
    }

    public String getAvailable_subtitles() {
        return available_subtitles;
    }

    public String getProducer() {
        return producer;
    }

    public String getActors() {
        return actors;
    }
}
