module com.example.chessgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.chessgui to javafx.fxml;
    exports com.example.chessgui;
}