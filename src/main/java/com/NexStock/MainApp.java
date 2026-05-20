package com.NexStock;

import javafx.application.Application;
import javafx.stage.Stage;
import com.NexStock.controller.Sceneswitches;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {//here a controller objects goooooo (' ? ')");//Just for fun
        stage.setResizable(false);
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("login.fxml");
    }

    public static void main(String[] args) {
        launch(args);//it start my app
    }
}