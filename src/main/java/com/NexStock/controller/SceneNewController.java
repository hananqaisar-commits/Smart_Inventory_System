package com.NexStock.controller;

import com.NexStock.model.Admin;
import com.NexStock.security.Password_Hasher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class SceneNewController {

    @FXML
    private TextField fullname;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmpassword;
    @FXML
    private TextField email;
    @FXML
    private Label labelshow;

    @FXML
    private Button createaccountbutton;

    Password_Hasher p1 = new Password_Hasher();

    @FXML
    public void createaccount() {

        String enteredfullname = fullname.getText();
        String usernameEntered = username.getText();
//                String passwordEntered1= password.getText();
//                String passwordEntered2= confirmpassword.getText();
        String emailentered = email.getText();

        Admin u1 = new Admin(enteredfullname, usernameEntered, emailentered, password.getText(), confirmpassword.getText(), "root");

        labelshow.setText("Account created successfully!");
    }
}