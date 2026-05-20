package com.NexStock.controller;

import com.NexStock.model.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import java.util.List;

import com.NexStock.FileHandler.fileIO;

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
    @FXML
    private PieChart pieChart;
    @FXML
    private Label told;
    @FXML
    private TextField searched;
    @FXML
    private ListView<String> listid;// it is my listview on dashboard

    @FXML
    private BarChart<String, Number> weeklySalesChart;

    private Image img1_Default, img1_Gif;
    private Image img2_Default, img2_Gif;
    private Image img3_Default, img3_Gif;
    private Image img4_Default, img4_Gif;
    private Image img5_Default, img5_Gif;
    private Image img6_Default, img6_Gif;
    private Image img7_Default, img7_Gif;
    private Image img8_Default, img8_Gif;

    private Image load(String name) {// this is method used to load images with secure check of null
        var stream = getClass().getResourceAsStream(name);
        return stream != null ? new Image(stream) : null;
    }

    fileIO IO = new fileIO();

    @FXML
    public void initialize() {

        told.setText("Admin");

        told.setStyle(
                "-fx-background-color: #1e293b;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 15 8 15;" +
                        "-fx-background-radius: 10;"
        );

        
        img1_Default = load("/com/NexStock/images/icons8-home-50.png");
        img1_Gif = load("/com/NexStock/images/icons8-home.gif");
        img2_Default = load("/com/NexStock/images/icons8-product-50.png");
        img2_Gif = load("/com/NexStock/images/icons8-product.gif");
        img3_Default = load("/com/NexStock/images/category.png");
        img3_Gif = load("/com/NexStock/images/menu.png");
        img4_Default = load("/com/NexStock/images/increase.png");
        img4_Gif = load("/com/NexStock/images/sales.png");
        img5_Default = load("/com/NexStock/images/supplier.png");
        img5_Gif = load("/com/NexStock/images/postman.gif");
        img6_Default = load("/com/NexStock/images/user.png");
        img6_Gif = load("/com/NexStock/images/user.gif");
        img7_Default = load("/com/NexStock/images/graph.png");
        img7_Gif = load("/com/NexStock/images/checklist.gif");
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

        IO.productread("Products.txt");
        countProducts();// for countin used in pcategories display on GUI

        addBarChart();

        pieChart.getData().addAll(
                new PieChart.Data("Electronics", e),
                new PieChart.Data("Clothing", cl),
                new PieChart.Data("Crockery", cr),
                new PieChart.Data("Furniture", f),
                new PieChart.Data("Accessory", a),
                new PieChart.Data("Grocery", g));

        searched.textProperty().addListener((obs, oldsearch, newsearch) -> {
            String word = newsearch == null ? "" : newsearch;// this is ternory operatory just to check that newval is
            // empty or not
            ObservableList<String> results = FXCollections.observableArrayList();// this is imp line in searching on
            // realtime from gui. here i create
            // list which is temporary and in start
            // it will always empty
            if (word.isEmpty()) {
                listid.setItems(results);
                return;
            }
            for (Product p : IO.readList_Products) {
                if (p.getPdname().toLowerCase().contains(word.toLowerCase())) {
                    results.add(p.getPdname());
                } else if (p.getCategory().toLowerCase().contains(word.toLowerCase())) {
                    results.add(p.getPdname());
                }
            }
            listid.setItems(results);
        });
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


    @FXML
    public void sceneSwitch(ActionEvent e) {
        Stage stage = new Stage();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("report.fxml");
    }


    @FXML
    public void logout(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("login.fxml");
        System.out.println("Logout");
    }

    @FXML
    public void catButton(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("category.fxml");
    }

    @FXML
    public void addBarChart() {
        XYChart.Series<String, Number> barchart = new XYChart.Series<>();
        barchart.setName("Reorder level");

        for (Product p : IO.readList_Products) {
            barchart.getData().add(
                    new XYChart.Data<>(p.getPdname(), p.getReorderlevel())
            );
        }

        weeklySalesChart.getData().clear();
        weeklySalesChart.getData().add(barchart);
    }

    private int e, cr, cl, a, f, g, total_count = 0;
    private int e_reorder, cr_reorder, cl_reorder, a_reorder, f_reorder, g_reorder, total_count_reorder = 0;
    private double e_price, cr_price, clprice, a_price, f_price, g_price, total_count_price = 0.0;

    void countProducts() {
        e = cr = cl = a = f = g = 0;
        e_price = cr_price = clprice = a_price = f_price = g_price = 0.0;
        for (Product countable : IO.readList_Products) {
            if (countable.getCategory().equals("Electronics")) {
                e += countable.getStockQuantity();
                e_price += countable.getUnitPrice();
                e_reorder += countable.getReorderlevel();
            } else if (countable.getCategory().equals("Clothing")) {
                cl += countable.getStockQuantity();
                clprice += countable.getUnitPrice();
                cl_reorder += countable.getReorderlevel();
            } else if (countable.getCategory().equals("Crockery")) {
                cr += countable.getStockQuantity();
                cr_price += countable.getUnitPrice();
                cr_reorder += countable.getReorderlevel();
            } else if (countable.getCategory().equals("Furniture")) {
                f += countable.getStockQuantity();
                f_price += countable.getUnitPrice();
                f_reorder += countable.getReorderlevel();
            } else if (countable.getCategory().equals("Accessory")) {
                a += countable.getStockQuantity();
                a_price += countable.getUnitPrice();
                a_reorder += countable.getReorderlevel();
            } else if (countable.getCategory().equals("Grocery")) {
                g += countable.getStockQuantity();
                g_price += countable.getUnitPrice();
                g_reorder += countable.getReorderlevel();
            }
        }
        total_count = e + cl + cr + f + a + g;// total products quantity
        total_count_price = e_price + clprice + cr_price + f_price + a_price + g_price;// total price of all products
        total_count_reorder = e_reorder + cl_reorder + cr_reorder + f_reorder + a_reorder + g_reorder;// total reorder
        // level of all// products

    }
}