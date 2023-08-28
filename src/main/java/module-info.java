module cs440.arosenberg {
    requires javafx.controls;
    requires javafx.fxml;

    opens cs440.arosenberg to javafx.fxml;
    exports cs440.arosenberg;
}
