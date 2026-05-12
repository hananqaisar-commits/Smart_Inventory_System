
package com.NexStock.model;

class InvoiceItem {

    Product product;
    private int quantitySold;
    private double lineTotal;

    public InvoiceItem(Product product, int quantitySold) {
        this.product = product;

        if (quantitySold <= 0) {
            System.out.println("Invalid");
        } else {
            this.quantitySold = quantitySold;
        }
        this.lineTotal = getLineTotal();
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public Product getProduct() {
        return product;
    }

    public double getLineTotal() {

        return quantitySold * product.getUnitPrice();

    }

}