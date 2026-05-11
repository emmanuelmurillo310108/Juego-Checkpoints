package co.edu.uniquindio.poo.universidad.controller;

import co.edu.uniquindio.poo.universidad.model.Gestor;
import co.edu.uniquindio.poo.universidad.model.Jugador;
import co.edu.uniquindio.poo.universidad.model.Memento;

public class JuegoController {

    private Jugador jugador;
    private Gestor gestor;

    public JuegoController() {

        jugador = new Jugador(1, 3, 0);

        gestor = new Gestor();
    }

    public void subirNivel() {
        jugador.subirNivel();
    }

    public void perderVida() {
        jugador.perderVida();
    }

    public void ganarMonedas(int cantidad) {
        jugador.ganarMonedas(cantidad);
    }

    public void guardarCheckpoint() {

        Memento checkpoint = jugador.guardar();

        gestor.guardarCheckpoint(checkpoint);
    }

    public void restaurarCheckpoint() {

        Memento checkpoint =
                gestor.restaurarUltimoCheckpoint();

        if (checkpoint != null) {
            jugador.restaurar(checkpoint);
        }
    }

    public String obtenerEstadoJugador() {
        return jugador.toString();
    }

    public int cantidadCheckpoints() {
        return gestor.getCheckpoints().size();
    }

    public Jugador getJugador() {
        return jugador;
    }
}
