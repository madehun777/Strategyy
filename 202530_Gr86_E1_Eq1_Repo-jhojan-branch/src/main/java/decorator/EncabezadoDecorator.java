package decorator;

import bridge.Exportador;
import bridge.Informe;

/**
 * Añade un encabezado en la salida (simulado por consola).
 */
public class EncabezadoDecorator extends DecoradorInforme {

    private String encabezado;

    public EncabezadoDecorator(Informe informeDecorado, String encabezado) {
        super(informeDecorado);
        this.encabezado = encabezado;
    }

    @Override
    public void generar() {
        System.out.println("=== ENCABEZADO: " + encabezado + " ===");
        informeDecorado.generar();
    }
}
