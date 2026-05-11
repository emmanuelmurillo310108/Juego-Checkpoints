package co.edu.uniquindio.poo.universidad.model;

public class Jugador {

    private int nivel;
    private int vidas;
    private int monedas;

    public Jugador(int nivel, int vidas, int monedas) {
        this.nivel = nivel;
        this.vidas = vidas;
        this.monedas = monedas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }


    public Memento guardar() {
        return new VideoJuego(nivel, vidas, monedas);
    }

    public void restaurar(Memento memento) {
        this.nivel = memento.getNivel();
        this.vidas = memento.getVidas();
        this.monedas = memento.getMonedas();
    }

    public void subirNivel() {
        nivel++;
    }

    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    public void ganarMonedas(int cantidad) {
        monedas += cantidad;
    }

    @Override
    public String toString() {
        return "Nivel: " + nivel +
                " | Vidas: " + vidas +
                " | Monedas: " + monedas;
    }
}
