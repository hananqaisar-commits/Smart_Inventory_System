package main.java.com.NexStock.products;

import com.NexStock.model.Product;

public class Electronics extends Product {

    private static int count1;

    public Electronics(String pdname, String category, double unitPrice, int stockQuantity, int reorderlevel,
                       String supplierName) {
        super(pdname, category, unitPrice, stockQuantity, reorderlevel, supplierName);
    }

    @Override
    public String ID_Generator() {
        return String.format("%-2s%03d", "EL", ++count1);
    }

}
