package com.NexStock.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.NexStock.FileHandler.fileIO;
import com.NexStock.model.Product;
import javafx.stage.Stage;

public class categorycontroller {

    @FXML
    private Label total_Products;
    @FXML
    private Label instock;
    @FXML
    private Label lowstock;
    @FXML
    private Label totalstock_Price;
    @FXML
    private Label totalstock_Price1;
    @FXML
    private Label instock_qty;
    @FXML
    private Label lowstock_qty;
    @FXML
    private Label outstock_qty;

    @FXML
    private Button allbutton;
    @FXML
    private Button abutton;
    @FXML
    private Button gbutton;
    @FXML
    private Button fbutton;
    @FXML
    private Button cbutton;
    @FXML
    private Button crbutton;
    @FXML
    private Button ebutton;

    @FXML
    private Button backButton;

    fileIO IO = new fileIO();

    public void initialize() {
        IO.productread("Products.txt");
        countProducts();//count all products at start of code
        Allbutton();
    }

    @FXML
    public void backbutton(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.close();
    }

    private int e, cr, cl, a, f, g, total_count = 0;
    private int e_instock, cr_instock, cl_instock, a_instock, f_instock, g_instock, total_count_instock = 0;
    private int e_instock_qty, cr_instock_qty, cl_instock_qty, a_instock_qty, f_instock_qty, g_instock_qty,
            total_count_instock_qty = 0;
    private int e_reorder, cr_reorder, cl_reorder, a_reorder, f_reorder, g_reorder, total_count_reorder = 0;
    private double e_price, cr_price, clprice, a_price, f_price, g_price, total_count_price = 0.0;
    private int e_outstock, cr_outstock, cl_outstock, a_outstock, f_outstock, g_outstock, total_count_outstock = 0;
    private int e_outstock_qty, cr_outstock_qty, cl_outstock_qty, a_outstock_qty, f_outstock_qty, g_outstock_qty,
            total_count_outstock_qty = 0;
    private int e_lowstock, cr_lowstock, cl_lowstock, a_lowstock, f_lowstock, g_lowstock, total_count_lowstock = 0;
    private int e_lowstock_qty, cr_lowstock_qty, cl_lowstock_qty, a_lowstock_qty, f_lowstock_qty, g_lowstock_qty,
            total_count_lowstock_qty = 0;

