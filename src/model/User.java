package model;

import java.util.*;//need to convert binary code to hexa

import java.time.LocalDateTime;
import security.Password_Hasher;

abstract class User {

    final String userID, firstname, lastname;
    private String userName;
    private String password;
    private String gmail;
    static int count1 = 0, count2 = 0;
    private final LocalDateTime now;

    Password_Hasher p1 = new Password_Hasher();

    enum role {
        Admin, Cashier, Salesman
    };

    private boolean isLocked;// false by deafult mean it is not locked

    // Constructor

    public User(String firstname, String lastname,
            String userName, String gmail,
            String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.userName = userName;
        this.gmail = gmail;
        this.password = password;

        // i have to add ke jab user name pehlay hi exist krta ho to us ko msg display
        // karna hai already exist plz use new one

        this.userID = this.ID_Generator();// Id-Generator will assign automatically id to it Which will be unique

        System.out.println("Account created sucessfull");

        now = LocalDateTime.now();
    }

    // Setters & Getters

    public String getUserName() {
        return userName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setUserName(String userName) {

        if (userName == null || userName.trim().isEmpty()) {

            System.out.println("Invalid");

        } else {

            this.userName = userName;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHashed() {
        return p1.hashAlgorithm(this.getPassword());
    }

    public boolean isLocked() {
        return isLocked;
    }

    // methods

    // public String formatHex(byte[] bytes) {
    // return this.formatHex(bytes, 0, bytes.length);
    // } I picked this method from definition (Class HexFormat)
    // i am using this to convert array of byte to hexa(String) bcz mostly i saw
    // string hexa hashes

    public void changePassword(String oldPassword,
            String newPassed_1,
            String newPassed_2) {

        if (!p1.hashAlgorithm(oldPassword).equals(this.getPasswordHashed())) {
            System.out.println("Old password does't match");
            return;
        }

        System.out.println("Old password matched!!");

        if (newPassed_1.equals(newPassed_2)) {

            this.setPassword(p1.hashAlgorithm(newPassed_1));
            System.out.println("Changed Password Sucessfull");// hashed is saved to password feild

        } else {

            System.out.println("Failed");
        }

    }

    public void forgetPassword() {

    }

    public String ID_Generator() {

        if (getClass().getSimpleName().equalsIgnoreCase("Admin"))
            return String.format("%s%02d", "AD", ++count1);

        if (getClass().getSimpleName().equalsIgnoreCase("Cashier"))
            return String.format("%s%02d", "CA", ++count2);

        return "000";// if no type match then return 000 string
    }

    public String createdAT() {

        return String.format("User: %-16s created at %s",
                this.getUserName(),
                this.now);
    }

    public boolean verifyPassword(String password_entered) {

        if (!p1.hashAlgorithm(password_entered).equals(getPasswordHashed())) {
            System.out.println("Wrong password");
            return false;
        } else {
            System.out.println("Password Verified!");
            return true;

        }
    }

    public void updateUsername(String newName) {

        setUserName(newName);
        System.out.println("Sucessfully updated");
    }

    public void toFilestore() {

        System.out.printf("%-6s %-16s %-10s %s",
                getUserID(),
                getUserName(),
                getClass().getSimpleName(),
                createdAT());
    }

    public String toString() {

        return String.format(
                "User: %-10s(%-10s) %s Account locked -> %b\n",
                this.getClass().getSimpleName(),
                this.getUserName(),
                this.now,
                this.isLocked());
    }
}