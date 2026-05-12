package co.edu.uniquindio.poo.universidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader =
                new FXMLLoader(
                        App.class.getResource("juego.fxml")
                );
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/poo/universidad/styles/style.css").toExternalForm());
        stage.setTitle("Patrón Memento");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
