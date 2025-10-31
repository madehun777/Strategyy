package juegomovimiento;

/**
 * Estrategia Concreta 3: Implementa la lógica para volar.
 */
public class VolarEstrategia implements EstrategiaMovimiento {

    // Atributos del UML
    private int velocidadVuelo = 3;
    private int elevacionVuelo = 2;

    @Override
    public void moverse() {
        // Lógica específica para volar
        System.out.println("El personaje VUELA. Se mueve " + velocidadVuelo + 
                           " unidades hacia adelante y se eleva " + elevacionVuelo + ".");
    }
}