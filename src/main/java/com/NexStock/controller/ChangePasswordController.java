package com.NexStock.controller;

import com.NexStock.model.Admin;
import com.NexStock.model.Cashier;
import com.NexStock.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.NexStock.security.Password_Hasher;
import com.NexStock.FileHandler.fileIO;
import javafx.stage.Stage;


public class ChangePasswordController {


    @FXML
    private TextField username;

    @FXML
    private void back(ActionEvent e) {
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        stage.setResizable(false);
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("login.fxml");
    }

    public void setUsername(String name) {
        username.setText(name);
    }

    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField retypePassword;
    @FXML
    private Label label1;


    Password_Hasher p1 = new Password_Hasher();
    fileIO IO = new fileIO();

    public void initialize() {
        oldPassword.requestFocus();
        oldPassword.setOnAction(e -> newPassword.requestFocus());//this is lambda expression
        newPassword.setOnAction(e -> retypePassword.requestFocus());
    }

    @FXML
    public void checkPassword(ActionEvent e) {
        boolean found = false;
        IO.filereader("User.txt");

        for (User this_userhas : IO.readList_Users) {
            if (this_userhas.getUserName().equals(username.getText())) {
                found = true;

                if (this_userhas.getPassword().equals(p1.hashAlgorithm(oldPassword.getText()))) {
                    IO.clearfile("User.txt");// if password match then clear the file first
                    this_userhas.changePassword(oldPassword.getText(), newPassword.getText(), retypePassword.getText());// this
                    // is
                    // defined
                    // method
                    // in
                    // User
                    // class
                    for (User writeuser : IO.readList_Users) {
                        if (writeuser instanceof Admin a) {
                            IO.filewriter("User.txt", a.tofile());
                        } else if (writeuser instanceof Cashier c) {
                            IO.filewriter("User.txt", c.tofile());
                        }
                    }
                    if (found) {
                        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();//close this stage and back to login
                        stage.setResizable(false);
                        Sceneswitches.setStage(stage);
                        Sceneswitches.now_switchin("login.fxml");
                    }
                } else {
                    System.out.println("Not found. Try Next User " + this_userhas.getUserName());
                    label1.setText("          Password Error");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }
    }
}