package juegomovimiento;

/**
 * Estrategia Concreta 1: Implementa la lógica para caminar.
 */
public class CaminarEstrategia implements EstrategiaMovimiento {

    // Atributos del UML
    private int velocidadPasos = 1;

    @Override
    public void moverse() {
        // Lógica específica para caminar
        System.out.println("El personaje CAMINA. Se mueve " + velocidadPasos + " unidad.");
    }
}