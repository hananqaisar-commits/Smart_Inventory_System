
package com.NexStock.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public void sceneswitches{

    private Stage stage;
    public static void setStage(Stage mainstage) {
        this.stage = mainstage;
    }

    try{

public static void switchto(Scene switchscene) {
    FXMLLoader loader = new FXMLLoader("resources/com/view/" + switchscene);
    Scene scene = new Scene(loader);
    stage.setStage(scene);
    stage.show();
}
    }
    catch(Exception e){
        e.printStackTrace();
        }


}