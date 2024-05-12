module com.mycompany.routinegenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.routinegenerator to javafx.fxml;
    exports com.mycompany.routinegenerator;
}
