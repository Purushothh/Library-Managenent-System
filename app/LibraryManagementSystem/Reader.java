package LibraryManagementSystem;

/**
 * Creation of reader class which holds the details of the member of the library.
 */


public class Reader {

    //declaring variables
    private int id;
    private String name;
    private long mobile_number;
    private String email;

    public Reader(int id, String name, long mobile_number, String email) {
        this.id = id;
        this.name = name;
        this.mobile_number = mobile_number;
        this.email = email;

    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public String getEmail() {
        return email;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile_number=" + mobile_number +
                ", email='" + email + '\'' +
                '}';
    }
}

