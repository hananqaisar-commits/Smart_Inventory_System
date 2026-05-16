package com.NexStock.FileHandler;

import com.NexStock.model.Admin;
import com.NexStock.model.Cashier;
import com.NexStock.model.User;
import java.io.*;
import java.util.ArrayList;

public class fileIO {

    public ArrayList<User> readList_Users = new ArrayList<>();

    public void filereader(String datafileName) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(datafileName));
            String line;
            while ((line = bfr.readLine()) != null) {
                if (line.contains("Admin")) {// now i can read data from file efficiently according to my requirement
                    String lineofcode[] = line.split(",");
                    String role = lineofcode[0];
                    String name = lineofcode[1];
                    String username = lineofcode[2];
                    String gmail = lineofcode[3];
                    String ID = lineofcode[4];
                    boolean accesslevel = Boolean.parseBoolean(lineofcode[5]);
                    boolean canAddProduct = Boolean.parseBoolean(lineofcode[6]);
                    boolean canDeleteProduct = Boolean.parseBoolean(lineofcode[7]);
                    boolean canManageUsers = Boolean.parseBoolean(lineofcode[8]);
                    boolean canViewReports = Boolean.parseBoolean(lineofcode[9]);
                    String password = lineofcode[10];

                    readList_Users
                            .add(new Admin(name, username, gmail, ID, password, role, canAddProduct, canDeleteProduct,
                                    canManageUsers, canViewReports));

                } else if (line.contains("Cashier")) {
                    String lineofcode[] = line.split(",");
                    String role = lineofcode[0];
                    String name = lineofcode[1];
                    String username = lineofcode[2];
                    String gmail = lineofcode[3];
                    String password = lineofcode[4];
                    String ID = lineofcode[5];
                    boolean canViewSales = Boolean.parseBoolean(lineofcode[6]);
                    readList_Users.add(new Cashier(name, username, gmail, ID, password, canViewSales));
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
            bfw_WithoutAppend.write(this.toString().trim());
            bfw_WithoutAppend.write(texttobewrite);
            bfw_WithoutAppend.flush();

            bfw_WithoutAppend.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void clearfile(String datafileName) {
        try {
            BufferedWriter rm = new BufferedWriter(new FileWriter(datafileName));
            rm.write("");
            System.out.println("Empty text file");
            rm.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
