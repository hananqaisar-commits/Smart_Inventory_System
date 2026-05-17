package com.NexStock.products;

import com.NexStock.model.Product;

public class Grocery extends Product {

    private static int count2;

    public Grocery(String pdname, String category, double unitPrice, int reorderlevel,
                   String supplierName) {
        super(pdname, category, unitPrice, reorderlevel, supplierName);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "GR", ++count2);
    }

    public String tofile() {
        return this.ID_Generator()
                + (", Grocery: " + this.getPdname() + ", " + this.getCategory() + ", " + this.getUnitPrice() + ", "
                + ", " + this.getReorderlevel() + ", " + this.getSupplierName());
    }

}
