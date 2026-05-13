package com.NexStock.controller;


import com.NexStock.model.Product;
import com.NexStock.products.Electronics;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class addProductcontroller {


    @FXML
    private Label addproductlabel;
    @FXML
    private TextField productname;

    @FXML
    private ChoiceBox<Product.productlist> productcat;

    @FXML
    private TextField productcatText;

    @FXML
    private TextField suppliernametext;

    @FXML
    private TextField ppr;

    @FXML
    private TextField productid;

    @FXML
    private TextField stkquantity;

    @FXML
    private Spinner<Integer> spinn;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button saveproductbutton;

    public void createbutton() {
        Product p1 = new Electronics(productname.getText(), productcatText.getText(), Double.parseDouble(ppr.getText()), Integer.parseInt(stkquantity.getText()), 20, suppliernametext.getText());


        @FXML
        public void initialize() {
            try {
                productcat.getItems().addAll(productcat.getValue());//for drop down
                int n = spinn.getValue();//for save  increment or decrement in spinner
                LocalDate date = datePicker.getValue();
                System.out.println(date.toString());
            } finally {
                System.out.println();
            }
    }
}