package juegomovimiento;
public class VolarEstrategia implements EstrategiaMovimiento {

    private int velocidadVuelo = 3;
    private int elevacionVuelo = 2;

    @Override
    public void moverse() {
        System.out.println("El personaje VUELA. Se mueve " + velocidadVuelo + 
                           " unidades hacia adelante y se eleva " + elevacionVuelo + ".");
    }
}