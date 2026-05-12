package com.NexStock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/NexStock/view/createAccount.fxml"));


// Add a null check to debug easily
            if (loader.getLocation() == null) {
                System.out.println("FXML file not found!");
                return;
            }
            Scene scene = new Scene(loader.load());
            stage.setTitle("Create Account");

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}