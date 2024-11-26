module com.example.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.javafxproject to javafx.fxml;
    exports com.example.javafxproject;
    exports com.example.javafxproject.Controllers;
    opens com.example.javafxproject.Controllers to javafx.fxml;
}