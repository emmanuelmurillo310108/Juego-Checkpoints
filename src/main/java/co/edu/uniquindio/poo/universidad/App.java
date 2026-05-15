package co.edu.uniquindio.poo.universidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Font.loadFont(
                getClass().getResourceAsStream("/co/edu/uniquindio/poo/universidad/fonts/PressStart2P-Regular.ttf"),
                14
        );
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
