package com.NexStock.model;

public class Admin extends User {

    // Admin specific fields
    private String accessLevel;// like super doers(linux)
    private boolean canAddProduct;
    private boolean canDeleteProduct;
    private boolean canManageUsers;
    private boolean canViewReports;
    private static int failedLoginAttempts;

    public Admin(String firstname,
                 String userName, String gmail,
                 String password1, String password2, String accessLevel) {

        super(firstname, userName, gmail, password1, password2); // User ka constructor

        this.accessLevel = accessLevel;
        this.canAddProduct = true; // Admin ko by default sab permissions
        this.canDeleteProduct = true;
        this.canManageUsers = true;
        this.canViewReports = true;


    }

    // Setter & Getters

    public void removeUser(User deluser) {
        if (users.contains(deluser) && this.canManageUsers) {
            users.remove(deluser);
        } else {
            System.out.println(deluser.getFirstname() + " not existed");

        }
    }


    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public boolean isCanAddProduct() {
        return canAddProduct;
    }

    public void setCanAddProduct(boolean canAddProduct) {
        this.canAddProduct = canAddProduct;
    }

    public boolean isCanDeleteProduct() {
        return canDeleteProduct;
    }

    public void setCanDeleteProduct(boolean canDeleteProduct) {
        this.canDeleteProduct = canDeleteProduct;
    }

    public boolean isCanManageUsers() {
        return canManageUsers;
    }

    public void setCanManageUsers(boolean canManageUsers) {
        this.canManageUsers = canManageUsers;
    }

    public boolean isCanViewReports() {
        return canViewReports;
    }

    public void setCanViewReports(boolean canViewReports) {
        this.canViewReports = canViewReports;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    @Override
    public void setPassword(String password_1) {
        super.setPassword(password_1);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public void addUser(User newuser) {
        if (!users.contains(newuser) && this.canManageUsers) {
            users.add(newuser);
            System.out.println(newuser.getFirstname() + " added with ID: " + newuser.getUserID());
        } else
            System.out.println("Already exists");
    }

    public void unlockuser(User user_to_beUnlocked) {
        if (!users.contains(user_to_beUnlocked) && this.canManageUsers) {
            user_to_beUnlocked.setLocked(false);
            System.out.println(user_to_beUnlocked.getUserID() + " is Unlocked!");
        }
    }

    public void lockuser(User user_to_belocked) {
        if (!users.contains(user_to_belocked) && this.canManageUsers) {
            user_to_belocked.setLocked(true);
            System.out.println(user_to_belocked.getUserID() + " is locked!");
        }
    }

}
