package model;

import java.util.ArrayList;

class Product implements Comparable<Product> {

    private final String productID;
    private String pdname;
    private String category;
    private double unitPrice;
    private int stockQuantity;
    private int reorderlevel;
    private String supplierName;
    ArrayList<StockObserver> Observer;
    static int count1, count2, count3 = 0;
    static int count4, count5, count6, count7 = 0;

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
        this.Observer = new ArrayList<>();
    }

    public String ID_Generator() {

        if (getClass().getSimpleName().equalsIgnoreCase("Crockery")) {
            return String.format("%-2s%03d", "CK", ++count1);
        }

        if (getClass().getSimpleName().equalsIgnoreCase("Accessory")) {
            return String.format("%-2s%03d", "AS", ++count2);
        }

        if (getClass().getSimpleName().equalsIgnoreCase("Product")) {
            return String.format("%-2s%03d", "PR", ++count3);
        }

        if (getClass().getSimpleName().equalsIgnoreCase("Electronics")) {
            return String.format("%-2s%03d", "EL", ++count4);
        }

        if (getClass().getSimpleName().equalsIgnoreCase("Furniture")) {
            return String.format("%-2s%03d", "FU", ++count5);
        }

        if (getClass().getSimpleName().equalsIgnoreCase("Clothing")) {
            return String.format("%-2s%03d", "CL", ++count6);
        }

        if (getClass().getSimpleName().equalsIgnoreCase("Grocery")) {
            return String.format("%-2s%03d", "GR", ++count7);
        }

        return "000";
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

    void addObserver(StockObserver other) {

        Observer.add(other);

    }

    void deductsales(int stocksaled) {

        stockQuantity -= stocksaled;

        System.out.println("Remaining Stock:" + stockQuantity);
        if (stockQuantity < 5) {
            notifyObserver();
        }

    }

    void notifyObserver() {

        for (StockObserver watcher : Observer) {
            watcher.Notify();
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

}
