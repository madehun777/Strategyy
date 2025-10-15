package decorator;

import bridge.Exportador;
import bridge.Informe;

/**
 * Añade pie de página al final del informe.
 */
public class PiePaginaDecorator extends DecoradorInforme {

    private String pie;

    public PiePaginaDecorator(Informe informeDecorado, String pie) {
        super(informeDecorado);
        this.pie = pie;
    }

    @Override
    public void generar() {
        informeDecorado.generar();
        System.out.println();
        System.out.println("=== PIE DE PÁGINA: " + pie + " ===");
    }
}
