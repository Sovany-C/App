module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens org.openjfx to javafx.fxml;

    exports org.openjfx;
    exports org.openjfx.Class;
    exports org.openjfx.Pane;
    exports org.openjfx.Controleur;
}
