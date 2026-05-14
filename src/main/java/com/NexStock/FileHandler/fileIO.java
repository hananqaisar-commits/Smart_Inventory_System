package com.NexStock.FileHandler;

import java.io.*;

public class fileIO {

    public void filereader(String datafileName) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(datafileName));
            String line;
            while ((line = bfr.readLine()) != null)
                System.out.println(line);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void filewriter(String datafileName, String textTobewrite) {
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(datafileName, true));
            bfw.write(textTobewrite.trim());
            bfw.newLine();//for new line
            bfw.flush();

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
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void clearfile(String datafileName) {
        try {
            BufferedWriter rm = new BufferedWriter(new FileWriter(datafileName));
            rm.write("");
            System.out.println("Empty text file");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
