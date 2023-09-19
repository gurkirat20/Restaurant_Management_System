package Employee;

public class Employee {

    /***** Data Members *****/
    private int ID;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String email;
    private String designation;

    /***** Constructors *****/
    public Employee() {
        this.ID = 0;
        this.name = "";
        this.age = 0;
        this.address = "";
        this.phoneNumber = "";
        this.email = "";
        this.designation = "";
    }

    public Employee(int ID, String name, int age, String address, String phoneNumber, String email, String position) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.designation = position;
    }

    /***** Getters  *****/
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDesignation() {
        return designation;
    }

}
