package co.edu.uniquindio.poo.universidad.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checkpoint implements Memento {

    private final int nivel;
    private final int vidas;
    private final int monedas;
    private final EstadoJuego estadoJuego;
    private final int numero;
    private final LocalDateTime fecha;

    public Checkpoint(int numero, int nivel, int vidas, int monedas, EstadoJuego estadoJuego) {
        this.numero = numero;
        this.nivel = nivel;
        this.vidas = vidas;
        this.monedas = monedas;
        this.estadoJuego = estadoJuego;
        fecha = LocalDateTime.now();
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

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Checkpoint #"
                + numero
                + " | "
                + fecha.format(formato)
                + "\nNivel "
                + nivel
                + " | Vidas "
                + vidas
                + " | Monedas "
                + monedas;
    }
}