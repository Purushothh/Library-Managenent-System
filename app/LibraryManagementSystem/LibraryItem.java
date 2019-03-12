

/**
 * Creation of abstract class having all the instance variables
 */

package LibraryManagementSystem;

public abstract class LibraryItem {

    //declaring the variables
    private int isbn_num;
    private String title;
    private String sector;
    private String published_date;
    private DateTime borrowed_Info;
    private Reader reader;
    private boolean borrowed;

    public LibraryItem(int isbn_num, String title, String sector, String published_date) {
        this.isbn_num = isbn_num;
        this.title = title;
        this.sector = sector;
        this.published_date = published_date;
    }


    public int getIsbn_num() {
        return isbn_num;
    }


    public String getTitle() {
        return title;
    }


    public String getSector() {
        return sector;
    }


    public String getPublished_date() {
        return published_date;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public DateTime getBorrowed_Info() {
        return borrowed_Info;
    }


    public void setBorrowed_Info(DateTime borrowed_Info) {
        this.borrowed_Info = borrowed_Info;
    }

    //setters

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }


    @Override
    public String toString() {
        return "LibrarySystem.LibraryItem{" +
                "isbn_num=" + isbn_num +
                ", title='" + title + '\'' +
                ", sector='" + sector + '\'' +
                ", published_date =" + published_date;
    }
}

