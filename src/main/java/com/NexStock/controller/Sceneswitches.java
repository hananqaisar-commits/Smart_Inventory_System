package com.NexStock.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sceneswitches {

    private static Stage mainstage;

    public static void setStage(Stage stage) {//stage is passed by parameter of calling function from main
        mainstage = stage;
        System.out.println("Stage is set: " + stage);//ready to set scene on same main stage
    }

    public static void now_switchin(String switchscene) {
        if (mainstage == null) {
            System.out.println("Stage is null!");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(
                    Sceneswitches.class.getResource("/com/NexStock/view/" + switchscene));
            Scene scene = new Scene(loader.load());
            mainstage.setScene(scene);// now load this scene and set scene on main stage
            mainstage.setTitle("NexStock");// My Software name is NexStock........
            mainstage.show();//show main Stage
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done");//it always run
        }
    }
}
