package com.NexStock.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class dashboardcontroller {

    @FXML
    private Button dashboardID;
    @FXML
    private Button productID;
    @FXML
    private Button catID;
    @FXML
    private Button salesID;
    @FXML
    private Button supplierID;
    @FXML
    private Button userID;
    @FXML
    private Button reportID;
    @FXML
    private Button logoutID;
    @FXML
    private ImageView myview1;
    @FXML
    private ImageView myimage2;
    @FXML
    private ImageView myimage3;
    @FXML
    private ImageView myimage4;
    @FXML
    private ImageView myimage5;
    @FXML
    private ImageView myimage6;
    @FXML
    private ImageView myimage7;
    @FXML
    private ImageView myimage8;

    private Image img1_Default, img1_Gif;
    private Image img2_Default, img2_Gif;
    private Image img3_Default, img3_Gif;
    private Image img4_Default, img4_Gif;
    private Image img5_Default, img5_Gif;
    private Image img6_Default, img6_Gif;
    private Image img7_Default, img7_Gif;
    private Image img8_Default, img8_Gif;

    private Image load(String name) {
        var stream = getClass().getResourceAsStream(name);
        return stream != null ? new Image(stream) : null;
    }

    @FXML
    public void initialize() {
        img1_Default = load("/com/NexStock/images/icons8-home-50.png");
        img1_Gif = load("/com/NexStock/images/icons8-home.gif");
        img2_Default = load("/com/NexStock/images/icons8-product-50.png");
        img2_Gif = load("/com/NexStock/images/icons8-product.gif");
        img3_Default = load("/com/NexStock/images/icons8-product-50.png");
        img3_Gif = load("/com/NexStock/images/icons8-product.gif");
        img4_Default = load("/com/NexStock/images/icons8-home-50.png");
        img4_Gif = load("/com/NexStock/images/icons8-home.gif");
        img5_Default = load("/com/NexStock/images/icons8-home-50.png");
        img5_Gif = load("/com/NexStock/images/icons8-home.gif");
        img6_Default = load("/com/NexStock/images/icons8-home-50.png");
        img6_Gif = load("/com/NexStock/images/icons8-home.gif");
        img7_Default = load("/com/NexStock/images/icons8-home-50.png");
        img7_Gif = load("/com/NexStock/images/icons8-home.gif");
        img8_Default = load("/com/NexStock/images/icons8-logout-50.png");
        img8_Gif = load("/com/NexStock/images/icons8-logout.gif");

        myview1.setImage(img1_Default);
        myimage2.setImage(img2_Default);
        myimage3.setImage(img3_Default);
        myimage4.setImage(img4_Default);
        myimage5.setImage(img5_Default);
        myimage6.setImage(img6_Default);
        myimage7.setImage(img7_Default);
        myimage8.setImage(img8_Default);
    }

    @FXML
    private void on1(MouseEvent e) {
        myview1.setImage(img1_Gif);
    }

    @FXML
    private void on2(MouseEvent e) {
        myview1.setImage(img1_Default);
    }

    @FXML
    private void on3(MouseEvent e) {
        myimage2.setImage(img2_Gif);
    }

    @FXML
    private void on4(MouseEvent e) {
        myimage2.setImage(img2_Default);
    }

    @FXML
    private void on5(MouseEvent e) {
        myimage3.setImage(img3_Gif);
    }

    @FXML
    private void on6(MouseEvent e) {
        myimage3.setImage(img3_Default);
    }

    @FXML
    private void on7(MouseEvent e) {
        myimage4.setImage(img4_Gif);
    }

    @FXML
    private void on8(MouseEvent e) {
        myimage4.setImage(img4_Default);
    }

    @FXML
    private void on9(MouseEvent e) {
        myimage5.setImage(img5_Gif);
    }

    @FXML
    private void on10(MouseEvent e) {
        myimage5.setImage(img5_Default);
    }

    @FXML
    private void on11(MouseEvent e) {
        myimage6.setImage(img6_Gif);
    }

    @FXML
    private void on12(MouseEvent e) {
        myimage6.setImage(img6_Default);
    }

    @FXML
    private void on13(MouseEvent e) {
        myimage7.setImage(img7_Gif);
    }

    @FXML
    private void on14(MouseEvent e) {
        myimage7.setImage(img7_Default);
    }

    @FXML
    private void on15(MouseEvent e) {
        myimage8.setImage(img8_Gif);
    }

    @FXML
    private void on16(MouseEvent e) {
        myimage8.setImage(img8_Default);
    }

    @FXML
    public void productbutton(ActionEvent event) {
        Stage stage = new Stage();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("addProduct.fxml");
    }
}