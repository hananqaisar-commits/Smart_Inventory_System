module src.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.demo to javafx.fxml;
    exports src.demo;
}