package com.NexStock.products;

import com.NexStock.model.Product;

public class Clothing extends Product {

    private static int count6;

    public Clothing(String pdname, String category, double unitPrice, int stockQuantity, int reorderlevel,
            String supplierName) {
        super(pdname, category, unitPrice, stockQuantity, reorderlevel, supplierName);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "CL", ++count6);
    }

    public String tofile() {
        return this.ID_Generator()
                + (", Clothing: " + this.getPdname() + ", " + this.getCategory() + ", " + this.getUnitPrice() + ", "
                        + this.getStockQuantity() + ", " + this.getReorderlevel() + ", " + this.getSupplierName());
    }

}
