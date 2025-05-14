module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens org.openjfx to javafx.fxml;

    exports org.openjfx;
    exports org.openjfx.Model;
    exports org.openjfx.Pane;
    exports org.openjfx.Controleur;
}
