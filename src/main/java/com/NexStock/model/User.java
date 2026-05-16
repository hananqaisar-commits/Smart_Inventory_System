package com.NexStock.model;

import com.NexStock.security.Password_Hasher;

import java.time.LocalDateTime;//for setting time and i made it final when user create
import java.util.ArrayList;

public abstract class User {

    final String userID, firstname;
    private String userName;
    private String password;
    private String retrypassword;
    private String gmail;
    static int count1 = 0, count2 = 0;
    private final LocalDateTime now;
    private boolean isLocked = false;
    public static ArrayList<User> users = new ArrayList<>();
    private static int login_Attempts_Remain = 3;

    Password_Hasher p1 = new Password_Hasher();

    // Constructor

    public User(String firstname,
            String userName, String gmail,
            String password1, String password2) {

        if (firstname == null || userName.trim().isEmpty()) {
            this.firstname = "";
        } else
            this.firstname = firstname;

        this.userName = userName;

        if (gmail == null || gmail.trim().isEmpty() || !gmail.contains("@")) {
            System.out.println("Invalid gmail");
        } else
            this.gmail = gmail;

        this.password = p1.hashAlgorithm(password1);
        this.retrypassword = p1.hashAlgorithm(password2);
        this.userID = this.ID_Generator();// Id-Generator will assign automatically id to it Which will be unique
        now = LocalDateTime.now();
        if (this.getPassword().equals(this.getRetrypassword())) {
            System.out.println("Account created successful");
            //

            return;
        }
        System.out.println("No account created");

    }

    // Setters & Getters

    public String getRetrypassword() {
        return retrypassword;
    }

    public static void setLogin_Attempts_Remain(int login_Attempts_Remain) {
        User.login_Attempts_Remain = login_Attempts_Remain;
    }

    public static int getLogin_Attempts_Remain() {
        return login_Attempts_Remain;
    }

    public void setRetrypassword(String retrypassword) {
        this.retrypassword = p1.hashAlgorithm(retrypassword);
    }

    public String getUserName() {
        return userName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean get_isLocked() {
        return isLocked;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setUserName(String userName) {

        if (userName == null || userName.trim().isEmpty()) {

            System.out.println("Invalid");

        } else {

            this.userName = userName;
        }
    }

    public void setPassword(String password_1) {
        this.password = p1.hashAlgorithm(password_1);
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHashed() {
        return getPassword();
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

        if (this.isLocked) {
            System.out.println("Account blocked");
            return;
        }
        if (!p1.hashAlgorithm(oldPassword).equals(this.getPasswordHashed())) {
            System.out.println("Old password doesn't match");
            --this.login_Attempts_Remain;
            System.out.println("Wrong password - "
                    + this.login_Attempts_Remain + " attempts remaining");
            if (this.login_Attempts_Remain <= 0) {
                this.isLocked = true;
                System.out.println("Account locked - Contact your admin");
            }
            return;
        } else {
            System.out.println("Old password matched!!");
            this.login_Attempts_Remain = 3;// reset attempts to 3
        }

        if (newPassed_1.equals(newPassed_2)) {

            this.setPassword(newPassed_1);// it will hashed the password bcz od setter
            System.out.println("Changed Password Successful");// hashed is saved to password feild

        } else {

            System.out.println("Failed");
        }

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
        System.out.println("Successfully updated");
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
                this.isLocked);
    }
}