package juegomovimiento;
public class CaminarEstrategia implements EstrategiaMovimiento {

    private int velocidadPasos = 1;

    @Override
    public void moverse() {
        System.out.println("El personaje CAMINA. Se mueve " + velocidadPasos + " unidad.");
    }
}