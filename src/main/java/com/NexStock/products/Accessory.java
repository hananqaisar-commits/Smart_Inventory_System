package com.NexStock.products;

import com.NexStock.model.Product;

public class Accessory extends Product {

    private static int count2;

    public Accessory(String pdname, String category, double unitPrice, int stockQuantity, int reorderlevel,
            String supplierName) {
        super(pdname, category, unitPrice, stockQuantity, reorderlevel, supplierName);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "AC", ++count2);
    }

    public String tofile() {
        return this.ID_Generator()
                + (", Accessory: " + this.getPdname() + ", " + this.getCategory() + ", " + this.getUnitPrice() + ", "
                        + this.getStockQuantity() + ", " + this.getReorderlevel() + ", " + this.getSupplierName());
    }

}
