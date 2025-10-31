package juegomovimiento;

/**
 * Estrategia Concreta 2: Implementa la lógica para correr.
 */
public class CorrerEstrategia implements EstrategiaMovimiento {

    // Atributos del UML
    private int velocidadCorrer = 5;

    @Override
    public void moverse() {
        // Lógica específica para correr
        System.out.println("El personaje CORRE. Se mueve " + velocidadCorrer + " unidades.");
    }
}