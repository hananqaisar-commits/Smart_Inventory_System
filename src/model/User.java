package model;

import java.time.LocalDateTime;

abstract class User {
    final String userID;
    private String userName;
    private String passwordHash;
    static int count1, count2, count3 = 0;

    enum role {
        Admin, Cashier, Salesman
    };

    private boolean isLocked;// false by deafult mean it is not locked

    // Constructor
    public User(String userName) {
        this.userName = userName;
        this.userID = this.ID_Generator();
    }

    public User(String userName, String passwordHash) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.userID = this.ID_Generator();

    }

    // Setters & Getters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isLocked() {
        return isLocked;
    }

    // methods

    public String ID_Generator() {
        if (getClass().getSimpleName().equalsIgnoreCase("Admin")) {

            return String.format("%-2s%00d", "AD", ++count1);
        }
        if (getClass().getSimpleName().equalsIgnoreCase("Cashier")) {

            return String.format("%-2s%00d", "CA", ++count2);
        }
        if (getClass().getSimpleName().equalsIgnoreCase("Product")) {

            return String.format("%-2s%000d", "PR", ++count3);
        }
        return "000";// if no type match then return 000 string
    }

    public String createdAT() {
        return String.format("User: %-16s created at %s", this.getUserName(), LocalDateTime.now());
    }

    public String toString() {
        return String.format("User: %-16s\n%s Acoount locked: %b\n", this.getClass().getSimpleName(),
                LocalDateTime.now(), this.isLocked());
    }
}