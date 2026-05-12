package co.edu.uniquindio.poo.universidad.controller;

import co.edu.uniquindio.poo.universidad.model.EstadoJuego;
import co.edu.uniquindio.poo.universidad.model.Gestor;
import co.edu.uniquindio.poo.universidad.model.Jugador;
import co.edu.uniquindio.poo.universidad.model.Memento;
import java.util.List;

public class JuegoController {

    private Jugador jugador;
    private final Gestor gestor;

    public JuegoController() {
        jugador = new Jugador();
        gestor = new Gestor();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int cantidadCheckpoints() {
        return gestor.cantidadCheckpoints();
    }

    public boolean checkpointsLlenos() {
        return gestor.estaLleno();
    }

    public void reemplazarCheckpoint() {
        gestor.eliminarMasViejo();
        gestor.guardarCheckpoint(jugador.guardar(gestor.generarNumeroCheckpoint()));
    }

    public void reiniciarJuego() {
        jugador = new Jugador();
        gestor.limpiarCheckpoints();
    }

    public void subirNivel() {
        jugador.subirNivel();
    }

    public void perderVida() {
        jugador.perderVida();
    }

    public void ganarMonedas() {
        jugador.ganarMonedas(10);
    }

    public String guardarCheckpoint() {
        if (jugador.getEstadoJuego() == EstadoJuego.GAME_OVER) {
            return "No puedes guardar en GAME OVER";
        }
        gestor.guardarCheckpoint(jugador.guardar(gestor.generarNumeroCheckpoint()));
        return "Checkpoint guardado";
    }

    public String restaurarCheckpoint(int indice) {
        Memento checkpoint = gestor.obtenerCheckpoint(indice);
        if (checkpoint == null) {
            return "Checkpoint invalido";
        }
        jugador.restaurar(checkpoint);
        return "Checkpoint restaurado";
    }

    public List<Memento> obtenerCheckpoints() {
        return gestor.getCheckpoints();
    }
}