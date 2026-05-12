package com.NexStock.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public abstract class
Product implements Comparable<Product>, StockObserver {

    private final String productID;
    private String pdname;
    private String category;
    private double unitPrice;
    private int stockQuantity;
    private int reorderlevel;
    private String supplierName;
    ArrayList<StockObserver> observer = new ArrayList<>();
    static ArrayList<Product> list = new ArrayList<>();

    static int count4 = 0, count5 = 0, count6 = 0, count7 = 0;

    public Product(String pdname, String category, double unitPrice, int stockQuantity, int reorderlevel,
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
        if (stockQuantity < 0) {
            System.out.println("INVALID");

        } else
            this.stockQuantity = stockQuantity;

        if (reorderlevel < 0) {
            System.out.println("INVALID");

        } else
            this.reorderlevel = reorderlevel;

        this.supplierName = supplierName;
        Product.list.add(this);// access arraylist in static context
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
                    "Notification sent to " + stockObserver.getClass().getSimpleName() + " for product: "
                            + this.productID);
            stockObserver.Notify(); // har observer ko notify karo
        }
    }

    // equals Method
    // boolean equals(Product other){

    // if (other instanceof Product){

    // Product obj=(Product) other;

    // return this.pdname.equals(other.pdname);

    // }

    // }

    public int compareTo(Product other) {
        int result = this.pdname.compareToIgnoreCase(other.pdname);

        if (result == 0) {
            return Double.compare(this.getUnitPrice(), other.getUnitPrice());
        }

        return result;
    }

    // Ascending
    static Comparator<Product> byname_ace = (arg0, arg1) -> arg0.getPdname().compareToIgnoreCase(arg1.getPdname());
    static Comparator<Product> byprice_ace = (arg0, arg1) -> Double.compare(arg0.getUnitPrice(), arg1.getUnitPrice());
    static Comparator<Product> byid_ace = (arg0, arg1) -> arg0.getProductID().compareToIgnoreCase(arg1.getProductID());
    static Comparator<Product> bycat_ace = (arg0, arg1) -> arg0.getCategory().compareToIgnoreCase(arg1.getCategory());

    // Descending
    static Comparator<Product> byname_dec = (arg0, arg1) -> arg1.getPdname().compareToIgnoreCase(arg0.getPdname());
    static Comparator<Product> byprice_dec = (arg0, arg1) -> Double.compare(arg1.getUnitPrice(), arg0.getUnitPrice());
    static Comparator<Product> byid_dec = (arg0, arg1) -> arg1.getProductID().compareToIgnoreCase(arg0.getProductID());
    static Comparator<Product> bycat_dec = (arg0, arg1) -> arg1.getCategory().compareToIgnoreCase(arg0.getCategory());

}