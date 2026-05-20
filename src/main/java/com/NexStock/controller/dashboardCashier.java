package com.NexStock.controller;

import com.NexStock.model.Product;
import com.NexStock.FileHandler.fileIO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

import java.util.PrimitiveIterator;

public class dashboardCashier {

    @FXML
    private Button dashboardID;
    @FXML
    private Button catID;
    @FXML
    private Button reportID;
    @FXML
    private Button logoutID;
    @FXML
    private ImageView myview1;
    @FXML
    private ImageView myimage3;
    @FXML
    private ImageView myimage7;
    @FXML
    private ImageView myimage8;
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField searched;
    @FXML
    private ListView<String> listid;


    @FXML
    private BarChart<String, Number> weeklySalesChart;
    @FXML
    private Label told;


    private Image img1_Default, img1_Gif;
    private Image img3_Default, img3_Gif;
    private Image img7_Default, img7_Gif;
    private Image img8_Default, img8_Gif;

    private Image load(String name) {
        var stream = getClass().getResourceAsStream(name);
        return stream != null ? new Image(stream) : null;
    }

    fileIO IO = new fileIO();

    private int e, cr, cl, a, f, g;
    private double e_price, cr_price, clprice, a_price, f_price, g_price;
    private int e_reorder, cr_reorder, cl_reorder, a_reorder, f_reorder, g_reorder;
    private int total_count = 0;
    private double total_count_price = 0.0;
    private int total_count_reorder = 0;

    @FXML
    public void initialize() {
        told.setText("Cashier");

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
        img3_Default = load("/com/NexStock/images/category.png");
        img3_Gif = load("/com/NexStock/images/menu.png");
        img7_Default = load("/com/NexStock/images/graph.png");
        img7_Gif = load("/com/NexStock/images/checklist.gif");
        img8_Default = load("/com/NexStock/images/icons8-logout-50.png");
        img8_Gif = load("/com/NexStock/images/icons8-logout.gif");

        myview1.setImage(img1_Default);
        myimage3.setImage(img3_Default);
        myimage7.setImage(img7_Default);
        myimage8.setImage(img8_Default);

        IO.productread("Products.txt");
        countProducts();
        addBarChart();

        pieChart.getData().addAll(
                new PieChart.Data("Electronics", e),
                new PieChart.Data("Clothing", cl),
                new PieChart.Data("Crockery", cr),
                new PieChart.Data("Furniture", f),
                new PieChart.Data("Accessory", a),
                new PieChart.Data("Grocery", g));

        searched.textProperty().addListener((obs, oldsearch, newsearch) -> {
            String word = newsearch == null ? "" : newsearch;
            ObservableList<String> results = FXCollections.observableArrayList();
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
    private void on5(MouseEvent e) {
        myimage3.setImage(img3_Gif);
    }

    @FXML
    private void on6(MouseEvent e) {
        myimage3.setImage(img3_Default);
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


    @FXML
    public void logout(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("login.fxml");
        System.out.println("Logout");
    }


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
        total_count = e + cl + cr + f + a + g;
        total_count_price = e_price + clprice + cr_price + f_price + a_price + g_price;
        total_count_reorder = e_reorder + cl_reorder + cr_reorder + f_reorder + a_reorder + g_reorder;
    }


    @FXML
    public void sceneSwitch(ActionEvent e) {
        Stage stage = new Stage();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("report.fxml");
    }
}