    void countProducts() {

        e = cr = cl = a = f = g = 0;
        e_instock = cr_instock = cl_instock = a_instock = f_instock = g_instock = 0;
        e_instock_qty = cr_instock_qty = cl_instock_qty = a_instock_qty = f_instock_qty = g_instock_qty = 0;
        e_reorder = cr_reorder = cl_reorder = a_reorder = f_reorder = g_reorder = 0;
        e_price = cr_price = clprice = a_price = f_price = g_price = 0.0;
        e_outstock = cr_outstock = cl_outstock = a_outstock = f_outstock = g_outstock = 0;
        e_outstock_qty = cr_outstock_qty = cl_outstock_qty = a_outstock_qty = f_outstock_qty = g_outstock_qty = 0;
        e_lowstock = cr_lowstock = cl_lowstock = a_lowstock = f_lowstock = g_lowstock = 0;
        e_lowstock_qty = cr_lowstock_qty = cl_lowstock_qty = a_lowstock_qty = f_lowstock_qty = g_lowstock_qty = 0;

        for (Product countable : IO.readList_Products) {
            if ("Electronics".equals(countable.getCategory())) {
                e += countable.getStockQuantity();
                if (countable.getStockQuantity() > 0) {
                    ++e_instock;
                    e_instock_qty += countable.getStockQuantity();
                } else {
                    ++e_outstock;
                    e_outstock_qty += countable.getStockQuantity();
                }
                if (countable.getStockQuantity() <= countable.getReorderlevel()) {
                    ++e_lowstock;
                    e_lowstock_qty += countable.getStockQuantity();
                }
                e_price += countable.getUnitPrice() * countable.getStockQuantity();
                e_reorder += countable.getReorderlevel();

            } else if ("Clothing".equals(countable.getCategory())) {
                cl += countable.getStockQuantity();
                if (countable.getStockQuantity() > 0) {
                    ++cl_instock;
                    cl_instock_qty += countable.getStockQuantity();
                } else {
                    ++cl_outstock;
                    cl_outstock_qty += countable.getStockQuantity();
                }
                if (countable.getStockQuantity() <= countable.getReorderlevel()) {
                    ++cl_lowstock;
                    cl_lowstock_qty += countable.getStockQuantity();
                }
                clprice += countable.getUnitPrice() * countable.getStockQuantity();
                cl_reorder += countable.getReorderlevel();
            } else if ("Crockery".equals(countable.getCategory())) {
                cr += countable.getStockQuantity();
                if (countable.getStockQuantity() > 0) {
                    ++cr_instock;
                    cr_instock_qty += countable.getStockQuantity();
                } else {
                    ++cr_outstock;
                    cr_outstock_qty += countable.getStockQuantity();
                }
                if (countable.getStockQuantity() <= countable.getReorderlevel()) {
                    ++cr_lowstock;
                    cr_lowstock_qty += countable.getStockQuantity();
                }
                cr_price += countable.getUnitPrice() * countable.getStockQuantity();
                cr_reorder += countable.getReorderlevel();
            } else if ("Furniture".equals(countable.getCategory())) {
                f += countable.getStockQuantity();
                if (countable.getStockQuantity() > 0) {
                    ++f_instock;
                    f_instock_qty += countable.getStockQuantity();
                } else {
                    ++f_outstock;
                    f_outstock_qty += countable.getStockQuantity();
                }
                if (countable.getStockQuantity() <= countable.getReorderlevel()) {
                    ++f_lowstock;
                    f_lowstock_qty += countable.getStockQuantity();
                }
                f_price += countable.getUnitPrice() * countable.getStockQuantity();
                f_reorder += countable.getReorderlevel();
            } else if ("Accessory".equals(countable.getCategory())) {
                a += countable.getStockQuantity();
                if (countable.getStockQuantity() > 0) {
                    ++a_instock;
                    a_instock_qty += countable.getStockQuantity();
                } else {
                    ++a_outstock;
                    a_outstock_qty += countable.getStockQuantity();
                }

                if (countable.getStockQuantity() <= countable.getReorderlevel()) {
                    ++a_lowstock;
                    a_lowstock_qty += countable.getStockQuantity();
                }

                a_price += countable.getUnitPrice() * countable.getStockQuantity();
                a_reorder += countable.getReorderlevel();
            } else if ("Grocery".equals(countable.getCategory())) {

                g += countable.getStockQuantity();

                if (countable.getStockQuantity() > 0) {
                    ++g_instock;
                    g_instock_qty += countable.getStockQuantity();
                } else {
                    ++g_outstock;
                    g_outstock_qty += countable.getStockQuantity();
                }
                if (countable.getStockQuantity() <= countable.getReorderlevel()) {
                    ++g_lowstock;
                    g_lowstock_qty += countable.getStockQuantity();
                }
                g_price += countable.getUnitPrice() * countable.getStockQuantity();
                g_reorder += countable.getReorderlevel();
            }
        }

        total_count = e + cl + cr + f + a + g;
        total_count_price = e_price + clprice + cr_price + f_price + a_price + g_price;
        total_count_reorder = e_reorder + cl_reorder + cr_reorder + f_reorder + a_reorder + g_reorder;
        total_count_instock = a_instock + cr_instock + cl_instock + f_instock + g_instock + e_instock;
        total_count_outstock = e_outstock + cr_outstock + cl_outstock + a_outstock + f_outstock + g_outstock;
        total_count_lowstock = e_lowstock + cr_lowstock + cl_lowstock + a_lowstock + f_lowstock + g_lowstock;
        total_count_lowstock_qty = e_lowstock_qty + cr_lowstock_qty + cl_lowstock_qty + a_lowstock_qty
                + f_lowstock_qty + g_lowstock_qty;
        total_count_instock_qty = e_instock_qty + cr_instock_qty + cl_instock_qty + a_instock_qty + f_instock_qty
                + g_instock_qty;
        total_count_outstock_qty = e_outstock_qty + cr_outstock_qty + cl_outstock_qty + a_outstock_qty + f_outstock_qty
                + g_outstock_qty;

    }

