package model;

import java.util.*;//need to convert binary code to hexa
import java.time.LocalDateTime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

abstract class User {
    final String userID;
    private String userName;
    private String password;
    static int count1, count2 = 0;
    private final LocalDateTime now;

    enum role {
        Admin, Cashier, Salesman
    };

    private boolean isLocked;// false by deafult mean it is not locked

    // Constructor
    public User(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Invalid");
        } else
            this.userName = userName;
        this.userID = this.ID_Generator();
        now = LocalDateTime.now();
    }

    // Setters & Getters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Invalid");
        } else
            this.userName = userName;
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
        return this.hashAlgorithm();
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
    public String hashAlgorithm() {
        try {
            MessageDigest message = MessageDigest.getInstance("SHA-256");// use sha-256 algorithm
            byte[] bytes = message.digest(this.getPassword().getBytes());// digest mine password with algorithm sha-256
            String hex = HexFormat.of().formatHex(bytes);
            return hex;
        } catch (NoSuchAlgorithmException e) {// catch excemtion if not available algorithm
            e.getMessage();
            return null;
        }
    }

    public String ID_Generator() {
        if (getClass().getSimpleName().equalsIgnoreCase("Admin")) {

            return String.format("%-2s%02d", "AD", ++count1);
        }
        if (getClass().getSimpleName().equalsIgnoreCase("Cashier")) {

            return String.format("%-2s%02d", "CA", ++count2);
        }

        return "000";// if no type match then return 000 string
    }

    public String createdAT() {
        return String.format("User: %-16s created at %s", this.getUserName(), now);
    }

    public boolean verifyPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            String hex2 = HexFormat.of().formatHex(bytes);

            if (!hex2.equals(getPasswordHashed())) {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    public void updateUsername(String newName) {

        setUserName(newName);
        System.out.println("Sucessfully updated");
    }

    public void toFilestore() {
        System.out.printf("%-6s %-16s %-10s %s", getUserID(), getUserName(), getClass().getSimpleName(), createdAT());
    }

    public String toString() {
        return String.format("User: %-10s(%-10s) %s Account locked -> %b\n", this.getClass().getSimpleName(),
                this.getUserName(),
                LocalDateTime.now(), this.isLocked());
    }
}