package com.NexStock;

import javafx.application.Application;
import javafx.stage.Stage;
import com.NexStock.controller.Sceneswitches;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {//here a controller object is created
        System.out.println("App starting, setting stage... let's gooo (' ? ')");//Just for fun
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("createAccount.fxml");
    }

    public static void main(String[] args) {
        launch(args);//it start my app
    }
}