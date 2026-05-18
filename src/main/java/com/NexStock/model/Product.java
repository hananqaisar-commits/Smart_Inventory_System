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
    private String brand;
    private String date;


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

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            System.out.println("INVALID");
        } else {
            this.stockQuantity = stockQuantity;
        }
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            System.out.println("INVALID");
        } else {
            this.unitPrice = unitPrice;
        }
    }

    public static void setByprice_ace(Comparator<Product> byprice_ace) {
        Product.byprice_ace = byprice_ace;
    }

    public static Comparator<Product> getBycat_ace() {
        return bycat_ace;
    }

    public static void setBycat_ace(Comparator<Product> bycat_ace) {
        Product.bycat_ace = bycat_ace;
    }

    public static Comparator<Product> getBycat_dec() {
        return bycat_dec;
    }

    public static void setBycat_dec(Comparator<Product> bycat_dec) {
        Product.bycat_dec = bycat_dec;
    }

    public static Comparator<Product> getByid_ace() {
        return byid_ace;
    }

    public static void setByid_ace(Comparator<Product> byid_ace) {
        Product.byid_ace = byid_ace;
    }

    public static Comparator<Product> getByid_dec() {
        return byid_dec;
    }

    public static void setByid_dec(Comparator<Product> byid_dec) {
        Product.byid_dec = byid_dec;
    }

    public static Comparator<Product> getByname_ace() {
        return byname_ace;
    }

    public static void setByname_ace(Comparator<Product> byname_ace) {
        Product.byname_ace = byname_ace;
    }

    public static Comparator<Product> getByname_dec() {
        return byname_dec;
    }

    public static void setByname_dec(Comparator<Product> byname_dec) {
        Product.byname_dec = byname_dec;
    }

    public static Comparator<Product> getByprice_ace() {
        return byprice_ace;
    }

    public static void setByprice_dec(Comparator<Product> byprice_dec) {
        Product.byprice_dec = byprice_dec;
    }

    public static Comparator<Product> getByprice_dec() {
        return byprice_dec;
    }

    public void setObserver(ArrayList<StockObserver> observer) {
        this.observer = observer;
    }

    public ArrayList<StockObserver> getObserver() {
        return observer;
    }


    public void setpdname(String pdname) {
        if (pdname == null || pdname.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.pdname = pdname;
        }
    }

    public void setReorderlevel(int reorderlevel) {
        if (reorderlevel < 0) {
            System.out.println("INVALID");
        } else {
            this.reorderlevel = reorderlevel;
        }
    }

    public int getReorderlevel() {
        return reorderlevel;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getBrand() {
        return brand;
    }

    public void setPdname(String pdname) {
        if (pdname == null || pdname.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.pdname = pdname;
        }
    }


    public String getDate() {
        return date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDate(String date) {
    }

    public String getCategory() {
        return category;
    }

    public String getPdname() {
        return pdname;
    }

    public String getProductID() {
        return productID;
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
    public static Comparator<Product> byname_ace = (a, b) -> a.getPdname().compareToIgnoreCase(b.getPdname());

    public static Comparator<Product> byprice_ace = (a, b) -> Double.compare(a.getUnitPrice(), b.getUnitPrice());

    public static Comparator<Product> byid_ace = (a, b) -> a.getProductID().compareToIgnoreCase(b.getProductID());

    public static Comparator<Product> bycat_ace = (a, b) -> a.getCategory().compareToIgnoreCase(b.getCategory());

    // Descending
    public static Comparator<Product> byname_dec = (a, b) -> b.getPdname().compareToIgnoreCase(a.getPdname());

    public static Comparator<Product> byprice_dec = (a, b) -> Double.compare(b.getUnitPrice(), a.getUnitPrice());

    public static Comparator<Product> byid_dec = (a, b) -> b.getProductID().compareToIgnoreCase(a.getProductID());

    public static Comparator<Product> bycat_dec = (a, b) -> b.getCategory().compareToIgnoreCase(a.getCategory());
}