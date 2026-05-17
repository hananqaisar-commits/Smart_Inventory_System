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

import java.io.IOException;
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
    private Spinner<Integer> spinn;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField suppliernameID;
    @FXML
    private Button saveproductbutton;
    @FXML
    private Button backButton;
    @FXML
    private Label errortext;


    public void initialize() {
        productcat.getItems().addAll(Product.productlist.values());//add all categories to dropbox
        SpinnerValueFactory<Integer> spinnervalue = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 11000);
        spinnervalue.setValue(1);
        spinn.setValueFactory(spinnervalue);
    }


    public void switchDashboard(ActionEvent event) {

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Sceneswitches.setStage(stage);
        Sceneswitches.now_switchin("Dashboard.fxml");


    }


    @FXML
    public void saveproductbuttonClicked(ActionEvent event) {

        ArrayList<Product> products = new ArrayList<>();
        LocalDate date = datePicker.getValue();// to get calender on datepicker
        if (date == null) {
            System.out.println("Select date");
            errortext.setText("Fill all boxes");
            return;
        }

        //imp to check box is empty or not
        if (productname.getText().trim().isEmpty() ||
                pprID.getText().trim().isEmpty() ||
                suppliernameID.getText().trim().isEmpty() ||
                productcat.getValue() == null) {
            errortext.setText("Fill all boxes");
            return;
        }

        double price;

        try {
            price = Double.parseDouble(pprID.getText().trim());

        } catch (NumberFormatException e) {
            errortext.setText("Price must be numbers.");
            return;
        }
        try {
            switch (productcat.getValue()) {// here i used enum (Enumuration) that i created in product class
                case Accessory:
                    products.add(new Accessory(productname.getText(), productcat.getValue().toString(),
                            price,
                            spinn.getValue(), suppliernameID.getText()));

                    break;
                case Electronics:

                    products.add(new Electronics(productname.getText(), productcat.getValue().toString(),
                            price,
                            spinn.getValue(), suppliernameID.getText()));
                    break;
                case Clothing:
                    products.add(new Clothing(productname.getText(), productcat.getValue().toString(),
                            price,
                            spinn.getValue(), suppliernameID.getText()));
                    break;
                case Crockery:
                    products.add(new Crockery(productname.getText(), productcat.getValue().toString(),
                            price,
                            spinn.getValue(), suppliernameID.getText()));
                    break;
                case Furniture:
                    products.add(new Furniture(productname.getText(), productcat.getValue().toString(),
                            price,
                            spinn.getValue(), suppliernameID.getText()));
                    break;
                case Grocery:
                    products.add(new Grocery(productname.getText(), productcat.getValue().toString(),
                            price,
                            spinn.getValue(), suppliernameID.getText()));
                    break;
                default:
                    System.out.println("Problem happen in switch statement of addProductcontroller");
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setResizable(false);
            alert.setContentText("Please select a product category.");
            alert.setHeaderText("No Category Selected");
            alert.setTitle("Category Selection");
            alert.showAndWait();
        }


        fileIO IO = new fileIO();
        boolean added = false;
        for (Product n_product : products) {
            if (n_product instanceof Accessory ac) {// used in modern java reduce code
                IO.filewriter("Products.txt", ac.tofile() + ", " + spinn.getValue() + ", " + date);
                added = true;
            } else if (n_product instanceof Clothing cl) {
                IO.filewriter("Products.txt", cl.tofile() + ", " + spinn.getValue() + ", " + date);
                added = true;
            } else if (n_product instanceof Crockery cr) {
                IO.filewriter("Products.txt", cr.tofile() + ", " + spinn.getValue() + ", " + date);
                added = true;
            } else if (n_product instanceof Electronics el) {
                IO.filewriter("Products.txt", el.tofile() + ", " + spinn.getValue() + ", " + date);
                added = true;
            } else if (n_product instanceof Furniture fu) {
                IO.filewriter("Products.txt", fu.tofile() + ", " + spinn.getValue() + ", " + date);
                added = true;
            } else if (n_product instanceof Grocery gr) {
                IO.filewriter("Products.txt", gr.tofile() + ", " + spinn.getValue() + ", " + date);

                added = true;
            }
            if (added) {
                System.out.println(n_product.getPdname() + " written to file Products");
                this.switchDashboard(event);
                break;
            }
        }
    }
}