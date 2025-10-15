package decorator;

import bridge.Exportador;
import bridge.Informe;

/**
 * Decorator base que delega en un Informe.
 */
public abstract class DecoradorInforme implements Informe {
    protected Informe informeDecorado;

    public DecoradorInforme(Informe informeDecorado) {
        this.informeDecorado = informeDecorado;
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeDecorado.establecerExportador(exportador);
    }
}
