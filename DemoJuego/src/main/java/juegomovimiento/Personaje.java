package juegomovimiento;

/**
 * Esta es la clase Contexto (Context).
 * Mantiene una referencia a una Estrategia y le delega la ejecución.
 */
public class Personaje {
    
    // Atributo (referencia) a la estrategia actual (como en el UML)
    private EstrategiaMovimiento estrategiaActual;

    /**
     * Constructor: Asignamos una estrategia inicial por defecto.
     * (El UML no lo pide, pero es buena práctica)
     */
    public Personaje() {
        // Por defecto, el personaje empieza caminando
        this.estrategiaActual = new CaminarEstrategia();
    }
    
    /**
     * Método para CAMBIAR la estrategia en tiempo de ejecución (como en el UML)
     * @param nuevaEstrategia La nueva estrategia a utilizar (Caminar, Correr o Volar)
     */
    public void setEstrategia(EstrategiaMovimiento nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }
    
    /**
     * Método que delega la acción a la estrategia actual (como en el UML)
     */
    public void ejecutarMovimiento() {
        // El personaje no sabe CÓMO se mueve,
        // simplemente llama al método de la estrategia que tenga asignada.
        estrategiaActual.moverse();
    }
}