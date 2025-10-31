package juegomovimiento;

public class CorrerEstrategia implements EstrategiaMovimiento {

    private int velocidadCorrer = 5;

    @Override
    public void moverse() {
        System.out.println("El personaje CORRE. Se mueve " + velocidadCorrer + " unidades.");
    }
}