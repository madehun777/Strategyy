package decorator;

import bridge.Informe;
import bridge.Exportador;

public class PiePaginaDecorator extends DecoradorInforme {

    private String textoPie;

    public PiePaginaDecorator(Informe informeDecorado, String textoPie) {
        super(informeDecorado);
        this.textoPie = textoPie;
    }

    @Override
    public void generar() {
        informeDecorado.generar(); 
        System.out.println("\n--- " + textoPie + " ---");
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeDecorado.establecerExportador(exportador);
    }
}
