module co.edu.uniquindio.poo.universidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens co.edu.uniquindio.poo.universidad to javafx.fxml;
    opens co.edu.uniquindio.poo.universidad.viewController to javafx.fxml;

    exports co.edu.uniquindio.poo.universidad;
}