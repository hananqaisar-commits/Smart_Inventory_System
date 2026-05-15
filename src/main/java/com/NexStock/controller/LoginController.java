package main.java.com.NexStock.controller;

import com.NexStock.FileHandler.fileIO;
import com.NexStock.security.Password_Hasher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private fileIO fio = new fileIO();
    private Password_Hasher hasher = new Password_Hasher();

    @FXML
    public void initialize() {
        usernameField.requestFocus();
        usernameField.setOnAction(e -> passwordField.requestFocus());
    }

    @FXML
    public void handleLogin() {
        String enteredUsername = usernameField.getText().trim();
        String enteredPassword = hasher.hashAlgorithm(passwordField.getText().trim());

        if (enteredUsername.isEmpty() || passwordField.getText().isEmpty()) {
            showAlert("Error", "Fields cannot be empty!");
            return;
        }

        ArrayList<String> lines = fio.filereader("users.txt");
        boolean userFound = false;

        for (String line : lines) {
            String[] parts = line.split(",");
            // parts[0]=name, parts[1]=email, parts[2]=password
            if (parts[0].equals(enteredUsername)) {
                userFound = true;
                if (parts[2].equals(enteredPassword)) {
                    showAlert("Success", "Logged in successfully!");
                    // scene switch here
                } else {
                    showAlert("Error", "Incorrect password!");
                }
                break;
            }
        }

        if (!userFound) {
            showAlert("Error", "User not found! Please create an account first.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}