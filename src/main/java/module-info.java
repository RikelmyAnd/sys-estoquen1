module org.sysestoquen1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.sysestoquen1 to javafx.fxml;
    exports org.sysestoquen1;
    exports org.sysestoquen1.principal;
    opens org.sysestoquen1.principal to javafx.fxml;
}