package juegomovimiento;

public class Personaje {
    
    private EstrategiaMovimiento estrategiaActual;

    public Personaje() {
        this.estrategiaActual = new CaminarEstrategia();
    }
    
    public void setEstrategia(EstrategiaMovimiento nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }
    
    public void ejecutarMovimiento() {
        estrategiaActual.moverse();
    }
}