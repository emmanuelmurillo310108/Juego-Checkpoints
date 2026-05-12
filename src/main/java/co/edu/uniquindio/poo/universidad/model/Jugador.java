package co.edu.uniquindio.poo.universidad.model;

public class Jugador {

    private int nivel;
    private int vidas;
    private int monedas;
    private EstadoJuego estadoJuego;

    public Jugador() {
        nivel = 1;
        vidas = 3;
        monedas = 0;
        estadoJuego = EstadoJuego.JUGANDO;
    }

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

    public Memento guardar(int numero) {
        return new Checkpoint(numero, nivel, vidas, monedas, estadoJuego);
    }

    public void restaurar(Memento memento) {
        Checkpoint checkpoint = (Checkpoint) memento;
        this.nivel = checkpoint.getNivel();
        this.vidas = checkpoint.getVidas();
        this.monedas = checkpoint.getMonedas();
        this.estadoJuego =
                checkpoint.getEstadoJuego();
    }

    public void subirNivel() {
        if (puedeJugar()) {
            nivel++;
        }
    }

    public void ganarMonedas(int cantidad) {
        if (puedeJugar()) {
            monedas += cantidad;
        }
    }

    public void perderVida() {
        if (vidas > 0) {
            vidas--;
            if (vidas == 0) {
                estadoJuego =
                        EstadoJuego.GAME_OVER;
            }
        }
    }

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