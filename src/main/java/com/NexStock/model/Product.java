package com.NexStock.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public abstract class Product implements Comparable<Product>, StockObserver {

    private final String productID;
    private String pdname;
    private String category;
    private double unitPrice;
    private int stockQuantity;
    private int reorderlevel;
    private String supplierName;

    ArrayList<StockObserver> observer = new ArrayList<>();
    static ArrayList<Product> list = new ArrayList<>();

    static int count1 = 0, count2 = 0, count3 = 0;
    static int count4 = 0, count5 = 0, count6 = 0, count7 = 0;

    public enum productlist {
        Accessory, Clothing, Crockery, Electronics, Furniture, Grocery
    }

    public Product(String pdname, String category, double unitPrice, int reorderlevel,
                   String supplierName) {

        if (pdname == null || pdname.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.pdname = pdname;
        }

        this.category = category;
        this.productID = ID_Generator();

        if (unitPrice > 0)
            this.unitPrice = unitPrice;
        else
            System.out.println("INVALID");


        if (reorderlevel < 0) {
            System.out.println("INVALID");
        } else {
            this.reorderlevel = reorderlevel;
        }

        this.supplierName = supplierName;
        Product.list.add(this);
    }

    // Methods, Setter & Getters
    public abstract String ID_Generator();

    public String getCategory() {
        return category;
    }

    public String getPdname() {
        return pdname;
    }

    public String getProductID() {
        return productID;
    }

    public int getReorderlevel() {
        return reorderlevel;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    void addobserver(StockObserver other) {
        observer.add(other);
    }

    void deductsales(int stocksaled) {
        stockQuantity -= stocksaled;
        System.out.println("Remaining Stock:" + stockQuantity);
        if (stockQuantity < 5) {
            Notify();
        }
    }

    @Override
    public void Notify() {
        for (StockObserver stockObserver : observer) {
            System.out.println(
                    "Notification sent to " + stockObserver.getClass().getSimpleName()
                            + " for product: " + this.productID);
            stockObserver.Notify();
        }
    }

    public int compareTo(Product other) {
        int result = this.pdname.compareToIgnoreCase(other.pdname);

        if (result == 0) {
            return Double.compare(this.getUnitPrice(), other.getUnitPrice());
        }

        return result;
    }

    // Ascending
    static Comparator<Product> byname_ace = (a, b) -> a.getPdname().compareToIgnoreCase(b.getPdname());

    static Comparator<Product> byprice_ace = (a, b) -> Double.compare(a.getUnitPrice(), b.getUnitPrice());

    static Comparator<Product> byid_ace = (a, b) -> a.getProductID().compareToIgnoreCase(b.getProductID());

    static Comparator<Product> bycat_ace = (a, b) -> a.getCategory().compareToIgnoreCase(b.getCategory());

    // Descending
    static Comparator<Product> byname_dec = (a, b) -> b.getPdname().compareToIgnoreCase(a.getPdname());

    static Comparator<Product> byprice_dec = (a, b) -> Double.compare(b.getUnitPrice(), a.getUnitPrice());

    static Comparator<Product> byid_dec = (a, b) -> b.getProductID().compareToIgnoreCase(a.getProductID());

    static Comparator<Product> bycat_dec = (a, b) -> b.getCategory().compareToIgnoreCase(a.getCategory());
}