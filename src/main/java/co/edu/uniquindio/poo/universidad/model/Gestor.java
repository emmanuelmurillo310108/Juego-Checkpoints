package co.edu.uniquindio.poo.universidad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gestor {

    private final List<Memento> checkpoints;
    private int contadorCheckpoints;
    private static final int LIMITE = 7;

    public Gestor() {
        checkpoints = new ArrayList<>();
        contadorCheckpoints = 0;
    }

    public int generarNumeroCheckpoint() {
        contadorCheckpoints++;
        return contadorCheckpoints;
    }

    public boolean estaLleno() {
        return checkpoints.size() >= LIMITE;
    }

    public void eliminarMasViejo() {
        if(!checkpoints.isEmpty()) {
            checkpoints.remove(0);
        }
    }

    public void limpiarCheckpoints() {
        checkpoints.clear();
        contadorCheckpoints = 0;
    }

    public void guardarCheckpoint(Memento memento) {
        checkpoints.add(memento);
    }

    public Memento obtenerCheckpoint(int indice) {
        if(indice < 0 || indice >= checkpoints.size()) {
            return null;
        }
        return checkpoints.get(indice);
    }

    public int cantidadCheckpoints() {
        return checkpoints.size();
    }

    public List<Memento> getCheckpoints() {
        return Collections.unmodifiableList(checkpoints);
    }
}