package com.NexStock.controller;

import com.NexStock.FileHandler.fileIO;
import com.NexStock.model.Product;
import com.NexStock.products.Accessory;
import com.NexStock.products.Clothing;
import com.NexStock.products.Crockery;
import com.NexStock.products.Electronics;
import com.NexStock.products.Furniture;
import com.NexStock.products.Grocery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class addProductcontroller {

    @FXML
    private Label addproductlabel;
    @FXML
    private TextField productname;
    @FXML
    private TextArea DescriptionID;
    @FXML
    private ChoiceBox<Product.productlist> productcat;
    @FXML
    private TextField pprID;
    @FXML
    private TextField productID;
    @FXML
    private TextField stockquantityID;
    @FXML
    private Spinner<Integer> spinn;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea suppliernameID;
    @FXML
    private Button saveproductbutton;

    @FXML
    public void initialize() {
        productcat.getItems().addAll();

    }

    public void switchDashboard(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("Dashboard.fxml");
    }

    ArrayList<Product> products = new ArrayList<>();

    @FXML
    public void saveproductbuttonClicked(ActionEvent event) {

        spinn.increment();
        spinn.decrement();
        int n = spinn.getValue();

        LocalDate date = datePicker.getValue();// to get calender on datepicker
        if (date != null) {
            System.out.println(date.toString());
        }


        switch (productcat.getValue()) {//here i used enum that i created in product class
            case Accessory:
                products.add(new Accessory(productname.getText(), productcat.getValue().toString(),
                        Double.parseDouble(pprID.getText()),
                        Integer.parseInt(stockquantityID.getText()), spinn.getValue(), suppliernameID.getText()));
                break;
            case Electronics:
                products.add(new Electronics(productname.getText(), productcat.getValue().toString(),
                        Double.parseDouble(pprID.getText()),
                        Integer.parseInt(stockquantityID.getText()), spinn.getValue(), suppliernameID.getText()));
                break;
            case Clothing:
                products.add(new Clothing(productname.getText(), productcat.getValue().toString(),
                        Double.parseDouble(pprID.getText()),
                        Integer.parseInt(stockquantityID.getText()), spinn.getValue(), suppliernameID.getText()));
                break;
            case Crockery:
                products.add(new Crockery(productname.getText(), productcat.getValue().toString(),
                        Double.parseDouble(pprID.getText()),
                        Integer.parseInt(stockquantityID.getText()), spinn.getValue(), suppliernameID.getText()));
                break;
            case Furniture:
                products.add(new Furniture(productname.getText(), productcat.getValue().toString(),
                        Double.parseDouble(pprID.getText()),
                        Integer.parseInt(stockquantityID.getText()), spinn.getValue(), suppliernameID.getText()));
                break;
            case Grocery:
                products.add(new Grocery(productname.getText(), productcat.getValue().toString(),
                        Double.parseDouble(pprID.getText()),
                        Integer.parseInt(stockquantityID.getText()), spinn.getValue(), suppliernameID.getText()));
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setResizable(false);
                alert.setContentText("Please select a product category.");
                alert.setHeaderText("No Category Selected");
                alert.setTitle("Category Selection");
                alert.showAndWait();

        }

        fileIO IO = new fileIO();
        for (Product n_product : products) {
            if (n_product instanceof Accessory ac) {//used in modern java reduce code
                IO.filewriter("Products.txt", ac.tofile());
            } else if (n_product instanceof Clothing cl) {
                IO.filewriter("Products.txt", cl.tofile());
            } else if (n_product instanceof Crockery cr) {
                IO.filewriter("Products.txt", cr.tofile());
            } else if (n_product instanceof Electronics el) {
                IO.filewriter("Products.txt", el.tofile());
            } else if (n_product instanceof Furniture fu) {
                IO.filewriter("Products.txt", fu.tofile());
            } else if (n_product instanceof Grocery gr) {
                IO.filewriter("Products.txt", gr.tofile());
            }
        }

        this.switchDashboard(event);
    }
}
