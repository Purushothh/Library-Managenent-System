/**
 * This class has the Constructor and methods to the calculation of date validation in
 *the library management system.
 *
 */
package LibraryManagementSystem;

public class DateTime {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    //Constructors
    public DateTime(String dateBorrowed) {
        String[] date = dateBorrowed.split("/");
        this.day = Integer.parseInt(date[0]);
        this.month = Integer.parseInt(date[1]);
        this.year = Integer.parseInt(date[2]);
    }

    public DateTime(String dateBorrowed, String timeBorrrowed) {
        this(dateBorrowed);
        String[] time = timeBorrrowed.split(":");
        this.hour = Integer.parseInt(time[0]);
        this.minute = Integer.parseInt(time[1]);

    }

    public DateTime(int date, int month, int year) {
        super();
        this.day = date;
        this.month = month;
        this.year = year;
    }

    //Getters
    public String getDate() {
        return String.format("%d/%d/%d", day, month, year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}



