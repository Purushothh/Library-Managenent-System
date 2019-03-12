/**
 * Contains the abstract methods of Library-manager interface
 *
 *
 */
package LibraryManagementSystem;

 public interface Library_manager {

//abstract methdods of library_manager Interface
    public int add_new_item(LibraryItem something);

    public int delete_an_item(int delete_deleteThing);

    public int add_new_readers(Reader newUsers);

    public void display_item();

    public void borrow_item(int isbn);

    public String return_item(int returning, String returnDate);

    public void generate_item();


}
