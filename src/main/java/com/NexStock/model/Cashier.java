package com.NexStock.model;

public class Cashier extends User {

    public Cashier(String firstname,
            String userName, String gmail,
            String password1, String password2) {
        super(firstname, userName, gmail, password1, password2);
    }

    public String tofile() {
        return ("Cashier: " + this.getFirstname() + ", " + this.getUserName() + ", " + this.getGmail() + ", "
                + this.getPassword());
    }

}
