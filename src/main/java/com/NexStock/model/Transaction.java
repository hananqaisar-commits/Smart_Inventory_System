package com.NexStock.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {

    private String invoiceID;
    ArrayList<InvoiceItem> items;
    private double taxAmount;
    private String paymentMethod;
    private LocalDateTime dateTime;
    private DiscountStrategy discount;
    static int count = 0;

    String InvoiceID_Generator() {
        return String.format("%-2s%s%s%03d", "IN-", dateTime, "-", ++count);

    }

    public Transaction(String invoiceID, double taxAmount, String paymentMethod, LocalDateTime dateTime,
                       DiscountStrategy discount) {
        this.invoiceID = InvoiceID_Generator();
        this.items = new ArrayList<>();
        this.taxAmount = taxAmount;
        this.paymentMethod = paymentMethod;
        this.dateTime = dateTime;

        if (discount != null) {
            this.discount = discount;
        } else {
            System.out.println("Invalid!");
        }
    }


    public String getInvoiceID() {
        return invoiceID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public ArrayList<InvoiceItem> getItems() {
        return items;
    }

    public double totalCompute() {
        double grandTotal = 0;
        double finalAmount = 0;
        for (InvoiceItem list : items) {

            grandTotal += list.getLineTotal();
        }
        finalAmount = (grandTotal + taxAmount) - discount.applydiscount(grandTotal);

        return finalAmount;
    }

}