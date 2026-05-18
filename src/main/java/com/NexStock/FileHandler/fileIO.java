package com.NexStock.FileHandler;

import com.NexStock.model.Admin;
import com.NexStock.model.Cashier;
import com.NexStock.model.Product;
import com.NexStock.model.User;
import com.NexStock.products.*;

import java.io.*;
import java.util.ArrayList;

public class fileIO {

    public ArrayList<User> readList_Users = new ArrayList<>();
    public ArrayList<Product> readList_Products = new ArrayList<>();

    public void filereader(String datafileName) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(datafileName));
            readList_Users.clear();
            String line;
            while ((line = bfr.readLine()) != null) {
                if (line.contains("Admin")) {// now i can read data from file efficiently according to my requirement
                    String lineofcode[] = line.split(",");
                    String role = lineofcode[0];
                    String name = lineofcode[1];
                    String username = lineofcode[2];
                    String gmail = lineofcode[3];
                    String ID = lineofcode[4];
                    String accessLevel = lineofcode[5];
                    boolean canAddProduct = Boolean.parseBoolean(lineofcode[6]);
                    boolean canDeleteProduct = Boolean.parseBoolean(lineofcode[7]);
                    boolean canManageUsers = Boolean.parseBoolean(lineofcode[8]);
                    boolean canViewReports = Boolean.parseBoolean(lineofcode[9]);
                    String password = lineofcode[10];

                    Admin a = new Admin(name, username, gmail, ID, "", role, canAddProduct, canDeleteProduct,
                            canManageUsers, canViewReports);
                    a.setPasswordHashed(password);// this was main bug of my programme
                    readList_Users.add(a);

                } else if (line.contains("Cashier")) {
                    String lineofcode[] = line.split(",");

                    String name = lineofcode[1];
                    String username = lineofcode[2];
                    String gmail = lineofcode[3];
                    String password = lineofcode[4];
                    String ID = lineofcode[5];
                    boolean canViewSales = Boolean.parseBoolean(lineofcode[6]);

                    Cashier c = new Cashier(name, username, gmail, ID, "", canViewSales);
                    c.setPasswordHashed(password);
                    readList_Users.add(c);
                }
            }
            bfr.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void productread(String filename) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(filename));
            readList_Products.clear();
            String line;
            while ((line = bfr.readLine()) != null) {
                if (line.contains("Electronics")) {

                    String[] lineofcode = line.split(",");

                    String ID = lineofcode[0].trim();
                    String name = lineofcode[1].trim();
                    String category = lineofcode[2].trim();
                    double price = Double.parseDouble(lineofcode[3].trim());
                    String brand = lineofcode[4].trim();
                    int stock = Integer.parseInt(lineofcode[5].trim());
                    String supplier = lineofcode[6].trim();
                    int quantity = Integer.parseInt(lineofcode[7].trim());
                    String date = lineofcode[8].trim();

                    readList_Products.add(
                            new Electronics(ID, name, category, price, brand, stock, supplier, quantity, date));

                } else if (line.contains("Accessory")) {

                    String[] lineofcode = line.split(",");

                    String ID = lineofcode[0].trim();
                    String name = lineofcode[1].trim();
                    String category = lineofcode[2].trim();
                    double price = Double.parseDouble(lineofcode[3].trim());
                    String brand = lineofcode[4].trim();
                    int stock = Integer.parseInt(lineofcode[5].trim());
                    String supplier = lineofcode[6].trim();
                    int quantity = Integer.parseInt(lineofcode[7].trim());
                    String date = lineofcode[8].trim();

                    readList_Products.add(
                            new Accessory(ID, name, category, price, brand, stock, supplier, quantity, date));

                } else if (line.contains("Clothing")) {

                    String[] lineofcode = line.split(",");

                    String ID = lineofcode[0].trim();
                    String name = lineofcode[1].trim();
                    String category = lineofcode[2].trim();
                    double price = Double.parseDouble(lineofcode[3].trim());
                    String brand = lineofcode[4].trim();
                    int stock = Integer.parseInt(lineofcode[5].trim());
                    String supplier = lineofcode[6].trim();
                    int quantity = Integer.parseInt(lineofcode[7].trim());
                    String date = lineofcode[8].trim();

                    readList_Products.add(
                            new Clothing(ID, name, category, price, brand, stock, supplier, quantity, date));
                } else if (line.contains("Crockery")) {

                    String[] lineofcode = line.split(",");

                    String ID = lineofcode[0].trim();
                    String name = lineofcode[1].trim();
                    String category = lineofcode[2].trim();
                    double price = Double.parseDouble(lineofcode[3].trim());
                    String brand = lineofcode[4].trim();
                    int stock = Integer.parseInt(lineofcode[5].trim());
                    String supplier = lineofcode[6].trim();
                    int quantity = Integer.parseInt(lineofcode[7].trim());
                    String date = lineofcode[8].trim();

                    readList_Products.add(
                            new Crockery(ID, name, category, price, brand, stock, supplier, quantity, date));
                } else if (line.contains("Furniture")) {

                    String[] lineofcode = line.split(",");

                    String ID = lineofcode[0].trim();
                    String name = lineofcode[1].trim();
                    String category = lineofcode[2].trim();
                    double price = Double.parseDouble(lineofcode[3].trim());
                    String brand = lineofcode[4].trim();
                    int stock = Integer.parseInt(lineofcode[5].trim());
                    String supplier = lineofcode[6].trim();
                    int quantity = Integer.parseInt(lineofcode[7].trim());
                    String date = lineofcode[8].trim();

                    readList_Products.add(
                            new Furniture(ID, name, category, price, brand, stock, supplier, quantity, date));
                } else if (line.contains("Grocery")) {

                    String[] lineofcode = line.split(",");

                    String ID = lineofcode[0].trim();
                    String name = lineofcode[1].trim();
                    String category = lineofcode[2].trim();
                    double price = Double.parseDouble(lineofcode[3].trim());
                    String brand = lineofcode[4].trim();
                    int stock = Integer.parseInt(lineofcode[5].trim());
                    String supplier = lineofcode[6].trim();
                    int quantity = Integer.parseInt(lineofcode[7].trim());
                    String date = lineofcode[8].trim();

                    readList_Products.add(
                            new Grocery(ID, name, category, price, brand, stock, supplier, quantity, date));
                }

            }
            bfr.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void filewriter(String datafileName, String textTobewrite) {
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(datafileName, true));
            bfw.write(textTobewrite.trim());
            bfw.newLine();// for new line
            bfw.flush();
            bfw.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void filewriterwithoutappend(String datafileName, String texttobewrite) {
        try {
            BufferedWriter bfw_WithoutAppend = new BufferedWriter(new FileWriter(datafileName));
            bfw_WithoutAppend.write(texttobewrite);
            bfw_WithoutAppend.flush();

            bfw_WithoutAppend.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public ArrayList<String> readList_Bills = new ArrayList<>();

    public void billsReader(String datafileName) {
        BufferedReader bfr;
        try {
            bfr = new BufferedReader(new FileReader(datafileName));
            String line;
            StringBuilder currentBill = new StringBuilder();
            while ((line = bfr.readLine()) != null) {
                currentBill.append(line).append("\n");

                if (line.contains("Thank you for shopping!")) {
                    readList_Bills.add(currentBill.toString());
                    currentBill = new StringBuilder();
                }
            }

            bfr.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void clearfile(String datafileName) {
        try {
            BufferedWriter rm = new BufferedWriter(new FileWriter(datafileName));
            rm.write("");
            System.out.println("Text file is cleared now");
            rm.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}