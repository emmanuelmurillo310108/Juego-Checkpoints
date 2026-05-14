package co.edu.uniquindio.poo.universidad.model;

public class Jugador {

    private int nivel;
    private int vidas;
    private int monedas;
    private EstadoJuego estadoJuego;

    /*
     * Constructor del jugador, inicializando el nivel en 1, vidas en 3, monedas en 0 y estado del juego en JUGANDO.
     */
    public Jugador() {
        nivel = 1;
        vidas = 3;
        monedas = 0;
        estadoJuego = EstadoJuego.JUGANDO;
    }

    /*
     * Getters
     */
    public int getNivel() {
        return nivel;
    }

    public int getVidas() {
        return vidas;
    }

    public int getMonedas() {
        return monedas;
    }

    public EstadoJuego getEstadoJuego() {
        return estadoJuego;
    }

    private boolean puedeJugar() {

        return estadoJuego
                != EstadoJuego.GAME_OVER;
    }

    /*
     * Crea un nuevo checkpoint con el estado actual del jugador, utilizando el número proporcionado como identificador del checkpoint.
     * @param numero el número del checkpoint a guardar
     * @return un nuevo objeto Checkpoint que representa el estado actual del jugador en el momento de guardar
     */
    public Memento guardar(int numero) {
        return new Checkpoint(numero, nivel, vidas, monedas, estadoJuego);
    }

    /*
     * Restaura el estado del jugador a partir de un checkpoint proporcionado como memento
     * @param memento el checkpoint del cual se restaurará el estado del jugador
     */
    public void restaurar(Memento memento) {
        Checkpoint checkpoint = (Checkpoint) memento;
        this.nivel = checkpoint.getNivel();
        this.vidas = checkpoint.getVidas();
        this.monedas = checkpoint.getMonedas();
        this.estadoJuego =
                checkpoint.getEstadoJuego();
    }

    /*
     * Incrementa el nivel del jugador en uno, siempre y cuando el jugador tenga el atributo de puedeJugar en true.
     */
    public void subirNivel() {
        if (puedeJugar()) {
            nivel++;
        }
    }

    /*
     * Incrementa la cantidad de monedas del jugador en la cantidad especificada, siempre y cuando el jugador tenga el atributo de puedeJugar en true.
     * @param cantidad la cantidad de monedas a ganar
     */
    public void ganarMonedas(int cantidad) {
        if (puedeJugar()) {
            monedas += cantidad;
        }
    }

    /*
     * Decrementa la vida del jugador en uno, siempre y cuando el jugador tenga el atributo de puedeJugar en true.
     * Si las vidas llegan a cero, el estado del juego se cambia a GAME_OVER.
     */
    public void perderVida() {
        if (vidas > 0) {
            vidas--;
            if (vidas == 0) {
                estadoJuego =
                        EstadoJuego.GAME_OVER;
            }
        }
    }

    /*
     * Método toString para mostrar la información del jugador de forma legible.
     * Muestra el nivel, vidas, monedas y estado del juego.
     */
    @Override
    public String toString() {
        return "Nivel: "
                + nivel
                + " | Vidas: "
                + vidas
                + " | Monedas: "
                + monedas
                + " | Estado: "
                + estadoJuego;
    }
}