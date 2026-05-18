package com.NexStock.controller;

import com.NexStock.report.ReportManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.time.LocalDate;

public class ReportController {

    @FXML
    private TextField invoiceIDField;
    @FXML
    private Button backID;
    @FXML
    private Button btnSingleBill;

    @FXML
    private Button btnDailyReport;

    @FXML
    private Button btnProductWise;

    @FXML
    private Button btnAllHistory;

    @FXML
    private Button btnGenerate;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea reportArea;


    ReportManager manager = new ReportManager();
    private String SelectedBtn;

    @FXML
    public void initialize() {
        datePicker.setValue(LocalDate.now());
        reportArea.setText("");
        reportArea.setEditable(false);
        btnSingleBill.setOnAction(e -> handleSingleBill());
        btnDailyReport.setOnAction(e -> handleDailyReport());
        btnProductWise.setOnAction(e -> handleProductWise());
        btnAllHistory.setOnAction(e -> handleAllHistory());
        btnGenerate.setOnAction(e -> handleGenerate());
    }

    public void handleSingleBill() {
        SelectedBtn = "Single";
    }

    public void handleDailyReport() {
        SelectedBtn = "DailyReport";
    }

    public void handleProductWise() {
        SelectedBtn = "ProductWise";
    }


    public void handleAllHistory() {
        SelectedBtn = "AllHistory";
    }


    public void handleGenerate() {

        if (SelectedBtn == null) {
            reportArea.setText("Please select a report type  first!");
            return;
        }

        if (SelectedBtn.equals("Single")) {
            if (invoiceIDField.getText() == null || invoiceIDField.getText().trim().isEmpty()) {
                reportArea.setText("Please Enter Invoice ID!");
                return;
            }
        }
        if (SelectedBtn.equals("DailyReport")) {
            if (datePicker.getValue() == null) {
                reportArea.setText("Please select a Date!");
                return;
            }
        }

        if (SelectedBtn.equals("Single")) {
            String receipt = manager.getSingleBillReceipt(invoiceIDField.getText());
            reportArea.setText(receipt);
        } else if (SelectedBtn.equals("DailyReport")) {
            String report = manager.generateDailyReport(datePicker.getValue());
            reportArea.setText(report);
        } else if
        (SelectedBtn.equals("ProductWise")) {
            String report = manager.generateProductWiseReport();
            reportArea.setText(report);
        } else if
        (SelectedBtn.equals("AllHistory")) {
            String report = manager.generateAllHistoryReport();
            reportArea.setText(report);
        }


    }

    @FXML
    public void back(ActionEvent a) {
        Stage stage = (Stage) ((Button) a.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.close();
    }
}