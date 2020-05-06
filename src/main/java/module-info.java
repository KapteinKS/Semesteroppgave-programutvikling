module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    opens org.example.componentClasses to javafx.base;
    exports org.example;
}