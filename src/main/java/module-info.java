module com.temperatureconvertion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.temperatureconvertion to javafx.fxml;
    exports com.temperatureconvertion;
}