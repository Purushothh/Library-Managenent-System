/**
 * This class implements the abstract methods in the interface also this class has the method body
 * of those implemented methods
 */
package LibraryManagementSystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Westminster_library_manager implements Library_manager {
    //Database implementation
    private final String NAME = "root";
    private final String ID = "";
    public final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = ("jdbc:mysql://localhost:3306/mylibrary");
    private Connection connection;
    private PreparedStatement myStmt;

    //Arraylist of the Library items to store the books or dvd in the library database
    public static List<LibraryItem> listLibrary = new ArrayList<>();
    public static List<Reader> listReaderDetails = new ArrayList<>();

    static int w1699582_someBook_count;
    static int w1699582_somedvd_count;
    static int w1699582_remainingbooks;
    static int w1699582_remainingddvd;
    static int addedReader;


    //add new item method describes how to add the book or dvd in the array List
    @Override
    public int add_new_item(LibraryItem LibraryItems) {
        if (LibraryItems instanceof Book) {
            if (w1699582_someBook_count >= 100) {
                System.out.println("number exceeded");
            } else {
                listLibrary.add(LibraryItems);
                w1699582_someBook_count++;
                w1699582_remainingbooks = (100 - w1699582_someBook_count);
                System.out.println("Only " + w1699582_remainingbooks + " left!.");
                addToDatabase(LibraryItems);

                return w1699582_remainingbooks;
            }
        } else {
            if (w1699582_somedvd_count >= 50) {
                System.out.println("number exceeded");
            } else {
                listLibrary.add(LibraryItems);
                w1699582_somedvd_count++;
                w1699582_remainingddvd = (50 - w1699582_somedvd_count);
                System.out.println("Only " + w1699582_remainingddvd + " left!.");
                addToDatabase(LibraryItems);

                return w1699582_remainingddvd;
            }
        }

        return 0;
    }

    public void addToDatabase(LibraryItem LibraryItems) {
         /**    String objJSON = javaToJson(LibraryItems);
         System.out.println("connected Json : " + objJSON);
         try {
         Class.forName (DRIVER);
         connection = DriverManager.getConnection(URL,NAME,ID);
         String sqlStatement = "insert into royal_library Values(?,?,?)";
         myStmt = connection.prepareStatement(sqlStatement);


         if (LibraryItems instanceof DVD) {
         myStmt.setInt(1, w1699582_somedvd_count);
         } else {
         myStmt.setInt(1, w1699582_someBook_count);
         }
         myStmt.setInt(2, LibraryItems.getIsbn_num());
         myStmt.setString(3, objJSON);
         myStmt.execute();
         System.out.println("added to database : " + LibraryItems);
         } catch (SQLException e) {
         e.printStackTrace();
         } catch (ClassNotFoundException e) {
         e.printStackTrace();
         }
          */

    }

    //add the reader details to to an array List
    @Override
    public int add_new_readers(Reader newUsers) {
        listReaderDetails.add(newUsers);
        System.out.println("Reader Added!\n" + newUsers);
        return addedReader;
    }

    //displays the items in the array list to display
    @Override
    public void display_item() {
        for (int y = 0; y < listLibrary.size(); y++) {
            System.out.println(listLibrary.get(y).toString());
        }
    }

    //deletes the items in the library item array list
    @Override
    public int delete_an_item(int isbnNumber) {
        LibraryItem deletedItem = null;
        for (int x = 0; x < listLibrary.size(); x++) {
            if (listLibrary.get(x).getIsbn_num() == isbnNumber) {
                deletedItem = listLibrary.get(x);
                listLibrary.remove(x);
                System.out.println("deleted: " + deletedItem);
                System.out.println("You have " + (w1699582_remainingbooks) + " free slots.");

                if (deletedItem instanceof Book) {
                    w1699582_remainingbooks++;
                    return w1699582_remainingbooks;
                } else {
                    w1699582_remainingddvd++;
                    return w1699582_remainingddvd;
                }
            }
        }
        return 0;
    }

    //add the book or dvd to the array list whenever the
    @Override
    public void borrow_item(int isbn) {
        for (int x = 0; x < listLibrary.size(); x++) {
            if (listLibrary.get(x).getIsbn_num() == isbn) {
                if (listLibrary.get(x).isBorrowed() == false) {
                    System.out.println("Available");
                } else {
                    System.out.println("Not Available");

                }
            }
        }
    }

    // returns the item whenever the reader returns the book or dvd
    @Override
    public String return_item(int isbn, String returnDateasString) {
        DateTime returnDate = new DateTime(returnDateasString);
        int borrowableDays = 0;
        int availableDays = 0;
        double fineValue = 0;
        int extraDays = 0;
        String fineDetails = null;
        String resp = null;


        for (LibraryItem item : listLibrary) {
            if (item.getIsbn_num() == isbn) {

                if (item instanceof Book) {
                    borrowableDays = 7;
                } else {
                    borrowableDays = 3;
                }

                if (item.isBorrowed()) {
                    availableDays = findDaysAvailable(returnDate.getDay(), returnDate.getMonth(),
                            item.getBorrowed_Info().getMonth(), item.getBorrowed_Info().getDay(),
                            borrowableDays);
                }

                resp = item.getTitle() + " Returned, \n";
            }
        }

        // Calculate Fine By Time
        extraDays = Math.abs(availableDays);
        if (availableDays < 0) {
            fineDetails = "You returned before the due date";
        } else if (extraDays < 4) {
            fineValue = extraDays * 24 * 0.2;
            fineDetails = "You have to pay £" + fineValue + " for extra " + extraDays + "Days";
        } else {
            fineValue = 3 * 0.2 * 24 + (extraDays - 3) * 0.5 * 24;
            fineDetails = "You have to pay £" + fineValue + " for extra " + extraDays + "Days";
        }


        return resp + fineDetails;
    }

    @Override
    public void generate_item() {

    }


    public int getDays_IfMonthsAreDistinctArrivalOfBook(int currentMonth, int borrowedMonth, int borrowedDate, int borrowableDays) {
        if (currentMonth - borrowedMonth == 1 || currentMonth - borrowedMonth > 1) {
            if (borrowedMonth == 2) {
                if (borrowedDate > 21)
                    return borrowableDays - (28 - borrowedDate);    //february
                else
                    return borrowedDate;
            } else if (borrowedDate > 22) {
                if (borrowedMonth <= 7) {
                    if (borrowedMonth % 2 == 0) {
                        return borrowableDays - (30 - borrowedDate);
                    } else {                                            //6 month odd number
                        return borrowableDays - (31 - borrowedDate);
                    }
                } else {
                    if (borrowedMonth % 2 == 0) {
                        return borrowableDays - (31 - borrowedDate);
                    } else {                                             //6 month in even number
                        return borrowableDays - (30 - borrowedDate);
                    }
                }
            } else {
                return borrowableDays - borrowedDate;
            }
        } else {
            return borrowedDate;
        }
    }


    public int findDaysAvailable(int currentDate, int currentMonth, int borrowedMonth,
                                 int borrowedDate, int maxDays) {
        if (currentMonth == borrowedMonth) {
            return currentDate - borrowedDate;
        } else {
            return (getDays_IfMonthsAreDistinctArrivalOfBook(currentMonth, borrowedMonth,
                    borrowedDate, maxDays) - currentDate);
        }
    }


    public String javaToJson(Object object) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.out.println("Exception occurred while converting Java Object to Json --> "
                    + e.getMessage());
        }
        return jsonResult;
    }
}
