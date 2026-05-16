package com.NexStock.controller;

import com.NexStock.model.Admin;
import com.NexStock.model.Cashier;
import com.NexStock.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.NexStock.security.Password_Hasher;
import com.NexStock.FileHandler.fileIO;

public class ChangePasswordController {

    @FXML
    private TextField username;

    public void setUsername(String name) {
        username.setText(name);
    }

    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField retypePassword;

    Password_Hasher p1 = new Password_Hasher();
    fileIO IO = new fileIO();

    public void initialize() {
        oldPassword.requestFocus();
        oldPassword.setOnAction(e -> newPassword.requestFocus());
        newPassword.setOnAction(e -> retypePassword.requestFocus());
    }

    @FXML
    public void checkPassword(ActionEvent e) {
        IO.filereader("User.txt");

        for (User this_userhas : IO.readList_Users) {
            if (this_userhas.getUserName().equals(username.getText()))
                if (this_userhas.getPassword().equals(p1.hashAlgorithm(oldPassword.getText()))) {
                    this_userhas.changePassword(oldPassword.getText(), newPassword.getText(), retypePassword.getText());
                    IO.clearfile("User.txt");
                    for (User writeuser : IO.readList_Users) {
                        if (writeuser instanceof Admin a) {
                            IO.filewriter("User.txt", a.tofile());
                        } else if (writeuser instanceof Cashier c) {
                            IO.filewriter("User.txt", c.tofile());
                        }
                    }
                } else {
                    System.out.println("Next User " + this_userhas.getUserName());
                }
        }
    }
}