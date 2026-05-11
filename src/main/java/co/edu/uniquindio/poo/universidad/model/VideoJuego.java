package co.edu.uniquindio.poo.universidad.model;

public class VideoJuego implements Memento {

    private int nivel;
    private int vidas;
    private int monedas;

    public VideoJuego(int nivel, int vidas, int monedas) {
        this.nivel = nivel;
        this.vidas = vidas;
        this.monedas = monedas;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public int getVidas() {
        return vidas;
    }

    @Override
    public int getMonedas() {
        return monedas;
    }
}
