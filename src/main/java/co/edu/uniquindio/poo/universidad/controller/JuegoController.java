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
    /*
     * Get de jugador para acceder a su estado desde la vista, como nivel, vidas, monedas, etc.
     * @return el jugador actual del juego
     */
    public Jugador getJugador() {
        return jugador;
    }

    /*
     * Get de la cantidad de checkpoints guardados en el gestor, para mostrarlo en la vista.
     * @return la cantidad de checkpoints actualmente almacenados
     */
    public int cantidadCheckpoints() {
        return gestor.cantidadCheckpoints();
    }

    /*
     * Verifica si el gestor de checkpoints ha alcanzado su capacidad máxima.
     * @return true si el gestor está lleno, false en caso contrario
     */
    public boolean checkpointsLlenos() {
        return gestor.estaLleno();
    }

    /*
     * Reemplaza el checkpoint más antiguo en el gestor con el estado actual del jugador.
     * Si el gestor no está lleno, simplemente guarda un nuevo checkpoint.
     */
    public void reemplazarCheckpoint() {
        gestor.eliminarMasViejo();
        gestor.guardarCheckpoint(jugador.guardar(gestor.generarNumeroCheckpoint()));
    }

    /*
     * Reinicia el juego creando un nuevo jugador y limpiando todos los checkpoints almacenados en el gestor.
     */
    public void reiniciarJuego() {
        jugador = new Jugador();
        gestor.limpiarCheckpoints();
    }

    /*
     * Método que incrementa el nivel del jugador en uno, permitiendo avanzar en el juego.
     */
    public void subirNivel() {
        jugador.subirNivel();
    }

    /*
     * Método que decrementa la vida del jugador en uno, lo que puede llevar a un estado de GAME OVER si las vidas llegan a cero.
     */
    public void perderVida() {
        jugador.perderVida();
    }

    /*
     * Método que incrementa la cantidad de monedas del jugador en diez.
     */
    public void ganarMonedas() {
        jugador.ganarMonedas(10);
    }

    /*
     * Método que guarda el estado actual del jugador como un checkpoint en el gestor.
     * Si el jugador está en estado GAME OVER, no se permite guardar y se devuelve un mensaje de error.
     * @return un mensaje indicando si el checkpoint fue guardado o si hubo un error
     */
    public String guardarCheckpoint() {
        if (jugador.getEstadoJuego() == EstadoJuego.GAME_OVER) {
            return "No puedes guardar en GAME OVER";
        }
        gestor.guardarCheckpoint(jugador.guardar(gestor.generarNumeroCheckpoint()));
        return "Checkpoint guardado";
    }

        /*
        * Método que restaura el estado del jugador a partir de un checkpoint seleccionado por su índice en el gestor.
        * Si el índice es inválido, se devuelve un mensaje de error.
        * @param indice el índice del checkpoint a restaurar
        * @return un mensaje indicando si el checkpoint fue restaurado o si hubo un error
        */
    public String restaurarCheckpoint(int indice) {
        Memento checkpoint = gestor.obtenerCheckpoint(indice);
        if (checkpoint == null) {
            return "Checkpoint invalido";
        }
        jugador.restaurar(checkpoint);
        return "Checkpoint restaurado";
    }
       /*
        * Método que devuelve la lista de checkpoints almacenados en el gestor, para mostrarla en la vista.
        * @return la lista de checkpoints actualmente almacenados en el gestor
        */
    public List<Memento> obtenerCheckpoints() {
        return gestor.getCheckpoints();
    }
}