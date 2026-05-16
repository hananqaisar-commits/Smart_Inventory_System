package com.NexStock.model;

public class Cashier extends User {

    private boolean canViewSales;

    public Cashier(String firstname,
            String userName, String gmail,
            String password1, String password2) {
        super(firstname, userName, gmail, password1, password2);
        this.canViewSales = true;
    }

    public Cashier(String name, String userName, String gmail, String userID, String password, boolean canViewSales) {// for
                                                                                                                      // converting
                                                                                                                      // to
                                                                                                                      // object
                                                                                                                      // from
                                                                                                                      // file
                                                                                                                      // data
        super(name, userName, gmail, userID, password);
        this.canViewSales = canViewSales;

    }

    public String tofile() {
        return ("Cashier , Name" + this.getFirstname() + ", " + this.getUserName() + ", " + this.getGmail() + ", "
                + this.getPassword() + ",UserID " + this.getUserID() + ", Can View Sales: " + this.canViewSales);
    }

}
