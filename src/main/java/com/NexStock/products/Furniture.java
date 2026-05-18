package com.NexStock.products;

import com.NexStock.model.Product;

public class Furniture extends Product {

    private static int count5;

    public Furniture(String pdname, String category, double unitPrice, int reorderlevel,
                     String supplierName) {
        super(pdname, category, unitPrice, reorderlevel, supplierName);
    }

    public Furniture(String ID, String name, String category, double price, String brand, int stock, String supplier,
                     int reorderlevel, String date) {
        super(name, category, price, stock, supplier);
        setStockQuantity(stock);
        setReorderlevel(reorderlevel);
        setDate(date);
        setBrand(brand);
    }

    @Override
    public void setDate(String date) {
        super.setDate(date);
    }

    @Override
    public void setBrand(String brand) {
        super.setBrand(brand);
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public String getPdname() {
        return super.getPdname();
    }

    @Override
    public double getUnitPrice() {
        return super.getUnitPrice();
    }

    @Override
    public int getReorderlevel() {
        return super.getReorderlevel();
    }

    @Override
    public String getSupplierName() {
        return super.getSupplierName();
    }

    @Override
    public int getStockQuantity() {
        return super.getStockQuantity();
    }

    @Override
    public String getCategory() {
        return super.getCategory();
    }

    @Override
    public String getProductID() {
        return super.getProductID();
    }

    @Override
    public void setStockQuantity(int stockQuantity) {
        super.setStockQuantity(stockQuantity);
    }

    @Override
    public void setUnitPrice(double unitPrice) {
        super.setUnitPrice(unitPrice);
    }

    @Override
    public void setReorderlevel(int reorderlevel) {
        super.setReorderlevel(reorderlevel);
    }

    @Override
    public void setSupplierName(String supplierName) {
        super.setSupplierName(supplierName);
    }

    public void setPdname(String pdname) {
        super.setPdname(pdname);
    }


    public void setCategory(String category) {
        super.setCategory(category);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "FR", ++count5);
    }

    public String toFile() {
        return String.format(
                "\n%s, %s, %s, %.1f, %s, %d, %s, %d, %s",
                this.ID_Generator(),
                this.getPdname(),
                this.getCategory(),
                this.getUnitPrice(),
                this.getBrand(),
                this.getStockQuantity(),
                this.getSupplierName(),
                this.getReorderlevel(),
                this.getDate());
    }
}
