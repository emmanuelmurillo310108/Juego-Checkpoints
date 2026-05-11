package co.edu.uniquindio.poo.universidad.model;

import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private List<Memento> checkpoints;

    public Gestor() {
        checkpoints = new ArrayList<>();
    }

    public void guardarCheckpoint(Memento memento) {
        checkpoints.add(memento);
    }

    public Memento restaurarUltimoCheckpoint() {

        if (checkpoints.isEmpty()) {
            return null;
        }

        return checkpoints.remove(checkpoints.size() - 1);
    }

    public List<Memento> getCheckpoints() {
        return checkpoints;
    }
}
