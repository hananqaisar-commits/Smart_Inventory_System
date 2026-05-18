package com.NexStock.report;


import com.NexStock.FileHandler.fileIO;
import com.NexStock.model.Customer;
import com.NexStock.model.InvoiceItem;
import com.NexStock.model.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReportManager {


    private static final String BILLS_FILE = "bills.txt";

    fileIO fio = new fileIO();
    ReportFormatter formatter = new ReportFormatter();
    ArrayList<Transaction> allTransactions = new ArrayList<>();
    ArrayList<Customer> allCustomers = new ArrayList<>();

    public void saveBill(Transaction t, Customer c) {
        allTransactions.add(t);
        allCustomers.add(c);
        fio.filewriter(BILLS_FILE, formatter.formatReceipt(t, c));
        System.out.println("Bill saved: " + t.getInvoiceID());
    }

    public String getSingleBillReceipt(String invoiceID) {
        for (int i = 0; i < allTransactions.size(); i++) {
            if (allTransactions.get(i).getInvoiceID().equals(invoiceID)) {
                return formatter.formatReceipt(allTransactions.get(i), allCustomers.get(i));
            }
        }
        System.out.println("Invoice ID not found: " + invoiceID);
        return "";
    }

    public String generateDailyReport(LocalDate date) {
        ArrayList<Transaction> dailyList = new ArrayList<>();
        for (Transaction t : allTransactions) {
            if (t.getDateTime().toLocalDate().equals(date))
                dailyList.add(t);
        }
        String report = formatter.formatDailyReport(date, dailyList);
        fio.filewriter(BILLS_FILE, report);
        return report;
    }

    public String generateProductWiseReport() {
        Map<String, double[]> productData = new LinkedHashMap<>();
        for (Transaction t : allTransactions) {
            for (InvoiceItem item : t.getItems()) {
                String name = item.getProduct().getPdname();
                double revenue = item.getLineTotal();
                int qty = item.getQuantitySold();
                if (productData.containsKey(name)) {
                    productData.get(name)[0] += qty;
                    productData.get(name)[1] += revenue;
                } else {
                    productData.put(name, new double[]{qty, revenue});
                }
            }
        }
        String report = formatter.formatProductReport(productData);
        fio.filewriter(BILLS_FILE, report);
        return report;
    }

    public String generateAllHistoryReport() {
        String report = formatter.formatAllHistory(allTransactions, allCustomers);
        fio.filewriter(BILLS_FILE, report);
        return report;
    }

    public void loadBillsFromFile() {
        fio.billsReader(BILLS_FILE);
        System.out.println("Bills loaded: " + fio.readList_Bills.size());
    }


}
