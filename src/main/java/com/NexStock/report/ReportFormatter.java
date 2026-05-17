package com.NexStock.report;

import com.NexStock.model.Customer;
import com.NexStock.model.InvoiceItem;
import com.NexStock.model.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ReportFormatter {

    String formatReceipt(Transaction t, Customer c) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("           NexStock - RECEIPT             \n");
        sb.append("==========================================\n");
        sb.append(String.format("Invoice ID  : %s%n", t.getInvoiceID()));
        sb.append(String.format("Date & Time : %s%n", t.getDateTime()));
        sb.append(String.format("Customer    : %s%n", c.getCustomerName()));
        sb.append(String.format("Phone       : %s%n", c.getPhoneNo()));
        sb.append(String.format("Payment     : %s%n", t.getPaymentMethod()));
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-20s %5s %8s %10s%n", "Product", "Qty", "Price", "Total"));
        sb.append("------------------------------------------\n");
        for (InvoiceItem item : t.getItems()) {
            sb.append(String.format("%-20s %5d %8.2f %10.2f%n",
                    item.getProduct().getPdname(),
                    item.getQuantitySold(),
                    item.getProduct().getUnitPrice(),
                    item.getLineTotal()));
        }
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-20s %25.2f%n", "Tax:", t.getTaxAmount()));
        sb.append(String.format("%-20s %25.2f%n", "GRAND TOTAL:", t.totalCompute()));
        sb.append("==========================================\n");
        sb.append("       Thank you for shopping!            \n");
        sb.append("==========================================\n");
        return sb.toString();
    }

    String formatDailyReport(LocalDate date, List<Transaction> transactions) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("         NexStock - DAILY REPORT          \n");
        sb.append("==========================================\n");
        sb.append(String.format("Date        : %s%n", date));
        sb.append(String.format("Total Bills : %d%n", transactions.size()));
        sb.append("------------------------------------------\n");
        double totalRevenue = 0;
        int billNo = 1;
        for (Transaction t : transactions) {
            double billTotal = t.totalCompute();
            sb.append(String.format("%d. Invoice: %-20s  Total: %.2f%n",
                    billNo++, t.getInvoiceID(), billTotal));
            totalRevenue += billTotal;
        }
        sb.append("------------------------------------------\n");
        sb.append(String.format("TOTAL REVENUE : %.2f PKR%n", totalRevenue));
        sb.append("==========================================\n");
        return sb.toString();
    }

    String formatProductReport(Map<String, double[]> productData) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("      NexStock - PRODUCT-WISE REPORT      \n");
        sb.append("==========================================\n");
        sb.append(String.format("%-22s %8s %12s%n", "Product", "Qty Sold", "Revenue"));
        sb.append("------------------------------------------\n");
        double grandTotal = 0;
        for (Map.Entry<String, double[]> entry : productData.entrySet()) {
            String productName = entry.getKey();
            int qtySold        = (int) entry.getValue()[0];
            double revenue     = entry.getValue()[1];
            grandTotal        += revenue;
            sb.append(String.format("%-22s %8d %12.2f%n", productName, qtySold, revenue));
        }
        sb.append("------------------------------------------\n");
        sb.append(String.format("%-22s %8s %12.2f%n", "TOTAL REVENUE", "", grandTotal));
        sb.append("==========================================\n");
        return sb.toString();
    }

    String formatAllHistory(List<Transaction> allTransactions, List<Customer> allCustomers) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("       NexStock - ALL BILLS HISTORY       \n");
        sb.append("==========================================\n");
        if (allTransactions.isEmpty()) {
            sb.append("No records found.\n");
        } else {
            for (int i = 0; i < allTransactions.size(); i++) {
                Transaction t   = allTransactions.get(i);
                Customer c      = (i < allCustomers.size()) ? allCustomers.get(i) : null;
                String custName = (c != null) ? c.getCustomerName() : "Unknown";
                sb.append(String.format("Invoice: %-20s | Customer: %-15s | Total: %.2f | Date: %s%n",
                        t.getInvoiceID(), custName, t.totalCompute(), t.getDateTime()));
            }
        }
        sb.append("==========================================\n");
        sb.append(String.format("Total Transactions: %d%n", allTransactions.size()));
        sb.append("==========================================\n");
        return sb.toString();
    }
}
