package co.edu.uniquindio.poo.universidad.viewController;

import co.edu.uniquindio.poo.universidad.controller.JuegoController;
import co.edu.uniquindio.poo.universidad.model.Memento;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class VistaController {

    @FXML
    private Label lblNivel;
    @FXML
    private Label lblVidas;
    @FXML
    private Label lblMonedas;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblMensaje;
    @FXML
    private ListView<Memento> listCheckpoints;
    @FXML
    private ImageView imgGif;

    private JuegoController juegoController;

    @FXML
    public void initialize() {
        juegoController = new JuegoController();
        actualizarVista();
        actualizarHistorial();
        Rectangle clip = new Rectangle(
                180,
                100
        );
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imgGif.setClip(clip);
    }

    @FXML
    private void subirNivel() {
        juegoController.subirNivel();
        actualizarVista();
    }

    @FXML
    private void perderVida() {
        juegoController.perderVida();
        actualizarVista();
    }

    @FXML
    private void ganarMonedas() {
        juegoController.ganarMonedas();
        actualizarVista();
    }

    @FXML
    private void guardarCheckpoint() {
        if(juegoController.checkpointsLlenos()) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Limite de checkpoints");
            alerta.setHeaderText("Se alcanzo el limite de checkpoints");
            alerta.setContentText("Se eliminara el checkpoint " + "mas antiguo.\n" + "¿Continuar?");
            ButtonType resultado = alerta.showAndWait().orElse(ButtonType.CANCEL);
            if(resultado != ButtonType.OK) {lblMensaje.setText("Guardado cancelado");
                return;
            }
            juegoController.reemplazarCheckpoint();
        }
        else {
            String mensaje = juegoController.guardarCheckpoint();
            lblMensaje.setText(mensaje);
        }
        actualizarHistorial();
        actualizarVista();
    }

    @FXML
    private void restaurarCheckpoint() {
        int indiceSeleccionado = listCheckpoints.getSelectionModel().getSelectedIndex();
        if(indiceSeleccionado == -1) {
            lblMensaje.setText("Selecciona un checkpoint");
            return;
        }
        String mensaje = juegoController.restaurarCheckpoint(indiceSeleccionado);
        lblMensaje.setText(mensaje);
        actualizarVista();
        actualizarHistorial();
    }

    @FXML
    private void reiniciarJuego() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Reiniciar juego");
        alerta.setHeaderText("Se perdera todo el progreso");
        alerta.setContentText("¿Desea reiniciar la partida?");
        ButtonType resultado = alerta.showAndWait().orElse(ButtonType.CANCEL);
        if (resultado != ButtonType.OK) {
            lblMensaje.setText("Reinicio cancelado");
            return;
        }
        juegoController.reiniciarJuego();
        lblMensaje.setText("Juego reiniciado"
        );
        actualizarVista();
        actualizarHistorial();
    }

    private void actualizarVista() {
        lblNivel.setText("Nivel: " + juegoController.getJugador().getNivel());
        lblVidas.setText("Vidas: " + juegoController.getJugador().getVidas());
        lblMonedas.setText("Monedas: " + juegoController.getJugador().getMonedas());
        lblEstado.setText(juegoController.getJugador().getEstadoJuego().toString());
    }

    private void actualizarHistorial() {
        listCheckpoints.getItems().setAll(juegoController.obtenerCheckpoints());
    }
}