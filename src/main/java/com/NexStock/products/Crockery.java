
package com.NexStock.products;

import com.NexStock.model.Product;

public class Crockery extends Product {

    private static int count1;

    public Crockery(String pdname, String category, double unitPrice, int reorderlevel,
                    String supplierName) {
        super(pdname, category, unitPrice, reorderlevel, supplierName);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "CR", ++count1);
    }

    public String tofile() {
        return this.ID_Generator()
                + (", Crockery: " + this.getPdname() + ", " + this.getCategory() + ", " + this.getUnitPrice() + ", "
                + ", " + this.getReorderlevel() + ", " + this.getSupplierName());
    }
}