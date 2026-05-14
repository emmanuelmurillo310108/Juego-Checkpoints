package co.edu.uniquindio.poo.universidad.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class GestorTest {

    private Gestor gestor;

    @BeforeEach
    public void setUp() {
        gestor = new Gestor();
    }

    @Test
    public void testGenerarNumeroCheckpoint() {
        assertEquals(1, gestor.generarNumeroCheckpoint());
        assertEquals(2, gestor.generarNumeroCheckpoint());
    }

    @Test
    public void testGuardarYObtenerCheckpoint() {
        // Usamos el constructor con los 5 parámetros: numero, nivel, vidas, monedas, estado
        Checkpoint cp = new Checkpoint(1, 1, 3, 100, null);
        gestor.guardarCheckpoint(cp);

        assertEquals(1, gestor.cantidadCheckpoints());
        assertSame(cp, gestor.obtenerCheckpoint(0));
    }

    @Test
    public void testEstaLlenoAlAlcanzarLimite() {
        for (int i = 0; i < 7; i++) {
            gestor.guardarCheckpoint(new Checkpoint(i, 1, 3, 0, null));
        }
        assertTrue(gestor.estaLleno());
    }

    @Test
    public void testEliminarMasViejo() {
        Checkpoint checkpoint1 = new Checkpoint(1, 1, 3, 0, null);
        Checkpoint checkpoint2 = new Checkpoint(2, 1, 3, 0, null);

        gestor.guardarCheckpoint(checkpoint1);
        gestor.guardarCheckpoint(checkpoint2);

        gestor.eliminarMasViejo();

        assertEquals(1, gestor.cantidadCheckpoints());
        assertSame(checkpoint2, gestor.obtenerCheckpoint(0));
    }

    @Test
    public void testLimpiarCheckpoints() {
        gestor.guardarCheckpoint(new Checkpoint(1, 1, 3, 0, null));
        gestor.generarNumeroCheckpoint();

        gestor.limpiarCheckpoints();

        assertEquals(0, gestor.cantidadCheckpoints());
        assertEquals(1, gestor.generarNumeroCheckpoint());
    }

    @Test
    public void testObtenerIndiceInvalido() {
        assertNull(gestor.obtenerCheckpoint(99));
        assertNull(gestor.obtenerCheckpoint(-1));
    }

    @Test
    public void testInmutabilidadDeLista() {
        List<Memento> lista = gestor.getCheckpoints();
        assertThrows(UnsupportedOperationException.class, () -> {
            lista.add(new Checkpoint(1, 1, 1, 1, null));
        });
    }
}