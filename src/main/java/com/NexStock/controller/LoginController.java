package com.NexStock.controller;

import com.NexStock.FileHandler.fileIO;
import com.NexStock.model.Cashier;
import com.NexStock.model.User;
import com.NexStock.security.Password_Hasher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import com.NexStock.FileHandler.*;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private Button newUser;
    @FXML
    private Button forgotPassword;

    @FXML
    private TextField passwordField;

    private fileIO IO = new fileIO();
    private Password_Hasher hasher = new Password_Hasher();

    @FXML
    public void initialize() {
        username.requestFocus();
        username.setOnAction(e -> passwordField.requestFocus());
    }

    @FXML
    public void clickedforgot(ActionEvent event) {
        try {
            boolean found = false;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/NexStock/view/changePassword.fxml"));
            Parent root = loader.load();
            ChangePasswordController chngctrl = loader.getController();// to pass username to other stage
            if (username.getText().trim().isEmpty()) {
                showAlert("Error", "Username cannot be empty");
                return;
            } else {
                IO.filereader("User.txt");// first read from list and store in readlist_user
                for (User this_user : IO.readList_Users) {// now check here
                    if (this_user.getUserName().equals(username.getText())) {
                        chngctrl.setUsername(username.getText());
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                showAlert("Error", "Username no exist. Create your account first");
                return;
            }
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setTitle("Change Password");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException exception) {
            System.out.println("Problem in IO Exception");
            exception.printStackTrace();
        }
    }

    @FXML
    public void createUser(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        stage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/NexStock/view/createAccount.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    public void handleLogin(ActionEvent e) {

        String user = username.getText().trim();
        String pass = hasher.hashAlgorithm(passwordField.getText());

        if (user.trim().isEmpty()) {
            showAlert("Input Error", "Username cannot be empty.");
            return;
        }
        boolean userFound = false;
        IO.filereader("User.txt");
        for (User login_User : IO.readList_Users) {
            if (login_User.getUserName().equals(user)) {
                userFound = true;
                if (login_User.get_isLocked()) {
                    showAlert("Account Locked", "Your account is locked due to too many failed login attempts.");
                    return;
                }
                if (login_User.getPasswordHashed().equals(pass)) {
                    if (login_User.getClass().getSimpleName().equals("Admin")) {
                        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
                        stage.setResizable(false);
                        Sceneswitches.setStage(stage);
                        System.out.println("Login successful from file for user: " + user);

                        User.setLogin_Attempts_Remain(3);// if succesfull then set limit again to 3 for next time
                        Sceneswitches.now_switchin("Dashboard.fxml");
                    } else if (login_User.getClass().getSimpleName().equals("Cashier")) {
                        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
                        stage.setResizable(false);
                        Sceneswitches.setStage(stage);
                        System.out.println("Login successful from file for user: " + user);
                        User.setLogin_Attempts_Remain(3);// if succesfull then set limit again to 3 for next time

                        Sceneswitches.now_switchin("Dashboard_Cashier.fxml");
                    }
                } else {// i hve to lock account if user enter wrong password 3 times so i have to
                    // decrease login attempt and if it is 0 then lock account
                    System.out.println("Login failed for user: " + user);
                    User.setLogin_Attempts_Remain(User.getLogin_Attempts_Remain() - 1);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login Failed");
                    alert.setHeaderText("Invalid username or password");
                    alert.setContentText("You have " + User.getLogin_Attempts_Remain() + " login attempts remaining.");
                    alert.resizableProperty().set(false);
                    alert.showAndWait();
                    if (User.getLogin_Attempts_Remain() <= 0) {
                        showAlert("Account Locked", "Too many failed login attempts. Your account has been locked.");
                        login_User.setLocked(true);
                        return;
                    }
                }
                break;// if user is found then we will break the loop to exit and save time.
            }
        }

        if (!userFound) {
            showAlert("User not found", "No account found with the provided username.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.resizableProperty().set(false);
        alert.showAndWait();
    }

}