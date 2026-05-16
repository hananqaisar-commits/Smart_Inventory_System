package com.NexStock.controller;

import com.NexStock.FileHandler.fileIO;
import com.NexStock.model.User;
import com.NexStock.security.Password_Hasher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/NexStock/view/changePassword.fxml"));
            Parent root = loader.load();
            ChangePasswordController chngctrl = loader.getController();// to pass username to other stage
            if (username.getText().trim().isEmpty()) {
                showAlert(" Error", "Username cannot be empty.");// here if username is empty then show alert msg
                return;
            }
            chngctrl.setUsername(username.getText());
            Stage stage = new Stage();
            stage.setTitle("Change Password");

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

        IO.filereader("User.txt");
        for (User login_User : IO.readList_Users) {
            if (login_User.getUserName().equals(user)) {
                if (login_User.getPasswordHashed().equals(pass)) {
                    System.out.println("Login successful");
                    Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
                    Sceneswitches.setStage(stage);
                    Sceneswitches.now_switchin("Dashboard.fxml");
                }
            } else {
                System.out.println("Next user");
            }
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