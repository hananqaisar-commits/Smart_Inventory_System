package com.NexStock.products;

import com.NexStock.model.Product;

public class Furniture extends Product {

    private static int count5;

    public Furniture(String pdname, String category, double unitPrice, int stockQuantity, int reorderlevel,
                     String supplierName) {
        super(pdname, category, unitPrice, stockQuantity, reorderlevel, supplierName);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "FU", ++count5);
    }

}
