package controllers;

import AddingItem.Adding;
import LibraryManagementSystem.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;

class AppSummary {
    private String content;

    AppSummary(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

public class HomeController extends Controller {

    public static Westminster_library_manager libObj = new Westminster_library_manager();


    public Result appSummary() {
        JsonNode jsonNode = Json.toJson(new AppSummary("Java Play Angular Seed"));
        return ok(jsonNode).as("application/json");
    }

    public Result postTest() {
        JsonNode jsonNode = Json.toJson(new AppSummary("Post Request TestAdd => Data Sending Success"));
        return ok(jsonNode).as("application/json");
    }

    //Add method to capture the data given in the UI by the user(book)
    public Result TestAdd() {
        JsonNode test = Json.parse(request().body().asText());

        System.out.println(test);

        Book newBook = new Book(
                test.get("number").asInt(),
                test.get("title").textValue(),
                test.get("itemSector").textValue(),
                test.get("itemPbDate").textValue(),
                test.get("Author").textValue(),
                test.get("Publisher").textValue(),
                test.get("itemPages").asInt()
        );

        int remainingItemCount = libObj.add_new_item(newBook);

        JsonNode jsonNode = Json.toJson("Data added successfully\n" +
                "Only" + remainingItemCount + " Book Slots Available");
        return ok(jsonNode).as("application/json");
    }

    //Add method to capture the data given in the UI by the user(DVD)
    public Result TestDVD() {
        JsonNode test = Json.parse(request().body().asText());

        System.out.println(test);

        System.out.println(test.get("number").textValue());
        System.out.println(test.get("title").textValue());

        DVD newDVD = new DVD(
                test.get("number").asInt(),
                test.get("title").textValue(),
                test.get("itemSector").textValue(),
                test.get("itemPbdDate").textValue(),
                test.get("languages").textValue(),
                test.get("subtitles").textValue(),
                test.get("Producer").textValue(),
                test.get("Actor").textValue()
        );

        int remainingItemCount = libObj.add_new_item(newDVD);

        JsonNode jsonNode = Json.toJson("Data added successfully\n" +
                "Only" + remainingItemCount + " DVD Slots Available");
        return ok(jsonNode).as("application/json");
    }

    //Add method to capture the data given in the UI by the user(Reader)
    public Result TestAddReader() {
        JsonNode test = Json.parse(request().body().asText());

        System.out.println(test.get("RID").textValue());

        Reader newReader = new Reader(
                test.get("RID").asInt(),
                test.get("readerName").textValue(),
                test.get("TelNo").asLong(),
                test.get("Email").textValue()
        );

        int readerId = libObj.add_new_readers(newReader);


        JsonNode jsonNode = Json.toJson(
                "The reader Id " + test.get("RID").textValue()
                        + " has been added to database");
        return ok(jsonNode).as("application/json");
    }

    //Delete method to delete the details form the main array list
    public Result TestDelete() {
        JsonNode test = Json.parse(request().body().asText());

        System.out.println(test.get("number").asInt());

        int remainingItemcount = libObj.delete_an_item(test.get("number").asInt());
        System.out.println(remainingItemcount);

        JsonNode jsonNode = Json.toJson("Successfully deleted, " +
                remainingItemcount + " free slots available.");


        return ok(jsonNode).as("application/json");
    }

    //Display method to display the database in the UI
    public Result TestDisplay() {
        JsonNode test = Json.parse(request().body().asText());

        System.out.println(test.get("number").textValue());

        Adding t = new Adding("display");
        JsonNode jsonNode = Json.toJson(t);
        return ok(jsonNode).as("application/json");
    }

    //Borrow method to lend the book or DVD for the user
    public Result TestBorrow() {
        JsonNode requestedBorrowItem = Json.parse(request().body().asText());
        LibraryItem borrowObj = null;
        Reader readerObj = null;
        JsonNode jsonNode = null;

        //System.out.println(requestedBorrowItem);

        // Finding Borrower and Library item
        for (int x = 0; x < libObj.listReaderDetails.size(); x++) {
            readerObj = libObj.listReaderDetails.get(x);
        }
        for (int x = 0; x < libObj.listLibrary.size(); x++) {
            if (libObj.listLibrary.get(x).getIsbn_num() == requestedBorrowItem.get("number").asInt())
                borrowObj = libObj.listLibrary.get(x);
        }
    //after founding the correct isbn  number and reader ID
        if (borrowObj.isBorrowed() == false) {
            borrowObj.setBorrowed(true);
            borrowObj.setReader(readerObj);
            borrowObj.setBorrowed_Info(new DateTime(requestedBorrowItem.get("BDate").asText(),
                    requestedBorrowItem.get("BTime").asText()));
            System.out.println(readerObj + " has borrowed " + requestedBorrowItem.get("number").asInt());
            jsonNode = Json.toJson(readerObj.getName() + " Borrowed " + borrowObj.getTitle());
        } else {
            int currentMonth, currentDate, borrwedMonth, borrowedDate, borrowableDays, availableDays;
            currentDate = new DateTime(requestedBorrowItem.get("BDate").textValue()).getDay();
            currentMonth = new DateTime(requestedBorrowItem.get("BDate").textValue()).getMonth();
            borrwedMonth = borrowObj.getBorrowed_Info().getMonth();
            borrowedDate = borrowObj.getBorrowed_Info().getDay();

            if (borrowObj instanceof Book) {
                borrowableDays = 7;
            } else {
                borrowableDays = 3;
            }

            availableDays = libObj.findDaysAvailable(currentDate, currentMonth, borrwedMonth, borrowedDate, borrowableDays);
            String message = borrowObj.getTitle() + " NOT AVAILABLE right NOW\n" + borrowObj.getTitle() +
                    (availableDays < 1 ? " still not returned" : "Will be available on : " + ((availableDays == 0) ? "Later Today" : availableDays + "days"));

            jsonNode = Json.toJson(message);
        }
        return ok(jsonNode).as("application/json");
    }

    //return method to when user returns the book to the library
    public Result TestReturn() {
        JsonNode request = Json.parse(request().body().asText());

        String fineDetails = libObj.return_item(request.get("isbn").asInt(), request.get("returnDate").asText());

        JsonNode jsonNode = Json.toJson(fineDetails);
        return ok(jsonNode).as("application/json");
    }


}
