package co.edu.uniquindio.poo.universidad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gestor {

    private final List<Memento> checkpoints;
    private int contadorCheckpoints;
    private static final int LIMITE = 7;

    /*
     * Constructor del gestor
     */
    public Gestor() {
        checkpoints = new ArrayList<>();
        contadorCheckpoints = 0;
    }

    /*
     * Genera un número único para cada checkpoint, incrementando el atributo contadorCheckpoints cada vez que se llama.
     * @return el número del checkpoint generado
     */
    public int generarNumeroCheckpoint() {
        contadorCheckpoints++;
        return contadorCheckpoints;
    }

    /*
     * Verifica si el gestor ha alcanzado su capacidad máxima de checkpoints.
     */
    public boolean estaLleno() {
        return checkpoints.size() >= LIMITE;
    }

    /*
     * Elimina el checkpoint más antiguo del gestor, que es el primero en la lista.
     * Si la lista de checkpoints está vacía, no hace nada.
     */
    public void eliminarMasViejo() {
        if(!checkpoints.isEmpty()) {
            checkpoints.remove(0);
        }
    }

    /*
     * Limpia todos los checkpoints almacenados en el gestor y reinicia el contador de checkpoints a cero.
     */
    public void limpiarCheckpoints() {
        checkpoints.clear();
        contadorCheckpoints = 0;
    }

    /*
     * Guarda un nuevo checkpoint en el gestor, agregándolo al final de la lista de checkpoints.
     * @param memento el checkpoint a guardar
     */
    public void guardarCheckpoint(Memento memento) {
        checkpoints.add(memento);
    }

    /*
     * Obtiene un checkpoint específico del gestor según su índice en la lista de checkpoints.
     * Si el índice es inválido (menor que 0 o mayor o igual al tamaño de la lista), devuelve null.
     * @param indice el índice del checkpoint a obtener
     * @return el checkpoint en el índice especificado, o null si el índice es inválido
     */
    public Memento obtenerCheckpoint(int indice) {
        if(indice < 0 || indice >= checkpoints.size()) {
            return null;
        }
        return checkpoints.get(indice);
    }

    /*
     * Devuelve la cantidad actual de checkpoints almacenados en el gestor.
     * @return el número de checkpoints en el gestor
     */
    public int cantidadCheckpoints() {
        return checkpoints.size();
    }

    /*
     * Devuelve una lista inmodificable de los checkpoints almacenados en el gestor, para evitar que se modifiquen desde fuera de la clase.
     * @return una lista inmodificable de los checkpoints actuales
     */
    public List<Memento> getCheckpoints() {
        return Collections.unmodifiableList(checkpoints);
    }
}