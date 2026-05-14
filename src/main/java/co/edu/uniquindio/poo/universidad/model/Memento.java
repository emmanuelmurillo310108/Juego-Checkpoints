package co.edu.uniquindio.poo.universidad.model;

public interface Memento {
    /*
     * Interfaz Memento que define los métodos para obtener el estado del jugador en un checkpoint.
     * Este es el actor principal del patrón Memento
     */
    int getNivel();
    int getVidas();
    int getMonedas();
}