    @FXML
    public void Allbutton() {
        total_Products.setText(String.valueOf(total_count));
        instock.setText(String.valueOf(total_count_instock));
        lowstock.setText(String.valueOf(total_count_lowstock));
        totalstock_Price.setText(String.valueOf(total_count_outstock));
        totalstock_Price1.setText(String.valueOf(total_count_price));
        instock_qty.setText(String.valueOf(total_count_instock_qty));
        lowstock_qty.setText(String.valueOf(total_count_lowstock_qty));
        outstock_qty.setText(String.valueOf(total_count_outstock_qty));
    }

    @FXML
    public void Abutton() {
        total_Products.setText(String.valueOf(a));
        instock.setText(String.valueOf(a_instock));
        lowstock.setText(String.valueOf(a_lowstock));
        totalstock_Price.setText(String.valueOf(a_outstock));
        totalstock_Price1.setText(String.valueOf(a_price));
        instock_qty.setText(String.valueOf(a_instock_qty));
        lowstock_qty.setText(String.valueOf(a_lowstock_qty));
        outstock_qty.setText(String.valueOf(a_outstock_qty));
    }

    @FXML
    public void Gbuttonn() {
        total_Products.setText(String.valueOf(g));
        instock.setText(String.valueOf(g_instock));
        lowstock.setText(String.valueOf(g_lowstock));
        totalstock_Price.setText(String.valueOf(g_outstock));
        totalstock_Price1.setText(String.valueOf(g_price));
        instock_qty.setText(String.valueOf(g_instock_qty));
        lowstock_qty.setText(String.valueOf(g_lowstock_qty));
        outstock_qty.setText(String.valueOf(g_outstock_qty));
    }

    @FXML
    public void Fbutton() {
        total_Products.setText(String.valueOf(f));
        instock.setText(String.valueOf(f_instock));
        lowstock.setText(String.valueOf(f_lowstock));
        totalstock_Price.setText(String.valueOf(f_outstock));
        totalstock_Price1.setText(String.valueOf(f_price));
        instock_qty.setText(String.valueOf(f_instock_qty));
        lowstock_qty.setText(String.valueOf(f_lowstock_qty));
        outstock_qty.setText(String.valueOf(f_outstock_qty));
    }

    @FXML
    public void Cbutton() {
        total_Products.setText(String.valueOf(cl));
        instock.setText(String.valueOf(cl_instock));
        lowstock.setText(String.valueOf(cl_lowstock));
        totalstock_Price.setText(String.valueOf(cl_outstock));
        totalstock_Price1.setText(String.valueOf(clprice));
        instock_qty.setText(String.valueOf(cl_instock_qty));
        lowstock_qty.setText(String.valueOf(cl_lowstock_qty));
        outstock_qty.setText(String.valueOf(cl_outstock_qty));
    }

    @FXML
    public void CRbutton() {
        total_Products.setText(String.valueOf(cr));
        instock.setText(String.valueOf(cr_instock));
        lowstock.setText(String.valueOf(cr_lowstock));
        totalstock_Price.setText(String.valueOf(cr_outstock));
        totalstock_Price1.setText(String.valueOf(cr_price));
        instock_qty.setText(String.valueOf(cr_instock_qty));
        lowstock_qty.setText(String.valueOf(cr_lowstock_qty));
        outstock_qty.setText(String.valueOf(cr_outstock_qty));
    }

    @FXML
    public void Ebutton() {
        total_Products.setText(String.valueOf(e));
        instock.setText(String.valueOf(e_instock));
        lowstock.setText(String.valueOf(e_lowstock));
        totalstock_Price.setText(String.valueOf(e_outstock));
        totalstock_Price1.setText(String.valueOf(e_price));
        instock_qty.setText(String.valueOf(e_instock_qty));
        lowstock_qty.setText(String.valueOf(e_lowstock_qty));
        outstock_qty.setText(String.valueOf(e_outstock_qty));
    }
}